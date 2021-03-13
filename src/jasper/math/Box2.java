package jasper.math;

public interface Box2 extends Box {
    public default Vector2  xy() { return new Vector2( x(),  y()); }
    public default Vector2  wh() { return new Vector2( w(),  h()); }
    public default Vector2 xy0() { return new Vector2(x0(), y0()); }
    public default Vector2 xy1() { return new Vector2(x1(), y1()); }
    public default Vector2 xy2() { return new Vector2(x2(), y2()); }
    
    @Override
    public abstract Box2 copy();
    
    public static interface Mutable extends Box2, Box.Mutable {
        public default Vector2  xy(float  x, float  y) { return new Vector2( x( x),  y( y)); }
        public default Vector2  wh(float  w, float  h) { return new Vector2( w( w),  h( h)); }
        public default Vector2 xy0(float x0, float y0) { return new Vector2(x0(x0), y0(y0)); }
        public default Vector2 xy1(float x1, float y1) { return new Vector2(x1(x1), y1(y1)); }
        public default Vector2 xy2(float x2, float y2) { return new Vector2(x2(x2), y2(y2)); }
        
        @Override
        public abstract Box2.Mutable copy();
    }
}