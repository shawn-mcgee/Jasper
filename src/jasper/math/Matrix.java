package jasper.math;

import jasper.util.Copyable;
import jasper.util.Debug;

import java.io.Serializable;

public interface Matrix<ROW extends Vector, COL extends Vector> extends Copyable<Matrix<ROW, COL>>, Serializable {
    public static final float
        EPSILON = .001f;
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

    public static boolean equals(Matrix2 a, Matrix2 b, float e) {
        return equals(
            a.xx(), a.xy(),
            a.yx(), a.yy(),

            b.xx(), b.xy(),
            b.yx(), b.yy(),

            e
        );
    }

    public static boolean equals(Matrix2 a, Matrix3 b, float e) {
        return equals(
            a.xx(), a.xy(), 0f,
            a.yx(), a.yy(), 0f,
            0f    , 0f    , 0f,

            b.xx(), b.xy(), b.xz(),
            b.yx(), b.yy(), b.yz(),
            b.zx(), b.zy(), b.zz(),

            e
        );
    }

    public static boolean equals(Matrix3 a, Matrix2 b, float e) {
        return equals(
            a.xx(), a.xy(), a.xz(),
            a.yx(), a.yy(), a.yz(),
            a.zx(), a.zy(), a.zz(),

            b.xx(), b.xy(), 0f,
            b.yx(), b.yy(), 0f,
            0f    , 0f    , 0f,

            e
        );
    }

    public static boolean equals(Matrix3 a, Matrix3 b, float e) {
        return equals(
            a.xx(), a.xy(), a.xz(),
            a.yx(), a.yy(), a.yz(),
            a.zx(), a.zy(), a.zz(),

            b.xx(), b.xy(), b.xz(),
            b.yx(), b.yy(), b.yz(),
            b.zx(), b.zy(), b.zz(),

            e
        );
    }

    public static boolean equals(Matrix2 a, Matrix4 b, float e) {
        return equals(
            a.xx(), a.xy(), 0f, 0f,
            a.yx(), a.yy(), 0f, 0f,
            0f    , 0f    , 0f, 0f,
            0f    , 0f    , 0f, 0f,

            b.xx(), b.xy(), b.xz(), b.xw(),
            b.yx(), b.yy(), b.yz(), b.yw(),
            b.zx(), b.zy(), b.zz(), b.zw(),
            b.wx(), b.wy(), b.wz(), b.ww(),

            e
        );
    }

    public static boolean equals(Matrix3 a, Matrix4 b, float e) {
        return equals(
            a.xx(), a.xy(), a.xz(), 0f,
            a.yx(), a.yy(), a.yz(), 0f,
            a.zx(), a.zy(), a.zz(), 0f,
            0f    , 0f    , 0f    , 0f,

            b.xx(), b.xy(), b.xz(), b.xw(),
            b.yx(), b.yy(), b.yz(), b.yw(),
            b.zx(), b.zy(), b.zz(), b.zw(),
            b.wx(), b.wy(), b.wz(), b.ww(),

            e
        );
    }

    public static boolean equals(Matrix4 a, Matrix2 b, float e) {
        return equals(
            a.xx(), a.xy(), a.xz(), a.xw(),
            a.yx(), a.yy(), a.yz(), a.yw(),
            a.zx(), a.zy(), a.zz(), a.zw(),
            a.wx(), a.wy(), a.wz(), a.ww(),

            b.xx(), b.xy(), 0f, 0f,
            b.yx(), b.yy(), 0f, 0f,
            0f    , 0f    , 0f, 0f,
            0f    , 0f    , 0f, 0f,

            e
        );
    }

    public static boolean equals(Matrix4 a, Matrix3 b, float e) {
        return equals(
            a.xx(), a.xy(), a.xz(), a.xw(),
            a.yx(), a.yy(), a.yz(), a.yw(),
            a.zx(), a.zy(), a.zz(), a.zw(),
            a.wx(), a.wy(), a.wz(), a.ww(),

            b.xx(), b.xy(), b.xz(), 0f,
            b.yx(), b.yy(), b.yz(), 0f,
            b.zx(), b.zy(), b.zz(), 0f,
            0f    , 0f    , 0f    , 0f,

            e
        );
    }

    public static boolean equals(Matrix4 a, Matrix4 b, float e) {
        return equals(
            a.xx(), a.xy(), a.xz(), a.xw(),
            a.yx(), a.yy(), a.yz(), a.yw(),
            a.zx(), a.zy(), a.zz(), a.zw(),
            a.wx(), a.wy(), a.wz(), a.ww(),

            b.xx(), b.xy(), b.xz(), b.xw(),
            b.yx(), b.yy(), b.yz(), b.yw(),
            b.zx(), b.zy(), b.zz(), b.zw(),
            b.wx(), b.wy(), b.wz(), b.ww(),

            e
        );
    }

    public static boolean equals(
        float xx0, float xy0,
        float yx0, float yy0,

        float xx1, float xy1,
        float yx1, float yy1,

        float e
    ) {
        return
            (xx0 >= xx1 ? xx0 - xx1 : xx1 - xx0) < e &&
            (xy0 >= xy1 ? xy0 - xy1 : xy1 - xy0) < e &&
            (yx0 >= yx1 ? yx0 - yx1 : yx1 - yx0) < e &&
            (yy0 >= yy1 ? yy0 - yy1 : yy1 - yy0) < e;
    }

