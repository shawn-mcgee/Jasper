package jasper.util;

public final class Utility {

    public static <T> T copyOf(T t) {
        if(t instanceof Copyable) {
            Copyable<?> u = Unsafe.cast(t       );
            return          Unsafe.cast(u.copy());
        } else if (t != null)
            Console.warn(new Object() { }, typeOf(t) + " is not of type jasper.util.Copyable");
        return t;
    }

    public static <T> Class<T> typeOf(T t) {
        return Unsafe.cast(t.getClass());
    }

    private Utility() {
        // do nothing
    }
}
