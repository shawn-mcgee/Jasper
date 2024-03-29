package jasper.math;

import static jasper.math.Math.EPSILON;
import static jasper.util.StringToObject.stringToFloat;
import static jasper.util.Utility.parse;

public class Matrix3 implements Matrix<Vector3, Vector3> {
    private static final long
        serialVersionUID = 1L;
    protected static final int
        xx = 0, xy = 1, xz = 2,
        yx = 3, yy = 4, yz = 5,
        zx = 6, zy = 7, zz = 8;
    protected final float[]
        m = new float[9];
    
    public Matrix3() {
        // do nothing
    }
    
    public Matrix3(
        Matrix<?, ?> m
    ) {
        mSet(m);
    }
    
    public Matrix3(
        int mode,
        Vector v0,
        Vector v1,
        Vector v2
    ) {
        switch (mode) {
            case ROW_MAJOR:
                mSetRowMajor(v0, v1, v2);
                break;
            case COL_MAJOR:
                mSetColMajor(v0, v1, v2);
                break;
        }
    }
    
    public Matrix3(
        int mode,
        float a, float b, float c,
        float d, float e, float f,
        float g, float h, float i
    ) {
        switch (mode) {
            case ROW_MAJOR:
                mSetRowMajor(a, b, c, d, e, f, g, h, i);
                break;
            case COL_MAJOR:
                mSetColMajor(a, b, c, d, e, f, g, h, i);
                break;
        }
    }
    
    protected void mSet(
        Matrix<?, ?> m
    ) {
        this.m[xx] = m.xx(); this.m[xy] = m.xy(); this.m[xz] = m.xz();
        this.m[yx] = m.yx(); this.m[yy] = m.yy(); this.m[yz] = m.yz();
        this.m[zx] = m.zx(); this.m[zy] = m.zy(); this.m[zz] = m.zz();
    }
    
    protected void mSetRowMajor(
        Vector r0,
        Vector r1,
        Vector r2
    ) {
        m[xx] = r0.x(); m[xy] = r0.y(); m[xz] = r0.z();
        m[yx] = r1.x(); m[yy] = r1.y(); m[yz] = r1.z();
        m[zx] = r2.x(); m[zy] = r2.y(); m[zz] = r2.z();
    }
    
    protected void mSetColMajor(
        Vector c0,
        Vector c1,
        Vector c2
    ) {
        m[xx] = c0.x(); m[xy] = c1.x(); m[xz] = c2.x();
        m[yx] = c0.y(); m[yy] = c1.y(); m[yz] = c2.y();
        m[zx] = c0.z(); m[zy] = c1.z(); m[zz] = c2.z();
    }
    
    protected void mSetRowMajor(
        float a, float b, float c,
        float d, float e, float f,
        float g, float h, float i
    ) {
        m[xx] = a; m[xy] = b; m[xz] = c;
        m[yx] = d; m[yy] = e; m[yz] = f;
        m[zx] = g; m[zy] = h; m[zz] = i;
    }
    
    protected void mSetColMajor(
        float a, float b, float c,
        float d, float e, float f,
        float g, float h, float i
    ) {
        m[xx] = a; m[xy] = d; m[xz] = g;
        m[yx] = b; m[yy] = e; m[yz] = h;
        m[zx] = c; m[zy] = f; m[zz] = i;
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
    public final int m() {
        return 3;
    }
    
    @Override
    public final int n() {
        return 3;
    }
    
    @Override
    public Vector3 row(int i) {
        switch (i) {
            case 0:
                return new Vector3(m[xx], m[xy], m[xz]);
            case 1:
                return new Vector3(m[yx], m[yy], m[yz]);
            case 2:
                return new Vector3(m[zx], m[zy], m[zz]);
        }
        return null;
    }
    
    @Override
    public Vector3 col(int j) {
        switch (j) {
            case 0:
                return new Vector3(m[xx], m[yx], m[zx]);
            case 1:
                return new Vector3(m[xy], m[yy], m[zy]);
            case 2:
                return new Vector3(m[xz], m[yz], m[zz]);
        }
        return null;
    }
    
    @Override
    public Matrix3 copy() {
        return new Matrix3(this);
    }
    
    @Override
    public String toString() {
        return Matrix3.toRowMajorString(this);
    }

    @Override
    public int hashCode() {
        return Matrix.hashCode(this);
    }

    @Override
    public boolean equals(Object o) {
        return o instanceof Matrix3 && Matrix.equals(this, (Matrix3) o, EPSILON);
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
            case ROW_MAJOR: return Matrix3.toRowMajorString(m);
            case COL_MAJOR: return Matrix3.toColMajorString(m);
        }
    }
    
    public static String toRowMajorString(Matrix<?, ?> m) {
        return "[" +
            m.xx() + ", " + m.xy() + ", " + m.xz() + ", " +
            m.yx() + ", " + m.yy() + ", " + m.yz() + ", " +
            m.zx() + ", " + m.zy() + ", " + m.zz() + "]";
    }
    
    public static String toColMajorString(Matrix<?, ?> m) {
        return "[" +
            m.xx() + ", " + m.yx() + ", " + m.zx() + ", " +
            m.xy() + ", " + m.yy() + ", " + m.zy() + ", " +
            m.xz() + ", " + m.yz() + ", " + m.zz() + "]";
    }
    
    public static Matrix3 fromString(int mode, String s) {
        return Matrix3.fromString(new Matrix3(), mode, s);
    }
    
    public static Matrix3 fromRowMajorString(String s) {
        return Matrix3.fromString(new Matrix3(), ROW_MAJOR, s);
    }
    
