package jasper.util;

import java.util.Objects;

public class Tuple4<A, B, C, D> implements Tuple {
    private static final long
        serialVersionUID = 1L;

    protected A a;
    protected B b;
    protected C c;
    protected D d;

    public Tuple4() {
        // do nothing
    }

    public Tuple4(A a, B b, C c, D d) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
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

    public D d() {
        return d;
    }

    @Override
    public String toString() {
        return jasper.util.Tuple4.toString(this);
    }

    public static String toString(
        jasper.util.Tuple4<?, ?, ?, ?> t
    ) {
        return Tuple4.toString(t,
            Objects::toString,
            Objects::toString,
            Objects::toString,
            Objects::toString
        );
    }

    public static <A, B, C, D> String toString(
        Tuple4<A, B, C, D> t,
        ObjectToString<A> a,
        ObjectToString<B> b,
        ObjectToString<C> c,
        ObjectToString<D> d
    ) {
        return "(" +
            a.toString(t.a()) + ", " +
            b.toString(t.b()) + ", " +
            c.toString(t.c()) + ", " +
            d.toString(t.d()) + ")";
    }

    public static class Mutable<A, B, C, D> extends Tuple4<A, B, C, D> {
        private static final long
            serialVersionUID = 1L;

        public Mutable() {
            super();
        }

        public Mutable(A a, B b, C c, D d) {
            super(a, b, c, d);
        }

        public Tuple4.Mutable<A, B, C, D> a(A a) {
            this.a = a;
            return this;
        }

        public Tuple4.Mutable<A, B, C, D> b(B b) {
            this.b = b;
            return this;
        }

        public Tuple4.Mutable<A, B, C, D> c(C c) {
            this.c = c;
            return this;
        }

        public Tuple4.Mutable<A, B, C, D> d(D d) {
            this.d = d;
            return this;
        }
    }
}