    public static boolean equals(
        float xx0, float xy0, float xz0,
        float yx0, float yy0, float yz0,
        float zx0, float zy0, float zz0,

        float xx1, float xy1, float xz1,
        float yx1, float yy1, float yz1,
        float zx1, float zy1, float zz1,

        float e
    ) {
        return
            (xx0 >= xx1 ? xx0 - xx1 : xx1 - xx0) < e &&
            (xy0 >= xy1 ? xy0 - xy1 : xy1 - xy0) < e &&
            (xz0 >= xz1 ? xz0 - xz1 : xz1 - xz0) < e &&

            (yx0 >= yx1 ? yx0 - yx1 : yx1 - yx0) < e &&
            (yy0 >= yy1 ? yy0 - yy1 : yy1 - yy0) < e &&
            (yz0 >= yz1 ? yz0 - yz1 : yz1 - yz0) < e &&

            (zx0 >= zx1 ? zx0 - zx1 : zx1 - zx0) < e &&
            (zy0 >= zy1 ? zy0 - zy1 : zy1 - zy0) < e &&
            (zz0 >= zz1 ? zz0 - zz1 : zz1 - zz0) < e;
    }

    public static boolean equals(
        float xx0, float xy0, float xz0, float xw0,
        float yx0, float yy0, float yz0, float yw0,
        float zx0, float zy0, float zz0, float zw0,
        float wx0, float wy0, float wz0, float ww0,

        float xx1, float xy1, float xz1, float xw1,
        float yx1, float yy1, float yz1, float yw1,
        float zx1, float zy1, float zz1, float zw1,
        float wx1, float wy1, float wz1, float ww1,

        float e
    ) {
        return
            (xx0 >= xx1 ? xx0 - xx1 : xx1 - xx0) < e &&
            (xy0 >= xy1 ? xy0 - xy1 : xy1 - xy0) < e &&
            (xz0 >= xz1 ? xz0 - xz1 : xz1 - xz0) < e &&
            (xw0 >= xw1 ? xw0 - xw1 : xw1 - xw0) < e &&

            (yx0 >= yx1 ? yx0 - yx1 : yx1 - yx0) < e &&
            (yy0 >= yy1 ? yy0 - yy1 : yy1 - yy0) < e &&
            (yz0 >= yz1 ? yz0 - yz1 : yz1 - yz0) < e &&
            (yw0 >= yw1 ? yw0 - yw1 : yw1 - yw0) < e &&

            (zx0 >= zx1 ? zx0 - zx1 : zx1 - zx0) < e &&
            (zy0 >= zy1 ? zy0 - zy1 : zy1 - zy0) < e &&
            (zz0 >= zz1 ? zz0 - zz1 : zz1 - zz0) < e &&
            (zw0 >= zw1 ? zw0 - zw1 : zw1 - zw0) < e &&

            (wx0 >= wx1 ? wx0 - wx1 : wx1 - wx0) < e &&
            (wy0 >= wy1 ? wy0 - wy1 : wy1 - wy0) < e &&
            (wz0 >= wz1 ? wz0 - wz1 : wz1 - wz0) < e &&
            (ww0 >= ww1 ? ww0 - ww1 : ww1 - ww0) < e;
    }

    public static int hashCode(Matrix2 a) {
        return hashCode(
            a.xx(), a.xy(),
            a.yx(), a.yy()
        );
    }

    public static int hashCode(Matrix3 a) {
        return hashCode(
            a.xx(), a.xy(), a.xz(),
            a.yx(), a.yy(), a.yz(),
            a.zx(), a.zy(), a.zz()
        );
    }

    public static int hashCode(Matrix4 a) {
        return hashCode(
            a.xx(), a.xy(), a.xz(), a.xw(),
            a.yx(), a.yy(), a.yz(), a.yw(),
            a.zx(), a.zy(), a.zz(), a.zw(),
            a.wx(), a.wy(), a.wz(), a.ww()
        );
    }

    public static int hashCode(
        float xx, float xy,
        float yx, float yy
    ) {
        return 7 +
            31 * Float.hashCode(xx) +
            31 * Float.hashCode(xy) +

            31 * Float.hashCode(yx) +
            31 * Float.hashCode(yy);
    }

    public static int hashCode(
        float xx, float xy, float xz,
        float yx, float yy, float yz,
        float zx, float zy, float zz
    ) {
        return 7 +
            31 * Float.hashCode(xx) +
            31 * Float.hashCode(xy) +
            31 * Float.hashCode(xz) +

            31 * Float.hashCode(yx) +
            31 * Float.hashCode(yy) +
            31 * Float.hashCode(yz) +

            31 * Float.hashCode(zx) +
            31 * Float.hashCode(zy) +
            31 * Float.hashCode(zz);
    }
    
    public static int hashCode(
        float xx, float xy, float xz, float xw,
        float yx, float yy, float yz, float yw,
        float zx, float zy, float zz, float zw,
        float wx, float wy, float wz, float ww
        
    ) {
        return 7 +
            31 * Float.hashCode(xx) +
            31 * Float.hashCode(xy) +
            31 * Float.hashCode(xz) +
            31 * Float.hashCode(xw) +

            31 * Float.hashCode(yx) +
            31 * Float.hashCode(yy) +
            31 * Float.hashCode(yz) +
            31 * Float.hashCode(yw) +

            31 * Float.hashCode(zx) +
            31 * Float.hashCode(zy) +
            31 * Float.hashCode(zz) +
            31 * Float.hashCode(zw) +

            31 * Float.hashCode(wx) +
            31 * Float.hashCode(wy) +
            31 * Float.hashCode(wz) +
            31 * Float.hashCode(ww);
    }
    
    public static Matrix2 add(Matrix2 a, Matrix2 b) {
        return new Matrix2(
            Matrix.ROW_MAJOR,
            a.xx() + b.xx(), a.xy() + b.xy(),
            a.yx() + b.yx(), a.yy() + b.yy()
        );
    }
    
