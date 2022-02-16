package jasper.core.awt;

import jasper.math.Bounds2;
import jasper.math.Vector;
import jasper.math.Vector2;
import jasper.util.*;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.HashMap;

public class Sprite implements Copyable<Sprite>, Renderable {
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
    protected final Vector2.Mutable
        origin = new Vector2.Mutable();
    protected final Bounds2.Mutable
        bounds = new Bounds2.Mutable();

    public Sprite(               Sprite.Atlas atlas) {
        this(null  , atlas       );
    }

    public Sprite(Sprite sprite                    ) {
        this(sprite, sprite.atlas);
    }

    public Sprite(Sprite sprite, Sprite.Atlas atlas) {
        this.atlas = atlas;
        if(sprite != null) {
            this.mode = sprite.mode;
            this
                .frame(sprite.frame)
                .speed(sprite.speed)
                .flip (sprite.flip )
                .flop (sprite.flop );
            this.origin.set(sprite.origin);
            this.bounds.set(sprite.bounds);
        } else {
            this.bounds.set(0, 0,
                this.atlas.frame_w,
                this.atlas.frame_h
            );
        }
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

    public Sprite x(float x) {
        origin.x(x);
        return this;
    }

    public Sprite y(float y) {
        origin.y(y);
        return this;
    }

    public Sprite x0(float x0) {
        bounds.x0(x0);
        return this;
    }

    public Sprite w(float w) {
        bounds.w(w);
        return this;
    }

    public Sprite h(float h) {
        bounds.h(h);
        return this;
    }

    public Sprite xy(float x, float y) {
        origin.xy(x, y);
        return this;
    }

    public Sprite wh(float w, float h) {
        bounds.wh(w, h);
        return this;
    }

    public Sprite xy(Vector xy) {
        origin.xy(xy);
        return this;
    }

    public Sprite wh(Vector wh) {
        bounds.wh(wh);
        return this;
    }

    public Sprite.Atlas atlas() {
        return atlas;
    }

    public int mode() {
        return mode;
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

    public float frame() {
        return frame;
    }

    public float speed() {
        return speed;
    }

    public boolean isFlipped() {
        return flip;
    }

    public boolean isFlopped() {
        return flop;
    }

    public float x() {
        return origin.x();
    }

    public float y() {
        return origin.y();
    }

    public float w() {
        return bounds.w();
    }

    public float h() {
        return bounds.h();
    }

    public Vector2 xy() {
        return origin.xy();
    }

    public Vector2 wh() {
        return bounds.wh();
    }

    public Vector2.Mutable origin() {
        return origin;
    }

    public Bounds2.Mutable bounds() {
        return bounds;
    }

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
            x0 = (int) bounds.x1();
            x1 = (int) bounds.x0();
        } else {
            x0 = (int) bounds.x0();
            x1 = (int) bounds.x1();
        }
        int y0, y1;
        if(flop) {
            y0 = (int) bounds.y1();
            y1 = (int) bounds.y0();
        } else {
            y0 = (int) bounds.y0();
            y1 = (int) bounds.y1();
        }

        context.image(
            atlas.frames[(int)frame],
            0, 0,
            atlas.frame_w,
            atlas.frame_h,
            origin.x() + x0,
            origin.y() + y0,
            (x1 - x0),
            (y1 - y0)
        );
    }

    @Override
    public Sprite copy() {
        return new Sprite(this);
    }

    public static Sprite load(Resource resource, int w, int h, Sprite.Effect... effects) {
        Sprite.Atlas atlas = Sprite.Effect.apply(Sprite.Atlas.load(resource, w, h), effects);
        return atlas != null ? new Sprite(atlas) : null;
    }

    public static Sprite load(String   resource, int w, int h, Sprite.Effect... effects) {
        return Sprite.load(new Resource(resource), w, h, effects);
    }

    public static Sprite load(Class<?> from, String path, int w, int h, Sprite.Effect... effects) {
        return Sprite.load(new Resource(from, path), w, h, effects);
    }

    public static Sprite load(String   from, String path, int w, int h, Sprite.Effect... effects) {
        return Sprite.load(new Resource(from, path), w, h, effects);
    }

