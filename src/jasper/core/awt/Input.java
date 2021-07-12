package jasper.core.awt;

import jasper.math.Vector2;

import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelListener;

import static java.awt.event.KeyEvent.*;

public class Input implements KeyListener, MouseListener, MouseWheelListener, MouseMotionListener {
    public static final Class<KeyEvent>
        KEY_EVENT = KeyEvent.class;
    public static final Class<MouseEvent>
        MOUSE_EVENT = MouseEvent.class;
    public static final Class<MouseMovedEvent>
        MOUSE_MOVED_EVENT = MouseMovedEvent.class;
    public static final Class<MouseWheelEvent>
        MOUSE_WHEEL_EVENT = MouseWheelEvent.class;
    
    protected static final int
        k = 128,
        m =   6;
    protected final boolean[]
        key0   = new boolean[k],
        key1   = new boolean[k],
        mouse0 = new boolean[m],
        mouse1 = new boolean[m];
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
        return !key1[key];
    }
    
    public boolean isKeyDown(int key) {
        return key1[key];
    }
    
    public boolean isMouseUp(int mouse) {
        return !mouse1[mouse];
    }
    
    public boolean isMouseDown(int mouse) {
        return mouse1[mouse];
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
        if(event.id >= 0 && event.id < k) {
            if (event.isDown()) {
                key1[event.id] = true;
                stage.onKeyDown(event.id);
            } else {
                key1[event.id] = false;
                stage.onKeyUp(event.id);
            }
            stage.flush(event);
        }
    }
    
    public void onMouseEvent(MouseEvent event) {
        if(event.id >= 0 && event.id < m) {
            if(event.isDown()) {
                mouse1[event.id] = true;
                stage.onMouseDown(event.id);
            } else {
                mouse1[event.id] = false;
                stage.onMouseUp(event.id);
            }
            stage.flush(event);
        }
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
        for(int id = 0; id < k; id ++)
            if(  key0[id]) queue(  new KeyEvent(self, false, id));
        for(int id = 0; id < m; id ++)
            if(mouse0[id]) queue(new MouseEvent(self, false, id));
    }
    
    @Override
    public void keyTyped(java.awt.event.KeyEvent ke) {
        // do nothing
    }
    
    @Override
    public void keyPressed(java.awt.event.KeyEvent ke) {
        int id = KeyEvent.from(ke);
        if(!key0[id]) {
            key0[id] = true;
            queue(new KeyEvent(self, true , id));
        }
    }
    
    @Override
    public void keyReleased(java.awt.event.KeyEvent ke) {
        int id = KeyEvent.from(ke);
        if( key0[id]) {
            key0[id] = false;
            queue(new KeyEvent(self, false, id));
        }
    }
    
    @Override
    public void mouseClicked(java.awt.event.MouseEvent me) {
        // do nothing
    }
    
    @Override
    public void mousePressed(java.awt.event.MouseEvent me) {
        int id = MouseEvent.from(me);
        if(!mouse0[id]) {
            mouse0[id] = true;
            queue(new MouseEvent(self, true , id));
        }
    }
    
    @Override
    public void mouseReleased(java.awt.event.MouseEvent me) {
        int id = MouseEvent.from(me);
        if( mouse0[id]) {
            mouse0[id] = false;
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
    
        public static final int from(java.awt.event.KeyEvent ke) {
            switch(ke.getKeyCode()) {
                /*ASCII:   0 -  31*/
                case VK_BACK_SPACE   : return KEY_BACKSPACE;
                case VK_TAB          : return KEY_TAB      ;
                case VK_ENTER        : return KEY_ENTER    ;
                case VK_ESCAPE       : return KEY_ESCAPE   ;
                /*ASCII:  32 -  47*/
                case VK_SPACE        : return KEY_SPACE    ;
                case VK_QUOTE        : return KEY_QUOTE    ;
                case VK_ASTERISK     : return KEY_ASTERISK ;
                case VK_PLUS         : return KEY_PLUS     ;
                case VK_COMMA        : return KEY_COMMA    ;
                case VK_MINUS        : return KEY_MINUS    ;
                case VK_PERIOD       : return KEY_PERIOD   ;
                case VK_SLASH        : return KEY_SLASH    ;
                /*ASCII:  48 -  57*/
                case VK_0            : return KEY_0        ;
                case VK_1            : return KEY_1        ;
                case VK_2            : return KEY_2        ;
                case VK_3            : return KEY_3        ;
                case VK_4            : return KEY_4        ;
                case VK_5            : return KEY_5        ;
                case VK_6            : return KEY_6        ;
                case VK_7            : return KEY_7        ;
                case VK_8            : return KEY_8        ;
                case VK_9            : return KEY_9        ;
                /*ASCII:  58 -  64*/
                case VK_SEMICOLON    : return KEY_SEMICOLON;
                case VK_EQUALS       : return KEY_EQUALS   ;
                /*ASCII:  65 -  90*/
                case VK_A            : return KEY_A        ;
                case VK_B            : return KEY_B        ;
                case VK_C            : return KEY_C        ;
                case VK_D            : return KEY_D        ;
                case VK_E            : return KEY_E        ;
                case VK_F            : return KEY_F        ;
                case VK_G            : return KEY_G        ;
                case VK_H            : return KEY_H        ;
                case VK_I            : return KEY_I        ;
                case VK_J            : return KEY_J        ;
                case VK_K            : return KEY_K        ;
                case VK_L            : return KEY_L        ;
                case VK_M            : return KEY_M        ;
                case VK_N            : return KEY_N        ;
                case VK_O            : return KEY_O        ;
                case VK_P            : return KEY_P        ;
                case VK_Q            : return KEY_Q        ;
                case VK_R            : return KEY_R        ;
                case VK_S            : return KEY_S        ;
                case VK_T            : return KEY_T        ;
                case VK_U            : return KEY_U        ;
                case VK_V            : return KEY_V        ;
                case VK_W            : return KEY_W        ;
                case VK_X            : return KEY_X        ;
                case VK_Y            : return KEY_Y        ;
                case VK_Z            : return KEY_Z        ;
                /*ASCII:  91 -  96*/
                case VK_OPEN_BRACKET : return KEY_L_BRACKET;
                case VK_BACK_SLASH   : return KEY_BACKSLASH;
                case VK_CLOSE_BRACKET: return KEY_R_BRACKET;
                case VK_BACK_QUOTE   : return KEY_BACKQUOTE;
                /*ASCII:  97 - 127*/
                case VK_DELETE       : return KEY_DELETE   ;
            }
            return 0;
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
        
        public static final int from(java.awt.event.MouseEvent me) {
            switch(me.getButton()) {
                case 1: return MOUSE_1;
                case 2: return MOUSE_2;
                case 3: return MOUSE_3;
                case 4: return MOUSE_4;
                case 5: return MOUSE_5;
            }
            return 0;
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
    
    public static final int
        /*MOUSE*/
        MOUSE_1              = 1,
        MOUSE_2              = 2,
        MOUSE_3              = 3,
        MOUSE_4              = 4,
        MOUSE_5              = 5;
    
    public static final int
        /*ASCII:   0 -  31*/
        KEY_BACKSPACE        = '\b',// 08
        KEY_TAB              = '\t',// 09
        KEY_ENTER            = '\n',// 10
        KEY_ESCAPE           = 0x1B,// 27
    
        /*ASCII:  32 -  47*/
        KEY_SPACE            = ' ', // 32
        KEY_QUOTE            = '\'',// 39
        KEY_ASTERISK         = '*', // 42
        KEY_PLUS             = '+', // 43
        KEY_COMMA            = ',', // 44
        KEY_MINUS            = '-', // 45
        KEY_PERIOD           = '.', // 46
        KEY_SLASH            = '/', // 47
    
        /*ASCII:  48 -  57*/
        KEY_0                = '0', // 48
        KEY_1                = '1', // 49
        KEY_2                = '2', // 50
        KEY_3                = '3', // 51
        KEY_4                = '4', // 52
        KEY_5                = '5', // 53
        KEY_6                = '6', // 54
        KEY_7                = '7', // 55
        KEY_8                = '8', // 56
        KEY_9                = '9', // 57
    
        /*ASCII:  58 -  64*/
        KEY_SEMICOLON        = ';', // 59
        KEY_EQUALS           = '=', // 61
    
        /*ASCII:  65 -  90*/
        KEY_A                = 'A', // 65
        KEY_B                = 'B', // 66
        KEY_C                = 'C', // 67
        KEY_D                = 'D', // 68
        KEY_E                = 'E', // 69
        KEY_F                = 'F', // 70
        KEY_G                = 'G', // 71
        KEY_H                = 'H', // 72
        KEY_I                = 'I', // 73
        KEY_J                = 'J', // 74
        KEY_K                = 'K', // 75
        KEY_L                = 'L', // 76
        KEY_M                = 'M', // 77
        KEY_N                = 'N', // 78
        KEY_O                = 'O', // 79
        KEY_P                = 'P', // 80
        KEY_Q                = 'Q', // 81
        KEY_R                = 'R', // 82
        KEY_S                = 'S', // 83
        KEY_T                = 'T', // 84
        KEY_U                = 'U', // 85
        KEY_V                = 'V', // 86
        KEY_W                = 'W', // 87
        KEY_X                = 'X', // 88
        KEY_Y                = 'Y', // 89
        KEY_Z                = 'Z', // 90
    
        /*ASCII:  91 -  96*/
        KEY_L_BRACKET        = '[', // 91
        KEY_BACKSLASH        = '\\',// 92
        KEY_R_BRACKET        = ']', // 93
        KEY_BACKQUOTE        = '`', // 96
    
        /*ASCII:  97 - 127*/
        KEY_DELETE           = 0x7f;// 127
}