    public static Matrix3 add(Matrix3 a, Matrix3 b) {
        return new Matrix3(
            Matrix.ROW_MAJOR,
            a.xx() + b.xx(), a.xy() + b.xy(), a.xz() + b.xz(),
            a.yx() + b.yx(), a.yy() + b.yy(), a.yz() + b.yz(),
            a.zx() + b.zx(), a.zy() + b.zy(), a.zz() + b.zz()
        );
    }
    
    public static Matrix4 add(Matrix4 a, Matrix4 b) {
        return new Matrix4(
            Matrix.ROW_MAJOR,
            a.xx() + b.xx(), a.xy() + b.xy(), a.xz() + b.xz(), a.xw() + b.xw(),
            a.yx() + b.yx(), a.yy() + b.yy(), a.yz() + b.yz(), a.yw() + b.yw(),
            a.zx() + b.zx(), a.zy() + b.zy(), a.zz() + b.zz(), a.zw() + b.zw(),
            a.wx() + b.wx(), a.wy() + b.wy(), a.wz() + b.wz(), a.ww() + b.ww()
        );
    }
    
    public static Matrix2.Mutable add(Matrix2 a, Matrix2 b, Matrix2.Mutable m) {
        return m.setRowMajor(
            a.xx() + b.xx(), a.xy() + b.xy(),
            a.yx() + b.yx(), a.yy() + b.yy()
        );
    }
    
    public static Matrix3.Mutable add(Matrix3 a, Matrix3 b, Matrix3.Mutable m) {
        return m.setRowMajor(
            a.xx() + b.xx(), a.xy() + b.xy(), a.xz() + b.xz(),
            a.yx() + b.yx(), a.yy() + b.yy(), a.yz() + b.yz(),
            a.zx() + b.zx(), a.zy() + b.zy(), a.zz() + b.zz()
        );
    }
    
    public static Matrix4.Mutable add(Matrix4 a, Matrix4 b, Matrix4.Mutable m) {
        return m.setRowMajor(
            a.xx() + b.xx(), a.xy() + b.xy(), a.xz() + b.xz(), a.xw() + b.xw(),
            a.yx() + b.yx(), a.yy() + b.yy(), a.yz() + b.yz(), a.yw() + b.yw(),
            a.zx() + b.zx(), a.zy() + b.zy(), a.zz() + b.zz(), a.zw() + b.zw(),
            a.wx() + b.wx(), a.wy() + b.wy(), a.wz() + b.wz(), a.ww() + b.ww()
        );
    }
    
    public static Matrix2 sub(Matrix2 a, Matrix2 b) {
        return new Matrix2(
            Matrix.ROW_MAJOR,
            a.xx() - b.xx(), a.xy() - b.xy(),
            a.yx() - b.yx(), a.yy() - b.yy()
        );
    }
    
    public static Matrix3 sub(Matrix3 a, Matrix3 b) {
        return new Matrix3(
            Matrix.ROW_MAJOR,
            a.xx() - b.xx(), a.xy() - b.xy(), a.xz() - b.xz(),
            a.yx() - b.yx(), a.yy() - b.yy(), a.yz() - b.yz(),
            a.zx() - b.zx(), a.zy() - b.zy(), a.zz() - b.zz()
        );
    }
    
    public static Matrix4 sub(Matrix4 a, Matrix4 b) {
        return new Matrix4(
            Matrix.ROW_MAJOR,
            a.xx() - b.xx(), a.xy() - b.xy(), a.xz() - b.xz(), a.xw() - b.xw(),
            a.yx() - b.yx(), a.yy() - b.yy(), a.yz() - b.yz(), a.yw() - b.yw(),
            a.zx() - b.zx(), a.zy() - b.zy(), a.zz() - b.zz(), a.zw() - b.zw(),
            a.wx() - b.wx(), a.wy() - b.wy(), a.wz() - b.wz(), a.ww() - b.ww()
        );
    }
    
    public static Matrix2.Mutable sub(Matrix2 a, Matrix2 b, Matrix2.Mutable m) {
        return m.setRowMajor(
            a.xx() - b.xx(), a.xy() - b.xy(),
            a.yx() - b.yx(), a.yy() - b.yy()
        );
    }
    
    public static Matrix3.Mutable sub(Matrix3 a, Matrix3 b, Matrix3.Mutable m) {
        return m.setRowMajor(
            a.xx() - b.xx(), a.xy() - b.xy(), a.xz() - b.xz(),
            a.yx() - b.yx(), a.yy() - b.yy(), a.yz() - b.yz(),
            a.zx() - b.zx(), a.zy() - b.zy(), a.zz() - b.zz()
        );
    }
    
    public static Matrix4.Mutable sub(Matrix4 a, Matrix4 b, Matrix4.Mutable m) {
        return m.setRowMajor(
            a.xx() - b.xx(), a.xy() - b.xy(), a.xz() - b.xz(), a.xw() - b.xw(),
            a.yx() - b.yx(), a.yy() - b.yy(), a.yz() - b.yz(), a.yw() - b.yw(),
            a.zx() - b.zx(), a.zy() - b.zy(), a.zz() - b.zz(), a.zw() - b.zw(),
            a.wx() - b.wx(), a.wy() - b.wy(), a.wz() - b.wz(), a.ww() - b.ww()
        );
    }
    
    public static Vector2 mul(Matrix2 a, Vector2 b) {
        return Matrix.mul(a, b.x(), b.y());
    }
    
    public static Vector2 mul(Vector2 a, Matrix2 b) {
        return Matrix.mul(a.x(), a.y(), b);
    }
    
    public static Vector2 mul(Matrix3 a, Vector2 b) {
        return Matrix.mul(a, b.x(), b.y());
    }
    
