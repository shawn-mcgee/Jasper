package jasper.math;

import static jasper.util.StringToObject.stringToFloat;

public class Affine2 implements Matrix<Vector3, Vector2> {
    private static final long
        serialVersionUID = 1L;
    protected static final int
        xx = 0, xy = 1, xz = 2,
        yx = 3, yy = 4, yz = 5;
    protected final float[]
        m = new float[6];
    
    public Affine2() {
        // do nothing
    }
    
    public Affine2(
        Matrix<?, ?> m
    ) {
        mSet(m);
    }
    
    public Affine2(
        int mode,
        float a, float b, float c,
        float d, float e, float f
    ) {
        switch (mode) {
            case ROW_MAJOR:
                mSetRowMajor(a, b, c, d, e, f);
                break;
            case COL_MAJOR:
                mSetColMajor(a, b, c, d, e, f);
                break;
        }
    }
    
    protected void mSet(
        Matrix<?, ?> m
    ) {
        this.m[xx] = m.xx(); this.m[xy] = m.xy(); this.m[xz] = m.xz();
        this.m[yx] = m.yx(); this.m[yy] = m.yy(); this.m[yz] = m.yz();
    }
    
    protected void mSetRowMajor(
        Vector r0,
        Vector r1
    ) {
        m[xx] = r0.x(); m[xy] = r0.y(); m[xz] = r0.z();
        m[yx] = r1.x(); m[yy] = r1.y(); m[yz] = r1.z();
    }
    
    protected void mSetColMajor(
        Vector c0,
        Vector c1,
        Vector c2
    ) {
        m[xx] = c0.x(); m[xy] = c1.x(); m[xz] = c2.x();
        m[yx] = c0.y(); m[yy] = c1.y(); m[yz] = c2.y();
    }
    
    protected void mSetRowMajor(
        float a, float b, float c,
        float d, float e, float f
    ) {
        m[xx] = a; m[xy] = b; m[xz] = c;
        m[yx] = d; m[yy] = e; m[yz] = f;
    }
    
    protected void mSetColMajor(
        float a, float b, float c,
        float d, float e, float f
    ) {
        m[xx] = a; m[xy] = c; m[xz] = e;
        m[yx] = b; m[yy] = d; m[yz] = f;
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
    public Vector3 row(int i) {
        switch (i) {
            case 0:
                return new Vector3(m[xx], m[xy], m[xz]);
            case 1:
                return new Vector3(m[yx], m[yy], m[yz]);
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
            case 2:
                return new Vector2(m[xz], m[yz]);
        }
        return null;
    }
    
    @Override
    public Affine2 copy() {
        return new Affine2(this);
    }
    
    @Override
    public String toString() {
        return Affine2.toRowMajorString(this);
    }
    
    public static String toString(Matrix<?, ?> m, int mode) {
        switch(mode) {
            default:
            case ROW_MAJOR: return toRowMajorString(m);
            case COL_MAJOR: return toColMajorString(m);
        }
    }
    
    public static String toRowMajorString(Matrix<?, ?> m) {
        return "[" +
            m.xx() + ", " + m.xy() + ", " + m.xz() + ", " +
            m.yx() + ", " + m.yy() + ", " + m.yz() + "]";
    }
    
    public static String toColMajorString(Matrix<?, ?> m) {
        return "[" +
            m.xx() + ", " + m.yx() + ", " +
            m.xy() + ", " + m.yy() + ", " +
            m.xz() + ", " + m.yz() + "]";
    }
    
    public static Affine2 fromString(int mode, String s) {
        return Affine2.fromString(new Affine2(), mode, s);
    }
    
    public static Affine2 fromRowMajorString(String s) {
        return Affine2.fromString(new Affine2(), ROW_MAJOR, s);
    }
    
    public static Affine2 fromColMajorString(String s) {
        return Affine2.fromString(new Affine2(), COL_MAJOR, s);
    }
    
    protected static <T extends Affine2> T fromString(T m, int mode, String s) {
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
            
            String[] t = s.split(",");
            float[]  u = new float[6];
            int n = Math.min(t.length, u.length);
            
            for(int k = 0; k < n; k ++)
                u[k] = stringToFloat(t[k]);
            
            switch(mode) {
                default:
                case ROW_MAJOR:
                    m.mSetRowMajor(
                        u[0], u[1], u[2],
                        u[3], u[4], u[5]
                    ); break;
                case COL_MAJOR:
                    m.mSetColMajor(
                        u[0], u[1], u[2],
                        u[3], u[4], u[5]
                    ); break;
            }
        }
        return m;
    }
    
