package jasper.core.scene;

import jasper.math.Region2;

import java.nio.file.Path;

public class Sprite implements Renderable, Updateable {
    protected final Region2.Mutable
        bounds = new Region2.Mutable();
    protected boolean
        flip,
        flop;
    
    
    @Override
    public void onRender(RenderContext context) {
    
    }
    
    @Override
    public void onUpdate(UpdateContext context) {
    
    }
    
    public static Sprite load(Class<?> loader, String path) {
        
        return null;
    }

    public static Sprite load(String path) {
        
        return null;
    }
    
    public static Sprite load(Path   path) {
        
        return null;
    }
    
    public static class Resource {
    
    }
}
