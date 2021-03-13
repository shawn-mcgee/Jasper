package jasper.engine;

import jasper.util.Debug;

public abstract class Process implements Runnable {
    protected final Event.Broker
        broker;
    protected final Event.Handle
        handle;
    
    protected volatile boolean
        running;
    protected Thread
        process;
    
    public Process() {
        broker = new Event.Broker();
        handle = new Event.Handle();
        broker.onAttach(handle);
    }
    
    public void onAttach() { }
    public void onDetach() { }
    
    public void onInit() { }
    public void onStep() { }
    public void onStop() { }
    
    public <T extends Event> void attach(Class<T> type, Event.Listener<T> listener) {
        handle.attach(type, listener);
    }
    
    public <T extends Event> void detach(Class<T> type, Event.Listener<T> listener) {
        handle.detach(type, listener);
    }
    
    public void attach(Event.Broker broker) {
        this.broker.attach(broker);
    }
    
    public void detach(Event.Broker broker) {
        this.broker.detach(broker);
    }
    
    public void attach(Event.Handle handle) {
        this.broker.attach(handle);
    }
    
    public void detach(Event.Handle handle) {
        this.broker.detach(handle);
    }
    
    public <T extends Event> void queue(T event) {
        broker.queue(event);
    }
    
    public <T extends Event> void flush(T event) {
        broker.flush(event);
    }
    
    public void poll() {
        broker.poll();
    }
    
    @Override
    public void run() {
        try {
            onInit();
            while(running)
                onStep();
        } catch(Exception fatal) {
            Debug.warn(new Object() { }, "A fatal exception has occurred in process '" + getClass().getName() + "'");
        } finally {
            onStop();
        }
    }
}