    public static Matrix3 fromColMajorString(String s) {
        return Matrix3.fromString(new Matrix3(), COL_MAJOR, s);
    }
    
    protected static final String[]
        row_major = { "xx", "xy", "xz", "yx", "yy", "yz", "zx", "zy", "zz" },
        col_major = { "xx", "yx", "zx", "xy", "yy", "zy", "xz", "yz", "zz" };
    protected static <M extends Matrix3> M fromString(M m, int mode, String s) {
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
            float[] u = new float[9];
            for(int n = 0; n < 9; n ++)
                u[n] = stringToFloat(t[n]);
            
            switch(mode) {
                default:
                case ROW_MAJOR:
                    m.mSetRowMajor(
                        u[0], u[1], u[2],
                        u[3], u[4], u[5],
                        u[6], u[7], u[8]
                    ); break;
                case COL_MAJOR:
                    m.mSetColMajor(
                        u[0], u[1], u[2],
                        u[3], u[4], u[5],
                        u[6], u[7], u[8]
                    ); break;
            }
        }
        return m;
    }
    
    public static Matrix3 identity() {
        return new Matrix3(
            Matrix.ROW_MAJOR,
            1f, 0f, 0f,
            0f, 1f, 0f,
            0f, 0f, 1f
        );
    }
    
    public static class Mutable extends Matrix3 implements Matrix.Mutable<Vector3, Vector3> {
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
            Vector v2
        ) {
            super(mode, v0, v1, v2);
        }
        
        public Mutable(
            int mode,
            float a, float b, float c,
            float d, float e, float f,
            float g, float h, float i
        ) {
            super(mode, a, b, c, d, e, f, g, h, i);
        }
        
        @Override
        public Matrix3.Mutable xx(float xx) {
            m[Matrix3.xx] = xx; return this;
        }
        
        @Override
        public Matrix3.Mutable xy(float xy) {
            m[Matrix3.xy] = xy; return this;
        }
        
        @Override
        public Matrix3.Mutable xz(float xz) {
            m[Matrix3.xz] = xz; return this;
        }
        
        @Override
        public Matrix3.Mutable yx(float yx) {
            m[Matrix3.yx] = yx; return this;
        }
        
        @Override
        public Matrix3.Mutable yy(float yy) {
            m[Matrix3.yy] = yy; return this;
        }
        
        @Override
        public Matrix3.Mutable yz(float yz) {
            m[Matrix3.yz] = yz; return this;
        }
        
        @Override
        public Matrix3.Mutable zx(float zx) {
            m[Matrix3.zx] = zx; return this;
        }
        
        @Override
        public Matrix3.Mutable zy(float zy) {
            m[Matrix3.zy] = zy; return this;
        }
        
        @Override
        public Matrix3.Mutable zz(float zz) {
            m[Matrix3.zz] = zz; return this;
        }
        
        @Override
        public Matrix3.Mutable row(int i, Vector r0) {
            return row(i, r0.x(), r0.y(), r0.z());
        }
        
        @Override
        public Matrix3.Mutable col(int j, Vector c0) {
            return col(j, c0.x(), c0.y(), c0.z());
        }
        
        public Matrix3.Mutable row(int i, float x, float y, float z) {
            switch (i) {
                case 0: m[xx] = x; m[xy] = y; m[xz] = z; break;
                case 1: m[yx] = x; m[yy] = y; m[yz] = z; break;
                case 2: m[zx] = x; m[zy] = y; m[zz] = z; break;
            }
            return this;
        }
        
        public Matrix3.Mutable col(int j, float x, float y, float z) {
            switch (j) {
                case 0: m[xx] = x; m[yx] = y; m[zx] = z; break;
                case 1: m[xy] = x; m[yy] = y; m[zy] = z; break;
                case 2: m[xz] = x; m[yz] = y; m[zz] = z; break;
            }
            return this;
        }
        
        public Matrix3.Mutable set(
            Matrix<?, ?> m
        ) {
            mSet(m);
            return this;
        }
        
        public Matrix3.Mutable setRowMajor(
            Vector r0,
            Vector r1,
            Vector r2
        ) {
            mSetRowMajor(r0, r1, r2);
            return this;
        }
        
        public Matrix3.Mutable setColMajor(
            Vector c0,
            Vector c1,
            Vector c2
        ) {
            mSetColMajor(c0, c1, c2);
            return this;
        }
        
        public Matrix3.Mutable setRowMajor(
            float a, float b, float c,
            float d, float e, float f,
            float g, float h, float i
        ) {
            mSetRowMajor(a, b, c, d, e, f, g, h, i);
            return this;
        }
        
        public Matrix3.Mutable setColMajor(
            float a, float b, float c,
            float d, float e, float f,
            float g, float h, float i
        ) {
            mSetColMajor(a, b, c, d, e, f, g, h, i);
            return this;
        }
        
        @Override
        public Matrix3.Mutable copy() {
            return new Matrix3.Mutable(this);
        }
    
        public static Matrix3.Mutable fromString(int mode, String s) {
            return Matrix3.fromString(new Matrix3.Mutable(), mode, s);
        }
    
        public static Matrix3.Mutable fromRowMajorString(String s) {
            return Matrix3.fromString(new Matrix3.Mutable(), ROW_MAJOR, s);
        }
    
        public static Matrix3.Mutable fromColMajorString(String s) {
            return Matrix3.fromString(new Matrix3.Mutable(), COL_MAJOR, s);
        }
        
        public static Matrix3.Mutable identity() {
            return new Matrix3.Mutable(
                Matrix.ROW_MAJOR,
                1f, 0f, 0f,
                0f, 1f, 0f,
                0f, 0f, 1f
            );
        }
    }
}
