package jasper.math;

import jasper.util.Debug;

import java.util.Arrays;

import static jasper.math.Math.EPSILON;
import static jasper.util.StringToObject.stringToFloat;
import static jasper.util.Utility.parse;

public class Matrix4 implements Matrix<Vector4, Vector4> {
    private static final long
        serialVersionUID = 1L;
    protected static final int
        xx =  0, xy =  1, xz =  2, xw =  3,
        yx =  4, yy =  5, yz =  6, yw =  7,
        zx =  8, zy =  9, zz = 10, zw = 11,
        wx = 12, wy = 13, wz = 14, ww = 15;
    protected final float[]
        m = new float[16];
    
    public Matrix4() {
        // do nothing
    }
    
    public Matrix4(
        Matrix<?, ?> m
    ) {
        mSet(m);
    }
    
    public Matrix4(
        int mode,
        Vector v0,
        Vector v1,
        Vector v2,
        Vector v3
    ) {
        switch (mode) {
            case ROW_MAJOR:
                mSetRowMajor(v0, v1, v2, v3);
                break;
            case COL_MAJOR:
                mSetColMajor(v0, v1, v2, v3);
                break;
        }
    }
    
    public Matrix4(
        int mode,
        float a, float b, float c, float d,
        float e, float f, float g, float h,
        float i, float j, float k, float l,
        float m, float n, float o, float p
    ) {
        switch (mode) {
            case ROW_MAJOR:
                mSetRowMajor(a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p);
                break;
            case COL_MAJOR:
                mSetColMajor(a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p);
                break;
        }
    }
    
    protected void mSet(
        Matrix<?, ?> m
    ) {
        this.m[xx] = m.xx(); this.m[xy] = m.xy(); this.m[xz] = m.xz(); this.m[xw] = m.xw();
        this.m[yx] = m.yx(); this.m[yy] = m.yy(); this.m[yz] = m.yz(); this.m[yw] = m.yw();
        this.m[zx] = m.zx(); this.m[zy] = m.zy(); this.m[zz] = m.zz(); this.m[zw] = m.zw();
        this.m[wx] = m.wx(); this.m[wy] = m.wy(); this.m[wz] = m.wz(); this.m[ww] = m.ww();
    }
    
    protected void mSetRowMajor(
        Vector r0,
        Vector r1,
        Vector r2,
        Vector r3
    ) {
        m[xx] = r0.x(); m[xy] = r0.y(); m[xz] = r0.z(); m[xw] = r0.w();
        m[yx] = r1.x(); m[yy] = r1.y(); m[yz] = r1.z(); m[yw] = r1.w();
        m[zx] = r2.x(); m[zy] = r2.y(); m[zz] = r2.z(); m[zw] = r2.w();
        m[wx] = r3.x(); m[wy] = r3.y(); m[wz] = r3.z(); m[ww] = r3.w();
    }
    
    protected void mSetColMajor(
        Vector c0,
        Vector c1,
        Vector c2,
        Vector c3
    ) {
        m[xx] = c0.x(); m[xy] = c1.x(); m[xz] = c2.x(); m[xw] = c3.x();
        m[yx] = c0.y(); m[yy] = c1.y(); m[yz] = c2.y(); m[yw] = c3.y();
        m[zx] = c0.z(); m[zy] = c1.z(); m[zz] = c2.z(); m[zw] = c3.z();
        m[wx] = c0.w(); m[wy] = c1.w(); m[wz] = c2.w(); m[ww] = c3.w();
    }
    
    protected void mSetRowMajor(
        float a, float b, float c, float d,
        float e, float f, float g, float h,
        float i, float j, float k, float l,
        float m, float n, float o, float p
    ) {
        this.m[xx] = a; this.m[xy] = b; this.m[xz] = c; this.m[xw] = d;
        this.m[yx] = e; this.m[yy] = f; this.m[yz] = g; this.m[yw] = h;
        this.m[zx] = i; this.m[zy] = j; this.m[zz] = k; this.m[zw] = l;
        this.m[wx] = m; this.m[wy] = n; this.m[wz] = o; this.m[ww] = p;
    }
    
