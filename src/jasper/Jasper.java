package jasper;

import jasper.util.Debug;
import jasper.util.Version;

public class Jasper {
    public static final Version
        VERSION = new Version("Jasper", 0, 3, 1);
    
    public static void main(String[] args) {
        Debug.info(new Object() { }, VERSION);
    }
}
