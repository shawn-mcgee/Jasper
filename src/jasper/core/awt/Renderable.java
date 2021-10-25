package jasper.core.awt;

import jasper.math.Box2;
import jasper.math.Vector;

import java.awt.*;

public interface Renderable {
    public void onRender(RenderContext context);
    
    public static class RenderContext {
        private static final float
            PI = (float)Math.PI;
        public static final float
            RADIANS = 2 * PI,
            DEGREES =   360f;
        
        protected RenderContext
            parent;
        
        public Graphics2D
            g;
        public Stage
            stage;
        public Input
            input;
        public float
            t,
            dt,
            fixed_dt;
        public int
            canvas_w,
            canvas_h;
        
        public RenderContext push() {
            RenderContext context = new RenderContext();
        
            context.parent = this;
            context.stage = stage;
            context.input = input;
            context.t  = t ;
            context.dt = dt;
            context.fixed_dt = fixed_dt;
            context.canvas_w = canvas_w;
            context.canvas_h = canvas_h;
        
            context.g = (Graphics2D)g.create();
            
            return context;
        }
        
        public RenderContext pull() {
           if(parent != null)
               try {
                   g . dispose();
                   return parent;
               } finally {
                   parent = null;
               }
           return this;
        }

        public RenderContext draw(Renderable t) {
            t.onRender(this);
            return this;
        }
        
        public RenderContext color(Color color) {
            g.setColor(color); return this;
        }
        
        public RenderContext color3i(int argb) {
            g.setColor(Colors.color3i(argb)); return this;
        }
        
        public RenderContext color4i(int argb) {
            g.setColor(Colors.color4i(argb)); return this;
        }
        
        public RenderContext color3i(Vector color) {
            g.setColor(Colors.color3i(color)); return this;
        }
        
        public RenderContext color4i(Vector color) {
            g.setColor(Colors.color4i(color)); return this;
        }
        
        public RenderContext color3f(Vector color) {
            g.setColor(Colors.color3f(color)); return this;
        }
        
        public RenderContext color4f(Vector color) {
            g.setColor(Colors.color4f(color)); return this;
        }
        
        public RenderContext color3i(int r, int g, int b) {
            this.g.setColor(Colors.color3i(r, g, b)); return this;
        }
        
        public RenderContext color4i(int r, int g, int b, int a) {
            this.g.setColor(Colors.color4i(r, g, b, a)); return this;
        }
        
        public RenderContext color3f(float r, float g, float b) {
            this.g.setColor(Colors.color3f(r, g, b)); return this;
        }
        
        public RenderContext color4f(float r, float g, float b, float a) {
            this.g.setColor(Colors.color4f(r, g, b, a)); return this;
        }
        
        public RenderContext stroke(float w) {
            return stroke(new BasicStroke(w));
        }
        
        public RenderContext stroke(Stroke stroke) {
            g.setStroke(stroke); return this;
        }
        
        public RenderContext rect(Box2 box, boolean fill) {
            return rect(box.x(), box.y(), box.w(), box.h(), fill);
        }
        
        public RenderContext rect(Vector wh, boolean fill) {
            return rect(0f, 0f, wh.x(), wh.y(), fill);
        }
        
        public RenderContext rect(Vector xy, Vector wh, boolean fill) {
            return rect(xy.x(), xy.y(), wh.x(), wh.y(), fill);
        }
        
        public RenderContext rect(float w, float h, boolean fill) {
            return rect(0f, 0f, w, h, fill);
        }
        
        public RenderContext rect(float x, float y, float w, float h, boolean fill) {
            if(fill)
                g.fillRect((int)x, (int)y, (int)w, (int)h);
            else
                g.drawRect((int)x, (int)y, (int)w, (int)h);
            return this;
        }
        
        public RenderContext oval(Box2 box, boolean fill) {
            return oval(box.x(), box.y(), box.w(), box.h(), fill);
        }
        
        public RenderContext oval(Vector wh, boolean fill) {
            return oval(0f, 0f, wh.x(), wh.y(), fill);
        }
        
        public RenderContext oval(Vector xy, Vector wh, boolean fill) {
            return oval(xy.x(), xy.y(), wh.x(), wh.y(), fill);
        }
        
