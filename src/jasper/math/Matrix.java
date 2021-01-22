package jasper.math;

import jasper.util.Copyable;

import java.io.Serializable;

public interface Matrix<ROW extends Vector, COL extends Vector> extends Copyable<Matrix<ROW, COL>>, Serializable {
    public static final int
        ROW_MAJOR = 0,
        COL_MAJOR = 1;
    
    public default float xx() { return 0f; }
    public default float xy() { return 0f; }
    public default float xz() { return 0f; }
    public default float xw() { return 0f; }
    
    public default float yx() { return 0f; }
    public default float yy() { return 0f; }
    public default float yz() { return 0f; }
    public default float yw() { return 0f; }
    
    public default float zx() { return 0f; }
    public default float zy() { return 0f; }
    public default float zz() { return 0f; }
    public default float zw() { return 0f; }
    
    public default float wx() { return 0f; }
    public default float wy() { return 0f; }
    public default float wz() { return 0f; }
    public default float ww() { return 0f; }
    
    public default int m() { return 0; }
    public default int n() { return 0; }
    
    public ROW row(int i);
    public COL col(int j);
    
    public static interface Mutable<ROW extends Vector, COL extends Vector> extends Matrix<ROW, COL> {
        public default float xx(float xx) { return xx(); }
        public default float xy(float xy) { return xy(); }
        public default float xz(float xz) { return xz(); }
        public default float xw(float xw) { return xw(); }
        
        public default float yx(float yx) { return yx(); }
        public default float yy(float yy) { return yy(); }
        public default float yz(float yz) { return yz(); }
        public default float yw(float yw) { return yw(); }
        
        public default float zx(float zx) { return zx(); }
        public default float zy(float zy) { return zy(); }
        public default float zz(float zz) { return zz(); }
        public default float zw(float zw) { return zw(); }
        
        public default float wx(float wx) { return wx(); }
        public default float wy(float wy) { return wy(); }
        public default float wz(float wz) { return wz(); }
        public default float ww(float ww) { return ww(); }
        
        public ROW row(int i, Vector r0);
        public COL col(int j, Vector c0);
    }
}
