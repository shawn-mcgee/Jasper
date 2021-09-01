package jasper.core.awt;

import jasper.math.*;
import jasper.util.Debug;
import jasper.util.Resource;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.InputStream;

public class Sprite implements Renderable {
    public static final int
        STOP = 0,
        PLAY = 1,
        LOOP = 2;

    protected Sprite.Atlas
        atlas;

    protected int
        mode;
    protected float
        frame,
        speed;
    protected boolean
        flip,
        flop;
    protected final Region2.Mutable
        xywh = new Region2.Mutable();

    public Sprite(Sprite.Atlas atlas) {
        this.atlas = atlas;
        xywh.wh(
            this.atlas.frame_w,
            this.atlas.frame_h
        );
    }

    public Sprite.Atlas atlas() {
        return atlas;
    }

    public Sprite stop() {
        mode = STOP;
        return this;
    }

    public Sprite play() {
        mode = PLAY;
        return this;
    }

    public Sprite loop() {
        mode = LOOP;
        return this;
    }

    public Sprite stop(float frame) {
        return frame(frame).stop();
    }

    public Sprite play(float speed) {
        return speed(speed).play();
    }

    public Sprite loop(float speed) {
        return speed(speed).loop();
    }

    public boolean isStopped() {
        return mode == STOP;
    }

    public boolean isPlaying() {
        return mode == PLAY;
    }

    public boolean isLooping() {
        return mode == LOOP;
    }

    public Sprite frame(float frame) {
        this.frame = frame;
        if(frame < 0                   ) this.frame = (frame % atlas.frames.length) + atlas.frames.length;
        if(frame >= atlas.frames.length) this.frame = (frame % atlas.frames.length)                      ;
        return this;
    }

    public Sprite speed(float speed) {
        this.speed = speed;
        return this;
    }

    public float frame() {
        return frame;
    }

    public float speed() {
        return speed;
    }

    public Sprite flip(boolean flip) {
        this.flip = flip;
        return this;
    }

    public Sprite flop(boolean flop) {
        this.flop = flop;
        return this;
    }

    public Sprite flip() {
        flip = !flip;
        return  this;
    }

    public Sprite flop() {
        flop = !flop;
        return  this;
    }

    public boolean isFlipped() {
        return flip;
    }

    public boolean isFlopped() {
        return flop;
    }

    public Sprite x(float x) { xywh.x(x); return this; }
    public Sprite y(float y) { xywh.y(y); return this; }
    public Sprite w(float w) { xywh.w(w); return this; }
    public Sprite h(float h) { xywh.h(h); return this; }
    public Sprite xy(float x, float y) { xywh.xy(x, y); return this; }
    public Sprite wh(float w, float h) { xywh.wh(w, h); return this; }
    public Sprite xy(Vector xy) { xywh.xy(xy); return this; }
    public Sprite wh(Vector wh) { xywh.wh(wh); return this; }

    public Sprite xywh(float x, float y, float w, float h) {
        xywh.set(x, y, w, h);
        return this;
    }

    public Sprite xywh(Box b) {
        xywh.set(b);
        return this;
    }

    public float x() { return xywh.x(); }
    public float y() { return xywh.y(); }
    public float w() { return xywh.w(); }
    public float h() { return xywh.h(); }
    public Vector2 xy() { return xywh.xy(); }
    public Vector2 wh() { return xywh.wh(); }
    public Box2.Mutable xywh() { return xywh; }

    @Override
    public void onRender(RenderContext context) {
        switch(mode) {
            default:
            case STOP:
                break;
            case PLAY:
                frame += speed * context.fixed_dt;
                if(frame <  0                  ) { frame = (frame % atlas.frames.length) + atlas.frames.length; mode = STOP; }
                if(frame >= atlas.frames.length) { frame = (frame % atlas.frames.length)                      ; mode = STOP; }
                break;
            case LOOP:
                frame += speed * context.fixed_dt;
                if(frame <  0                  ) { frame = (frame % atlas.frames.length) + atlas.frames.length; }
                if(frame >= atlas.frames.length) { frame = (frame % atlas.frames.length)                      ; }
                break;
        }

        int x0, x1;
        if(flip) {
            x0 = (int)xywh.x1();
            x1 = (int)xywh.x0();
        } else {
            x0 = (int)xywh.x0();
            x1 = (int)xywh.x1();
        }
        int y0, y1;
        if(flop) {
            y0 = (int)xywh.y1();
            y1 = (int)xywh.y0();
        } else {
            y0 = (int)xywh.y0();
            y1 = (int)xywh.y1();
        }

        context.image(
            atlas.frames[(int)frame],
            0, 0,
            atlas.frame_w,
            atlas.frame_h,
            x0, y0,
            (x1 - x0),
            (y1 - y0)
        );
    }

    public static Sprite load(Resource resource, int w, int h) {
        return new Sprite(Sprite.Atlas.load(resource, w, h));
    }

    public static Sprite load(String   resource, int w, int h) {
        return Sprite.load(new Resource(resource), w, h);
    }
    
    public static Sprite load(Class<?> from, String path, int w, int h) {
        return Sprite.load(new Resource(from, path), w, h);
    }
    
    public static Sprite load(String   from, String path, int w, int h) {
        return Sprite.load(new Resource(from, path), w, h);
    }
    
    public static class Atlas {
        protected final Resource
            resource;

        protected BufferedImage
            image;
        protected final int
            image_w,
            image_h;

        protected BufferedImage[]
            frames;
        protected final int
            frame_w,
            frame_h;

        public Atlas(
            Resource resource,
            BufferedImage image,
            int image_w,
            int image_h,
            BufferedImage[] frames,
            int frame_w,
            int frame_h
        ) {
            this.resource = resource;
            this.image = image;
            this.image_w = image_w;
            this.image_h = image_h;
            this.frames = frames;
            this.frame_w = frame_w;
            this.frame_h = frame_h;
        }

        public static Sprite.Atlas load(Resource resource, int w, int h) {
            try(InputStream input = resource.newInputStream()) {
                if(input == null)
                    Debug.warn(new Object() { }, "Unable to load Sprite.Atlas '" + resource + "'");
                else {
                    BufferedImage image = ImageIO.read(input);
                    int
                        image_w = image.getWidth() ,
                        image_h = image.getHeight(),
                        frame_w = w,
                        frame_h = h;
                    w = image_w / frame_w;
                    h = image_h / frame_h;
                    BufferedImage[] frames = new BufferedImage[w * h];
                    for(int i = 0; i < w; i ++)
                        for(int j = 0; j < h; j ++)
                            frames[j * w + i] = image.getSubimage(
                                i * frame_w,
                                j * frame_h,
                                frame_w, frame_h
                            );
                    return new Sprite.Atlas(
                        resource,
                        image , image_w, image_h,
                        frames, frame_w, frame_h
                    );
                }
            } catch (Exception na) {
                Debug.warn(new Object() { }, "Unable to load Sprite.Atlas '" + resource + "'");
            }
            return null;
        }

        public static Sprite.Atlas load(String   resource, int w, int h) {
            return load(new Resource(resource), w, h);
        }

        public static Sprite.Atlas load(Class<?> from, String path, int w, int h) {
            return load(new Resource(from, path), w, h);
        }

        public static Sprite.Atlas load(String   from, String path, int w, int h) {
            return load(new Resource(from, path), w, h);
        }
    }
}
