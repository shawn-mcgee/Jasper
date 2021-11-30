package jasper.util;

import java.util.Objects;

public class Tuple2<A, B> implements Tuple {
    private static final long
        serialVersionUID = 1L;

    protected A a;
    protected B b;

    public Tuple2() {
        // do nothing
    }

    public Tuple2(A a, B b) {
        this.a = a;
        this.b = b;
    }

    public A a() {
        return a;
    }

    public B b() {
        return b;
    }

    @Override
    public String toString() {
        return Tuple2.toString(this);
    }

    public static String toString(
        Tuple2<?, ?> t
    ) {
        return Tuple2.toString(t,
            Objects::toString,
            Objects::toString
        );
    }

    public static <A, B> String toString(
        Tuple2<A, B> t,
        ObjectToString<A> a,
        ObjectToString<B> b
    ) {
        return "(" +
            a.toString(t.a()) + ", " +
            b.toString(t.b()) + ")";
    }

    public static class Mutable<A, B> extends Tuple2<A, B> {
        private static final long
            serialVersionUID = 1L;

        public Mutable() {
            super();
        }

        public Mutable(A a, B b) {
            super(a, b);
        }

        public Tuple2.Mutable<A, B> a(A a) {
            this.a = a;
            return this;
        }

        public Tuple2.Mutable<A, B> b(B b) {
            this.b = b;
            return this;
        }
    }
}
