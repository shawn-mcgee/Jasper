package jasper.math;

import static jasper.util.StringToObject.stringToFloat;

public class Vector2 implements Vector {
    private static final long
        serialVersionUID = 1L;
    protected float
        x, y;
    
    public Vector2() {
        // do nothing
    }
    
    public Vector2(Vector xy) {
        x = xy.x();
        y = xy.y();
    }
    
    public Vector2(float x, float y) {
        this.x = x;
        this.y = y;
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
    public final int n() {
        return 2;
    }
    
    @Override
    public Vector2 copy() {
        return new Vector2(this);
    }
    
    @Override
    public String toString() {
        return Vector2.toString(this);
    }
    
    public static String toString(Vector v) {
        return "<" + v.x() + ", " + v.y() + ">";
    }
    
    public static Vector2 fromString(String s) {
        return Vector2.fromString(new Vector2(), s);
    }
    
    protected static <T extends Vector2> T fromString(T v, String s) {
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
            
            String[] t = s.split(",");
            switch(t.length) {
                default:
                case 2: v.y = stringToFloat(t[Y]);
                case 1: v.x = stringToFloat(t[X]);
                case 0:
            }
        }
        return v;
    }
    
    public static class Mutable extends Vector2 implements Vector.Mutable {
        private static final long
            serialVersionUID = 1L;
        
        public Mutable() {
            super();
        }
        
        public Mutable(Vector xy) {
            super(xy);
        }
        
        public Mutable(float x, float y) {
            super(x, y);
        }
        
        @Override
        public float x(float x) {
            return this.x = x;
        }
        
        @Override
        public float y(float y) {
            return this.y = y;
        }
        
        public Vector2.Mutable set(Vector xy) {
            x = xy.x();
            y = xy.y();
            return this;
        }
        
        public Vector2.Mutable set(float x, float y) {
            this.x = x;
            this.y = y;
            return this;
        }
        
        @Override
        public Vector2.Mutable copy() {
            return new Vector2.Mutable(this);
        }
        
        public static Vector2.Mutable fromString(String s) {
            return Vector2.fromString(new Vector2.Mutable(), s);
        }
    }
}
