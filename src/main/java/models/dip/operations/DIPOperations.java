package models.dip.operations;

import util.DIPUtils;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;

import static util.Const.DIM;

/**
 * Created by andrei.vancea on 10/14/2016.
 */
public class DIPOperations {

    private static int[] pixels;

    public static BufferedImage adjustBrightness(BufferedImage image, int brightness) {
        pixels = DIPUtils.grabPixels(image);

        ColorModel cm = ColorModel.getRGBdefault();
        for (int i = 0; i < DIM; i++) {
            for (int j = 0; j < DIM; j++) {

                int r = DIPUtils.makeCorrections(cm.getRed(pixels[i * DIM + j]) + brightness);
                int g = DIPUtils.makeCorrections(cm.getGreen(pixels[i * DIM + j]) + brightness);
                int b = DIPUtils.makeCorrections(cm.getBlue(pixels[i * DIM + j]) + brightness);

                Color newColor = new Color(r, g, b);
                image.setRGB(j, i, newColor.getRGB());
            }
        }
        return image;
    }

    public static BufferedImage adjustContrast(BufferedImage image, int contrast) {
        pixels = DIPUtils.grabPixels(image);
        BufferedImage result = image;

        int[] maxMin = setMinMax(pixels);

        int min = maxMin[0];
        int max = maxMin[1];

        int rr = max - min;

        //float factor = (259f * (contrast + 255f)) / (255f * (259f - contrast));

        ColorModel cm = ColorModel.getRGBdefault();
        for (int i = 0; i < DIM; i++) {
            for (int j = 0; j < DIM; j++) {

                int p = (pixels[i] - min) / rr * 255;

                int r = cm.getRed(p);
                int g = cm.getGreen(p);
                int b = cm.getBlue(p);


                r = DIPUtils.makeCorrections(r + contrast);
                g = DIPUtils.makeCorrections(g + contrast);
                b = DIPUtils.makeCorrections(b + contrast);

                Color newColor = new Color(r, g, b);
                result.setRGB(j, i, newColor.getRGB());
            }
        }
        return result;
    }

    private static int[] setMinMax(int[] pixels) {

        int min = 255;
        int max = 0;

        for (int p : pixels) {
            if (p > max) {
                max = p;
            }
            if (p < min) {
                min = p;
            }
        }
        return new int[]{min, max};

    }

}
