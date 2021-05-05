package jasper.core.scene;

import jasper.Jasper;
import jasper.core.Layout;
import jasper.core.Server;
import jasper.math.Bounds2;
import jasper.math.Region2;
import jasper.math.Vector2;
import jasper.math.Vector4;
import jasper.util.*;

import java.awt.*;
import java.awt.image.BufferStrategy;
import java.nio.file.Path;
import java.util.LinkedHashMap;

import static jasper.core.Colors.color4i;
import static jasper.util.StringToObject.BOOLEAN;
import static jasper.util.StringToObject.INTEGER;

public class Stage extends Server {
    // configuration variables
    protected Vector4
        canvas_background = color4i(Color.WHITE);
    protected Layout
        canvas_layout = new Layout();
    protected boolean
        debug = false;
    protected Vector4
        debug_background = new Vector4(  0,   0,   0, 192);
    protected String
        debug_font_name = "Monospaced";
    protected int
        debug_font_size = 12;
    protected Vector4
        debug_foreground = new Vector4(255, 255, 255, 192);
    protected int
        render_hz = 60,
        update_hz = 60;
    protected Vector4
        window_background = color4i(Color.BLACK);
    protected boolean
        window_border;
    protected int
        window_device;
    protected Layout
        window_layout = new Layout();
    protected String
        window_string = Jasper.VERSION.toString();
    
    protected java.awt.Color
        canvas_background_color,
        debug_background_color ,
        debug_foreground_color ,
        window_background_color;
    protected java.awt.Font
        debug_font;
    
    // timer variables
    protected int
        avg_update_hz,
        avg_render_hz;
    protected float
        avg_update_ms,
        min_update_ms,
        max_update_ms,
    
        avg_render_ms,
        min_render_ms,
        max_render_ms;
    protected int
        logical_canvas_w,
        logical_canvas_h,
    
        virtual_canvas_w,
        virtual_canvas_h;
    protected float
        virtual_canvas_scale;
    
    // instance variables
    protected java.awt.Frame
        window;
    protected java.awt.Canvas
        canvas;
    protected Input
        input;
    protected Scene
        scene;
    // debug info
    protected final LinkedHashMap<String, String>
        dbg  =  new LinkedHashMap<String, String>();
    
    public Stage() {
        super();
        
        configure(
            CANVAS_LAYOUT, canvas_layout,
            WINDOW_BORDER, window_border,
            WINDOW_DEVICE, window_device,
            WINDOW_LAYOUT, window_layout
        );
        
        handle.onAttach(SceneEvent.class, this::onSceneEvent);
        handle.onAttach(WindowEvent.class, this::onWindowEvent);
        handle.onAttach(CanvasEvent.class, this::onCanvasEvent);
        
        input = new Input(this);
        
        Configuration.configure(dbg,
            DEBUG_UPDATE_INFO, null,
            DEBUG_RENDER_INFO, null,
            DEBUG_CANVAS_INFO, null
        );
    }
    
    public void setScene(Scene scene) {
        queue(new SceneEvent(scene));
    }
    
    public Vector2 getLogicalCanvasSize() {
        return new Vector2(
            logical_canvas_w,
            logical_canvas_h
        );
    }
    
    public Vector2 getVirtualCanvasSize() {
        return new Vector2(
            virtual_canvas_w,
            virtual_canvas_h
        );
    }
    
    public Vector2 logicalToVirtual(float x, float y) {
        return new Vector2(
            (x - logical_canvas_w / 2f) / virtual_canvas_scale + virtual_canvas_w / 2f,
            (y - logical_canvas_h / 2f) / virtual_canvas_scale + virtual_canvas_h / 2f
        );
    }
    
    public Vector2 virtualToLogical(float x, float y) {
        return new Vector2(
            (x - virtual_canvas_w / 2f) * virtual_canvas_scale + logical_canvas_w / 2f,
            (y - virtual_canvas_h / 2f) * virtual_canvas_scale + logical_canvas_h / 2f
        );
    }
    
    public Vector2 logicalToVirtual(Vector2 v) {
        return logicalToVirtual(v.x(), v.y());
    }
    
