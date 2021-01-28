package jasper.math;

public class Vector2 implements Vector {
    private static final long
        serialVersionUID = 1L;
    public static final String
        FORMAT = "<%1$s, %2$s>";
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
        return Vector2.toString(this, FORMAT);
    }
    
    public static String toString(Vector v, String f) {
        return String.format(f, v.x(), v.y());
    }
    
    public static Vector2 fromString(String s) {
        return Vector2.fromString(new Vector2(), s);
    }
    
    protected static <V extends Vector2> V fromString(V v, String s) {
        if(v != null && s != null) {
        
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
