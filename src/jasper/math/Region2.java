package jasper.math;

public class Region2 implements Box2, Region {
    private static final long
        serialVersionUID = 1L;
    public static final String
        FORMAT = "[%1$s, %2$s, %3$s, %4$s]";
    protected float
        x, y,
        w, h;
    
    public Region2() {
        // do nothing
    }
    
    public Region2(
        Box b
    ) {
        mSet(b);
    }
    
    public Region2(
        Vector xy,
        Vector wh
    ) {
        mSet(xy, wh);
    }
    
    public Region2(
        float x, float y,
        float w, float h
    ) {
        mSet(x, y, w, h);
    }
    
    protected void mSet(
        Box b
    ) {
        x = b.x(); y = b.y();
        w = b.w(); h = b.h();
    }
    
    protected void mSet(
        Vector xy,
        Vector wh
    ) {
        x = xy.x(); y = xy.y();
        w = wh.x(); h = wh.y();
    }
    
    protected void mSet(
        float x, float y,
        float w, float h
    ) {
        this.x = x; this.y = y;
        this.w = w; this.h = h;
    }
    
    @Override
    public float x() { return x; }
    @Override
    public float y() { return y; }
    
    @Override
    public float w() { return w; }
    @Override
    public float h() { return h; }
    
    @Override
    public Region2 copy() {
        return new Region2(this);
    }
    
    @Override
    public String toString() {
        return Region2.toString(this, FORMAT);
    }
    
    public static String toString(Box b, String f) {
        return String.format(f, b.x(), b.y(), b.w(), b.h());
    }
    
    public static class Mutable extends Region2 implements Region.Mutable {
        private static final long
            serialVersionUID = 1L;
        
        public Mutable() {
            super();
        }
        
        public Mutable(
            Box b
        ) {
            super(b);
        }
        
        public Mutable(
            Vector xy,
            Vector wh
        ) {
            super(xy, wh);
        }
        
        public Mutable(
            float x, float y,
            float w, float h
        ) {
            super(x, y, w, h);
        }
    
        @Override
        public float x(float x) { return this.x = x; }
        @Override
        public float y(float y) { return this.y = y; }
    
        @Override
        public float w(float w) { return this.w = w; }
        @Override
        public float h(float h) { return this.h = h; }
    }
}
