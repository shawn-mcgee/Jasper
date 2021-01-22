package jasper.math;

public class Vector3 implements Vector {
    private static final long
        serialVersionUID = 1L;

    protected float
        x, y, z;

    public Vector3() {
        // do nothing
    }

    public Vector3(Vector xyz) {
        x = xyz.x();
        y = xyz.y();
        z = xyz.z();
    }

    public Vector3(float x, float y, float z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Vector3(Vector2 xy, float z) {
        this.x = xy.x();
        this.y = xy.y();
        this.z = z;
    }

    public Vector3(float x, Vector2 yz) {
        this.x = x;
        this.y = yz.x();
        this.z = yz.y();
    }

    @Override
    public float x() { return x; }
    @Override
    public float y() { return y; }
    @Override
    public float z() { return z; }
    @Override
    public final int n() { return 3; }

    @Override
    public Vector3 copy() {
        return new Vector3(this);
    }

    @Override
    public String toString() {
        return Vector3.toString(this, "%s");
    }

    public static String toString(Vector v, String f) {
        return "<" +
            String.format(f, v.x()) + ", " +
            String.format(f, v.y()) + ", " +
            String.format(f, v.z()) + ">";
    }

    public static class Mutable extends Vector3 implements Vector.Mutable {
        private static final long
            serialVersionUID = 1L;

        public Mutable() {
            super();
        }

        public Mutable(Vector xyz) {
            super(xyz);
        }

        public Mutable(Vector2 xy, float z) {
            super(xy, z);
        }

        public Mutable(float x, Vector2 yz) {
            super(x, yz);
        }

        public Mutable(float x, float y, float z) {
            super(x, y, z);
        }

        @Override
        public float x(float x) { return this.x = x; }
        @Override
        public float y(float y) { return this.y = y; }
        @Override
        public float z(float z) { return this.z = z; }

        public Vector3.Mutable set(Vector xyz) {
            x = xyz.x();
            y = xyz.y();
            z = xyz.z();
            return this;
        }

        public Vector3.Mutable set(Vector2 xy, float z) {
            this.x = xy.x();
            this.y = xy.y();
            this.z = z;
            return this;
        }

        public Vector3.Mutable set(float x, Vector2 yz) {
            this.x = x;
            this.y = yz.x();
            this.z = yz.y();
            return this;
        }

        public Vector3.Mutable set(float x, float y, float z) {
            this.x = x;
            this.y = y;
            this.z = z;
            return this;
        }

        @Override
        public Vector3.Mutable copy() {
            return new Vector3.Mutable(this);
        }
    }
}
