package jasper.util;

public final class Random {
    private Random() {
        // do nothing
    }

    /**
     * @return a new 8-bit LFSR seeded with System.nanoTime()
     */
    public static final LFSR08 LFSR08() {
        byte seed = (byte) System.nanoTime();
        return new LFSR08(seed != 0 ? seed : LFSR08.DEFAULT_MODE);
    }

    /**
     * @return a new 16-bit LFSR seeded with System.nanoTime()
     */
    public static final LFSR16 LFSR16() {
        short seed = (short) System.nanoTime();
        return new LFSR16(seed != 0 ? seed : LFSR16.DEFAULT_MODE);
    }

    /**
     * @return a new 32-bit LFSR seeded with System.nanoTime()
     */
    public static final LFSR32 LFSR32() {
        int seed = (int) System.nanoTime();
        return new LFSR32(seed != 0 ? seed : LFSR32.DEFAULT_MODE);
    }

    /**
     * @return a new 64-bit LFSR seeded with System.nanoTime()
     */
    public static final LFSR64 LFSR64() {
        long seed = System.nanoTime();
        return new LFSR64(seed != 0 ? seed : LFSR64.DEFAULT_MODE);
    }

    /**
     * 8-bit Linear Feedback Shift Register
     */
    public static final class LFSR08 {
        private final static byte
            DEFAULT_MODE = (byte) 1,
            DEFAULT_MASK = (byte) -123; // 8-bit mask with maximum periodicity
        private byte
            mode;
        private final byte mask;

        public LFSR08() {
            this(
                DEFAULT_MODE,
                DEFAULT_MASK
            );
        }

        public LFSR08(byte mode) {
            this(
                mode,
                DEFAULT_MASK
            );
        }

        public LFSR08(byte mode, byte mask) {
            if (mode == 0)
                throw new IllegalArgumentException("LFSR cannot be set to zero");
            this.mode = mode;
            this.mask = mask;
        }

        public byte next() {
            byte lsb = (byte) (mode & 1);
            mode >>= 1;
            if (lsb == 1)
                mode ^= mask;
            return mode;
        }

        public byte next(byte u) {
            byte n = next();
            n = (byte) (n >= 0 ? n : -n - 1);
            u = (byte) (u >= 1 ? u : 1);
            return (byte) (n % u);
        }
    }

    /**
     * 16-bit Linear Feedback Shift Register
     */
    public static final class LFSR16 {
        private final static short
            DEFAULT_MODE = (short) 1,
            DEFAULT_MASK = (short) -32758; // 16-bit mask with maximum periodicity
        private short
            mode;
        private final short mask;
        
        public LFSR16() {
            this(
                DEFAULT_MODE,
                DEFAULT_MASK
            );
        }
        
        public LFSR16(short mode) {
            this(
                mode,
                DEFAULT_MASK
            );
        }
        
        public LFSR16(short mode, short mask) {
            if (mode == 0)
                throw new IllegalArgumentException("LFSR cannot be set to zero");
            this.mode = mode;
            this.mask = mask;
        }
        
        public short next() {
            short lsb = (short) (mode & 1);
            mode >>= 1;
            if (lsb == 1)
                mode ^= mask;
            return mode;
        }
        
        public short next(short u) {
            short n = next();
            n = (short) (n >= 0 ? n : -n - 1);
            u = (short) (u >= 1 ? u : 1);
            return (short) (n % u);
        }
    }

    /**
     * 32-bit Linear Feedback Shift Register
     */
    public static final class LFSR32 {
        private final static int
            DEFAULT_MODE = 1,
            DEFAULT_MASK = -2147483607;// 32-bit mask with maximum periodicity
        private int
            mode;
        private final int mask;
        
        public LFSR32() {
            this(
                DEFAULT_MODE,
                DEFAULT_MASK
            );
        }
        
        public LFSR32(int mode) {
            this(
                mode,
                DEFAULT_MASK
            );
        }
        
        public LFSR32(int mode, int mask) {
            if (mode == 0)
                throw new IllegalArgumentException("LFSR cannot be set to zero");
            this.mode = mode;
            this.mask = mask;
        }
        
        public int next() {
            int lsb = mode & 1;
            mode >>= 1;
            if (lsb == 1)
                mode ^= mask;
            return mode;
        }
        
        public int next(int u) {
            int n = next();
            n = n >= 0 ? n : -n - 1;
            u = u >= 1 ? u : 1;
            return n % u;
        }
    }

    /**
     * 64-bit Linear Feedback Shift Register
     */
    public static final class LFSR64 {
        private final static long
            DEFAULT_MODE = 1L,
            DEFAULT_MASK = -2147483607;//-9223372036854775775L;
        private long
            mode;
        private final long mask;
        
        public LFSR64() {
            this(
                DEFAULT_MODE,
                DEFAULT_MASK
            );
        }
        
        public LFSR64(long mode) {
            this(
                mode,
                DEFAULT_MASK
            );
        }
        
        public LFSR64(long mode, long mask) {
            if (mode == 0)
                throw new IllegalArgumentException("LFSR cannot be set to zero");
            this.mode = mode;
            this.mask = mask;
        }
        
        public long next() {
            long lsb = mode & 1;
            mode >>= 1;
            if (lsb == 1)
                mode ^= mask;
            return mode;
        }
        
        public long next(long u) {
            long n = next();
            n = n >= 0 ? n : -n - 1;
            u = u >= 1 ? u : 1;
            return n % u;
        }
    }
}