    public static Vector2 mul(Vector3 a, Matrix2 b) {
        return Matrix.mul(a.x(), a.y(), b);
    }
    
    public static Vector3 mul(Matrix3 a, Vector3 b) {
        return Matrix.mul(a, b.x(), b.y(), b.z());
    }
    
    public static Vector3 mul(Vector3 a, Matrix3 b) {
        return Matrix.mul(a.x(), a.y(), a.z(), b);
    }
    
    public static Vector3 mul(Matrix4 a, Vector3 b) {
        return Matrix.mul(a, b.x(), b.y(), b.z());
    }
    
    public static Vector3 mul(Vector3 a, Matrix4 b) {
        return Matrix.mul(a.x(), a.y(), a.z(), b);
    }
    
    public static Vector4 mul(Matrix4 a, Vector4 b) {
        return Matrix.mul(a, b.x(), b.y(), b.z(), b.w());
    }
    
    public static Vector4 mul(Vector4 a, Matrix4 b) {
        return Matrix.mul(a.x(), a.y(), a.z(), a.w(), b);
    }
    
    public static Vector2.Mutable mul(Matrix2 a, Vector2 b, Vector2.Mutable m) {
        return Matrix.mul(a, b.x(), b.y(), m);
    }
    
    public static Vector2.Mutable mul(Vector2 a, Matrix2 b, Vector2.Mutable m) {
        return Matrix.mul(a.x(), a.y(), b, m);
    }
    
    public static Vector2.Mutable mul(Matrix3 a, Vector2 b, Vector2.Mutable m) {
        return Matrix.mul(a, b.x(), b.y(), m);
    }
    
    public static Vector2.Mutable mul(Vector3 a, Matrix2 b, Vector2.Mutable m) {
        return Matrix.mul(a.x(), a.y(), b, m);
    }
    
    public static Vector3.Mutable mul(Matrix3 a, Vector3 b, Vector3.Mutable m) {
        return Matrix.mul(a, b.x(), b.y(), b.z(), m);
    }
    
    public static Vector3.Mutable mul(Vector3 a, Matrix3 b, Vector3.Mutable m) {
        return Matrix.mul(a.x(), a.y(), a.z(), b, m);
    }
    
    public static Vector3.Mutable mul(Matrix4 a, Vector3 b, Vector3.Mutable m) {
        return Matrix.mul(a, b.x(), b.y(), b.z(), m);
    }
    
    public static Vector3.Mutable mul(Vector3 a, Matrix4 b, Vector3.Mutable m) {
        return Matrix.mul(a.x(), a.y(), a.z(), b, m);
    }
    
    public static Vector4.Mutable mul(Matrix4 a, Vector4 b, Vector4.Mutable m) {
        return Matrix.mul(a, b.x(), b.y(), b.z(), b.w(), m);
    }
    
    public static Vector4.Mutable mul(Vector4 a, Matrix4 b, Vector4.Mutable m) {
        return Matrix.mul(a.x(), a.y(), a.z(), a.w(), b, m);
    }
    
    public static Vector2 mul(Matrix2 a, float x, float y) {
        return new Vector2(
            a.xx() * x + a.xy() * y,
            a.yx() * x + a.yy() * y
        );
    }
    
    public static Vector2 mul(float x, float y, Matrix2 b) {
        return new Vector2(
            x * b.xx() + y * b.yx(),
            x * b.xy() + y * b.yy()
        );
    }
    
    public static Vector2 mul(Matrix3 a, float x, float y) {
        return new Vector2(
            a.xx() * x + a.xy() * y + a.xz(),
            a.yx() * x + a.yy() * y + a.yz()
        );
    }
    
    public static Vector2 mul(float x, float y, Matrix3 b) {
        return new Vector2(
            x * b.xx() + y * b.yx() + b.zx(),
            x * b.xy() + y * b.yy() + b.zy()
        );
    }
    
    public static Vector3 mul(Matrix3 a, float x, float y, float z) {
        return new Vector3(
            a.xx() * x + a.xy() * y + a.xz() * z,
            a.yx() * x + a.yy() * y + a.yz() * z,
            a.zx() * x + a.zy() * y + a.zz() * z
        );
    }
    
    public static Vector3 mul(float x, float y, float z, Matrix3 b) {
        return new Vector3(
            x * b.xx() + y * b.yx() + z * b.zx(),
            x * b.xy() + y * b.yy() + z * b.zy(),
            x * b.xz() + y * b.yz() + z * b.zz()
        );
    }
    
    public static Vector3 mul(Matrix4 a, float x, float y, float z) {
        return new Vector3(
            a.xx() * x + a.xy() * y + a.xz() * z + a.xw(),
            a.yx() * x + a.yy() * y + a.yz() * z + a.yw(),
            a.zx() * x + a.zy() * y + a.zz() * z + a.zw()
        );
    }
    
    public static Vector3 mul(float x, float y, float z, Matrix4 b) {
        return new Vector3(
            x * b.xx() + y * b.yx() + z * b.zx() + b.wx(),
            x * b.xy() + y * b.yy() + z * b.zy() + b.wy(),
            x * b.xz() + y * b.yz() + z * b.zz() + b.wz()
        );
    }
    
    public static Vector4 mul(Matrix4 a, float x, float y, float z, float w) {
        return new Vector4(
            a.xx() * x + a.xy() * y + a.xz() * z + a.xw() * w,
            a.yx() * x + a.yy() * y + a.yz() * z + a.yw() * w,
            a.zx() * x + a.zy() * y + a.zz() * z + a.zw() * w,
            a.wx() * x + a.wy() * y + a.wz() * z + a.ww() * w
        );
    }
    
