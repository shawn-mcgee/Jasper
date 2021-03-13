package jasper.data;

public interface Array<T> extends Sequence<T> {
    
    public abstract T set(int i, T t);
    public abstract T get(int i     );
    
    public abstract int index(       T t);
    public abstract int index(int i, T t);
    
    public abstract T insert(       T t);
    public abstract T insert(int i, T t);
    public abstract T remove(T   t);
    public abstract T remove(int i);
    
    public abstract void resize(int n);
    
    @Override
    public Array<T> copy();
}