    protected void mSetColMajor(
        float a, float b, float c, float d,
        float e, float f, float g, float h,
        float i, float j, float k, float l,
        float m, float n, float o, float p
    ) {
        this.m[xx] = a; this.m[xy] = e; this.m[xz] = i; this.m[xw] = m;
        this.m[yx] = b; this.m[yy] = f; this.m[yz] = j; this.m[yw] = n;
        this.m[zx] = c; this.m[zy] = g; this.m[zz] = k; this.m[zw] = o;
        this.m[wx] = d; this.m[wy] = h; this.m[wz] = l; this.m[ww] = p;
    }
    
    @Override
    public float xx() {
        return m[xx];
    }
    
    @Override
    public float xy() {
        return m[xy];
    }
    
    @Override
    public float xz() {
        return m[xz];
    }
    
    @Override
    public float xw() {
        return m[xw];
    }
    
    @Override
    public float yx() {
        return m[yx];
    }
    
    @Override
    public float yy() {
        return m[yy];
    }
    
    @Override
    public float yz() {
        return m[yz];
    }
    
    @Override
    public float yw() {
        return m[yw];
    }
    
    @Override
    public float zx() {
        return m[zx];
    }
    
    @Override
    public float zy() {
        return m[zy];
    }
    
    @Override
    public float zz() {
        return m[zz];
    }
    
    @Override
    public float zw() {
        return m[zw];
    }
    
    @Override
    public float wx() {
        return m[wx];
    }
    
    @Override
    public float wy() {
        return m[wy];
    }
    
    @Override
    public float wz() {
        return m[wz];
    }
    
    @Override
    public float ww() {
        return m[ww];
    }
    
    @Override
    public final int m() {
        return 4;
    }
    
    @Override
    public final int n() {
        return 4;
    }
    
    @Override
    public Vector4 row(int i) {
        switch (i) {
            case 0:
                return new Vector4(m[xx], m[xy], m[xz], m[xw]);
            case 1:
                return new Vector4(m[yx], m[yy], m[yz], m[yw]);
            case 2:
                return new Vector4(m[zx], m[zy], m[zz], m[zw]);
            case 3:
                return new Vector4(m[wx], m[wy], m[wz], m[ww]);
        }
        return null;
    }
    
    @Override
    public Vector4 col(int j) {
        switch (j) {
            case 0:
                return new Vector4(m[xx], m[yx], m[zx], m[wx]);
            case 1:
                return new Vector4(m[xy], m[yy], m[zy], m[wy]);
            case 2:
                return new Vector4(m[xz], m[yz], m[zz], m[wz]);
            case 3:
                return new Vector4(m[xw], m[yw], m[zw], m[ww]);
        }
        return null;
    }
    
    @Override
    public Matrix<Vector4, Vector4> copy() {
        return new Matrix4(this);
    }
    
    @Override
    public String toString() {
        return Matrix4.toRowMajorString(this);
    }

    @Override
    public int hashCode() {
        return Matrix.hashCode(this);
    }

    @Override
    public boolean equals(Object o) {
        return o instanceof Matrix4 && Matrix.equals(this, (Matrix4) o, EPSILON);
    }

    public boolean equals(Matrix2 b) {
        return Matrix.equals(this, b, EPSILON);
    }

    public boolean equals(Matrix3 b) {
        return Matrix.equals(this, b, EPSILON);
    }

    public boolean equals(Matrix4 b) {
        return Matrix.equals(this, b, EPSILON);
    }
    
    public static String toString(Matrix<?, ?> m, int mode) {
        switch(mode) {
            default:
            case ROW_MAJOR: return Matrix4.toRowMajorString(m);
            case COL_MAJOR: return Matrix4.toColMajorString(m);
        }
    }
    
    public static String toRowMajorString(Matrix<?, ?> m) {
        return "[" +
            m.xx() + ", " + m.xy() + ", " + m.xz() + ", " + m.xw() + ", " +
            m.yx() + ", " + m.yy() + ", " + m.yz() + ", " + m.yw() + ", " +
            m.zx() + ", " + m.zy() + ", " + m.zz() + ", " + m.zw() + ", " +
            m.wx() + ", " + m.wy() + ", " + m.wz() + ", " + m.ww() + "]";
    }
    
    public static String toColMajorString(Matrix<?, ?> m) {
        return "[" +
            m.xx() + ", " + m.yx() + ", " + m.zx() + ", " + m.wx() + ", " +
            m.xy() + ", " + m.yy() + ", " + m.zy() + ", " + m.wy() + ", " +
            m.xz() + ", " + m.yz() + ", " + m.zz() + ", " + m.wz() + ", " +
            m.xw() + ", " + m.yw() + ", " + m.zw() + ", " + m.ww() + "]";
    }
    