    public static Vector4 mul(float x, float y, float z, float w, Matrix4 b) {
        return new Vector4(
            x * b.xx() + y * b.yx() + z * b.zx() + w * b.wx(),
            x * b.xy() + y * b.yy() + z * b.zy() + w * b.wy(),
            x * b.xz() + y * b.yz() + z * b.zz() + w * b.wz(),
            x * b.xw() + y * b.yw() + z * b.zw() + w * b.ww()
        );
    }
    
    public static Vector2.Mutable mul(Matrix2 a, float x, float y, Vector2.Mutable m) {
        return m.set(
            a.xx() * x + a.xy() * y,
            a.yx() * x + a.yy() * y
        );
    }
    
    public static Vector2.Mutable mul(float x, float y, Matrix2 b, Vector2.Mutable m) {
        return m.set(
            x * b.xx() + y * b.yx(),
            x * b.xy() + y * b.yy()
        );
    }
    
    public static Vector2.Mutable mul(Matrix3 a, float x, float y, Vector2.Mutable m) {
        return m.set(
            a.xx() * x + a.xy() * y + a.xz(),
            a.yx() * x + a.yy() * y + a.yz()
        );
    }
    
    public static Vector2.Mutable mul(float x, float y, Matrix3 b, Vector2.Mutable m) {
        return m.set(
            x * b.xx() + y * b.yx() + b.zx(),
            x * b.xy() + y * b.yy() + b.zy()
        );
    }
    
    public static Vector3.Mutable mul(Matrix3 a, float x, float y, float z, Vector3.Mutable m) {
        return m.set(
            a.xx() * x + a.xy() * y + a.xz() * z,
            a.yx() * x + a.yy() * y + a.yz() * z,
            a.zx() * x + a.zy() * y + a.zz() * z
        );
    }
    
    public static Vector3.Mutable mul(float x, float y, float z, Matrix3 b, Vector3.Mutable m) {
        return m.set(
            x * b.xx() + y * b.yx() + z * b.zx(),
            x * b.xy() + y * b.yy() + z * b.zy(),
            x * b.xz() + y * b.yz() + z * b.zz()
        );
    }
    
    public static Vector3.Mutable mul(Matrix4 a, float x, float y, float z, Vector3.Mutable m) {
        return m.set(
            a.xx() * x + a.xy() * y + a.xz() * z + a.xw(),
            a.yx() * x + a.yy() * y + a.yz() * z + a.yw(),
            a.zx() * x + a.zy() * y + a.zz() * z + a.zw()
        );
    }
    
    public static Vector3.Mutable mul(float x, float y, float z, Matrix4 b, Vector3.Mutable m) {
        return m.set(
            x * b.xx() + y * b.yx() + z * b.zx() + b.wx(),
            x * b.xy() + y * b.yy() + z * b.zy() + b.wy(),
            x * b.xz() + y * b.yz() + z * b.zz() + b.wz()
        );
    }
    
    public static Vector4.Mutable mul(Matrix4 a, float x, float y, float z, float w, Vector4.Mutable m) {
        return m.set(
            a.xx() * x + a.xy() * y + a.xz() * z + a.xw() * w,
            a.yx() * x + a.yy() * y + a.yz() * z + a.yw() * w,
            a.zx() * x + a.zy() * y + a.zz() * z + a.zw() * w,
            a.wx() * x + a.wy() * y + a.wz() * z + a.ww() * w
        );
    }
    
    public static Vector4.Mutable mul(float x, float y, float z, float w, Matrix4 b, Vector4.Mutable m) {
        return m.set(
            x * b.xx() + y * b.yx() + z * b.zx() + w * b.wx(),
            x * b.xy() + y * b.yy() + z * b.zy() + w * b.wy(),
            x * b.xz() + y * b.yz() + z * b.zz() + w * b.wz(),
            x * b.xw() + y * b.yw() + z * b.zw() + w * b.ww()
        );
    }
    
    public static Matrix2 mul(Matrix2 a, Matrix2 b) {
        return new Matrix2(
            Matrix.ROW_MAJOR,
            // row a0 * col b0
            a.xx() * b.xx() + a.xy() * b.yx(),
            // row a0 * col b1
            a.xx() * b.xy() + a.xy() * b.yy(),
            
            // row a1 * col b0
            a.yx() * b.xx() + a.yy() * b.yx(),
            // row a1 * col b1
            a.yx() * b.xy() + a.yy() * b.yy()
        );
    }
    
    public static Matrix3 mul(Matrix3 a, Matrix3 b) {
        return new Matrix3(
            Matrix.ROW_MAJOR,
            // row a0 * col b0
            a.xx() * b.xx() + a.xy() * b.yx() + a.xz() * b.zx(),
            // row a0 * col b1
            a.xx() * b.xy() + a.xy() * b.yy() + a.xz() * b.zy(),
            // row a0 * col b2
            a.xx() * b.xz() + a.xy() * b.yz() + a.xz() * b.zz(),
    
            // row a1 * col b0
            a.yx() * b.xx() + a.yy() * b.yx() + a.yz() * b.zx(),
            // row a1 * col b1
            a.yx() * b.xy() + a.yy() * b.yy() + a.yz() * b.zy(),
            // row a1 * col b2
            a.yx() * b.xz() + a.yy() * b.yz() + a.yz() * b.zz(),
    
            // row a2 * col b0
            a.zx() * b.xx() + a.zy() * b.yx() + a.zz() * b.zx(),
            // row a2 * col b1
            a.zx() * b.xy() + a.zy() * b.yy() + a.zz() * b.zy(),
            // row a2 * col b2
            a.zx() * b.xz() + a.zy() * b.yz() + a.zz() * b.zz()
        );
    }
    
