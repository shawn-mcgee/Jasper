package jasper.core.stage;

import jasper.math.Vector2;

import java.io.Serializable;

public class Scene implements Serializable, Renderable, Updateable {
    protected static final long
        serialVersionUID = 1L;
    
    protected transient Stage
        stage;
    protected transient Input
        input;
    
    public Scene() {
        onCreate();
    }
    
    public void onCreate() { }
    public void onAttach() { }
    public void onDetach() { }
    public void onResize(Vector2 canvas) { }
    
    public void onUpdate(UpdateContext context) { }
    public void onRender(RenderContext context) { }
    
    public void onKeyUp(int key) { }
    public void onKeyDown(int key) { }
    public void onMouseUp(int mouse) { }
    public void onMouseDown(int mouse) { }
    public void onMouseMoved(Vector2 mouse) { }
    public void onMouseWheel(float   wheel) { }
    
    public void onClose() { }
    public void onFocus() { }
    public void onUnfocus() { }
}
