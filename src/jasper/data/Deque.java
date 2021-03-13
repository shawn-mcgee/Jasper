package jasper.data;

public interface Deque<T> extends Sequence<T> {
    public T pushHead(T t);
    public T peekHead();
    public T pullHead();
    
    public T pushTail(T t);
    public T peekTail();
    public T pullTail();
    
    public void clear();
    
    @Override
    public jasper.data.Deque<T> copy();
}
