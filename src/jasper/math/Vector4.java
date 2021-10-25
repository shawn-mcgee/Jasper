package jasper.math;

import static jasper.math.Math.EPSILON;
import static jasper.util.StringToObject.stringToFloat;
import static jasper.util.Utility.parse;
import static java.lang.Math.min;

public class Vector4 implements Vector {
    private static final long
        serialVersionUID = 1L;
    protected float
        x, y, z, w;
    
    public Vector4() {
        // do nothing
    }

    public Vector4(float a) {
        x = a;
        y = a;
        z = a;
        w = a;
    }
    
    public Vector4(Vector xyzw) {
        x = xyzw.x();
        y = xyzw.y();
        z = xyzw.z();
        w = xyzw.w();
    }

    public Vector4(float x, Vector3 yzw) {
        this.x = x;
        this.y = yzw.x();
        this.z = yzw.y();
        this.w = yzw.z();
    }
    
    public Vector4(Vector3 xyz, float w) {
        this.x = xyz.x();
        this.y = xyz.y();
        this.z = xyz.z();
        this.w = w;
    }
    
    public Vector4(Vector2 xy, Vector2 zw) {
        this.x = xy.x();
        this.y = xy.y();
        this.z = zw.x();
        this.w = zw.y();
    }

    public Vector4(float x, float y, Vector2 zw) {
        this.x = x;
        this.y = y;
        this.z = zw.x();
        this.w = zw.y();
    }

    public Vector4(float x, Vector2 yz, float w) {
        this.x = x;
        this.y = yz.x();
        this.z = yz.y();
        this.w = w;
    }
    
    public Vector4(Vector2 xy, float z, float w) {
        this.x = xy.x();
        this.y = xy.y();
        this.z = z;
        this.w = w;
    }

