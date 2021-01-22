package jasper.math;

public class Vector4 implements Vector {
    private static final long
        serialVersionUID = 1L;

    protected float
        x, y, z, w;

    public Vector4() {
        // do nothing
    }

    public Vector4(Vector xyzw) {
        x = xyzw.x();
        y = xyzw.y();
        z = xyzw.z();
        w = xyzw.w();
    }

    public Vector4(Vector3 xyz, float w) {
        this.x = xyz.x();
        this.y = xyz.y();
        this.z = xyz.z();
        this.w = w;
    }

    public Vector4(float x, Vector3 yzw) {
        this.x = x;
        this.y = yzw.x();
        this.z = yzw.y();
        this.w = yzw.z();
    }

    public Vector4(Vector2 xy, Vector2 zw) {
        this.x = xy.x();
        this.y = xy.y();
        this.z = zw.x();
        this.w = zw.y();
    }

    public Vector4(Vector2 xy, float z, float w) {
        this.x = xy.x();
        this.y = xy.y();
        this.z = z;
        this.w = w;
    }

    public Vector4(float x, Vector2 yz, float w) {
        this.x = x;
        this.y = yz.x();
        this.z = yz.y();
        this.w = w;
    }

    public Vector4(float x, float y, Vector2 zw) {
        this.x = x;
        this.y = y;
        this.z = zw.x();
        this.w = zw.y();
    }

    public Vector4(float x, float y, float z, float w) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.w = w;
    }

    @Override
    public float x() { return x; }
    @Override
    public float y() { return y; }
    @Override
    public float z() { return z; }
    @Override
    public float w() { return w; }
    @Override
    public final int n() { return 4; }

    @Override
    public Vector4 copy() {
        return new Vector4(this);
    }

    @Override
    public String toString() {
        return Vector4.toString(this, "%s");
    }

    public static String toString(Vector v, String f) {
        return "<" +
            String.format(f, v.x()) + ", " +
            String.format(f, v.y()) + ", " +
            String.format(f, v.z()) + ", " +
            String.format(f, v.w()) + ">";
    }

    public static class Mutable extends Vector4 implements Vector.Mutable {
        private static final long
            serialVersionUID = 1L;

        public Mutable() {
            super();
        }

        public Mutable(Vector xyzw) {
            super(xyzw);
        }

        public Mutable(Vector3 xyz, float w) {
            super(xyz, w);
        }

        public Mutable(float x, Vector3 yzw) {
            super(x, yzw);
        }

        public Mutable(Vector2 xy, Vector2 zw) {
            super(xy, zw);
        }

        public Mutable(Vector2 xy, float z, float w) {
            super(xy, z, w);
        }

        public Mutable(float x, Vector2 yz, float w) {
            super(x, yz, w);
        }

        public Mutable(float x, float y, Vector2 zw) {
            super(x, y, zw);
        }

        public Mutable(float x, float y, float z, float w) {
            super(x, y, z, w);
        }

        @Override
        public float x(float x) { return this.x = x; }
        @Override
        public float y(float y) { return this.y = y; }
        @Override
        public float z(float z) { return this.z = z; }
        @Override
        public float w(float w) { return this.w = w; }

        public Vector4.Mutable set(Vector xyzw) {
            x = xyzw.x();
            y = xyzw.y();
            z = xyzw.z();
            w = xyzw.w();
            return this;
        }

        public Vector4.Mutable set(Vector3 xyz, float w) {
            this.x = xyz.x();
            this.y = xyz.y();
            this.z = xyz.z();
            this.w = w;
            return this;
        }

        public Vector4.Mutable set(float x, Vector3 yzw) {
            this.x = x;
            this.y = yzw.x();
            this.z = yzw.y();
            this.w = yzw.z();
            return this;
        }

        public Vector4.Mutable set(Vector2 xy, Vector2 zw) {
            this.x = xy.x();
            this.y = xy.y();
            this.z = zw.x();
            this.w = zw.y();
            return this;
        }

        public Vector4.Mutable set(Vector2 xy, float z, float w) {
            this.x = xy.x();
            this.y = xy.y();
            this.z = z;
            this.w = w;
            return this;
        }

        public Vector4.Mutable set(float x, Vector2 yz, float w) {
            this.x = x;
            this.y = yz.x();
            this.z = yz.y();
            this.w = w;
            return this;
        }

        public Vector4.Mutable set(float x, float y, Vector2 zw) {
            this.x = x;
            this.y = y;
            this.z = zw.x();
            this.w = zw.y();
            return this;
        }

        public Vector4.Mutable set(float x, float y, float z, float w) {
            this.x = x;
            this.y = y;
            this.z = z;
            this.w = w;
            return this;
        }

        @Override
        public Vector4.Mutable copy() {
            return new Vector4.Mutable(this);
        }
    }
}
