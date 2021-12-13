package jasper.core.awt;

import jasper.math.Bounds2;
import jasper.math.Vector;
import jasper.math.Vector2;
import jasper.util.*;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Objects;

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

    protected final Array.Stack<Sprite>
        stack = new Array.Stack<Sprite>();

    public Sprite(Sprite.Atlas atlas) {
        this(null, atlas);
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

    public Sprite atlas(Sprite.Atlas atlas) {
        this.atlas = atlas;
        if(frame < 0                   ) frame = (frame % atlas.frames.length) + atlas.frames.length;
        if(frame >= atlas.frames.length) frame = (frame % atlas.frames.length)                      ;
        return this;
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

    public int mode() {
        return mode;
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

    public Sprite x(float x) {
        origin.x(x);
        return this;
    }

    public Sprite y(float y) {
        origin.y(y);
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

    public Sprite push() {
        stack.push(copy());
        return this;
    }

    public Sprite pull() {
        if(stack.size() > 0) {
            Sprite sprite = stack.pull();
            this.atlas = sprite.atlas;
            this.mode  = sprite.mode ;
            this.frame = sprite.frame;
            this.speed = sprite.speed;
            this.flip  = sprite.flip;
            this.flop  = sprite.flop;
            this.origin.set(sprite.origin);
            this.bounds.set(sprite.bounds);
        }
        return this;
    }

    @Override
    public Sprite copy() {
        return new Sprite(this);
    }

    public static Sprite load(Resource resource, int w, int h, Sprite.Effect... chain) {
        return new Sprite(Sprite.Effect.apply(Sprite.Atlas.load(resource, w, h), chain));
    }

    public static Sprite load(String   resource, int w, int h, Sprite.Effect... chain) {
        return Sprite.load(new Resource(resource), w, h, chain);
    }

    public static Sprite load(Class<?> from, String path, int w, int h, Sprite.Effect... chain) {
        return Sprite.load(new Resource(from, path), w, h, chain);
    }

    public static Sprite load(String   from, String path, int w, int h, Sprite.Effect... chain) {
        return Sprite.load(new Resource(from, path), w, h, chain);
    }

    public static Sprite load(Sprite.Cache cache, String id, Resource resource, int w, int h, Sprite.Effect... chain) {
        return new Sprite(cache.load(id, resource, w, h, chain));
    }

    public static Sprite load(Sprite.Cache cache, String id, String   resource, int w, int h, Sprite.Effect... chain) {
        return Sprite.load(cache, id, new Resource(resource), w, h, chain);
    }

    public static Sprite load(Sprite.Cache cache, String id, Class<?> from, String path, int w, int h, Sprite.Effect... chain) {
        return Sprite.load(cache, id, new Resource(from, path), w, h, chain);
    }

    public static Sprite load(Sprite.Cache cache, String id, String   from, String path, int w, int h, Sprite.Effect... chain) {
        return Sprite.load(cache, id, new Resource(from, path), w, h, chain);
    }

    public static Sprite from(Sprite.Cache cache, String id, Sprite.Effect... chain) {
        return new Sprite(cache.reserve(id, chain));
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
                AWT.copyImage (atlas ), atlas_w, atlas_h,
                AWT.copyImages(frames), frame_w, frame_h
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

        public static BufferedImage[] apply(BufferedImage[] frames, Sprite.Effect... chain) {
            frames = AWT.copyImages(frames);
            for(Sprite.Effect effect: chain)
                frames = effect.apply(frames);
            return frames;
        }

        public static Sprite.Atlas apply(Sprite.Atlas atlas, Sprite.Effect... chain) {
            if(chain.length > 0) {
                BufferedImage[] frames = apply(atlas.frames, chain);
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

        public static Sprite apply(Sprite sprite, Sprite.Effect... chain) {
            return new Sprite(sprite, apply(sprite.atlas, chain));
        }

        public static Sprite.Effect COERCE(int type) {
            return (frames) -> {
                for(int i = 0; i < frames.length; i ++) {
                    int
                        w = frames[i].getWidth() ,
                        h = frames[i].getHeight();
                    frames[i] = AWT.copyImage(frames[i], new BufferedImage(
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
            index = new HashMap<String, Cache.Element>();

        public Sprite.Atlas load(String id, Resource resource, int w, int h, Sprite.Effect... chain) {
            Cache.Element element = index.get(id);

            boolean
                warn = false;
            if(
                element == null ||
                (warn =
                    !Objects.equals(element.atlas().resource, resource) ||
                    element.atlas().frame_w != w ||
                    element.atlas().frame_h != h
                )
            ) {
                Sprite.Atlas atlas = Sprite.Atlas.load(resource, w, h);
                if(atlas != null) {
                    if(warn) Debug.warn(new Object() { }, String.format(
                        "Sprite.Atlas ('%1$s', %2$d, %3$d) with id '%4$s' will be replaced ('%5$s', %6$d, %7$d)",
                        element.atlas().resource,
                        element.atlas().frame_w ,
                        element.atlas().frame_h ,
                        id, resource, w, h
                    ));

                    element = new Cache.Element(this, atlas);
                    index.put(id, element);
                }
            }

            return element != null ? element.reserve(chain).atlas() : null;
        }

        public Sprite.Atlas load(String id, String   resource, int w, int h, Sprite.Effect... chain) {
            return load(id, new Resource(resource), w, h, chain);
        }

        public Sprite.Atlas load(String id, Class<?> from, String path, int w, int h, Sprite.Effect... chain) {
            return load(id, new Resource(from, path), w, h, chain);
        }

        public Sprite.Atlas load(String id, String   from, String path, int w, int h, Sprite.Effect... chain) {
            return load(id, new Resource(from, path), w, h, chain);
        }

        public Sprite.Atlas request(String id, Sprite.Effect... chain) {
            Cache.Element element;
            if((element = index.get(id)) != null)
                element = element.request(chain);
            return element != null ? element.atlas() : null;
        }

        public Sprite.Atlas require(String id, Sprite.Effect... chain) {
            Cache.Element element;
            if((element = index.get(id)) != null)
                element = element.require(chain);
            return element != null ? element.atlas() : null;
        }

        public Sprite.Atlas reserve(String id, Sprite.Effect... chain) {
            Cache.Element element;
            if((element = index.get(id)) != null)
                element = element.reserve(chain);
            return element != null ? element.atlas() : null;
        }

        public static class Element {
            protected final HashMap<Sprite.Effect, Cache.Element>
                index = new HashMap<Sprite.Effect, Cache.Element>();
            protected Sprite.Cache
                cache;
            protected Sprite.Atlas
                atlas;

            public Element(
                Sprite.Cache cache,
                Sprite.Atlas atlas
            ) {
                this.cache = cache;
                this.atlas = atlas;
            }

            public Sprite.Cache cache() {
                return cache;
            }

            public Sprite.Atlas atlas() {
                return atlas;
            }

            public Cache.Element request(Sprite.Effect... chain) {
                Cache.Element
                    root = this,
                    node = this;
                for(Sprite.Effect effect : chain) {
                    node = root.index.get(effect);
                    if(node != null)
                        root = node;
                    else
                        return null;
                }
                return node;
            }

            public Cache.Element require(Sprite.Effect... chain) {
                Cache.Element
                    root = this,
                    node = this;
                for(Sprite.Effect effect : chain) {
                    node = root.index.get(effect);
                    if(node != null)
                        root = node;
                    else
                        root = node = new Cache.Element(
                            cache, Sprite.Effect.apply(root.atlas, effect)
                        );
                }
                return node;
            }

            public Cache.Element reserve(Sprite.Effect... chain) {
                Cache.Element
                    root = this,
                    node = this;
                for(Sprite.Effect effect : chain) {
                    node = root.index.get(effect);
                    if(node != null)
                        root = node;
                    else {
                        root = node = new Cache.Element(
                            cache, Sprite.Effect.apply(root.atlas, effect)
                        );
                        index.put(effect, node);
                    }
                }
                return node;
            }
        }
    }
}