    public Vector4(float x, float y, float z, float w) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.w = w;
    }
    
    @Override
    public float x() {
        return x;
    }
    
    @Override
    public float y() {
        return y;
    }
    
    @Override
    public float z() {
        return z;
    }
    
    @Override
    public float w() {
        return w;
    }
    
    @Override
    public Vector4 copy() {
        return new Vector4(this);
    }
    
    @Override
    public String toString() {
        return Vector4.toString(this);
    }

    @Override
    public int hashCode() {
        return Vector.hashCode(this);
    }
    
    @Override
    public boolean equals(Object o) {
        return o instanceof Vector4 && Vector.equals(this, (Vector4) o, EPSILON);
    }
    
    public boolean equals(Vector2 b) {
        return Vector.equals(this, b, EPSILON);
    }
    
    public boolean equals(Vector3 b) {
        return Vector.equals(this, b, EPSILON);
    }
    
    public boolean equals(Vector4 b) {
        return Vector.equals(this, b, EPSILON);
    }
    
    public static String toString(Vector v) {
        return "<" + v.x() + ", " + v.y() + ", " + v.z() + ", " + v.w() + ">";
    }
    
    public static Vector4 fromString(String s) {
        return Vector4.fromString(new Vector4(), s);
    }
    
    protected static <V extends Vector4> V fromString(V v, String s) {
        if(v != null && s != null) {
            int
                i = s.indexOf("<"),
                j = s.indexOf(">");
            if (i >= 0 || j >= 0) {
                if (j > i)
                    s = s.substring(++ i, j);
                else
                    s = s.substring(++ i   );
            }
    
            String[] t = parse(s, "x|r", "y|g", "z|b", "w|a");
            v.w = stringToFloat(t[W]);
            v.z = stringToFloat(t[Z]);
            v.y = stringToFloat(t[Y]);
            v.x = stringToFloat(t[X]);
        }
        return v;
    }
    
    public static class Mutable extends Vector4 implements Vector.Mutable {
        private static final long
            serialVersionUID = 1L;
        
        public Mutable() {
            super();
        }

        public Mutable(float a) {
            super(a);
        }
        
        public Mutable(Vector xyzw) {
            super(xyzw);
        }

        public Mutable(float x, Vector3 yzw) {
            super(x, yzw);
        }
        
        public Mutable(Vector3 xyz, float w) {
            super(xyz, w);
        }
        
        public Mutable(Vector2 xy, Vector2 zw) {
            super(xy, zw);
        }

        public Mutable(float x, float y, Vector2 zw) {
            super(x, y, zw);
        }

        public Mutable(float x, Vector2 yz, float w) {
            super(x, yz, w);
        }
        
        public Mutable(Vector2 xy, float z, float w) {
            super(xy, z, w);
        }
        
        public Mutable(float x, float y, float z, float w) {
            super(x, y, z, w);
        }

        @Override
        public Vector4.Mutable x(float x) {
            this.x = x;
            return this;
        }

        @Override
        public Vector4.Mutable y(float y) {
            this.y = y;
            return this;
        }

        @Override
        public Vector4.Mutable z(float z) {
            this.z = z;
            return this;
        }

        @Override
        public Vector4.Mutable w(float w) {
            this.w = w;
            return this;
        }

        public Vector4.Mutable xy(float a) {
            x(a);
            y(a);
            return this;
        }

        public Vector4.Mutable xy(Vector xy) {
            x(xy.x());
            y(xy.y());
            return this;
        }

        public Vector4.Mutable xy(float x, float y) {
            x(x);
            y(y);
            return this;
        }

        public Vector4.Mutable xz(float a) {
            x(a);
            z(a);
            return this;
        }

        public Vector4.Mutable xz(Vector xz) {
            x(xz.x());
            z(xz.y());
            return this;
        }

        public Vector4.Mutable xz(float x, float z) {
            x(x);
            z(z);
            return this;
        }

        public Vector4.Mutable xw(float a) {
            x(a);
            w(a);
            return this;
        }

        public Vector4.Mutable xw(Vector xw) {
            x(xw.x());
            w(xw.y());
            return this;
        }

        public Vector4.Mutable xw(float x, float w) {
            x(x);
            w(w);
            return this;
        }

        public Vector4.Mutable yz(float a) {
            y(a);
            z(a);
            return this;
        }

        public Vector4.Mutable yz(Vector yz) {
            y(yz.x());
            z(yz.y());
            return this;
        }

        public Vector4.Mutable yz(float y, float z) {
            y(y);
            z(z);
            return this;
        }

        public Vector4.Mutable yw(float a) {
            y(a);
            w(a);
            return this;
        }

        public Vector4.Mutable yw(Vector yw) {
            y(yw.x());
            w(yw.y());
            return this;
        }

        public Vector4.Mutable yw(float y, float w) {
            y(y);
            w(w);
            return this;
        }

        public Vector4.Mutable zw(float a) {
            z(a);
            w(a);
            return this;
        }

        public Vector4.Mutable zw(Vector zw) {
            z(zw.x());
            w(zw.y());
            return this;
        }

        public Vector4.Mutable zw(float z, float w) {
            z(z);
            w(w);
            return this;
        }

        public Vector4.Mutable xyz(float a) {
            x(a);
            y(a);
            z(a);
            return this;
        }

        public Vector4.Mutable xyz(Vector xyz) {
            x(xyz.x());
            y(xyz.y());
            z(xyz.z());
            return this;
        }

        public Vector4.Mutable xyz(float x, Vector yz) {
            x(x);
            y(yz.x());
            z(yz.y());
            return this;
        }

        public Vector4.Mutable xyz(Vector xy, float z) {
            x(xy.x());
            y(xy.y());
            z(z);
            return this;
        }

        public Vector4.Mutable xyz(float x, float y, float z) {
            x(x);
            y(y);
            z(z);
            return this;
        }

        public Vector4.Mutable xyw(float a) {
            x(a);
            y(a);
            w(a);
            return this;
        }

        public Vector4.Mutable xyw(Vector xyw) {
            x(xyw.x());
            y(xyw.y());
            w(xyw.z());
            return this;
        }

        public Vector4.Mutable xyw(float x, Vector yw) {
            x(x);
            y(yw.x());
            w(yw.y());
            return this;
        }

        public Vector4.Mutable xyw(Vector xy, float w) {
            x(xy.x());
            y(xy.y());
            w(w);
            return this;
        }

        public Vector4.Mutable xyw(float x, float y, float w) {
            x(x);
            y(y);
            w(w);
            return this;
        }

        public Vector4.Mutable xzw(float a) {
            x(a);
            z(a);
            w(a);
            return this;
        }

        public Vector4.Mutable xzw(Vector xzw) {
            x(xzw.x());
            z(xzw.y());
            w(xzw.z());
            return this;
        }

        public Vector4.Mutable xzw(float x, Vector zw) {
            x(x);
            z(zw.x());
            w(zw.y());
            return this;
        }

        public Vector4.Mutable xzw(Vector xz, float w) {
            x(xz.x());
            z(xz.y());
            w(w);
            return this;
        }

        public Vector4.Mutable xzw(float x, float z, float w) {
            x(x);
            z(z);
            w(w);
            return this;
        }

        public Vector4.Mutable yzw(float a) {
            y(a);
            z(a);
            w(a);
            return this;
        }

        public Vector4.Mutable yzw(Vector yzw) {
            y(yzw.x());
            z(yzw.y());
            w(yzw.z());
            return this;
        }

        public Vector4.Mutable yzw(Vector yz, float w) {
            y(yz.x());
            z(yz.y());
            w(w);
            return this;
        }

        public Vector4.Mutable yzw(float y, Vector zw) {
            y(y);
            z(zw.x());
            w(zw.y());
            return this;
        }

        public Vector4.Mutable yzw(float y, float z, float w) {
            y(y);
            z(z);
            w(w);
            return this;
        }

        public Vector4.Mutable xyzw(float a) {
            x(a);
            y(a);
            z(a);
            w(a);
            return this;
        }

        public Vector4.Mutable xyzw(Vector xyzw) {
            x(xyzw.x());
            y(xyzw.y());
            z(xyzw.z());
            w(xyzw.w());
            return this;
        }

        public Vector4.Mutable xyzw(float x, Vector yzw) {
            x(x);
            y(yzw.x());
            z(yzw.y());
            w(yzw.z());
            return this;
        }

        public Vector4.Mutable xyzw(Vector xyz, float w) {
            x(xyz.x());
            y(xyz.y());
            z(xyz.z());
            w(w);
            return this;
        }

        public Vector4.Mutable xyzw(Vector xy, Vector zw) {
            x(xy.x());
            y(xy.y());
            z(zw.x());
            w(zw.y());
            return this;
        }

        public Vector4.Mutable xyzw(float x, float y, Vector zw) {
            x(x);
            y(y);
            z(zw.x());
            w(zw.y());
            return this;
        }

        public Vector4.Mutable xyzw(float x, Vector yz, float w) {
            x(x);
            y(yz.x());
            z(yz.y());
            w(w);
            return this;
        }

        public Vector4.Mutable xyzw(Vector xy, float z, float w) {
            x(xy.x());
            y(xy.y());
            z(z);
            w(w);
            return this;
        }

        public Vector4.Mutable xyzw(float x, float y, float z, float w) {
            x(x);
            y(y);
            z(z);
            w(w);
            return this;
        }
        
        @Override
        public Vector4.Mutable copy() {
            return new Vector4.Mutable(this);
        }
        
        public static Vector4.Mutable fromString(String s) {
            return Vector4.fromString(new Vector4.Mutable(), s);
        }
    }
}
