package jasper;

import jasper.util.Debug;
import jasper.util.Version;

public class Jasper {
    public static final Version
        VERSION = new Version("Jasper", 0, 2, 2);
    
    public static void main(String[] args) {
        Debug.info(VERSION);
    }
}
