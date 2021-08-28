package jasper.core.awt;

import jasper.math.Region2;
import jasper.util.Debug;
import jasper.util.Resource;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

public class Sprite implements Renderable {
    public static final int
        STOP = 0,
        PLAY = 1,
        LOOP = 2;

    protected Sprite.Atlas
        atlas;

    protected final Region2.Mutable
        xywh = new Region2.Mutable();
    protected boolean
        flip,
        flop;

    protected float
        frame;

    public Sprite(Sprite.Atlas atlas) {
        this.atlas = atlas;
        xywh.wh(
        );
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

    @Override
    public void onRender(RenderContext context) {
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
    }

    public static Sprite load(Resource resource, int w, int h) {
        return null;
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
                    ImageIO.read(input);
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
