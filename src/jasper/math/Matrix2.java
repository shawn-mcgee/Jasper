package jasper.math;

import static jasper.util.StringToObject.stringToFloat;
import static jasper.util.Utility.parse;

public class Matrix2 implements Matrix<Vector2, Vector2> {
    private static final long
        serialVersionUID = 1L;
    protected static final int
        xx = 0, xy = 1,
        yx = 2, yy = 3;
    protected final float[]
        m = new float[4];
    
    public Matrix2() {
        // do nothing
    }
    
    public Matrix2(
        Matrix<?, ?> m
    ) {
        mSet(m);
    }
    
    public Matrix2(
        int mode,
        Vector v0,
        Vector v1
    ) {
        switch (mode) {
            case ROW_MAJOR:
                mSetRowMajor(v0, v1);
                break;
            case COL_MAJOR:
                mSetColMajor(v0, v1);
                break;
        }
    }
    
    public Matrix2(
        int mode,
        float a, float b,
        float c, float d
    ) {
        switch (mode) {
            case ROW_MAJOR:
                mSetRowMajor(a, b, c, d);
                break;
            case COL_MAJOR:
                mSetColMajor(a, b, c, d);
                break;
        }
    }
    
    protected void mSet(
        Matrix<?, ?> m
    ) {
        this.m[xx] = m.xx(); this.m[xy] = m.xy();
        this.m[yx] = m.yx(); this.m[yy] = m.yy();
    }
    
    protected void mSetRowMajor(
        Vector r0,
        Vector r1
    ) {
        m[xx] = r0.x(); m[xy] = r0.y();
        m[yx] = r1.x(); m[yy] = r1.y();
    }
    
    protected void mSetColMajor(
        Vector c0,
        Vector c1
    ) {
        m[xx] = c0.x(); m[xy] = c1.x();
        m[yx] = c0.y(); m[yy] = c1.y();
    }
    
    protected void mSetRowMajor(
        float a, float b,
        float c, float d
    ) {
        m[xx] = a; m[xy] = b;
        m[yx] = c; m[yy] = d;
    }
    
    protected void mSetColMajor(
        float a, float b,
        float c, float d
    ) {
        m[xx] = a; m[xy] = c;
        m[yx] = b; m[yy] = d;
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
    public float yx() {
        return m[yx];
    }
    
    @Override
    public float yy() {
        return m[yy];
    }
    
    @Override
    public final int m() {
        return 2;
    }
    
    @Override
    public final int n() {
        return 2;
    }
    
    @Override
    public Vector2 row(int i) {
        switch (i) {
            case 0:
                return new Vector2(m[xx], m[xy]);
            case 1:
                return new Vector2(m[yx], m[yy]);
        }
        return null;
    }
    
    @Override
    public Vector2 col(int j) {
        switch (j) {
            case 0:
                return new Vector2(m[xx], m[yx]);
            case 1:
                return new Vector2(m[xy], m[yy]);
        }
        return null;
    }
    
    @Override
    public Matrix2 copy() {
        return new Matrix2(this);
    }
    
    @Override
    public String toString() {
        return Matrix2.toRowMajorString(this);
    }
    
    public static String toString(Matrix<?, ?> m, int mode) {
        switch(mode) {
            default:
            case ROW_MAJOR: return Matrix2.toRowMajorString(m);
            case COL_MAJOR: return Matrix2.toColMajorString(m);
        }
    }
    
    public static String toRowMajorString(Matrix<?, ?> m) {
        return "[" +
            m.xx() + ", " + m.xy() + ", " +
            m.yx() + ", " + m.yy() + "]";
    }
    
    public static String toColMajorString(Matrix<?, ?> m) {
        return "[" +
            m.xx() + ", " + m.yx() + ", " +
            m.xy() + ", " + m.yy() + "]";
    }
    
    public static Matrix2 fromString(int mode, String s) {
        return Matrix2.fromString(new Matrix2(), mode, s);
    }
    
    public static Matrix2 fromRowMajorString(String s) {
        return Matrix2.fromString(new Matrix2(), ROW_MAJOR, s);
    }
    
    public static Matrix2 fromColMajorString(String s) {
        return Matrix2.fromString(new Matrix2(), COL_MAJOR, s);
    }
    
    protected static final String[]
        row_major = { "xx", "xy", "yx", "yy"},
        col_major = { "xx", "yx", "xy", "yy"};
    protected static <M extends Matrix2> M fromString(M m, int mode, String s) {
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
            float[] u = new float[4];
            for(int n = 0; n < 4; n ++)
                u[n] = stringToFloat(t[n]);
            
            switch(mode) {
                default:
                case ROW_MAJOR:
                    m.mSetRowMajor(
                        u[0], u[1],
                        u[2], u[3]
                    ); break;
                case COL_MAJOR:
                    m.mSetColMajor(
                        u[0], u[1],
                        u[2], u[3]
                    ); break;
            }
        }
        return m;
    }
    
