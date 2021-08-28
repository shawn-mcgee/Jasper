package jasper.math;

import jasper.util.Copyable;

import java.io.Serializable;

public interface Transform extends Copyable<Transform>, Serializable {
    
    public default float tx() { return 0; }
    public default float ty() { return 0; }
    public default float tz() { return 0; }
    
    public default float rx() { return 0; }
    public default float ry() { return 0; }
    public default float rz() { return 0; }
    
    public static interface Mutable extends Transform {
        
        public default Transform tx(float tx) { return this; }
        public default Transform ty(float ty) { return this; }
        public default Transform tz(float tz) { return this; }
    
        public default Transform rx(float rx) { return this; }
        public default Transform ry(float ry) { return this; }
        public default Transform rz(float rz) { return this; }
    }


    
}