    public Vector2 virtualToLogical(Vector2 v) {
        return virtualToLogical(v.x(), v.y());
    }
    
    public void loadDebugInfo(Class<?> loader, String path) {
        Configuration.load(dbg, loader, path);
    }
    
    public void loadDebugInfo(String path) {
        Configuration.load(dbg, path);
    }
    
    public void loadDebugInfo(Path   path) {
        Configuration.load(dbg, path);
    }
    
    public void saveDebugInfo(String path) {
        Configuration.save(dbg, path);
    }
    
    public void saveDebugInfo(Path   path) {
        Configuration.save(dbg, path);
    }
    
    public String setDebugInfo(Object key, Object val) {
        return Configuration.setProperty(dbg, key, val);
    }
    
    public <OBJECT> String setDebugInfo(Object key, ObjectToString<OBJECT> o2s, OBJECT val            ) {
        return Configuration.setProperty(dbg, key, o2s, val     );
    }
    
    public <OBJECT> String setDebugInfo(Object key, ObjectToString<OBJECT> o2s, OBJECT val, String alt) {
        return Configuration.setProperty(dbg, key, o2s, val, alt);
    }
    
    public String getDebugInfo(Object key            ) {
        return Configuration.getProperty(dbg, key     );
    }
    
    public String getDebugInfo(Object key, Object alt) {
        return Configuration.getProperty(dbg, key, alt);
    }
    
    public <OBJECT> OBJECT getDebugInfoAs(Object key, StringToObject<OBJECT> s2o            ) {
        return Configuration.getPropertyAs(dbg, key, s2o     );
    }
    
    public <OBJECT> OBJECT getDebugInfoAs(Object key, StringToObject<OBJECT> s2o, OBJECT alt) {
        return Configuration.getPropertyAs(dbg, key, s2o, alt);
    }
    
    protected static final long
        one_second = 1000000000,
        one_millis =    1000000;
    
    protected long
        nanos_per_update,
        update_timer,
        update_count,
        avg_update_nanos,
        min_update_nanos,
        max_update_nanos,
    
        nanos_per_render,
        render_timer,
        render_count,
        avg_render_nanos,
        min_render_nanos,
        max_render_nanos,
    
        one_second_timer;
    protected float
        fixed_update_dt,
        fixed_update_ms,
    
        fixed_render_dt,
        fixed_render_ms;
    protected long
        t0, // baseline nanos
        t1, // previous nanos
        t2; // current nanos
    
