package jasper.math;

import static jasper.math.Math.EPSILON;
import static jasper.util.StringToObject.stringToFloat;
import static jasper.util.Utility.parse;

public class Vector3 implements Vector {
    private static final long
        serialVersionUID = 1L;
    protected float
        x, y, z;
    
    public Vector3() {
        // do nothing
    }

    public Vector3(float a) {
        x = a;
        y = a;
        z = a;
    }
    
    public Vector3(Vector xyz) {
        x = xyz.x();
        y = xyz.y();
        z = xyz.z();
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

    public Vector3(float x, float y, float z) {
        this.x = x;
        this.y = y;
        this.z = z;
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
    public Vector3 copy() {
        return new Vector3(this);
    }
    
    @Override
    public String toString() {
        return Vector3.toString(this);
    }

    @Override
    public int hashCode() {
        return Vector.hashCode(this);
    }
    
    @Override
    public boolean equals(Object o) {
        return o instanceof Vector3 && Vector.equals(this, (Vector3) o, EPSILON);
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
        return "<" + v.x() + ", " + v.y() + ", " + v.z() + ">";
    }
    
    public static Vector3 fromString(String s) {
        return Vector3.fromString(new Vector3(), s);
    }
    
    protected static <V extends Vector3> V fromString(V v, String s) {
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
            
            String[] t = parse(s, "x|r", "y|g", "z|b");
            v.z = stringToFloat(t[Z]);
            v.y = stringToFloat(t[Y]);
            v.x = stringToFloat(t[X]);
        }
        return v;
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

        public void set(Vector xyz) {
            xyz(  xyz  );
        }

        public void set(float x, float y, float z) {
            xyz(x, y, z);
        }

        @Override
        public Vector3.Mutable x(float x) {
            this.x = x;
            return this;
        }

        @Override
        public Vector3.Mutable y(float y) {
            this.y = y;
            return this;
        }

        @Override
        public Vector3.Mutable z(float z) {
            this.z = z;
            return this;
        }

        public Vector3.Mutable xy(float a) {
            x(a);
            y(a);
            return this;
        }

        public Vector3.Mutable xy(Vector xy) {
            x(xy.x());
            y(xy.y());
            return this;
        }

        public Vector3.Mutable xy(float x, float y) {
            x(x);
            y(y);
            return this;
        }

        public Vector3.Mutable xz(float a) {
            x(a);
            z(a);
            return this;
        }

        public Vector3.Mutable xz(Vector xz) {
            x(xz.x());
            z(xz.y());
            return this;
        }

        public Vector3.Mutable xz(float x, float z) {
            x(x);
            z(z);
            return this;
        }

        public Vector3.Mutable yz(float a) {
            y(a);
            z(a);
            return this;
        }

        public Vector3.Mutable yz(Vector yz) {
            y(yz.x());
            z(yz.y());
            return this;
        }

        public Vector3.Mutable yz(float y, float z) {
            y(y);
            z(z);
            return this;
        }

        public Vector3.Mutable xyz(float a) {
            x(a);
            y(a);
            z(a);
            return this;
        }

        public Vector3.Mutable xyz(Vector xyz) {
            x(xyz.x());
            y(xyz.y());
            z(xyz.z());
            return this;
        }

        public Vector3.Mutable xyz(float x, Vector yz) {
            x(x);
            y(yz.x());
            z(yz.y());
            return this;
        }

        public Vector3.Mutable xyz(Vector xy, float z) {
            x(xy.x());
            y(xy.y());
            z(z);
            return this;
        }

        public Vector3.Mutable xyz(float x, float y, float z) {
            x(x);
            y(y);
            z(z);
            return this;
        }
        
        @Override
        public Vector3.Mutable copy() {
            return new Vector3.Mutable(this);
        }
        
        public static Vector3.Mutable fromString(String s) {
            return Vector3.fromString(new Vector3.Mutable(), s);
        }
    }
}
