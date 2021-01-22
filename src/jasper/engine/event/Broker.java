package jasper.engine.event;

import jasper.util.data.ArrayStack;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Broker implements Serializable {
    private static final long
        serialVersionUID = 1L;
    protected final Handle.Group
        handles = new Handle.Group();
    protected final Broker.Group
        brokers = new Broker.Group();
    protected ArrayStack<Object>
        events0 = new ArrayStack<>(),
        events1 = new ArrayStack<>();

    public void attach(Handle handle) {
        handles.attach(handle);
    }

    public void detach(Handle handle) {
        handles.detach(handle);
    }

    public void onAttach(Handle handle) {
        handles.onAttach(handle);
    }

    public void onDetach(Handle handle) {
        handles.onDetach(handle);
    }

    public void attach(Broker broker) {
        brokers.attach(broker);
    }

    public void detach(Broker broker) {
        brokers.detach(broker);
    }

    public void onAttach(Broker broker) {
        brokers.onAttach(broker);
    }

    public void onDetach(Broker broker) {
        brokers.onDetach(broker);
    }

    public void onAttach() {
        handles.onAttach();
        brokers.onAttach();
    }

    public void onDetach() {
        handles.onDetach();
        brokers.onDetach();
    }

    public <T> void queue(T event) {
        System.out.println("Queue event... " + event);
        synchronized(this) {
            System.out.println("Queue event... Acquiring lock");
            events0.push(event);
            System.out.println("Queue event... Releasing lock");
        }
    }

    public <T> void flush(T event) {
        handles.flush(event);
        brokers.flush(event);
    }

    public void flush() {
        System.out.println("Swapping queue...");
        synchronized(this) {
            System.out.println("Swapping queue... Acquiring lock");

            ArrayStack<Object> events2 = events0;
            events0 = events1;
            events1 = events2;

            System.out.println("Swapping queue... Releasing lock");
        }
        System.out.println("Swapping queue... Done");

        System.out.println("Flushing queue...");

        for(Object event: events1)
            flush(event);
        events1.clear();

        System.out.println("Flushing queue... Done");
    }

    public void poll() {
        onAttach();
        onDetach();
        flush();
    }

    public static class Group implements Serializable {
        private static final long
            serialVersionUID = 1L;
        protected final Set<Broker>
            brokers = new HashSet<>(),
            attach  = new HashSet<>(),
            detach  = new HashSet<>();

        public void attach(Broker broker) {
            attach.add(broker);
        }

        public void detach(Broker broker) {
            detach.add(broker);
        }

        public void onAttach(Broker broker) {
            brokers.add   (broker);
        }

        public void onDetach(Broker broker) {
            brokers.remove(broker);
        }

        public void onAttach() {
            for(Broker broker: attach)
                onAttach(broker);
            for(Broker broker: brokers)
                broker.onAttach();
            attach.clear();
        }

        public void onDetach() {
            for(Broker broker: brokers)
                broker.onDetach();
            for(Broker broker: detach)
                onDetach(broker);
            detach.clear();
        }

        public <T> void flush(T event) {
            for(Broker broker: brokers)
                broker.flush(event);
        }
    }
}
