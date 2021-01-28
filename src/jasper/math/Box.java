package jasper.math;

import jasper.util.Copyable;

import java.io.Serializable;

public interface Box extends Copyable<Box>, Serializable {
    public default float x() { return 0f; }
    public default float y() { return 0f; }
    public default float z() { return 0f; }
    
    public default float w() { return 0f; }
    public default float h() { return 0f; }
    public default float d() { return 0f; }
    
    public default float x0() { return 0f; }
    public default float y0() { return 0f; }
    public default float z0() { return 0f; }
    
    public default float x1() { return 0f; }
    public default float y1() { return 0f; }
    public default float z1() { return 0f; }
    
    public default float x2() { return 0f; }
    public default float y2() { return 0f; }
    public default float z2() { return 0f; }
    
    public static interface Mutable extends Box {
        public default float x(float x) { return x(); }
        public default float y(float y) { return y(); }
        public default float z(float z) { return z(); }
    
        public default float w(float w) { return w(); }
        public default float h(float h) { return h(); }
        public default float d(float d) { return d(); }
    
        public default float x0(float x0) { return x0(); }
        public default float y0(float y0) { return y0(); }
        public default float z0(float z0) { return z0(); }
    
        public default float x1(float x1) { return x1(); }
        public default float y1(float y1) { return y1(); }
        public default float z1(float z1) { return z1(); }
    
        public default float x2(float x2) { return x2(); }
        public default float y2(float y2) { return y2(); }
        public default float z2(float z2) { return z2(); }
    }
}
