package jasper.util;

import java.util.Objects;

public class Tuple3<A, B, C> implements Tuple {
    private static final long
        serialVersionUID = 1L;

    protected A a;
    protected B b;
    protected C c;

    public Tuple3() {
        // do nothing
    }

    public Tuple3(A a, B b, C c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public A a() {
        return a;
    }

    public B b() {
        return b;
    }

    public C c() {
        return c;
    }

    @Override
    public String toString() {
        return Tuple3.toString(this);
    }

    public static String toString(
        Tuple3<?, ?, ?> t
    ) {
        return Tuple3.toString(t,
            Objects::toString,
            Objects::toString,
            Objects::toString
        );
    }

    public static <A, B, C> String toString(
        Tuple3<A, B, C> t,
        ObjectToString<A> a,
        ObjectToString<B> b,
        ObjectToString<C> c
    ) {
        return "(" +
            a.toString(t.a()) + ", " +
            b.toString(t.b()) + ", " +
            c.toString(t.c()) + ")";
    }

    public static class Mutable<A, B, C> extends Tuple3<A, B, C> {
        private static final long
            serialVersionUID = 1L;

        public Mutable() {
            super();
        }

        public Mutable(A a, B b, C c) {
            super(a, b, c);
        }

        public Tuple3.Mutable<A, B, C> a(A a) {
            this.a = a;
            return this;
        }

        public Tuple3.Mutable<A, B, C> b(B b) {
            this.b = b;
            return this;
        }

        public Tuple3.Mutable<A, B, C> c(C c) {
            this.c = c;
            return this;
        }
    }
}
