package jasper.math;

public interface Box3 extends Box {
    public default Vector3  xyz() { return new Vector3( x(),  y(),  z()); }
    public default Vector3  whd() { return new Vector3( w(),  h(),  d()); }
    public default Vector3 xyz0() { return new Vector3(x0(), y0(), z0()); }
    public default Vector3 xyz1() { return new Vector3(x1(), y1(), z1()); }
    public default Vector3 xyz2() { return new Vector3(x2(), y2(), z2()); }
    
    @Override
    public abstract Box3 copy();
    
    public default boolean includes(Box3   b, boolean edge) {
        return Box.includes(this, b, edge);
    }
    
    public default boolean includes(Vector b, boolean edge) {
        return Box.includes(this, b, edge);
    }
    
    public default boolean includes(float x, float y, float z, boolean edge) {
        return Box.includes(this, x, y, z, edge);
    }
    
    public default boolean excludes(Box3   b, boolean edge) {
        return Box.excludes(this, b, edge);
    }
    
    public default boolean excludes(Vector b, boolean edge) {
        return Box.excludes(this, b, edge);
    }
    
    public default boolean excludes(float x, float y, float z, boolean edge) {
        return Box.excludes(this, x, y, z, edge);
    }
    
    public default boolean intersects(Box3 b, boolean edge) {
        return Box.intersects(this, b, edge);
    }
    
    public static interface Mutable extends Box3, Box.Mutable {
        public default Box3.Mutable  xyz(float  x, float  y, float  z) { x(x); y(y); z(z); return this; }
        public default Box3.Mutable  whd(float  w, float  h, float  d) { w(w); h(h); d(d); return this; }
        public default Box3.Mutable xyz0(float x0, float y0, float z0) { x0(x0); y0(y0); z0(z0); return this; }
        public default Box3.Mutable xyz1(float x1, float y1, float z1) { x1(x1); y1(y1); z1(z1); return this; }
        public default Box3.Mutable xyz2(float x2, float y2, float z2) { x2(x2); y2(y2); z2(z2); return this; }

        public default Box3.Mutable  xyz(Vector xyz) { x(xyz.x()); y(xyz.y()); z(xyz.z()); return this; }
        public default Box3.Mutable  whd(Vector whd) { w(whd.x()); h(whd.y()); d(whd.z()); return this; }
        public default Box3.Mutable xyz0(Vector xyz0) { x0(xyz0.x()); y0(xyz0.y()); z0(xyz0.z()); return this; }
        public default Box3.Mutable xyz1(Vector xyz1) { x1(xyz1.x()); y1(xyz1.y()); z1(xyz1.z()); return this; }
        public default Box3.Mutable xyz2(Vector xyz2) { x2(xyz2.x()); y2(xyz2.y()); z2(xyz2.z()); return this; }
    
        @Override
        public abstract Box3.Mutable copy();
    }
}
