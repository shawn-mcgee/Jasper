package jasper.core;

import jasper.util.Callback;
import jasper.util.Debug;
import jasper.util.Event;

public abstract class Module {
    protected void onAttach() { }
    protected void onDetach() { }
    
    public static abstract class Process extends Module implements Runnable {
        protected java.lang.Thread
            thread;
        protected volatile boolean
            running;
    
        protected void onStart() throws Exception { }
        protected void onStep () throws Exception { }
        protected void onStop () { }
        
        @Override
        protected void onAttach() {
            if(!running) {
                thread  = new java.lang.Thread(this);
                running = true;
                thread.start();
            }
        }
        
        @Override
        protected void onDetach() {
            if( running)
                running = false;
        }
        
        @Override
        public void run() {
            try {
                onStart();
                while(running)
                    onStep();
            } catch(Exception fatal) {
                Debug.warn(new Object() { }, "A fatal exception has occurred in module '" + getClass().getName() + "'");
                fatal.printStackTrace();
            } finally {
                onStop();
            }
        }
    }
    
    public static abstract class Server extends Process {
        protected final Event.Broker
            broker;
        protected final Event.Handle
            handle;
        
        public Server() {
            broker = new Event.Broker();
            handle = new Event.Handle();
            broker.onAttach(handle);
        }
    
        public <T> void attach(Class<T> type, Event.Listener<T> listener) {
            handle.attach(type, listener);
        }
    
        public <T> void detach(Class<T> type, Event.Listener<T> listener) {
            handle.detach(type, listener);
        }
    
        protected <T> void onAttach(Class<T> type, Event.Listener<T> listener) {
            handle.onAttach(type, listener);
        }
    
        protected <T> void onDetach(Class<T> type, Event.Listener<T> listener) {
            handle.onDetach(type, listener);
        }
    
        public void attach(Event.Broker broker) {
            this.broker.attach(broker);
        }
    
        public void detach(Event.Broker broker) {
            this.broker.detach(broker);
        }
    
        protected void onAttach(Event.Broker broker) {
            this.broker.onAttach(broker);
        }
    
        protected void onDetach(Event.Broker broker) {
            this.broker.onDetach(broker);
        }
    
        public void attach(Event.Handle handle) {
            this.broker.attach(handle);
        }
    
        public void detach(Event.Handle handle) {
            this.broker.detach(handle);
        }
    
        protected void onAttach(Event.Handle handle) {
            this.broker.onAttach(handle);
        }
    
        protected void onDetach(Event.Handle handle) {
            this.broker.onDetach(handle);
        }
    
        public <T> void queue(T event) {
            broker.queue(event);
        }
    
        public <T> void flush(T event) {
            broker.flush(event);
        }
    
        protected void poll() {
            broker.poll();
        }

        public int pending() {
            return broker.pending();
        }
    }

    public static abstract class Resolver extends Server {

        public Resolver() {
            handle.onAttach(
                Callback.class,
                this::onResolve
            );
        }

        public void async(Callback event) {
            queue(event);
        }

        public void await(Callback event) {
            if(thread == Thread.currentThread())
                onResolve(event);
            else try {
                synchronized (event) {
                    queue(event);
                    event.wait();
                }
            } catch(Exception na) {
                Debug.warn(new Object() { }, "Failed to resolve callback '" + event + "'");
                na.printStackTrace();
            }
        }

        protected void onResolve(Callback event) {
            try {
                event.onResolve();
            } catch(Exception na) {
                Debug.warn(new Object() { }, "Failed to resolve callback'" + event + "'");
                na.printStackTrace();
            } finally {
                synchronized (event) {
                    event.notifyAll();
                }
            }
        }
    }
    
    public static class Worker extends Resolver {
        
        @Override
        public <T> void queue(T event) {
            super.queue(event);
            synchronized (this) {
                notifyAll();
            }
        }
        
        @Override
        public void onStep() throws Exception {
            if(broker.pending() > 0)
                poll();
            else if(running)
                synchronized (this) {
                    wait();
                }
        }
        
        @Override
        public void onDetach() {
            super.onDetach();
            synchronized (this) {
                notifyAll();
            }
        }
    }
}
