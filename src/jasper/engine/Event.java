package jasper.engine;

import jasper.data.ArrayStack;
import jasper.data.Stack;
import jasper.util.Unsafe;

import java.io.Serializable;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static jasper.util.Utility.typeOf;

public interface Event extends Serializable {
    
    public static interface Listener<T extends Event> extends Serializable {
        public void handle(T event);
        
        public static class Group<T extends Event> implements Serializable {
            private static final long
                serialVersionUID = 1L;
            protected final Set<Listener<T>>
                listeners = new HashSet<>();
            protected final Stack<Listener<T>>
                attach    = new ArrayStack<>(),
                detach    = new ArrayStack<>();
            
            public void attach(Listener<T> listener) {
                attach.push(listener);
            }
            
            public void detach(Listener<T> listener) {
                detach.push(listener);
            }
            
            public void onAttach(Listener<T> listener) {
                listeners.add   (listener);
            }
            
            public void onDetach(Listener<T> listener) {
                listeners.remove(listener);
            }
            
            public void onAttach() {
                if (attach.size() > 0) {
                    for (Listener<T> listener : attach)
                        onAttach(listener);
                    attach.clear();
                }
            }
            
            public void onDetach() {
                if (detach.size() > 0) {
                    for (Listener<T> listener : detach)
                        onDetach(listener);
                    detach.clear();
                }
            }
            
            public void flush(T event) {
                for (Listener<T> listener : listeners)
                    listener.handle(event);
            }
        }
    }
    
    public static class Handle implements Serializable {
        private static final long
            serialVersionUID = 1L;
        protected final Map<Class<?>, Listener.Group<?>>
            listeners = new HashMap<>();
        
        public Handle() {
            // do nothing
        }
        
        public <T extends Event> Listener.Group<T> request(Class<T> type) {
            Listener.Group<T> t = Unsafe.cast(listeners.get(type));
    //        if (t == null)
    //            listeners.put(type, t = new Listener.Group<>());
            return t;
        }
        
        public <T extends Event> Listener.Group<T> require(Class<T> type) {
            Listener.Group<T> t = Unsafe.cast(listeners.get(type));
            if (t == null)
                listeners.put(type, t = new Listener.Group<>());
            return t;
        }
        
        public <T extends Event> void attach(Class<T> type, Listener<T> listener) {
            require(type).attach(listener);
        }
        
        public <T extends Event> void detach(Class<T> type, Listener<T> listener) {
            Listener.Group<T> _listeners = request(type);
            if (_listeners != null)
                _listeners.detach(listener);
        }
        
        public <T extends Event> void onAttach(Class<T> type, Listener<T> listener) {
            require(type).onAttach(listener);
        }
        
        public <T extends Event> void onDetach(Class<T> type, Listener<T> listener) {
            Listener.Group<T> _listeners = request(type);
            if (_listeners != null)
                _listeners.onDetach(listener);
        }
        
        public void onAttach() {
            listeners.forEach((type, group) -> group.onAttach());
        }
        
        public void onDetach() {
            listeners.forEach((type, group) -> group.onDetach());
        }
        
        public <T extends Event> void flush(T event) {
            Listener.Group<T> _listeners = request(typeOf(event));
            if (_listeners != null)
                _listeners.flush(event);
        }
        
        public static class Group implements Serializable {
            private static final long
                serialVersionUID = 1L;
            protected final Set<Handle>
                handles = new HashSet<>();
            protected final Stack<Handle>
                attach  = new ArrayStack<>(),
                detach  = new ArrayStack<>();
            
            public void attach(Handle handle) {
                attach.push(handle);
            }
            
            public void detach(Handle handle) {
                detach.push(handle);
            }
            
            public void onAttach(Handle handle) {
                handles.add   (handle);
            }
            
            public void onDetach(Handle handle) {
                handles.remove(handle);
            }
            
            public void onAttach() {
                for (Handle handle : attach )
                    onAttach(handle);
                for (Handle handle : handles)
                    handle.onAttach();
                attach.clear();
            }
            
            public void onDetach() {
                for (Handle handle : handles)
                    handle.onDetach();
                for (Handle handle : detach )
                    onDetach(handle);
                detach.clear();
            }
            
            public <T extends Event> void flush(T event) {
                for (Handle handle : handles)
                    handle.flush(event);
            }
        }
    }
    
    public static class Broker implements Serializable {
        private static final long
            serialVersionUID = 1L;
        protected final Handle.Group
            handles = new Handle.Group();
        protected final Group
            brokers = new Group();
        protected ArrayStack<Event>
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
        
        public <T extends Event> void queue(T event) {
            synchronized (this) {
                events0.push(event);
            }
        }
        
        public <T extends Event> void flush(T event) {
            handles.flush(event);
            brokers.flush(event);
        }
        
        public void flush() {
            synchronized (this) {
                ArrayStack<Event> events2 = events0;
                events0 = events1;
                events1 = events2;
            }
            
            if(events1.size() > 0) {
                for (Event event : events1)
                    flush(event);
                events1.clear();
            }
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
                brokers = new HashSet<>();
            protected final Stack<Broker>
                attach  = new ArrayStack<>(),
                detach  = new ArrayStack<>();
            
            public void attach(Broker broker) {
                attach.push(broker);
            }
            
            public void detach(Broker broker) {
                detach.push(broker);
            }
            
            public void onAttach(Broker broker) {
                brokers.add   (broker);
            }
            
            public void onDetach(Broker broker) {
                brokers.remove(broker);
            }
            
            public void onAttach() {
                for (Broker broker : attach)
                    onAttach(broker);
                for (Broker broker : brokers)
                    broker.onAttach();
                attach.clear();
            }
            
            public void onDetach() {
                for (Broker broker : brokers)
                    broker.onDetach();
                for (Broker broker : detach)
                    onDetach(broker);
                detach.clear();
            }
            
            public <T extends Event> void flush(T event) {
                for (Broker broker : brokers)
                    broker.flush(event);
            }
        }
    }
}
