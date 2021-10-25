package jasper.math;

public class Math {
    public static final float
        EPSILON = .001f;

    public static byte min(byte... x) {
        byte m = x[0];
        for(byte i = 1; i < x.length; i ++)
            if(x[i] < m)
                m = x[i];
        return m;
    }

    public static int min(int... x) {
        int m = x[0];
        for(int i = 1; i < x.length; i ++)
            if(x[i] < m)
                m = x[i];
        return m;
    }

    public static long min(long... x) {
        long m = x[0];
        for(int i = 1; i < x.length; i ++)
            if(x[i] < m)
                m = x[i];
        return m;
    }

    public static float min(float... x) {
        float m = x[0];
        for(int i = 1; i < x.length; i ++)
            if(x[i] < m)
                m = x[i];
        return m;
    }

    public static byte max(byte... x) {
        byte m = x[0];
        for(byte i = 1; i < x.length; i ++)
            if(x[i] > m)
                m = x[i];
        return m;
    }

    public static int max(int... x) {
        int m = x[0];
        for(int i = 1; i < x.length; i ++)
            if(x[i] > m)
                m = x[i];
        return m;
    }

    public static long max(long... x) {
        long m = x[0];
        for(int i = 1; i < x.length; i ++)
            if(x[i] > m)
                m = x[i];
        return m;
    }

    public static float max(float... x) {
        float m = x[0];
        for(int i = 1; i < x.length; i ++)
            if(x[i] > m)
                m = x[i];
        return m;
    }
}