    public static Matrix4 fromString(int mode, String s) {
        return Matrix4.fromString(new Matrix4(), mode, s);
    }
    
    public static Matrix4 fromRowMajorString(String s) {
        return Matrix4.fromString(new Matrix4(), ROW_MAJOR, s);
    }
    
    public static Matrix4 fromColMajorString(String s) {
        return Matrix4.fromString(new Matrix4(), COL_MAJOR, s);
    }
    
    protected static final String[]
        row_major = { "xx", "xy", "xz", "xw", "yx", "yy", "yz", "yw", "zx", "zy", "zz", "zw", "wx", "wy", "wz", "ww" },
        col_major = { "xx", "yx", "zx", "wx", "xy", "yy", "zy", "wy", "xz", "yz", "zz", "wz", "xw", "yw", "zw", "ww" };
    protected static <M extends Matrix4> M fromString(M m, int mode, String s) {
        if(m != null && s != null) {
            int
                i = s.indexOf("["),
                j = s.indexOf("]");
            if (i >= 0 || j >= 0) {
                if (j > i)
                    s = s.substring(++ i, j);
                else
                    s = s.substring(++ i   );
            }
    
            String[] t;
            switch(mode) {
                default:
                case ROW_MAJOR: t = parse(s, row_major); break;
                case COL_MAJOR: t = parse(s, col_major); break;
            }
            float[] u = new float[16];
            for(int n = 0; n < 16; n ++)
                u[n] = stringToFloat(t[n]);
            
            switch(mode) {
                default:
                case ROW_MAJOR:
                    m.mSetRowMajor(
                        u[ 0], u[ 1], u[ 2], u[ 3],
                        u[ 4], u[ 5], u[ 6], u[ 7],
                        u[ 8], u[ 9], u[10], u[11],
                        u[12], u[13], u[14], u[15]
                    ); break;
                case COL_MAJOR:
                    m.mSetColMajor(
                        u[ 0], u[ 1], u[ 2], u[ 3],
                        u[ 4], u[ 5], u[ 6], u[ 7],
                        u[ 8], u[ 9], u[10], u[11],
                        u[12], u[13], u[14], u[15]
                    ); break;
            }
        }
        return m;
    }
    
    public static Matrix4 identity() {
        return new Matrix4(
            ROW_MAJOR,
            1f, 0f, 0f, 0f,
            0f, 1f, 0f, 0f,
            0f, 0f, 1f, 0f,
            0f, 0f, 0f, 1f
        );
    }
    
    public static class Mutable extends Matrix4 implements Matrix.Mutable<Vector4, Vector4> {
        private static final long
            serialVersionUID = 1L;
        
        public Mutable() {
            super();
        }
        
        public Mutable(
            Matrix<?, ?> m
        ) {
            super(m);
        }
        
        public Mutable(
            int mode,
            Vector v0,
            Vector v1,
            Vector v2,
            Vector v3
        ) {
            super(mode, v0, v1, v2, v3);
        }
        
        public Mutable(
            int mode,
            float a, float b, float c, float d,
            float e, float f, float g, float h,
            float i, float j, float k, float l,
            float m, float n, float o, float p
        ) {
            super(mode, a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p);
        }
        
        @Override
        public Matrix4.Mutable xx(float xx) {
            m[Matrix4.xx] = xx; return this;
        }
        
        @Override
        public Matrix4.Mutable xy(float xy) {
            m[Matrix4.xy] = xy; return this;
        }
        
        @Override
        public Matrix4.Mutable xz(float xz) {
            m[Matrix4.xz] = xz; return this;
        }
        
        @Override
        public Matrix4.Mutable xw(float xw) {
            m[Matrix4.xw] = xw; return this;
        }
        
        @Override
        public Matrix4.Mutable yx(float yx) {
            m[Matrix4.yx] = yx; return this;
        }
        
        @Override
        public Matrix4.Mutable yy(float yy) {
            m[Matrix4.yy] = yy; return this;
        }
        
        @Override
        public Matrix4.Mutable yz(float yz) {
            m[Matrix4.yz] = yz; return this;
        }
        
        @Override
        public Matrix4.Mutable yw(float yw) {
            m[Matrix4.yw] = yw; return this;
        }
        