    public static Matrix4 mul(Matrix4 a, Matrix4 b) {
        return new Matrix4(
            Matrix.ROW_MAJOR,
            // row a0 * col b0
            a.xx() * b.xx() + a.xy() * b.yx() + a.xz() * b.zx() + a.xw() * b.wx(),
            // row a0 * col b1
            a.xx() * b.xy() + a.xy() * b.yy() + a.xz() * b.zy() + a.xw() * b.wy(),
            // row a0 * col b2
            a.xx() * b.xz() + a.xy() * b.yz() + a.xz() * b.zz() + a.xw() * b.wz(),
            // row a0 * col b3
            a.xx() * b.xw() + a.xy() * b.yw() + a.xz() * b.zw() + a.xw() * b.ww(),
    
            // row a1 * col b0
            a.yx() * b.xx() + a.yy() * b.yx() + a.yz() * b.zx() + a.yw() * b.wx(),
            // row a1 * col b1
            a.yx() * b.xy() + a.yy() * b.yy() + a.yz() * b.zy() + a.yw() * b.wy(),
            // row a1 * col b2
            a.yx() * b.xz() + a.yy() * b.yz() + a.yz() * b.zz() + a.yw() * b.wz(),
            // row a1 * col b3
            a.yx() * b.xw() + a.yy() * b.yw() + a.yz() * b.zw() + a.yw() * b.ww(),
    
            // row a2 * col b0
            a.zx() * b.xx() + a.zy() * b.yx() + a.zz() * b.zx() + a.zw() * b.wx(),
            // row a2 * col b1
            a.zx() * b.xy() + a.zy() * b.yy() + a.zz() * b.zy() + a.zw() * b.wy(),
            // row a2 * col b2
            a.zx() * b.xz() + a.zy() * b.yz() + a.zz() * b.zz() + a.zw() * b.wz(),
            // row a2 * col b3
            a.zx() * b.xw() + a.zy() * b.yw() + a.zz() * b.zw() + a.zw() * b.ww(),
    
            // row a3 * col b0
            a.wx() * b.xx() + a.wy() * b.yx() + a.wz() * b.zx() + a.ww() * b.wx(),
            // row a3 * col b1
            a.wx() * b.xy() + a.wy() * b.yy() + a.wz() * b.zy() + a.ww() * b.wy(),
            // row a3 * col b2
            a.wx() * b.xz() + a.wy() * b.yz() + a.wz() * b.zz() + a.ww() * b.wz(),
            // row a3 * col b3
            a.wx() * b.xw() + a.wy() * b.yw() + a.wz() * b.zw() + a.ww() * b.ww()
        );
    }
    
    public static Matrix2.Mutable mul(Matrix2 a, Matrix2 b, Matrix2.Mutable m) {
        return m.setRowMajor(
            // row a0 * col b0
            a.xx() * b.xx() + a.xy() * b.yx(),
            // row a0 * col b1
            a.xx() * b.xy() + a.xy() * b.yy(),
            
            // row a1 * col b0
            a.yx() * b.xx() + a.yy() * b.yx(),
            // row a1 * col b1
            a.yx() * b.xy() + a.yy() * b.yy()
        );
    }
    
    public static Matrix3.Mutable mul(Matrix3 a, Matrix3 b, Matrix3.Mutable m) {
        return m.setRowMajor(
            // row a0 * col b0
            a.xx() * b.xx() + a.xy() * b.yx() + a.xz() * b.zx(),
            // row a0 * col b1
            a.xx() * b.xy() + a.xy() * b.yy() + a.xz() * b.zy(),
            // row a0 * col b2
            a.xx() * b.xz() + a.xy() * b.yz() + a.xz() * b.zz(),
            
            // row a1 * col b0
            a.yx() * b.xx() + a.yy() * b.yx() + a.yz() * b.zx(),
            // row a1 * col b1
            a.yx() * b.xy() + a.yy() * b.yy() + a.yz() * b.zy(),
            // row a1 * col b2
            a.yx() * b.xz() + a.yy() * b.yz() + a.yz() * b.zz(),
            
            // row a2 * col b0
            a.zx() * b.xx() + a.zy() * b.yx() + a.zz() * b.zx(),
            // row a2 * col b1
            a.zx() * b.xy() + a.zy() * b.yy() + a.zz() * b.zy(),
            // row a2 * col b2
            a.zx() * b.xz() + a.zy() * b.yz() + a.zz() * b.zz()
        );
    }
    
    public static Matrix4.Mutable mul(Matrix4 a, Matrix4 b, Matrix4.Mutable m) {
        return m.setRowMajor(
            // row a0 * col b0
            a.xx() * b.xx() + a.xy() * b.yx() + a.xz() * b.zx() + a.xw() * b.wx(),
            // row a0 * col b1
            a.xx() * b.xy() + a.xy() * b.yy() + a.xz() * b.zy() + a.xw() * b.wy(),
            // row a0 * col b2
            a.xx() * b.xz() + a.xy() * b.yz() + a.xz() * b.zz() + a.xw() * b.wz(),
            // row a0 * col b3
            a.xx() * b.xw() + a.xy() * b.yw() + a.xz() * b.zw() + a.xw() * b.ww(),
            
            // row a1 * col b0
            a.yx() * b.xx() + a.yy() * b.yx() + a.yz() * b.zx() + a.yw() * b.wx(),
            // row a1 * col b1
            a.yx() * b.xy() + a.yy() * b.yy() + a.yz() * b.zy() + a.yw() * b.wy(),
            // row a1 * col b2
            a.yx() * b.xz() + a.yy() * b.yz() + a.yz() * b.zz() + a.yw() * b.wz(),
            // row a1 * col b3
            a.yx() * b.xw() + a.yy() * b.yw() + a.yz() * b.zw() + a.yw() * b.ww(),
            
            // row a2 * col b0
            a.zx() * b.xx() + a.zy() * b.yx() + a.zz() * b.zx() + a.zw() * b.wx(),
            // row a2 * col b1
            a.zx() * b.xy() + a.zy() * b.yy() + a.zz() * b.zy() + a.zw() * b.wy(),
            // row a2 * col b2
            a.zx() * b.xz() + a.zy() * b.yz() + a.zz() * b.zz() + a.zw() * b.wz(),
            // row a2 * col b3
            a.zx() * b.xw() + a.zy() * b.yw() + a.zz() * b.zw() + a.zw() * b.ww(),
            
            // row a3 * col b0
            a.wx() * b.xx() + a.wy() * b.yx() + a.wz() * b.zx() + a.ww() * b.wx(),
            // row a3 * col b1
            a.wx() * b.xy() + a.wy() * b.yy() + a.wz() * b.zy() + a.ww() * b.wy(),
            // row a3 * col b2
            a.wx() * b.xz() + a.wy() * b.yz() + a.wz() * b.zz() + a.ww() * b.wz(),
            // row a3 * col b3
            a.wx() * b.xw() + a.wy() * b.yw() + a.wz() * b.zw() + a.ww() * b.ww()
        );
    }
    