    public static Matrix2 identity() {
        return new Matrix2(
            ROW_MAJOR,
            1f, 0f,
            0f, 1f
        );
    }
    
    public static class Mutable extends Matrix2 implements Matrix.Mutable<Vector2, Vector2> {
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
            Vector v1
        ) {
            super(mode, v0, v1);
        }
        
        public Mutable(
            int mode,
            float a, float b,
            float c, float d
        ) {
            super(mode, a, b, c, d);
        }
        
        @Override
        public float xx(float xx) {
            return m[Matrix2.xx] = xx;
        }
        
        @Override
        public float xy(float xy) {
            return m[Matrix2.xy] = xy;
        }
        
        @Override
        public float yx(float yx) {
            return m[Matrix2.yx] = yx;
        }
        
        @Override
        public float yy(float yy) {
            return m[Matrix2.yy] = yy;
        }
        
        @Override
        public Vector2 row(int i, Vector r0) {
            return row(i, r0.x(), r0.y());
        }
        
        @Override
        public Vector2 col(int j, Vector c0) {
            return col(j, c0.x(), c0.y());
        }
        
        public Vector2 row(int i, float x, float y) {
            switch (i) {
                case 0:
                    return new Vector2(m[xx] = x, m[xy] = y);
                case 1:
                    return new Vector2(m[yx] = x, m[yy] = y);
            }
            return null;
        }
        
        public Vector2 col(int j, float x, float y) {
            switch (j) {
                case 0:
                    return new Vector2(m[xx] = x, m[yx] = y);
                case 1:
                    return new Vector2(m[xy] = x, m[yy] = y);
            }
            return null;
        }
        
        public Matrix2.Mutable set(
            Matrix<?, ?> m
        ) {
            mSet(m);
            return this;
        }
        
        public Matrix2.Mutable setRowMajor(
            Vector r0,
            Vector r1
        ) {
            mSetRowMajor(r0, r1);
            return this;
        }
        
        public Matrix2.Mutable setColMajor(
            Vector c0,
            Vector c1
        ) {
            mSetColMajor(c0, c1);
            return this;
        }
        
        public Matrix2.Mutable setRowMajor(
            float a, float b,
            float c, float d
        ) {
            mSetRowMajor(a, b, c, d);
            return this;
        }
        
        public Matrix2.Mutable setColMajor(
            float a, float b,
            float c, float d
        ) {
            mSetColMajor(a, b, c, d);
            return this;
        }
        
        @Override
        public Matrix2.Mutable copy() {
            return new Matrix2.Mutable(this);
        }
        
        public static Matrix2.Mutable fromString(int mode, String s) {
            return Matrix2.fromString(new Matrix2.Mutable(), mode, s);
        }
    
        public static Matrix2.Mutable fromRowMajorString(String s) {
            return Matrix2.fromString(new Matrix2.Mutable(), ROW_MAJOR, s);
        }
    
        public static Matrix2.Mutable fromColMajorString(String s) {
            return Matrix2.fromString(new Matrix2.Mutable(), COL_MAJOR, s);
        }
    
        public static Matrix2.Mutable identity() {
            return new Matrix2.Mutable(
                ROW_MAJOR,
                1f, 0f,
                0f, 1f
            );
        }
    }
}