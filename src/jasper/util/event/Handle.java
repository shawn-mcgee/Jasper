package jasper.util.event;

import jasper.util.Array;
import jasper.util.Serial;
import jasper.util.Unsafe;

import java.io.Serializable;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static jasper.util.Utility.typeOf;

public class Handle implements Serializable {
    private static final long
        serialVersionUID = 1L;
    protected final Map<Class<?>, Listener.Group<?>>
        listeners = new HashMap<>();
    
    public Handle() {
        // do nothing
    }
    
    public <T> Listener.Group<T> request(Class<T> type) {
        Listener.Group<T> t = Unsafe.cast(listeners.get(type));
//            if (t == null)
//                listeners.put(type, t = new Listener.Group<>());
        return t;
    }
    
    public <T> Listener.Group<T> require(Class<T> type) {
        Listener.Group<T> t = Unsafe.cast(listeners.get(type));
        if (t == null)
            listeners.put(type, t = new Listener.Group<>());
        return t;
    }
    
    public <T> void attach(Class<T> type, Listener<T> listener) {
        require(type).attach(listener);
    }
    
    public <T> void detach(Class<T> type, Listener<T> listener) {
        Listener.Group<T> _listeners = request(type);
        if (_listeners != null)
            _listeners.detach(listener);
    }
    
    public <T> void onAttach(Class<T> type, Listener<T> listener) {
        require(type).onAttach(listener);
    }
    
    public <T> void onDetach(Class<T> type, Listener<T> listener) {
        Listener.Group<T> _listeners = request(type);
        if (_listeners != null)
            _listeners.onDetach(listener);
    }
    
    public void attach() {
        listeners.forEach((type, group) -> group.attach());
    }
    
    public void detach() {
        listeners.forEach((type, group) -> group.detach());
    }
    
    public <T> void flush(T event) {
        Listener.Group<T> _listeners = request(typeOf(event));
        if (_listeners != null)
            _listeners.flush(event);
    }
    
    public static class Group implements Serializable {
        private static final long
            serialVersionUID = 1L;
        protected final Set<Handle>
            handles = new HashSet<>();
        protected final Serial.Stack<Handle>
            attach = new Array.Stack<>(),
            detach = new Array.Stack<>();
        
        public void attach(Handle handle) {
            attach.push(handle);
        }
        
        public void detach(Handle handle) {
            detach.push(handle);
        }
        
        public void onAttach(Handle handle) {
            handles.add(handle);
        }
        
        public void onDetach(Handle handle) {
            handles.remove(handle);
        }
        
        public void attach() {
            for (Handle handle : attach)
                onAttach(handle);
            for (Handle handle : handles)
                handle.attach();
            attach.clear();
        }
        
        public void detach() {
            for (Handle handle : handles)
                handle.detach();
            for (Handle handle : detach)
                onDetach(handle);
            detach.clear();
        }
        
        public <T> void flush(T event) {
            for (Handle handle : handles)
                handle.flush(event);
        }
    }
}
