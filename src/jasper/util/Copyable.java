package jasper.util;

import static jasper.util.Utility.typeOf;

public interface Copyable<T> {
    public T copy();

    public static <T> T copyOf(T t) {
        if (t instanceof Copyable) {
            Copyable<?> u = Unsafe.cast(t       );
            return          Unsafe.cast(u.copy());
        } else if (t != null)
            Debug.warn(new Object() { }, typeOf(t) + " is not of type jasper.util.Copyable");
        return t;
    }
}