    public static Sprite load(Sprite.Cache cache, String eid, Resource resource, int w, int h, Sprite.Effect... effects) {
        Cache.Element element = cache.load(eid, resource, w, h, effects);
        return element != null ? new Sprite(element.sprite().atlas()) : null;
    }

    public static Sprite load(Sprite.Cache cache, String eid, String   resource, int w, int h, Sprite.Effect... effects) {
        return Sprite.load(cache, eid, new Resource(resource), w, h, effects);
    }

    public static Sprite load(Sprite.Cache cache, String eid, Class<?> from, String path, int w, int h, Sprite.Effect... effects) {
        return Sprite.load(cache, eid, new Resource(from, path), w, h, effects);
    }

    public static Sprite load(Sprite.Cache cache, String eid, String   from, String path, int w, int h, Sprite.Effect... effects) {
        return Sprite.load(cache, eid, new Resource(from, path), w, h, effects);
    }

    public static Sprite from(Sprite.Cache cache, String eid, Sprite.Effect... effects) {
        Cache.Element element = cache.get(eid, effects);
        return element != null ? new Sprite(element.sprite().atlas()) : null;
    }

    public static Sprite from(Sprite.Cache cache, int    iid, Sprite.Effect... effects) {
        Cache.Element element = cache.get(iid, effects);
        return element != null ? new Sprite(element.sprite().atlas()) : null;
    }

    public static class Atlas implements Copyable<Sprite.Atlas> {
        protected final Resource
            resource;
        protected final BufferedImage
            atlas;
        protected final int
            atlas_w,
            atlas_h;
        protected final BufferedImage[]
            frames;
        protected final int
            frame_w,
            frame_h;

        public Atlas(
            Resource resource,
            BufferedImage atlas,
            int atlas_w,
            int atlas_h,
            BufferedImage[] frames,
            int frame_w,
            int frame_h
        ) {
            this.resource = resource;
            this.atlas    = atlas;
            this.atlas_w  = atlas_w;
            this.atlas_h  = atlas_h;
            this.frames   = frames ;
            this.frame_w  = frame_w;
            this.frame_h  = frame_h;
        }

        @Override
        public Atlas copy() {
            return new Sprite.Atlas(
                Copyable.copyOf(resource),
                AWT.copy(atlas ), atlas_w, atlas_h,
                AWT.copy(frames), frame_w, frame_h
            );
        }