        public RenderContext oval(float w, float h, boolean fill) {
            return oval(0f, 0f, w, h, fill);
        }
        
        public RenderContext oval(float x, float y, float w, float h, boolean fill) {
            if(fill)
                g.fillOval((int)x, (int)y, (int)w, (int)h);
            else
                g.drawOval((int)x, (int)y, (int)w, (int)h);
            return this;
        }
        
        public RenderContext line(Vector xy0, Vector xy1) {
            return line(xy0.x(), xy0.y(), xy1.x(), xy1.y());
        }
        
        public RenderContext line(float x0, float y0, float x1, float y1) {
            g.drawLine((int)x0, (int)y0, (int)x1, (int)y1); return this;
        }
        
        public RenderContext translate(Vector xy) {
            return translate(xy.x(), xy.y());
        }
        
        public RenderContext translate(float x, float y) {
            g.translate(x, y); return this;
        }
        
        public RenderContext scale(Vector xy) {
            return scale(xy.x(), xy.y());
        }
        
        public RenderContext scale(float x, float y) {
            g.scale(x, y); return this;
        }
        
        public RenderContext rotate(float a, float u) {
            float r = 2 * PI * a / u;
            g.rotate(r);
            return this;
        }
        
        public RenderContext rotate(Vector xy, float a, float u) {
            return rotate(xy.x(), xy.y(), a, u);
        }
        
        public RenderContext rotate(float x, float y, float a, float u) {
            float r = 2 * PI * a / u;
            g.rotate(r, x, y);
            return this;
        }
        
        public RenderContext clip(Box2 box) {
            return clip(box.x(), box.y(), box.w(), box.h());
        }
        
        public RenderContext clip(Vector wh) {
            return clip(0f, 0f, wh.x(), wh.y());
        }
        
        public RenderContext clip(Vector xy, Vector wh) {
            return clip(xy.x(), xy.y(), wh.x(), wh.y());
        }
        
        public RenderContext clip(float w, float h) {
            return clip(0f, 0f, w, h);
        }
        
        public RenderContext clip(float x, float y, float w, float h) {
            g.clipRect((int)x, (int)y, (int)w, (int)h); return this;
        }
        
        public RenderContext font(String name, int type, int size) {
            return font(new Font(name, type, size));
        }
        
        public RenderContext font(Font font) {
            g.setFont(font); return this;
        }
        
        public RenderContext string(String s) {
            return string(s, 0f, 0f);
        }
        
        public RenderContext string(Vector xy, String s) {
            return string(s, xy.x(), xy.y());
        }
        
        public RenderContext string(String s, float x, float y) {
            g.drawString(s, x, y); return this;
        }
        
        public RenderContext image(Image image) {
            return image(image, 0f, 0f);
        }
        
        public RenderContext image(Image image, Vector xy) {
            return image(image, xy.x(), xy.y());
        }
        
        public RenderContext image(Image image, float x, float y) {
            g.drawImage(image, (int)x, (int)y, null); return this;
        }
        
        public RenderContext image(Image image, Box2 box) {
            return image(image, box.x(), box.y(), box.w(), box.h());
        }
        
        public RenderContext image(Image image, Vector xy, Vector wh) {
            return image(image, xy.x(), xy.y(), wh.x(), wh.y());
        }
        
        public RenderContext image(Image image, float x, float y, float w, float h) {
            g.drawImage(
                image,
                (int)x, (int)y,
                (int)w, (int)h,
                null
            );
            return this;
        }
        
        public RenderContext image(Image image, Box2 src, Box2 dst) {
            return image(
                image,
                src.x(), src.y(), src.w(), src.h(),
                dst.x(), dst.y(), dst.w(), dst.h()
            );
        }
        
        public RenderContext image(
            Image image,
            float sx, float sy, float sw, float sh,
            float dx, float dy, float dw, float dh
        ) {
            g.drawImage(
                image,
                (int)dx, (int)dy, (int)(dx + dw), (int)(dy + dh),
                (int)sx, (int)sy, (int)(sx + sw), (int)(sy + sh),
                null
            );
            return this;
        }
        
        public RenderContext aa(boolean aa) {
            if(aa)
                g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON );
            else
                g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_OFF);
            return this;
        }
    }
}
