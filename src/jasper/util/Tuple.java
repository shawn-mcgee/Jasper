package jasper.util;

import java.io.Serializable;

/**
 *
 */
public interface Tuple extends Serializable {

    public static <A, B> Tuple2<A, B> t(A a, B b) {
        return new Tuple2<>(a, b);
    }

    public static <A, B, C> Tuple3<A, B, C> t(A a, B b, C c) {
        return new Tuple3<>(a, b, c);
    }

    public static <A, B, C, D> Tuple4<A, B, C, D> t(A a, B b, C c, D d) {
        return new Tuple4<>(a, b, c, d);
    }

    public static interface Mutable extends Tuple {
        public static <A, B> Tuple2.Mutable<A, B> t(A a, B b) {
            return new Tuple2.Mutable<>(a, b);
        }

        public static <A, B, C> Tuple3.Mutable<A, B, C> t(A a, B b, C c) {
            return new Tuple3.Mutable<>(a, b, c);
        }

        public static <A, B, C, D> Tuple4.Mutable<A, B, C, D> t(A a, B b, C c, D d) {
            return new Tuple4.Mutable<>(a, b, c, d);
        }
    }
}
