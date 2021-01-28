package jasper.engine.event;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public interface Listener<T> extends Serializable {
    public void handle(T event);

    public static class Group<T> implements Serializable {
        private static final long
            serialVersionUID = 1L;
        protected final Set<Listener<T>>
            listeners = new HashSet<>(),
            attach    = new HashSet<>(),
            detach    = new HashSet<>();

        public void attach(Listener<T> listener) {
            attach.add(listener);
        }

        public void detach(Listener<T> listener) {
            detach.add(listener);
        }

        public void onAttach(Listener<T> listener) {
            listeners.add(listener);
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