    public static float det(Matrix2 a) {
        return Matrix.det(
            a.xx(), a.xy(),
            a.yx(), a.yy()
        );
    }
    
    public static float det(Matrix3 a) {
        return Matrix.det(
            a.xx(), a.xy(), a.xz(),
            a.yx(), a.yy(), a.yz(),
            a.zx(), a.zy(), a.zz()
        );
    }
    
    public static float det(Matrix4 a) {
        return Matrix.det(
            a.xx(), a.xy(), a.xz(), a.xw(),
            a.yx(), a.yy(), a.yz(), a.yw(),
            a.zx(), a.zy(), a.zz(), a.zw(),
            a.wx(), a.wy(), a.wz(), a.ww()
        );
    }
    
    public static float det(
        float a, float b,
        float c, float d
    ) {
        return a * d - b * c;
    }
    
    public static float det(
        float a, float b, float c,
        float d, float e, float f,
        float g, float h, float i
    ) {
        return
            a * det(e, f, h, i) -
            b * det(d, f, g, i) +
            c * det(d, e, g, h);
    }
    
    public static float det(
        float a, float b, float c, float d,
        float e, float f, float g, float h,
        float i, float j, float k, float l,
        float m, float n, float o, float p
    ) {
        return
            a * det(f, g, h, j, k, l, n, o, p) -
            b * det(e, g, h, i, k, l, m, o, p) +
            c * det(e, f, h, i, j, l, m, n, p) -
            d * det(e, f, g, i, j, k, m, n, o);
    }
    
    public static Matrix2 inv(Matrix2 a) {
        return Matrix.inv(
            a.xx(), a.xy(),
            a.yx(), a.yy()
        );
    }
    
    public static Matrix3 inv(Matrix3 a) {
        return Matrix.inv(
            a.xx(), a.xy(), a.xz(),
            a.yx(), a.yy(), a.yz(),
            a.zx(), a.zy(), a.zz()
        );
    }
    
    public static Matrix4 inv(Matrix4 a) {
        return Matrix.inv(
            a.xx(), a.xy(), a.xz(), a.xw(),
            a.yx(), a.yy(), a.yz(), a.yw(),
            a.zx(), a.zy(), a.zz(), a.zw(),
            a.wx(), a.wy(), a.wz(), a.ww()
        );
    }
    
    public static Matrix2 inv(
        float a, float b,
        float c, float d
    ) {
        float d0 = det(a, b, c, d);
        if(d0 == 0f)
            return null;
        else
            return new Matrix2(
                Matrix.ROW_MAJOR,
                 d / d0, -b / d0,
                -c / d0,  a / d0
            );
    }
    
    public static Matrix3 inv(
        float a, float b, float c,
        float d, float e, float f,
        float g, float h, float i
    ) {
        float
            a_ = det(e, f, h, i),
            b_ = det(d, f, g, i),
            c_ = det(d, e, g, h),
            d0 = a * a_ - b * b_ + c * c_;
        if(d0 == 0f)
            return null;
        else {
            float
                d_ = det(b, c, h, i),
                e_ = det(a, c, g, i),
                f_ = det(a, b, g, h),
                g_ = det(b, c, e, f),
                h_ = det(a, c, d, f),
                i_ = det(a, b, d, e);
            return new Matrix3(
                Matrix.COL_MAJOR,
                + a_ / d0, - b_ / d0, + c_ / d0,
                - d_ / d0, + e_ / d0, - f_ / d0,
                + g_ / d0, - h_ / d0, + i_ / d0
            );
        }
    }
    
    public static Matrix4 inv(
        float a, float b, float c, float d,
        float e, float f, float g, float h,
        float i, float j, float k, float l,
        float m, float n, float o, float p
    ) {
        float
            a_ = det(f, g, h, j, k, l, n, o, p),
            b_ = det(e, g, h, i, k, l, m, o, p),
            c_ = det(e, f, h, i, j, l, m, n, p),
            d_ = det(e, f, g, i, j, k, m, n, o),
            d0 = a * a_ - b * b_ + c * c_ - d * d_;
        if(d0 == 0f)
            return null;
        else {
            float
                e_ = det(b, c, d, j, k, l, n, o, p),
                f_ = det(a, c, d, i, k, l, m, o, p),
                g_ = det(a, b, d, i, j, l, m, n, p),
                h_ = det(a, b, c, i, j, k, m, n, o),
                i_ = det(b, c, d, f, g, h, n, o, p),
                j_ = det(a, c, d, e, g, h, m, o, p),
                k_ = det(a, b, d, e, f, h, m, n, p),
                l_ = det(a, b, c, e, f, g, m, n, o),
                m_ = det(b, c, d, f, g, h, j, k, l),
                n_ = det(a, c, d, e, g, h, i, k, l),
                o_ = det(a, b, d, e, f, h, i, j, l),
                p_ = det(a, b, c, e, f, g, i, j, k);
            return new Matrix4(
                Matrix.COL_MAJOR,
                + a_ / d0, - b_ / d0, + c_ / d0, - d_ / d0,
                - e_ / d0, + f_ / d0, - g_ / d0, + h_ / d0,
                + i_ / d0, - j_ / d0, + k_ / d0, - l_ / d0,
                - m_ / d0, + n_ / d0, - o_ / d0, + p_ / d0
            );
        }
    }
    