    @Override
    public void onInit() throws Exception {
        long a = System.nanoTime();
        // read configuration
        canvas_background = getPropertyAs(CANVAS_BACKGROUND, Vector4::fromString, canvas_background);
        canvas_layout     = getPropertyAs(CANVAS_LAYOUT    , Layout::fromString , canvas_layout    );
        
        debug            = getPropertyAs(DEBUG           , BOOLEAN            , debug           );
        debug_background = getPropertyAs(DEBUG_BACKGROUND, Vector4::fromString, debug_background);
        debug_font_name  = getProperty  (DEBUG_FONT_NAME ,                      debug_font_name );
        debug_font_size  = getPropertyAs(DEBUG_FONT_SIZE , INTEGER            , debug_font_size );
        debug_foreground = getPropertyAs(DEBUG_FOREGROUND, Vector4::fromString, debug_foreground);
        
        render_hz     = getPropertyAs(RENDER_HZ, INTEGER, render_hz);
        update_hz     = getPropertyAs(UPDATE_HZ, INTEGER, update_hz);
        
        window_background = getPropertyAs(WINDOW_BACKGROUND, Vector4::fromString, window_background);
        window_border     = getPropertyAs(WINDOW_BORDER    , BOOLEAN            , window_border    );
        window_device     = getPropertyAs(WINDOW_DEVICE    , INTEGER            , window_device    );
        window_layout     = getPropertyAs(WINDOW_LAYOUT    , Layout::fromString , window_layout    );
        window_string     = getProperty  (WINDOW_STRING    ,                      window_string    );
        
        canvas_background_color = color4i(canvas_background);
        debug_background_color  = color4i(debug_background );
        debug_foreground_color  = color4i(debug_foreground );
        window_background_color = color4i(window_background);
        debug_font = new java.awt.Font(debug_font_name, Font.PLAIN, debug_font_size);
        
        // release old resources
        if(window != null)
            window.dispose();
        
        // assign new resources
        window = new java.awt.Frame() ;
        canvas = new java.awt.Canvas();
        window.add(canvas);
        
        // compute the window bounds
        Region2 window_region = Layout.region(window_layout, getMaximumWindowRegion(window_device, !window_border));
        window.setUndecorated(!window_border);
        window.setBounds(
            (int)window_region.x(), (int)window_region.y(),
            (int)window_region.w(), (int)window_region.h()
        );
        window.setTitle(window_string);
        
        // compute the logical and virtual canvas size
        Insets window_insets = window.getInsets();
        Region2
            logical_canvas_region = new Region2(
                window_region.x() + window_insets.left,
                window_region.y() + window_insets.top ,
                window_region.w() - window_insets.left - window_insets.right ,
                window_region.h() - window_insets.top  - window_insets.bottom
            ),
            virtual_canvas_region = Layout.region(canvas_layout, logical_canvas_region);

        logical_canvas_w = (int)logical_canvas_region.w();
        logical_canvas_h = (int)logical_canvas_region.h();
        virtual_canvas_w = (int)virtual_canvas_region.w();
        virtual_canvas_h = (int)virtual_canvas_region.h();
        virtual_canvas_scale = Math.min(
            (float) logical_canvas_w / virtual_canvas_w,
            (float) logical_canvas_h / virtual_canvas_h
        );
        
        // add listeners
        window.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent we) {
                queue(WindowEvent.ON_CLOSE);
            }
        });
        window.addWindowFocusListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowGainedFocus(java.awt.event.WindowEvent we) {
                queue(WindowEvent.ON_FOCUS);
            }
    
            @Override
            public void windowLostFocus(java.awt.event.WindowEvent we) {
                queue(WindowEvent.ON_UNFOCUS);
            }
        });
        
        canvas.setFocusable(true);
        canvas.setFocusTraversalKeysEnabled(false);
        
        canvas.addKeyListener        (input);
        canvas.addMouseListener      (input);
        canvas.addMouseWheelListener (input);
        canvas.addMouseMotionListener(input);
        canvas.addComponentListener(new java.awt.event.ComponentAdapter() {
            @Override
            public void componentResized(java.awt.event.ComponentEvent ce) {
                queue(new CanvasEvent(
                    ce.getComponent().getWidth() ,
                    ce.getComponent().getHeight()
                ));
            }
        });
    
        // prepare to display
        window.setIgnoreRepaint(true);
        canvas.setIgnoreRepaint(true);
        window.setVisible(true);
        canvas.requestFocus(  );
        canvas.revalidate();
        
        long b = System.nanoTime();
        
        if(debug)
            Debug.info(new Object() { /* trace */}, String.format(
                "INIT: %1$3.2f ms", (float)(b - a) / one_millis
            ));
            
        // prepare timers
        nanos_per_update = update_hz > 0 ? one_second / update_hz : 0;
        update_timer = 0;
        update_count = 0;
        avg_update_nanos = 0;
        min_update_nanos = Long.MAX_VALUE;
        max_update_nanos = 0;
        
        nanos_per_render = render_hz > 0 ? one_second / render_hz : 0;
        render_timer = 0;
        render_count = 0;
        avg_render_nanos = 0;
        min_render_nanos = Long.MAX_VALUE;
        max_render_nanos = 0;
        
        one_second_timer = 0;
        
        fixed_update_dt = (float)nanos_per_update / one_second;
        fixed_update_ms = (float)nanos_per_update / one_millis;
        
        fixed_render_dt = (float)nanos_per_render / one_second;
        fixed_render_ms = (float)nanos_per_render / one_millis;
        
        t0 = t1 = t2 = System.nanoTime();
    }
    
    @Override
    public void onStep() throws Exception {
        t2 = System.nanoTime();
        
        long delta_nanos = t2 - t1; t1 = t2;
        update_timer     += delta_nanos;
        render_timer     += delta_nanos;
        one_second_timer += delta_nanos;
        
        if(update_timer >= nanos_per_update) {
            float  t = (float)   (t2 - t0) / one_second;
            float dt = (float)update_timer / one_second;
            
            long a = System.nanoTime();
            update(t, dt, fixed_update_dt);
            long b = System.nanoTime();
            
            long update_nanos = b - a;
            avg_update_nanos += update_nanos;
            if(update_nanos < min_update_nanos)
                min_update_nanos = update_nanos;
            if(update_nanos > max_update_nanos)
                max_update_nanos = update_nanos;
    
            update_timer = 0;
            update_count  ++;
        }
    
        if(render_timer >= nanos_per_render) {
            float  t = (float)   (t2 - t0) / one_second;
            float dt = (float)render_timer / one_second;
        
            long a = System.nanoTime();
            render(t, dt, fixed_render_dt);
            long b = System.nanoTime();
        
            long render_nanos = b - a;
            avg_render_nanos += render_nanos;
            if(render_nanos < min_render_nanos)
                min_render_nanos = render_nanos;
            if(render_nanos > max_render_nanos)
                max_render_nanos = render_nanos;
            
            render_timer = 0;
            render_count  ++;
        }
        
        if(one_second_timer >= one_second) {
            avg_update_hz = (int)update_count;
            avg_update_ms = (float)avg_update_nanos / update_count / one_millis;
            min_update_ms = (float)min_update_nanos / one_millis;
            max_update_ms = (float)max_update_nanos / one_millis;
    
            avg_render_hz = (int)render_count;
            avg_render_ms = (float)avg_render_nanos / render_count / one_millis;
            min_render_ms = (float)min_render_nanos / one_millis;
            max_render_ms = (float)max_render_nanos / one_millis;
            
            if(debug) {
                String
                    debug_update_info = String.format(
                        "UPDATE: %1$d hz @ %2$3.2f of %3$3.2f ms [ %4$3.2f < %5$3.2f]",
                        avg_update_hz,
                        avg_update_ms,
                        fixed_update_ms,
                        min_update_ms,
                        max_update_ms
                    ),
                    debug_render_info = String.format(
                        "RENDER: %1$d hz @ %2$3.2f of %3$3.2f ms [ %4$3.2f < %5$3.2f]",
                        avg_render_hz,
                        avg_render_ms,
                        fixed_render_ms,
                        min_render_ms,
                        max_render_ms
                    );
                setDebugInfo(DEBUG_UPDATE_INFO, debug_update_info);
                setDebugInfo(DEBUG_RENDER_INFO, debug_render_info);
                Debug.info(new Object() { }, debug_update_info);
                Debug.info(new Object() { }, debug_render_info);
            }
            
            avg_update_nanos = 0;
            min_update_nanos = Long.MAX_VALUE;
            max_update_nanos = 0;
            update_count = 0;
    
            avg_render_nanos = 0;
            min_render_nanos = Long.MAX_VALUE;
            max_render_nanos = 0;
            render_count = 0;
            
            one_second_timer = 0;
        }
        
        long sync = Math.min(
            nanos_per_update - update_timer,
            nanos_per_render - render_timer
        ) / one_millis;
        if(sync > 1)
            Thread.sleep(1);
    }
    
    @Override
    public void onStop() {
        if(window != null)
            window.dispose();
        if(debug) {
            long t = (t2 - t0);
            Debug.info(new Object() { /* trace */ }, String.format(
                "UPTIME: %1$02d:%2$02d:%3$02d",
                (t / one_second / 60),
                (t / one_second % 60),
                (100 * t / one_second) % 100
            ));
        }
    }
    
    protected final Updateable.UpdateContext
        update_context = new Updateable.UpdateContext();
    protected final Renderable.RenderContext
        render_context = new Renderable.RenderContext();
    
    protected void update(float t, float dt, float fixed_dt) {
        input.poll();
              poll();
              
        update_context.t  = t ;
        update_context.dt = dt;
        update_context.fixed_dt = fixed_dt;
        update_context.canvas_w = virtual_canvas_w;
        update_context.canvas_h = virtual_canvas_h;
        
        if(scene != null)
            scene.onUpdate(update_context);
    }
    
    protected BufferStrategy
        b;
    protected void render(float t, float dt, float fixed_dt) {
        if(b == null || b.contentsLost()) {
            canvas.createBufferStrategy(2);
            b = canvas.getBufferStrategy();
        }
        
        Graphics2D g = (Graphics2D)b.getDrawGraphics();
        Graphics2D h = (Graphics2D)g.create();
        
        h.setColor(window_background_color);
        h.fillRect(0, 0, logical_canvas_w, logical_canvas_h);
        
        h.translate(
            (int)(logical_canvas_w - virtual_canvas_w * virtual_canvas_scale) / 2,
            (int)(logical_canvas_h - virtual_canvas_h * virtual_canvas_scale) / 2
        );
        h.scale(
            virtual_canvas_scale,
            virtual_canvas_scale
        );
        h.clipRect(
            0, 0,
            virtual_canvas_w,
            virtual_canvas_h
        );
    
        h.setColor(canvas_background_color);
        h.fillRect(0, 0, virtual_canvas_w, virtual_canvas_h);
    
        render_context.t  = t ;
        render_context.dt = dt;
        render_context.fixed_dt = fixed_dt;
        render_context.canvas_w = virtual_canvas_w;
        render_context.canvas_h = virtual_canvas_h;
        
        render_context.g = h;
        
        if(scene != null)
            scene.onRender(render_context);
        
        if(debug && dbg.size() > 0) {
            g.setFont(debug_font);
            java.awt.FontMetrics fm = g.getFontMetrics();
            
            int
                print_w = 0,
                print_h = 0;
            for(String property : dbg.values())
                if(property != null) {
                    print_w  = Math.max(print_w, fm.stringWidth(property));
                    print_h += fm.getHeight();
                }
            
            g.setColor(debug_background_color);
            g.fillRect(0, 0, print_w, print_h);
            g.setColor(debug_foreground_color);
            
            int i = 0;
            for(String property : dbg.values())
                if(property != null)
                    g.drawString(property, 0, fm.getLeading() + fm.getAscent() + fm.getHeight() * i ++);
        }
        
        h.dispose();
        g.dispose();
        b.   show();
    }
    
    public void onKeyUp(int key) {
        if(scene != null) scene.onKeyUp(key);
    }
    
    public void onKeyDown(int key) {
        if(scene != null) scene.onKeyDown(key);
    }
    
    public void onMouseUp(int mouse) {
        if(scene != null) scene.onMouseUp(mouse);
    }
    
    public void onMouseDown(int mouse) {
        if(scene != null) scene.onMouseDown(mouse);
    }
    
    public void onMouseMoved(Vector2 mouse) {
        if(scene != null) scene.onMouseMoved(mouse);
    }
    
    public void onMouseWheel(float   wheel) {
        if(scene != null) scene.onMouseWheel(wheel);
    }
    
    public void onSceneEvent(SceneEvent event) {
        if(scene != null) {
            scene.onDetach();
            scene.stage = null;
            scene.input = null;
        }
        scene = event.scene;
        if(scene != null) {
            scene.stage = this ;
            scene.input = input;
            scene.onAttach();
        }
    }
    
    public void onWindowEvent(WindowEvent event) {
        switch(event) {
            case ON_CLOSE:
                input.onClose();
                if(scene != null)
                    scene.onClose();
                break;
            case ON_FOCUS:
                input.onFocus();
                if(scene != null)
                    scene.onFocus();
                break;
            case ON_UNFOCUS:
                input.onUnfocus();
                if(scene != null)
                    scene.onUnfocus();
                break;
        }
    }
    
    public void onCanvasEvent(CanvasEvent event) {
        Region2
            logical_canvas_region = new Region2(
                logical_canvas_w = event.logical_canvas_w,
                logical_canvas_h = event.logical_canvas_h
            ),
            virtual_canvas_region = Layout.region(canvas_layout, logical_canvas_region);
        
        virtual_canvas_w = (int)virtual_canvas_region.w();
        virtual_canvas_h = (int)virtual_canvas_region.h();
        virtual_canvas_scale = Math.min(
            (float) logical_canvas_w / virtual_canvas_w,
            (float) logical_canvas_h / virtual_canvas_h
        );
        
        setDebugInfo(DEBUG_CANVAS_INFO, String.format(
            "CANVAS: [%1$s, %2$s] (%3$s, %4$s) %5$3.2f%%",
            logical_canvas_w,
            logical_canvas_h,
            virtual_canvas_w,
            virtual_canvas_h,
            virtual_canvas_scale * 100
        ));
        
        if(scene != null)
            scene.onResize(new Vector2(
                virtual_canvas_w,
                virtual_canvas_h
            ));
    }
    
    public static Region2 getMaximumWindowRegion(int i, boolean borderless) {
        GraphicsDevice        gd = Utility.getGraphicsDevice(i);
        GraphicsConfiguration gc = gd.getDefaultConfiguration();
        Rectangle bounds = gc.getBounds();
        
        if(borderless)
            return new Region2(
                bounds.x,
                bounds.y,
                bounds.width,
                bounds.height
            );
        else {
            Insets insets = Toolkit.getDefaultToolkit().getScreenInsets(gc);
            return new Region2(
                bounds.x + insets.left,
                bounds.y + insets.top,
                bounds.width  - insets.left - insets.right,
                bounds.height - insets.top  - insets.bottom
            );
        }
    }
    
    public static Bounds2 getMaximumWindowBounds(int i, boolean borderless) {
        GraphicsDevice        gd = Utility.getGraphicsDevice(i);
        GraphicsConfiguration gc = gd.getDefaultConfiguration();
        Rectangle bounds = gc.getBounds();
        
        if(borderless)
            return new Bounds2(
                bounds.x,
                bounds.y,
                bounds.x + bounds.width,
                bounds.y + bounds.height
            );
        else {
            Insets insets = Toolkit.getDefaultToolkit().getScreenInsets(gc);
            return new Bounds2(
                bounds.x + insets.left,
                bounds.y + insets.top,
                bounds.x + bounds.width  - insets.left - insets.right,
                bounds.y + bounds.height - insets.top  - insets.bottom
            );
        }
    }
    
    public static class SceneEvent {
        public final Scene
            scene;
        
        public SceneEvent(Scene scene) {
            this.scene = scene;
        }
    }
    
    public static enum WindowEvent {
        ON_CLOSE,
        ON_FOCUS,
        ON_UNFOCUS;
    }
    
    public static class CanvasEvent {
        public final int
            logical_canvas_w,
            logical_canvas_h;
        
        public CanvasEvent(
            int canvas_logical_w,
            int canvas_logical_h
        ) {
            this.logical_canvas_w = canvas_logical_w;
            this.logical_canvas_h = canvas_logical_h;
        }
    }
    
    public static final String
        CANVAS_BACKGROUND = "canvas-background",
        CANVAS_LAYOUT = "canvas-layout",
        DEBUG = "debug",
        DEBUG_BACKGROUND = "debug-background",
        DEBUG_FONT_NAME = "debug-font-name",
        DEBUG_FONT_SIZE = "debug-font-size",
        DEBUG_FOREGROUND = "debug-foreground",
        RENDER_HZ = "render-hz",
        UPDATE_HZ = "update-hz",
        WINDOW_BACKGROUND = "window-background",
        WINDOW_BORDER = "window-border",
        WINDOW_DEVICE = "window-device",
        WINDOW_LAYOUT = "window-layout",
        WINDOW_STRING = "window-string";
    
    public static final String
        DEBUG_UPDATE_INFO = "debug.update.info",
        DEBUG_RENDER_INFO = "debug.render.info",
        DEBUG_CANVAS_INFO = "debug.canvas.info";
}