        public static Sprite.Atlas load(Resource resource, int w, int h) {
            try(InputStream input = resource.newInputStream()) {
                if(input == null)
                    Debug.warn(new Object() { }, "Unable to load Sprite.Atlas '" + resource + "'");
                else {
                    BufferedImage atlas = ImageIO.read(input);
                    int
                        atlas_w = atlas.getWidth (),
                        atlas_h = atlas.getHeight(),
                        frame_w = w,
                        frame_h = h;
                    w = atlas_w / frame_w;
                    h = atlas_h / frame_h;
                    BufferedImage[] frames = new BufferedImage[w * h];
                    for(int i = 0; i < w; i ++)
                        for(int j = 0; j < h; j ++)
                            frames[j * w + i] = atlas.getSubimage(
                                i * frame_w,
                                j * frame_h,
                                frame_w, frame_h
                            );
                    return new Atlas(
                        resource,
                        atlas , atlas_w, atlas_h,
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

    public static interface Effect {
        public static final Sprite.Effect
            COERCE_TYPE_INT_RGB  = Sprite.Effect.COERCE(BufferedImage.TYPE_INT_RGB ),
            COERCE_TYPE_INT_ARGB = Sprite.Effect.COERCE(BufferedImage.TYPE_INT_ARGB);

        public BufferedImage[] apply(BufferedImage[] frames);

        public static BufferedImage[] apply(BufferedImage[] frames, Sprite.Effect... effects) {
            frames = AWT.copy(frames);
            for(Sprite.Effect effect: effects)
                frames = effect.apply(frames);
            return frames;
        }

        public static Sprite.Atlas apply(Sprite.Atlas atlas, Sprite.Effect... effects) {
            if(effects.length > 0) {
                BufferedImage[] frames = apply(atlas.frames, effects);
                int
                    frame_w = 0,
                    frame_h = 0;
                if(frames.length > 0) {
                    frame_w = frames[0].getWidth() ;
                    frame_h = frames[0].getHeight();
                }
                return new Sprite.Atlas(
                    null,
                    null  ,       0,       0,
                    frames, frame_w, frame_h
                );
            } else
                return atlas;
        }

        public static Sprite apply(Sprite sprite, Sprite.Effect... effects) {
            return new Sprite(sprite, apply(sprite.atlas, effects));
        }

        public static Sprite.Effect COERCE(int type) {
            return (frames) -> {
                for(int i = 0; i < frames.length; i ++) {
                    int
                        w = frames[i].getWidth() ,
                        h = frames[i].getHeight();
                    frames[i] = AWT.copy(frames[i], new BufferedImage(
                        w, h,
                        type
                    ));
                }
                return frames;
            };
        }
    }

    public static class Cache {
        protected final HashMap<String, Cache.Element>
            cache = new HashMap<String, Cache.Element>();
        protected Cache.Element[]
            stack = new Cache.Element[16];
        protected int
            size;

        public Cache.Element link(String eid, Sprite sprite) {
            Cache.Element element = cache.get(eid);
            if(element != null)
                Debug.warn(new Object() { }, "Unable to link eid '" + eid + "' with Sprite '" + sprite + "'");
            else if(sprite != null) {
                if (size >= stack.length) {
                    Cache.Element[] _stack = new Cache.Element[stack.length + stack.length >> 1];
                    System.arraycopy(stack, 0, _stack, 0, stack.length);
                    stack = _stack;
                }
                cache.put(eid, element = stack[size] = new Cache.Element(eid, size ++, sprite));
            }
            return element;
        }

        public Cache.Element load(String eid, Resource resource, int w, int h, Sprite.Effect... effects) {
            return get(link(eid, Sprite.load(resource, w, h)), effects);
        }

        public Cache.Element load(String eid, String   resource, int w, int h, Sprite.Effect... effects) {
            return load(eid, new Resource(resource), w, h, effects);
        }

        public Cache.Element load(String eid, Class<?> from, String path, int w, int h, Sprite.Effect... effects) {
            return load(eid, new Resource(from, path), w, h, effects);
        }

        public Cache.Element load(String eid, String   from, String path, int w, int h, Sprite.Effect... effects) {
            return load(eid, new Resource(from, path), w, h, effects);
        }

        public Cache.Element get(String eid) {
            return cache.get(eid);
        }

        public Cache.Element get(int    iid) {
            return iid >= 0 && iid < size ? stack[iid] : null;
        }

        public Cache.Element get(String eid, Sprite.Effect... effects) {
            return get(get(eid), effects);
        }

        public Cache.Element get(int    iid, Sprite.Effect... effects) {
            return get(get(iid), effects);
        }

        protected Cache.Element get(Cache.Element element, Sprite.Effect... effects) {
            if(element != null) {
                Cache.Element
                    root = element,
                    node = element;
                for (Sprite.Effect effect : effects) {
                    node = root.cache.get(effect);
                    if (node != null)
                        root = node;
                    else {
                        if (size >= stack.length) {
                            Cache.Element[] _stack = new Cache.Element[stack.length + stack.length >> 1];
                            System.arraycopy(stack, 0, _stack, 0, stack.length);
                            stack = _stack;
                        }
                        root.cache.put(effect, root = node = stack[size] = new Cache.Element(
                            null, size++, Sprite.Effect.apply(root.sprite(), effect)
                        ));
                    }
                }
                return node;
            } else
                return null;
        }

        public static class Element {
            protected final HashMap<Sprite.Effect, Cache.Element>
                cache = new HashMap<Sprite.Effect, Cache.Element>();

            protected final String
                eid; // external id
            protected final int
                iid; // internal id

            protected final Sprite
                sprite;

            public Element(String eid, int iid, Sprite sprite) {
                this.eid = eid;
                this.iid = iid;
                this.sprite = sprite;
            }

            public String eid() { return eid; }
            public int    iid() { return iid; }
            public Sprite sprite() { return sprite; }
        }
    }
}
