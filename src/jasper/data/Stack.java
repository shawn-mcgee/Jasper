package jasper.data;

import java.util.Iterator;

public interface Stack<T> extends Sequence<T> {
    public T push(T t);
    public T peek();
    public T pull();
    
    public void clear();
    
    @Override
    public Stack<T> copy();
    
    public static <T> Stack<T> from(Deque<T> deque) {
        return new Stack<>() {
            private static final long
                serialVersionUID = 1L;
            
            @Override
            public T push(T t) {
                return deque.pushTail(t);
            }
            
            @Override
            public T peek() {
                return deque.peekTail();
            }
            
            @Override
            public T pull() {
                return deque.pullTail();
            }
            
            @Override
            public void clear() {
                deque.clear();
            }
            
            @Override
            public int size() {
                return deque.size();
            }
            
            @Override
            public Iterable<T> forward() {
                return deque.forward();
            }
            
            @Override
            public Iterable<T> reverse() {
                return deque.reverse();
            }
            
            @Override
            public Iterator<T> iterator() {
                return deque.iterator();
            }
            
            @Override
            public jasper.data.Stack<T> copy() {
                return jasper.data.Stack.from(deque.copy());
            }
            
            @Override
            public String toString() {
                return deque.toString();
            }
        };
    }
    
    public static class b {
        protected boolean[]
            a   ;
        protected int
            size;
    
        public b() {
            a = new boolean[16];
        }
    
        public boolean push(boolean t) {
            if(size >= a.length)
                increase();
            return a[size ++] = t;
        }
    
        public boolean peek(boolean t) {
            return size > 0 ? a[size - 1] : t;
        }
    
        public boolean pull(boolean t) {
            return size > 0 ? a[ -- size] : t;
        }
    
        public int size() {
            return size;
        }
    
        protected void increase() {
            boolean[] b = new boolean[a.length + (a.length >> 1)];
            System.arraycopy(a, 0, b, 0, a.length);
            a = b;
        }
    
        protected void decrease() {
            boolean[] b = new boolean[a.length - (a.length >> 1)];
            System.arraycopy(a, 0, b, 0, b.length);
            a = b;
        }
    }
    
    public static class i08 {
        protected byte[]
            a   ;
        protected int
            size;
    
        public i08() {
            a = new byte[16];
        }
    
        public byte push(byte t) {
            if(size >= a.length)
                increase();
            return a[size ++] = t;
        }
    
        public byte peek(byte t) {
            return size > 0 ? a[size - 1] : t;
        }
    
        public byte pull(byte t) {
            return size > 0 ? a[ -- size] : t;
        }
    
        public int size() {
            return size;
        }
    
        protected void increase() {
            byte[] b = new byte[a.length + (a.length >> 1)];
            System.arraycopy(a, 0, b, 0, a.length);
            a = b;
        }
    
        protected void decrease() {
            byte[] b = new byte[a.length - (a.length >> 1)];
            System.arraycopy(a, 0, b, 0, b.length);
            a = b;
        }
    }
    
    public static class i16 {
        protected short[]
            a   ;
        protected int
            size;
    
        public i16() {
            a = new short[16];
        }
    
        public short push(short t) {
            if(size >= a.length)
                increase();
            return a[size ++] = t;
        }
    
        public short peek(short t) {
            return size > 0 ? a[size - 1] : t;
        }
    
        public short pull(short t) {
            return size > 0 ? a[ -- size] : t;
        }
    
        public int size() {
            return size;
        }
    
        protected void increase() {
            short[] b = new short[a.length + (a.length >> 1)];
            System.arraycopy(a, 0, b, 0, a.length);
            a = b;
        }
    
        protected void decrease() {
            short[] b = new short[a.length - (a.length >> 1)];
            System.arraycopy(a, 0, b, 0, b.length);
            a = b;
        }
    }
    
    public static class i32 {
        protected int[]
            a   ;
        protected int
            size;
    
        public i32() {
            a = new int[16];
        }
    
        public int push(int t) {
            if(size >= a.length)
                increase();
            return a[size ++] = t;
        }
    
        public int peek(int t) {
            return size > 0 ? a[size - 1] : t;
        }
    
        public int pull(int t) {
            return size > 0 ? a[ -- size] : t;
        }
    
        public int size() {
            return size;
        }
    
        protected void increase() {
            int[] b = new int[a.length + (a.length >> 1)];
            System.arraycopy(a, 0, b, 0, a.length);
            a = b;
        }
    
        protected void decrease() {
            int[] b = new int[a.length - (a.length >> 1)];
            System.arraycopy(a, 0, b, 0, b.length);
            a = b;
        }
    }
    
    public static class i64 {
        protected long[]
            a   ;
        protected int
            size;
    
        public i64() {
            a = new long[16];
        }
    
        public long push(long t) {
            if(size >= a.length)
                increase();
            return a[size ++] = t;
        }
    
        public long peek(long t) {
            return size > 0 ? a[size - 1] : t;
        }
    
        public long pull(long t) {
            return size > 0 ? a[ -- size] : t;
        }
    
        public int size() {
            return size;
        }
    
        protected void increase() {
            long[] b = new long[a.length + (a.length >> 1)];
            System.arraycopy(a, 0, b, 0, a.length);
            a = b;
        }
    
        protected void decrease() {
            long[] b = new long[a.length - (a.length >> 1)];
            System.arraycopy(a, 0, b, 0, b.length);
            a = b;
        }
    }
    
    public static class f32 {
        protected float[]
            a   ;
        protected int
            size;
    
        public f32() {
            a = new float[16];
        }
    
        public float push(float t) {
            if(size >= a.length)
                increase();
            return a[size ++] = t;
        }
    
        public float peek(float t) {
            return size > 0 ? a[size - 1] : t;
        }
    
        public float pull(float t) {
            return size > 0 ? a[ -- size] : t;
        }
    
        public int size() {
            return size;
        }
    
        protected void increase() {
            float[] b = new float[a.length + (a.length >> 1)];
            System.arraycopy(a, 0, b, 0, a.length);
            a = b;
        }
    
        protected void decrease() {
            float[] b = new float[a.length - (a.length >> 1)];
            System.arraycopy(a, 0, b, 0, b.length);
            a = b;
        }
    }
    
    public static class f64 {
        protected double[]
            a   ;
        protected int
            size;
        
        public f64() {
            a = new double[16];
        }
        
        public double push(double t) {
            if(size >= a.length)
                increase();
            return a[size ++] = t;
        }
        
        public double peek(double t) {
            return size > 0 ? a[size - 1] : t;
        }
        
        public double pull(double t) {
            return size > 0 ? a[ -- size] : t;
        }
        
        public int size() {
            return size;
        }
    
        protected void increase() {
            double[] b = new double[a.length + (a.length >> 1)];
            System.arraycopy(a, 0, b, 0, a.length);
            a = b;
        }
    
        protected void decrease() {
            double[] b = new double[a.length - (a.length >> 1)];
            System.arraycopy(a, 0, b, 0, b.length);
            a = b;
        }
    }
}
