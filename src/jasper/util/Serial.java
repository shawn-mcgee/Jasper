package jasper.util;

import java.io.Serializable;
import java.util.Iterator;
import java.util.Objects;

public interface Serial<T> extends Copyable<Serial<T>>, Iterable<T>, Serializable {
    public int size();
    
    public Iterable<T> forward();
    public Iterable<T> reverse();
    
    public default boolean includes(T t) {
        return Serial.includes(this, t);
    }
    
    public default boolean excludes(T t) {
        return Serial.excludes(this, t);
    }
    
    public default T[] toArray(T[] a) { return Serial.toArray(this, a); }
    
    public static <T> String toString(Iterable<T> a) {
        return toString(a, "%s");
    }
    
    public static <T> String toString(Iterable<T> a, String f) {
        Iterator<T> i = a.iterator();
        
        StringBuilder s = new StringBuilder();
        String g = ", " + f;
        
        s.append("{");
        if (i.hasNext())
            s.append(String.format(f, i.next()));
        while (i.hasNext())
            s.append(String.format(g, i.next()));
        s.append("}");
        
        return s.toString();
    }
    
    public static <T> T[] toArray(Iterable<T> a, T[] t) {
        Iterator<T> i = a.iterator();
        for(int j = 0; j < t.length && i.hasNext(); j ++)
            t[j] = i.next();
        return t;
    }
    
    public static <T> int count(T[] a, T t) {
        int n = 0;
        for (T u : a)
            if (Objects.equals(u, t))
                n++;
        return n;
    }
    
    public static <T> int index(T[] a, T t) {
        int i = 0;
        for (T u : a) {
            if (Objects.equals(u, t))
                return i;
            i++;
        }
        return -1;
    }
    
    public static <T> int count(Iterable<T> a, T t) {
        int n = 0;
        for (T u : a)
            if (Objects.equals(u, t))
                n++;
        return n;
    }
    
    public static <T> int index(Iterable<T> a, T t) {
        int i = 0;
        for (T u : a) {
            if (Objects.equals(u, t))
                return i;
            i++;
        }
        return -1;
    }
    
    public static <T> boolean includes(Iterable<T> a, T t) {
        for (T u : a)
            if (Objects.equals(u, t))
                return true;
        return false;
    }
    
    public static <T> boolean excludes(Iterable<T> a, T t) {
        for (T u : a)
            if (Objects.equals(u, t))
                return false;
        return true;
    }
    
    @SafeVarargs
    public static <T> boolean includesAll(Iterable<T> a, T... b) {
        for (T u : b)
            if (excludes(a, u))
                return false;
        return true;
    }
    
    @SafeVarargs
    public static <T> boolean includesAny(Iterable<T> a, T... b) {
        for (T u : b)
            if (includes(a, u))
                return true;
        return false;
    }
    
    @SafeVarargs
    public static <T> boolean excludesAll(Iterable<T> a, T... b) {
        for (T u : b)
            if (includes(a, u))
                return false;
        return true;
    }
    
    @SafeVarargs
    public static <T> boolean excludesAny(Iterable<T> a, T... b) {
        for (T u : b)
            if (excludes(a, u))
                return true;
        return false;
    }
    
    public static <T> boolean includesAll(Iterable<T> a, Iterable<T> b) {
        for (T u : b)
            if (excludes(a, u))
                return false;
        return true;
    }
    
    public static <T> boolean includesAny(Iterable<T> a, Iterable<T> b) {
        for (T u : b)
            if (includes(a, u))
                return true;
        return false;
    }
    
    public static <T> boolean excludesAll(Iterable<T> a, Iterable<T> b) {
        for (T u : b)
            if (includes(a, u))
                return false;
        return true;
    }
    
    public static <T> boolean excludesAny(Iterable<T> a, Iterable<T> b) {
        for (T u : b)
            if (excludes(a, u))
                return true;
        return false;
    }
    
