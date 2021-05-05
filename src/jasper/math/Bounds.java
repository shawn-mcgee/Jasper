package jasper.math;

public interface Bounds extends Box {
    @Override
    public default float x() { return x0(); }
    @Override
    public default float y() { return y0(); }
    @Override
    public default float z() { return z0(); }
    
    @Override
    public default float w() { return x1() - x0(); }
    @Override
    public default float h() { return y1() - y0(); }
    @Override
    public default float d() { return z1() - z0(); }
    
    @Override
    public default float x2() { return (x0() + x1()) / 2; }
    @Override
    public default float y2() { return (y0() + y1()) / 2; }
    @Override
    public default float z2() { return (z0() + z1()) / 2; }
    
    public static interface Mutable extends Bounds, Box.Mutable {
        @Override
        public default float x(float x) {
            float dx = x - x0();
            x1(x1() + dx);
            x0(x0() + dx);
            return x;
        }
        
        @Override
        public default float y(float y) {
            float dy = y - y0();
            y1(y1() + dy);
            y0(y0() + dy);
            return y;
        }
    
        @Override
        public default float z(float z) {
            float dz = z - z0();
            z1(z1() + dz);
            z0(z0() + dz);
            return z;
        }
        
        @Override
        public default float w(float w) {
            w = w >= 0 ? w : - w;
            x1(x0() + w);
            return w;
        }
    
        @Override
        public default float h(float h) {
            h = h >= 0 ? h : - h;
            y1(y0() + h);
            return h;
        }
    
        @Override
        public default float d(float d) {
            d = d >= 0 ? d : - d;
            z1(z0() + d);
            return d;
        }
        
        @Override
        public default float x2(float x2) {
            float dx = x2 - x2();
            x0(x0() + dx);
            x1(x1() + dx);
            return x2;
        }
    
        @Override
        public default float y2(float y2) {
            float dy = y2 - y2();
            y0(y0() + dy);
            y1(y1() + dy);
            return y2;
        }
    
        @Override
        public default float z2(float z2) {
            float dz = z2 - z2();
            z0(z0() + dz);
            z1(z1() + dz);
            return z2;
        }
    }
}
