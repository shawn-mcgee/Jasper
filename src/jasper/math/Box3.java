package jasper.math;

public interface Box3 extends Box {
    public default Vector3  xyz() { return new Vector3( x(),  y(),  z()); }
    public default Vector3  whd() { return new Vector3( w(),  h(),  d()); }
    public default Vector3 xyz0() { return new Vector3(x0(), y0(), z0()); }
    public default Vector3 xyz1() { return new Vector3(x1(), y1(), z1()); }
    public default Vector3 xyz2() { return new Vector3(x2(), y2(), z2()); }
    
    @Override
    public abstract Box3 copy();
    
    public static interface Mutable extends Box3, Box.Mutable {
        public default Vector3  xyz(float  x, float  y, float  z) { return new Vector3( x( x),  y( y),  z( z)); }
        public default Vector3  whd(float  w, float  h, float  d) { return new Vector3( w( w),  h( h),  d( d)); }
        public default Vector3 xyz0(float x0, float y0, float z0) { return new Vector3(x0(x0), y0(y0), z0(z0)); }
        public default Vector3 xyz1(float x1, float y1, float z1) { return new Vector3(x1(x1), y1(y1), z1(z1)); }
        public default Vector3 xyz2(float x2, float y2, float z2) { return new Vector3(x2(x2), y2(y2), z2(z2)); }
    
        @Override
        public abstract Box3.Mutable copy();
    }
}
