package jasper.core.awt;

import jasper.math.Bounds2;
import jasper.math.Region2;

import java.awt.*;
import java.awt.image.BufferedImage;

public class AWT {
    public static GraphicsDevice getGraphicsDevice(int i) {
        GraphicsDevice[] gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getScreenDevices();
        if(i >= 0 && i < gd.length)
            return gd[i];
        else if (gd.length > 0)
            return gd[0];
        else
            return GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
    }

    public static Region2 getMaximumWindowRegion(int i, boolean borderless) {
        GraphicsDevice        gd = AWT.getGraphicsDevice(i);
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
        GraphicsDevice        gd = AWT.getGraphicsDevice(i);
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

    public static BufferedImage copy(BufferedImage a, BufferedImage b) {
        Graphics2D g = b.createGraphics();
        g.drawImage(
            a,
            0, 0,
            b.getWidth (),
            b.getHeight(),
            0, 0,
            a.getWidth() ,
            a.getHeight(),
            null
        );
        g.dispose();
        return    b;
    }

    public static BufferedImage copy(BufferedImage a) {
        return copy(a, new BufferedImage(
            a.getWidth (),
            a.getHeight(),
            a.getType()
        ));
    }

    public static BufferedImage[] copy(BufferedImage[] a) {
        BufferedImage[] b = new BufferedImage[a.length];
        for(int i = 0; i < a.length; i ++)
            b[i] = copy(a[i]);
        return b;
    }
}
