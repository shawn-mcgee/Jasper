package jasper.util.event;

import jasper.util.Array;
import jasper.util.Serial;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public interface Listener<T> extends Serializable {
    public void handle(T event);
    
    public static class Group<T> implements Serializable {
        private static final long
            serialVersionUID = 1L;
        protected final Set<Listener<T>>
            listeners = new HashSet<>();
        protected final Serial.Stack<Listener<T>>
            attach = new Array.Stack<>(),
            detach = new Array.Stack<>();
        
        public void attach(Listener<T> listener) {
            attach.push(listener);
        }
        
        public void detach(Listener<T> listener) {
            detach.push(listener);
        }
        
        public void onAttach(Listener<T> listener) {
            listeners.add(listener);
        }
        
        public void onDetach(Listener<T> listener) {
            listeners.remove(listener);
        }
        
        public void attach() {
            if (attach.size() > 0) {
                for (Listener<T> listener : attach)
                    onAttach(listener);
                attach.clear();
            }
        }
        
        public void detach() {
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