        @Override
        public Matrix4.Mutable zx(float zx) {
            m[Matrix4.zx] = zx; return this;
        }
        
        @Override
        public Matrix4.Mutable zy(float zy) {
            m[Matrix4.zy] = zy; return this;
        }
        
        @Override
        public Matrix4.Mutable zz(float zz) {
            m[Matrix4.zz] = zz; return this;
        }
        
        @Override
        public Matrix4.Mutable zw(float zw) {
            m[Matrix4.zw] = zw; return this;
        }
        
        @Override
        public Matrix4.Mutable wx(float wx) {
            m[Matrix4.wx] = wx; return this;
        }
        
        @Override
        public Matrix4.Mutable wy(float wy) {
            m[Matrix4.wy] = wy; return this;
        }
        
        @Override
        public Matrix4.Mutable wz(float wz) {
            m[Matrix4.wz] = wz; return this;
        }
        
        @Override
        public Matrix4.Mutable ww(float ww) {
            m[Matrix4.ww] = ww; return this;
        }
        
        @Override
        public Matrix4.Mutable row(int i, Vector r0) {
            return row(i, r0.x(), r0.y(), r0.z(), r0.w());
        }
        
        @Override
        public Matrix4.Mutable col(int j, Vector c0) {
            return col(j, c0.x(), c0.y(), c0.z(), c0.w());
        }
        
        public Matrix4.Mutable row(int i, float x, float y, float z, float w) {
            switch (i) {
                case 0: m[xx] = x; m[xy] = y; m[xz] = z; m[xw] = w; break;
                case 1: m[yx] = x; m[yy] = y; m[yz] = z; m[yw] = w; break;
                case 2: m[zx] = x; m[zy] = y; m[zz] = z; m[zw] = w; break;
                case 3: m[wx] = x; m[wy] = y; m[wz] = z; m[ww] = w; break;
            }
            return this;
        }
        
        public Matrix4.Mutable col(int j, float x, float y, float z, float w) {
            switch (j) {
                case 0: m[xx] = x; m[yx] = y; m[zx] = z; m[wx] = w; break;
                case 1: m[xy] = x; m[yy] = y; m[zy] = z; m[wy] = w; break;
                case 2: m[xz] = x; m[yz] = y; m[zz] = z; m[wz] = w; break;
                case 3: m[xw] = x; m[yw] = y; m[zw] = z; m[ww] = w; break;
            }
            return this;
        }
        
        public Matrix4.Mutable set(
            Matrix<?, ?> m
        ) {
            mSet(m);
            return this;
        }
        
        public Matrix4.Mutable setRowMajor(
            Vector r0,
            Vector r1,
            Vector r2,
            Vector r3
        ) {
            mSetRowMajor(r0, r1, r2, r3);
            return this;
        }
        
        public Matrix4.Mutable setColMajor(
            Vector c0,
            Vector c1,
            Vector c2,
            Vector c3
        ) {
            mSetColMajor(c0, c1, c2, c3);
            return this;
        }
        
        public Matrix4.Mutable setRowMajor(
            float a, float b, float c, float d,
            float e, float f, float g, float h,
            float i, float j, float k, float l,
            float m, float n, float o, float p
        ) {
            mSetRowMajor(a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p);
            return this;
        }
        
        public Matrix4.Mutable setColMajor(
            float a, float b, float c, float d,
            float e, float f, float g, float h,
            float i, float j, float k, float l,
            float m, float n, float o, float p
        ) {
            mSetColMajor(a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p);
            return this;
        }
        
        @Override
        public Matrix4.Mutable copy() {
            return new Matrix4.Mutable(this);
        }
    
        public static Matrix4.Mutable fromString(int mode, String s) {
            return Matrix4.fromString(new Matrix4.Mutable(), mode, s);
        }
    
        public static Matrix4.Mutable fromRowMajorString(String s) {
            return Matrix4.fromString(new Matrix4.Mutable(), ROW_MAJOR, s);
        }
    
        public static Matrix4.Mutable fromColMajorString(String s) {
            return Matrix4.fromString(new Matrix4.Mutable(), COL_MAJOR, s);
        }
        
        public static Matrix4.Mutable identity() {
            return new Matrix4.Mutable(
                ROW_MAJOR,
                1f, 0f, 0f, 0f,
                0f, 1f, 0f, 0f,
                0f, 0f, 1f, 0f,
                0f, 0f, 0f, 1f
            );
        }
    }
}