    public static Affine2 identity() {
        return new Affine2(
            ROW_MAJOR,
            1, 0, 0,
            0, 1, 0
        );
    }
    
    public static class Mutable extends Affine2 implements Matrix.Mutable<Vector3, Vector2> {
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
            float a, float b, float c,
            float d, float e, float f
        ) {
            super(mode, a, b, c, d, e, f);
        }
        
        @Override
        public float xx(float xx) {
            return m[Affine2.xx] = xx;
        }
    
        @Override
        public float xy(float xy) {
            return m[Affine2.xy] = xy;
        }
    
        @Override
        public float xz(float xz) {
            return m[Affine2.xz] = xz;
        }
    
        @Override
        public float yx(float yx) {
            return m[Affine2.yx] = yy;
        }
    
        @Override
        public float yy(float yy) {
            return m[Affine2.yy] = yy;
        }
    
        @Override
        public float yz(float yz) {
            return m[Affine2.yz] = yz;
        }
        
        @Override
        public Vector3 row(int i, Vector r0) {
            return row(i, r0.x(), r0.y(), r0.z());
        }
        
        @Override
        public Vector2 col(int j, Vector c0) {
            return col(j, c0.x(), c0.y()        );
        }
        
        public Vector3 row(int i, float x, float y, float z) {
            switch (i) {
                case 0:
                    return new Vector3(m[xx] = x, m[xy] = y, m[xz] = z);
                case 1:
                    return new Vector3(m[yx] = x, m[yy] = y, m[yz] = z);
            }
            return null;
        }
        
        public Vector2 col(int j, float x, float y) {
            switch (j) {
                case 0:
                    return new Vector2(m[xx] = x, m[yx] = y);
                case 1:
                    return new Vector2(m[xy] = x, m[yy] = y);
                case 2:
                    return new Vector2(m[xz] = x, m[yz] = y);
            }
            return null;
        }
        
        public Affine2.Mutable set(
            Matrix<?, ?> m
        ) {
            mSet(m);
            return this;
        }
        
        public Affine2.Mutable setRowMajor(
            Vector r0,
            Vector r1
        ) {
            mSetRowMajor(r0, r1);
            return this;
        }
        
        public Affine2.Mutable setColMajor(
            Vector c0,
            Vector c1,
            Vector c2
        ) {
            mSetColMajor(c0, c1, c2);
            return this;
        }
        
        public Affine2.Mutable setRowMajor(
            float a, float b, float c,
            float d, float e, float f
        ) {
            mSetRowMajor(a, b, c, d, e, f);
            return this;
        }
        
        public Affine2.Mutable setColMajor(
            float a, float b,
            float c, float d,
            float e, float f
        ) {
            mSetColMajor(a, b, c, d, e, f);
            return this;
        }
    
        @Override
        public Affine2.Mutable copy() {
            return new Affine2.Mutable(this);
        }
    
        public static Affine2.Mutable fromString(int mode, String s) {
            return Affine2.fromString(new Affine2.Mutable(), mode, s);
        }
    
        public static Affine2.Mutable fromRowMajorString(String s) {
            return Affine2.fromString(new Affine2.Mutable(), ROW_MAJOR, s);
        }
    
        public static Affine2.Mutable fromColMajorString(String s) {
            return Affine2.fromString(new Affine2.Mutable(), COL_MAJOR, s);
        }
    
        public static Affine2.Mutable identity() {
            return new Affine2.Mutable(
                ROW_MAJOR,
                1, 0, 0,
                0, 1, 0
            );
        }
    }
}
