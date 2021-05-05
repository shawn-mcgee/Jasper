package jasper.util.event;

import jasper.util.Array;
import jasper.util.Serial;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Broker implements Serializable {
    private static final long
        serialVersionUID = 1L;
    protected final Handle.Group
        handles = new Handle.Group();
    protected final Group
        brokers = new Group();
    protected Serial.Stack<Object>
        events0 = new Array.Stack<>(),
        events1 = new Array.Stack<>();
    
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
    
    public void attach() {
        handles.attach();
        brokers.attach();
    }
    
    public void detach() {
        handles.detach();
        brokers.detach();
    }
    
    public <T> void queue(T event) {
        synchronized (this) {
            events0.push(event);
        }
    }
    
    public <T> void flush(T event) {
        handles.flush(event);
        brokers.flush(event);
    }
    
    public void flush() {
        synchronized (this) {
            Serial.Stack<Object> events2 = events0;
            events0 = events1;
            events1 = events2;
        }
        
        if (events1.size() > 0) {
            for (Object event : events1)
                flush(event);
            events1.clear();
        }
    }
    
    public void poll() {
        attach();
        detach();
        flush();
    }
    
    public static class Group implements Serializable {
        private static final long
            serialVersionUID = 1L;
        protected final Set<Broker>
            brokers = new HashSet<>();
        protected final Serial.Stack<Broker>
            attach = new Array.Stack<>(),
            detach = new Array.Stack<>();
        
        public void attach(Broker broker) {
            attach.push(broker);
        }
        
        public void detach(Broker broker) {
            detach.push(broker);
        }
        
        public void onAttach(Broker broker) {
            brokers.add(broker);
        }
        
        public void onDetach(Broker broker) {
            brokers.remove(broker);
        }
        
        public void attach() {
            for (Broker broker : attach)
                onAttach(broker);
            for (Broker broker : brokers)
                broker.attach();
            attach.clear();
        }
        
        public void detach() {
            for (Broker broker : brokers)
                broker.detach();
            for (Broker broker : detach)
                onDetach(broker);
            detach.clear();
        }
        
        public <T> void flush(T event) {
            for (Broker broker : brokers)
                broker.flush(event);
        }
    }
}
