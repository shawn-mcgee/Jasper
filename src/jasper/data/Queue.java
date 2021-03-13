package jasper.data;

import java.util.Iterator;

public interface Queue<T> extends Sequence<T> {
    public T push(T t);
    public T peek();
    public T pull();
    
    public void clear();
    
    @Override
    public Queue<T> copy();
    
    public static <T> Queue<T> from(Deque<T> deque) {
        return new Queue<>() {
            private static final long
                serialVersionUID = 1L;
            
            @Override
            public T push(T t) {
                return deque.pushHead(t);
            }
            
            @Override
            public T peek() {
                return deque.peekTail();
            }
            
            @Override
            public T pull() {
                return deque.pullTail();
            }
            
            @Override
            public void clear() {
                deque.clear();
            }
            
            @Override
            public int size() {
                return deque.size();
            }
            
            @Override
            public Iterable<T> forward() {
                return deque.forward();
            }
            
            @Override
            public Iterable<T> reverse() {
                return deque.reverse();
            }
            
            @Override
            public Iterator<T> iterator() {
                return deque.iterator();
            }
            
            @Override
            public Queue<T> copy() {
                return Queue.from(deque.copy());
            }
    
            @Override
            public String toString() {
                return deque.toString();
            }
        };
    }
}
