package jasper.core.awt;

import jasper.math.Vector2;

import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelListener;
import java.util.HashMap;

public class Input implements KeyListener, MouseListener, MouseWheelListener, MouseMotionListener {
    public static final Class<KeyEvent>
        KEY_EVENT = KeyEvent.class;
    public static final Class<MouseEvent>
        MOUSE_EVENT = MouseEvent.class;
    public static final Class<MouseMovedEvent>
        MOUSE_MOVED_EVENT = MouseMovedEvent.class;
    public static final Class<MouseWheelEvent>
        MOUSE_WHEEL_EVENT = MouseWheelEvent.class;

    protected final HashMap<Integer, Boolean>
        k0 = new HashMap<>(),
        k1 = new HashMap<>(),
        m0 = new HashMap<>(),
        m1 = new HashMap<>();
    protected final Vector2.Mutable
        mouse = new Vector2.Mutable();
    protected float
        wheel = 0f;
    
    protected final jasper.util.Event.Broker
        broker = new jasper.util.Event.Broker();
    protected final jasper.util.Event.Handle
        handle = new jasper.util.Event.Handle();
    
    protected final Stage
        stage;
    protected final Input
        self = this;
    
    public Input(Stage stage) {
        this.stage = stage;
        
        handle.attach(KEY_EVENT  , this::onKeyEvent  );
        handle.attach(MOUSE_EVENT, this::onMouseEvent);
        handle.attach(MOUSE_MOVED_EVENT, this::onMouseMovedEvent);
        handle.attach(MOUSE_WHEEL_EVENT, this::onMouseWheelEvent);
        
        broker.attach(handle);
        broker.attach(      );
    }
    
    public Stage getStage() {
        return stage;
    }
    
    public boolean isKeyUp(int key) {
        Boolean b;
        return (b = k1.get(key)) == null || !b;
    }
    
    public boolean isKeyDown(int key) {
        Boolean b;
        return (b = k1.get(key)) != null &&  b;
    }
    
    public boolean isMouseUp(int mouse) {
        Boolean b;
        return (b = m1.get(mouse)) == null || !b;
    }
    
    public boolean isMouseDown(int mouse) {
        Boolean b;
        return (b = m1.get(mouse)) != null &&  b;
    }
    
    public Vector2 getMouse() {
        return new Vector2(mouse);
    }
    
    public float   getWheel() {
        return wheel;
    }
    
    public boolean isWheelUp() {
        return getWheel() < 0;
    }
    
    public boolean isWheelDown() {
        return getWheel() > 0;
    }
    
    public <T extends Input.Event<?>> void queue(T event) {
        broker.queue(event);
    }
    
    public void poll() {
        wheel = 0f;
        broker.poll();
    }
    
    public void onKeyEvent(KeyEvent event) {
        if (event.isDown()) {
            k1.put(event.id, true );
            stage.onKeyDown(event.id);
        } else {
            k1.put(event.id, false);
            stage.onKeyUp(event.id);
        }
        stage.flush(event);
    }
    
    public void onMouseEvent(MouseEvent event) {
        if(event.isDown()) {
            m1.put(event.id, true );
            stage.onMouseDown(event.id);
        } else {
            m1.put(event.id, false);
            stage.onMouseUp(event.id);
        }
        stage.flush(event);
    }
    
    public void onMouseMovedEvent(MouseMovedEvent event) {
        mouse.set(event.value);
        stage.onMouseMoved(event.value);
        stage.flush(event);
    }
    
    public void onMouseWheelEvent(MouseWheelEvent event) {
        wheel = event.value;
        stage.onMouseWheel(event.value);
        stage.flush(event);
    }
    
    public void onClose() {
        // do nothing
    }
    
    public void onFocus() {
        // do nothing
    }
    
    public void onUnfocus() {
        k0.forEach((id, value) -> {
            if(value) queue(  new KeyEvent(self, false, id));
        });
        m0.forEach((id, value) -> {
            if(value) queue(new MouseEvent(self, false, id));
        });
    }
    
    @Override
    public void keyTyped(java.awt.event.KeyEvent ke) {
        // do nothing
    }
    
    @Override
    public void keyPressed(java.awt.event.KeyEvent ke) {
        int id = ke.getKeyCode();
        Boolean b  =  k0.get(id);
        if(b == null || !b) {
            k0.put(id, true );
            queue(new KeyEvent(self, true , id));
        }
    }
    
    @Override
    public void keyReleased(java.awt.event.KeyEvent ke) {
        int id = ke.getKeyCode();
        Boolean b  =  k0.get(id);
        if(b != null &&  b) {
            k0.put(id, false);
            queue(new KeyEvent(self, false, id));
        }
    }
    
    @Override
    public void mouseClicked(java.awt.event.MouseEvent me) {
        // do nothing
    }
    
    @Override
    public void mousePressed(java.awt.event.MouseEvent me) {
        int id = me.getButton( );
        Boolean b  =  m0.get(id);
        if(b == null || !b) {
            m0.put(id, true );
            queue(new MouseEvent(self, true , id));
        }
    }
    
    @Override
    public void mouseReleased(java.awt.event.MouseEvent me) {
        int id = me.getButton( );
        Boolean b  =  m0.get(id);
        if(b != null &&  b) {
            m0.put(id, false);
            queue(new MouseEvent(self, false, id));
        }
    }
    
    @Override
    public void mouseEntered(java.awt.event.MouseEvent me) {
        // do nothing
    }
    
    @Override
    public void mouseExited(java.awt.event.MouseEvent me) {
        // do nothing
    }
    
    @Override
    public void mouseDragged(java.awt.event.MouseEvent me) {
        Vector2 mouse = stage.logicalToVirtual(me.getX(), me.getY());
        queue(new MouseMovedEvent(self, mouse));
    }
    
    @Override
    public void mouseMoved(java.awt.event.MouseEvent me) {
        Vector2 mouse = stage.logicalToVirtual(me.getX(), me.getY());
        queue(new MouseMovedEvent(self, mouse));
    }
    
    @Override
    public void mouseWheelMoved(java.awt.event.MouseWheelEvent mwe) {
        queue(new MouseWheelEvent(self, mwe.getWheelRotation()));
    }
    
    public static class Event<T> {
        public final Input
            input;
        public final T
            value;
        
        public Event(Input input, T value) {
            this.input = input;
            this.value = value;
        }
    }
    
    public static class KeyEvent extends Input.Event<Boolean> {
        public final int
            id;
        
        public KeyEvent(Input input, boolean value, int id) {
            super(input, value);
            this.id = id;
        }
        
        public boolean isKey(int id) {
            return this.id == id;
        }
        
        public boolean isDown() {
            return  value;
        }
        
        public boolean isUp() {
            return !value;
        }
    }
    
    public static class MouseEvent extends Input.Event<Boolean> {
        public final int
            id;
        
        public MouseEvent(Input input, boolean value, int id) {
            super(input, value);
            this.id = id;
        }
        
        public boolean isMouse(int id) {
            return this.id == id;
        }
        
        public boolean isDown() {
            return  value;
        }
        
        public boolean isUp() {
            return !value;
        }
    }
    
    public static class MouseMovedEvent extends Input.Event<Vector2> {
        public MouseMovedEvent(Input input, Vector2 value) {
            super(input, value);
        }
    }
    
    public static class MouseWheelEvent extends Input.Event<Float  > {
        public MouseWheelEvent(Input input, float value) {
            super(input, value);
        }
    
        public boolean isDown() {
            return value > 0f;
        }
        
        public boolean isUp() {
            return value < 0f;
        }
    }
}