    public static interface Stack<T> extends Serial<T> {
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
                public Stack<T> copy() {
                    return Stack.from(deque.copy());
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
    
    public static interface Queue<T> extends Serial<T> {
        public T push(T t);
        public T peek();
        public T pull();
        
        public void clear();
        
        @Override
        public Queue<T> copy();
        
        public static <T> Queue<T> from(Deque<T> deque) {
            return new Queue<>() {
                private static final long
                    serialVersionUID = 1L;
                
                @Override
                public T push(T t) {
                    return deque.pushHead(t);
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
                public Queue<T> copy() {
                    return Queue.from(deque.copy());
                }
        
                @Override
                public String toString() {
                    return deque.toString();
                }
            };
        }
    }
    
    public static interface Deque<T> extends Serial<T> {
        public T pushHead(T t);
        public T peekHead();
        public T pullHead();
        
        public T pushTail(T t);
        public T peekTail();
        public T pullTail();
        
        public void clear();
        
        @Override
        public Deque<T> copy();
        
        public static class b {
            protected boolean[]
                a;
            protected int
                head,
                tail,
                size;
            
            public b() {
                a = new boolean[16];
                head = 15;
                tail =  0;
                size =  0;
            }
            
            public boolean pushHead(boolean t) {
                if(head == tail)
                    increase();
                
                size ++;
                a[head] = t;
                head = decrement(head);
                
                return t;
            }
            
            public boolean peekHead(boolean t) {
                if(size > 0)
                    return a[            increment(head)];
                else
                    return t;
            }
            
            public boolean pullHead(boolean t) {
                if(size > 0) {
                    boolean u = a[head = increment(head)];
                    size  --;
                    return u;
                } else
                    return t;
            }
            
            public boolean pushTail(boolean t) {
                if(head == tail)
                    increase();
                
                size ++;
                a[tail] = t;
                tail = increment(tail);
                
                return t;
            }
            
            public boolean peekTail(boolean t) {
                if(size > 0)
                    return a[decrement(head)];
                else
                    return t;
            }
            
            public boolean pullTail(boolean t) {
                if(size > 0) {
                    boolean u = a[tail = decrement(tail)];
                    size  --;
                    return u;
                } else
                    return t;
            }
            
            public int size() {
                return size;
            }
        
            protected int increment(int i) {
                int j;
                return (j = i + 1) >= a.length ?            0 : j;
            }
        
            protected int decrement(int i) {
                int j;
                return (j = i - 1) < 0         ? a.length - 1 : j;
            }
            
            protected void increase() {
                int
                    m = a.length,
                    n = a.length << 1;
                boolean[] b = new boolean[n];
                int
                    h0 =     head + 1,
                    h1 = m - head - 1;
                System.arraycopy(a, h0, b,  0,   h1);
                System.arraycopy(a,  0, b, h1, tail);
                head = n - 1;
                tail = m - 1;
                a = b;
            }
        }
        
        public static class i08 {
            protected byte[]
                a;
            protected int
                head,
                tail,
                size;
            
            public i08() {
                a = new byte[16];
                head = 15;
                tail =  0;
                size =  0;
            }
            
            public byte pushHead(byte t) {
                if(head == tail)
                    increase();
                
                size ++;
                a[head] = t;
                head = decrement(head);
                
                return t;
            }
            
            public byte peekHead(byte t) {
                if(size > 0)
                    return a[            increment(head)];
                else
                    return t;
            }
            
            public byte pullHead(byte t) {
                if(size > 0) {
                    byte u = a[head = increment(head)];
                    size  --;
                    return u;
                } else
                    return t;
            }
            
            public byte pushTail(byte t) {
                if(head == tail)
                    increase();
                
                size ++;
                a[tail] = t;
                tail = increment(tail);
                
                return t;
            }
            
            public byte peekTail(byte t) {
                if(size > 0)
                    return a[decrement(head)];
                else
                    return t;
            }
            
            public byte pullTail(byte t) {
                if(size > 0) {
                    byte u = a[tail = decrement(tail)];
                    size  --;
                    return u;
                } else
                    return t;
            }
            
            public int size() {
                return size;
            }
            
            protected int increment(int i) {
                int j;
                return (j = i + 1) >= a.length ?            0 : j;
            }
            
            protected int decrement(int i) {
                int j;
                return (j = i - 1) < 0         ? a.length - 1 : j;
            }
            
            protected void increase() {
                int
                    m = a.length,
                    n = a.length << 1;
                byte[] b = new byte[n];
                int
                    h0 =     head + 1,
                    h1 = m - head - 1;
                System.arraycopy(a, h0, b,  0,   h1);
                System.arraycopy(a,  0, b, h1, tail);
                head = n - 1;
                tail = m - 1;
                a = b;
            }
        }
        
        public static class i16 {
            protected short[]
                a;
            protected int
                head,
                tail,
                size;
            
            public i16() {
                a = new short[16];
                head = 15;
                tail =  0;
                size =  0;
            }
            
            public short pushHead(short t) {
                if(head == tail)
                    increase();
                
                size ++;
                a[head] = t;
                head = decrement(head);
                
                return t;
            }
            
            public short peekHead(short t) {
                if(size > 0)
                    return a[            increment(head)];
                else
                    return t;
            }
            
            public short pullHead(short t) {
                if(size > 0) {
                    short u = a[head = increment(head)];
                    size  --;
                    return u;
                } else
                    return t;
            }
            
            public short pushTail(short t) {
                if(head == tail)
                    increase();
                
                size ++;
                a[tail] = t;
                tail = increment(tail);
                
                return t;
            }
            
            public short peekTail(short t) {
                if(size > 0)
                    return a[decrement(head)];
                else
                    return t;
            }
            
            public short pullTail(short t) {
                if(size > 0) {
                    short u = a[tail = decrement(tail)];
                    size  --;
                    return u;
                } else
                    return t;
            }
            
            public int size() {
                return size;
            }
            
            protected int increment(int i) {
                int j;
                return (j = i + 1) >= a.length ?            0 : j;
            }
            
            protected int decrement(int i) {
                int j;
                return (j = i - 1) < 0         ? a.length - 1 : j;
            }
            
            protected void increase() {
                int
                    m = a.length,
                    n = a.length << 1;
                short[] b = new short[n];
                int
                    h0 =     head + 1,
                    h1 = m - head - 1;
                System.arraycopy(a, h0, b,  0,   h1);
                System.arraycopy(a,  0, b, h1, tail);
                head = n - 1;
                tail = m - 1;
                a = b;
            }
        }
        
        public static class i32 {
            protected int[]
                a;
            protected int
                head,
                tail,
                size;
            
            public i32() {
                a = new int[16];
                head = 15;
                tail =  0;
                size =  0;
            }
            
            public int pushHead(int t) {
                if(head == tail)
                    increase();
                
                size ++;
                a[head] = t;
                head = decrement(head);
                
                return t;
            }
            
            public int peekHead(int t) {
                if(size > 0)
                    return a[            increment(head)];
                else
                    return t;
            }
            
            public int pullHead(int t) {
                if(size > 0) {
                    int u = a[head = increment(head)];
                    size  --;
                    return u;
                } else
                    return t;
            }
            
            public int pushTail(int t) {
                if(head == tail)
                    increase();
                
                size ++;
                a[tail] = t;
                tail = increment(tail);
                
                return t;
            }
            
            public int peekTail(int t) {
                if(size > 0)
                    return a[decrement(head)];
                else
                    return t;
            }
            
            public int pullTail(int t) {
                if(size > 0) {
                    int u = a[tail = decrement(tail)];
                    size  --;
                    return u;
                } else
                    return t;
            }
            
            public int size() {
                return size;
            }
            
            protected int increment(int i) {
                int j;
                return (j = i + 1) >= a.length ?            0 : j;
            }
            
            protected int decrement(int i) {
                int j;
                return (j = i - 1) < 0         ? a.length - 1 : j;
            }
            
            protected void increase() {
                int
                    m = a.length,
                    n = a.length << 1;
                int[] b = new int[n];
                int
                    h0 =     head + 1,
                    h1 = m - head - 1;
                System.arraycopy(a, h0, b,  0,   h1);
                System.arraycopy(a,  0, b, h1, tail);
                head = n - 1;
                tail = m - 1;
                a = b;
            }
        }
        
        public static class i64 {
            protected long[]
                a;
            protected int
                head,
                tail,
                size;
            
            public i64() {
                a = new long[16];
                head = 15;
                tail =  0;
                size =  0;
            }
            
            public long pushHead(long t) {
                if(head == tail)
                    increase();
                
                size ++;
                a[head] = t;
                head = decrement(head);
                
                return t;
            }
            
            public long peekHead(long t) {
                if(size > 0)
                    return a[            increment(head)];
                else
                    return t;
            }
            
            public long pullHead(long t) {
                if(size > 0) {
                    long u = a[head = increment(head)];
                    size  --;
                    return u;
                } else
                    return t;
            }
            
            public long pushTail(long t) {
                if(head == tail)
                    increase();
                
                size ++;
                a[tail] = t;
                tail = increment(tail);
                
                return t;
            }
            
            public long peekTail(long t) {
                if(size > 0)
                    return a[decrement(head)];
                else
                    return t;
            }
            
            public long pullTail(long t) {
                if(size > 0) {
                    long u = a[tail = decrement(tail)];
                    size  --;
                    return u;
                } else
                    return t;
            }
            
            public int size() {
                return size;
            }
            
            protected int increment(int i) {
                int j;
                return (j = i + 1) >= a.length ?            0 : j;
            }
            
            protected int decrement(int i) {
                int j;
                return (j = i - 1) < 0         ? a.length - 1 : j;
            }
            
            protected void increase() {
                int
                    m = a.length,
                    n = a.length << 1;
                long[] b = new long[n];
                int
                    h0 =     head + 1,
                    h1 = m - head - 1;
                System.arraycopy(a, h0, b,  0,   h1);
                System.arraycopy(a,  0, b, h1, tail);
                head = n - 1;
                tail = m - 1;
                a = b;
            }
        }
        
        public static class f32 {
            protected float[]
                a;
            protected int
                head,
                tail,
                size;
            
            public f32() {
                a = new float[16];
                head = 15;
                tail =  0;
                size =  0;
            }
            
            public float pushHead(float t) {
                if(head == tail)
                    increase();
                
                size ++;
                a[head] = t;
                head = decrement(head);
                
                return t;
            }
            
            public float peekHead(float t) {
                if(size > 0)
                    return a[            increment(head)];
                else
                    return t;
            }
            
            public float pullHead(float t) {
                if(size > 0) {
                    float u = a[head = increment(head)];
                    size  --;
                    return u;
                } else
                    return t;
            }
            
            public float pushTail(float t) {
                if(head == tail)
                    increase();
                
                size ++;
                a[tail] = t;
                tail = increment(tail);
                
                return t;
            }
            
            public float peekTail(float t) {
                if(size > 0)
                    return a[decrement(head)];
                else
                    return t;
            }
            
            public float pullTail(float t) {
                if(size > 0) {
                    float u = a[tail = decrement(tail)];
                    size  --;
                    return u;
                } else
                    return t;
            }
            
            public int size() {
                return size;
            }
            
            protected int increment(int i) {
                int j;
                return (j = i + 1) >= a.length ?            0 : j;
            }
            
            protected int decrement(int i) {
                int j;
                return (j = i - 1) < 0         ? a.length - 1 : j;
            }
            
            protected void increase() {
                int
                    m = a.length,
                    n = a.length << 1;
                float[] b = new float[n];
                int
                    h0 =     head + 1,
                    h1 = m - head - 1;
                System.arraycopy(a, h0, b,  0,   h1);
                System.arraycopy(a,  0, b, h1, tail);
                head = n - 1;
                tail = m - 1;
                a = b;
            }
        }
        
        public static class f64 {
            protected double[]
                a;
            protected int
                head,
                tail,
                size;
            
            public f64() {
                a = new double[16];
                head = 15;
                tail =  0;
                size =  0;
            }
            
            public double pushHead(double t) {
                if(head == tail)
                    increase();
                
                size ++;
                a[head] = t;
                head = decrement(head);
                
                return t;
            }
            
            public double peekHead(double t) {
                if(size > 0)
                    return a[            increment(head)];
                else
                    return t;
            }
            
            public double pullHead(double t) {
                if(size > 0) {
                    double u = a[head = increment(head)];
                    size  --;
                    return u;
                } else
                    return t;
            }
            
            public double pushTail(double t) {
                if(head == tail)
                    increase();
                
                size ++;
                a[tail] = t;
                tail = increment(tail);
                
                return t;
            }
            
            public double peekTail(double t) {
                if(size > 0)
                    return a[decrement(head)];
                else
                    return t;
            }
            
            public double pullTail(double t) {
                if(size > 0) {
                    double u = a[tail = decrement(tail)];
                    size  --;
                    return u;
                } else
                    return t;
            }
            
            public int size() {
                return size;
            }
            
            protected int increment(int i) {
                int j;
                return (j = i + 1) >= a.length ?            0 : j;
            }
            
            protected int decrement(int i) {
                int j;
                return (j = i - 1) < 0         ? a.length - 1 : j;
            }
            
            protected void increase() {
                int
                    m = a.length,
                    n = a.length << 1;
                double[] b = new double[n];
                int
                    h0 =     head + 1,
                    h1 = m - head - 1;
                System.arraycopy(a, h0, b,  0,   h1);
                System.arraycopy(a,  0, b, h1, tail);
                head = n - 1;
                tail = m - 1;
                a = b;
            }
        }
    }
}
