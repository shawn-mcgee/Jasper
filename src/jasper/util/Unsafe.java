package jasper.util;

public final class Unsafe {

    @SuppressWarnings("unchecked")
    public static <T> T cast(Object o               ) {
        return (T)o;
    }

    @SuppressWarnings("unchecked")
    public static <T> T cast(Object o, Class<T> type) {
        return (T)o;
    }

    private Unsafe() {
        // do nothing
    }
}