    public static Matrix2.Mutable inv(
        float a, float b,
        float c, float d,
        Matrix2.Mutable m
    ) {
        float d0 = det(a, b, c, d);
        if(d0 == 0f)
            return null;
        else
            return m.setRowMajor(
                 d / d0, -b / d0,
                -c / d0,  a / d0
            );
    }
    
    public static Matrix3.Mutable inv(
        float a, float b, float c,
        float d, float e, float f,
        float g, float h, float i,
        Matrix3.Mutable m
    ) {
        float
            a_ = det(e, f, h, i),
            b_ = det(d, f, g, i),
            c_ = det(d, e, g, h),
            d0 = a * a_ - b * b_ + c * c_;
        if(d0 == 0f)
            return null;
        else {
            float
                d_ = det(b, c, h, i),
                e_ = det(a, c, g, i),
                f_ = det(a, b, g, h),
                g_ = det(b, c, e, f),
                h_ = det(a, c, d, f),
                i_ = det(a, b, d, e);
            return m.setColMajor(
                + a_ / d0, - b_ / d0, + c_ / d0,
                - d_ / d0, + e_ / d0, - f_ / d0,
                + g_ / d0, - h_ / d0, + i_ / d0
            );
        }
    }
    
    public static Matrix4.Mutable inv(
        float a, float b, float c, float d,
        float e, float f, float g, float h,
        float i, float j, float k, float l,
        float m, float n, float o, float p,
        Matrix4.Mutable q
    ) {
        float
            a_ = det(f, g, h, j, k, l, n, o, p),
            b_ = det(e, g, h, i, k, l, m, o, p),
            c_ = det(e, f, h, i, j, l, m, n, p),
            d_ = det(e, f, g, i, j, k, m, n, o),
            d0 = a * a_ - b * b_ + c * c_ - d * d_;
        if(d0 == 0f)
            return null;
        else {
            float
                e_ = det(b, c, d, j, k, l, n, o, p),
                f_ = det(a, c, d, i, k, l, m, o, p),
                g_ = det(a, b, d, i, j, l, m, n, p),
                h_ = det(a, b, c, i, j, k, m, n, o),
                i_ = det(b, c, d, f, g, h, n, o, p),
                j_ = det(a, c, d, e, g, h, m, o, p),
                k_ = det(a, b, d, e, f, h, m, n, p),
                l_ = det(a, b, c, e, f, g, m, n, o),
                m_ = det(b, c, d, f, g, h, j, k, l),
                n_ = det(a, c, d, e, g, h, i, k, l),
                o_ = det(a, b, d, e, f, h, i, j, l),
                p_ = det(a, b, c, e, f, g, i, j, k);
            return q.setColMajor(
                + a_ / d0, - b_ / d0, + c_ / d0, - d_ / d0,
                - e_ / d0, + f_ / d0, - g_ / d0, + h_ / d0,
                + i_ / d0, - j_ / d0, + k_ / d0, - l_ / d0,
                - m_ / d0, + n_ / d0, - o_ / d0, + p_ / d0
            );
        }
    }
    
    public static Matrix2 transpose(Matrix2 a) {
        return new Matrix2(
            Matrix.COL_MAJOR,
            a.xx(), a.xy(),
            a.yx(), a.yy()
        );
    }
    
    public static Matrix3 transpose(Matrix3 a) {
        return new Matrix3(
            Matrix.COL_MAJOR,
            a.xx(), a.xy(), a.xz(),
            a.yx(), a.yy(), a.yz(),
            a.zx(), a.zy(), a.zz()
        );
    }
    
    public static Matrix4 transpose(Matrix4 a) {
        return new Matrix4(
            Matrix.COL_MAJOR,
            a.xx(), a.xy(), a.xz(), a.xw(),
            a.yx(), a.yy(), a.yz(), a.yw(),
            a.zx(), a.zy(), a.zz(), a.zw(),
            a.wx(), a.wy(), a.wz(), a.ww()
        );
    }
    
    public static Matrix2.Mutable transpose(Matrix2 a, Matrix2.Mutable m) {
        return m.setColMajor(
            a.xx(), a.xy(),
            a.yx(), a.yy()
        );
    }
    
    public static Matrix3.Mutable transpose(Matrix3 a, Matrix3.Mutable m) {
        return m.setColMajor(
            a.xx(), a.xy(), a.xz(),
            a.yx(), a.yy(), a.yz(),
            a.zx(), a.zy(), a.zz()
        );
    }
    
    public static Matrix4.Mutable transpose(Matrix4 a, Matrix4.Mutable m) {
        return m.setColMajor(
            a.xx(), a.xy(), a.xz(), a.xw(),
            a.yx(), a.yy(), a.yz(), a.yw(),
            a.zx(), a.zy(), a.zz(), a.zw(),
            a.wx(), a.wy(), a.wz(), a.ww()
        );
    }
}
