package jasper;

import jasper.core.Engine;
import jasper.core.stage.Input;
import jasper.core.stage.Scene;
import jasper.core.stage.Stage;
import jasper.util.Debug;
import jasper.util.Version;
import jasper.util.event.Handle;

public class Jasper {
    public static final Version
        VERSION = new Version("Jasper", 0, 1, 1);
    
    public static void main(String[] args) {
        Debug.info(VERSION);
        
        Stage stage = new Stage();
        stage.loadConfiguration(Jasper.class, "jasper.cfg");
        
        stage.attach(Stage.WINDOW_EVENT, (event) -> {
            if(event.isClose())
                Engine.exit();
        });
        
        Engine.init(stage);
        
        stage.setScene(new Scene() {
            @Override
            public void onRender(RenderContext context) {
            
            }
        });
    }
}
