package jasper;

import jasper.core.Engine;
import jasper.core.scene.Stage;
import jasper.util.Debug;
import jasper.util.Version;

public class Jasper {
    public static final Version
        VERSION = new Version("Jasper", 0, 1, 1);
    
    public static void main(String[] args) {
        Debug.info(VERSION);
        
        Engine.init(new Stage());
    }
}
