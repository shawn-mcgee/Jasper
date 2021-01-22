package jasper.engine.event;

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
        return Unsafe.cast(listeners.get(type));
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
    
    public void onAttach() {
        listeners.forEach((type, group) -> group.onAttach());
    }
    
    public void onDetach() {
        listeners.forEach((type, group) -> group.onDetach());
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
            handles = new HashSet<>(),
            attach = new HashSet<>(),
            detach = new HashSet<>();
        
        public void attach(Handle handle) {
            attach.add(handle);
        }
        
        public void detach(Handle handle) {
            detach.add(handle);
        }
        
        public void onAttach(Handle handle) {
            handles.add(handle);
        }
        
        public void onDetach(Handle handle) {
            handles.remove(handle);
        }
        
        public void onAttach() {
            for (Handle handle : attach)
                onAttach(handle);
            for (Handle handle : handles)
                handle.onAttach();
            attach.clear();
        }
        
        public void onDetach() {
            for (Handle handle : handles)
                handle.onDetach();
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
