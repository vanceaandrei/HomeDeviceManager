package util;

import java.awt.image.BufferedImage;
import java.awt.image.PixelGrabber;

import static util.Const.DIM;

/**
 * Created by andrei.vancea on 10/13/2016.
 */
public class DIPUtils {

    private static int[] pixels = new int[DIM * DIM];

    public static int[] grabPixels(BufferedImage image) {
        PixelGrabber grabber = new PixelGrabber(image, 0, 0, DIM, DIM, pixels, 0, DIM);

        try {
            grabber.grabPixels();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return pixels;
    }

    public static int makeCorrections(long v) {
        if (v < 0) {
            return 0;
        }
        if (v > 255) {
            return 255;
        }
        return (int) v;
    }
}
