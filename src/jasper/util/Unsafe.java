package jasper.util;

/**
 * The purpose of {@link jasper.util.Unsafe} is to enhance the readability of
 * library code by wrapping certain unsafe or unchecked operations at the call
 * site.
 * <br>
 * <br>
 * This class provides a semantic interface for performing certain unsafe or
 * unchecked operations. This class does NOT guarantee the safety of any
 * operations. Moreover, this class DOES suppress relevant unsafe or unchecked
 * compiler warnings and should be used with discretion.
 */
public final class Unsafe {
    
    private Unsafe() {
        // do nothing
    }

    /**
     * This method wraps an unchecked cast and suppresses relevant compiler
     * warnings. This method should be used where an explicit cast would
     * result in a compiler warning. This method will still throw a
     * {@link java.lang.ClassCastException} when attempting to perform an
     * invalid cast.
     */
    @SuppressWarnings("unchecked")
    public static <T> T cast(Object o               ) {
        return (T) o;
    }

    /**
     * This method wraps an unchecked cast and suppresses relevant compiler
     * warnings. This method should be used where an explicit cast would
     * result in a compiler warning. This method will still throw a
     * {@link java.lang.ClassCastException} when attempting to perform an
     * invalid cast.
     */
    @SuppressWarnings("unchecked")
    public static <T> T cast(Object o, Class<T> type) {
        return (T) o;
    }
}
