package jasper.util;

import java.io.Serializable;
import java.util.Objects;

import static jasper.util.Utility.copyOf;

public class Property<T> implements Copyable<Property<T>>, Serializable {
    private static final long
        serialVersionUID = 1L;
    protected T
        t;

    public Property() {
        //do nothing
    }

    public Property(T t) {
        this.t = t;
    }

    public T get() {
        return t;
    }

    @Override
    public Property<T> copy() {
        return new Property<>(copyOf(t));
    }

    @Override
    public String toString() {
        return Objects.toString(t);
    }

    public static class Mutable<T> extends Property<T> {
        private static final long
            serialVersionUID = 1L;

        public Mutable() {
            super();
        }

        public Mutable(T t) {
            super(t);
        }

        public Property.Mutable<T> set(T t) {
            this.t = t;
            return this;
        }

        @Override
        public Property.Mutable<T> copy() {
            return new Property.Mutable<>(copyOf(t));
        }
    }
}
