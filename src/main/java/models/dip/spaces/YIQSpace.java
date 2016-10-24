package models.dip.spaces;

import util.DIPUtils;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;

import static util.Const.DIM;
import static util.DIPConstants.YIQ_MATRIX;
import static util.DIPUtils.makeCorrections;

/**
 * Created by andrei.vancea on 10/13/2016.
 */
public class YIQSpace {

    private static float y[][] = new float[DIM][DIM];
    private static float ii[][] = new float[DIM / 2][DIM / 2];
    private static float q[][] = new float[DIM / 2][DIM / 2];

    private static int[] pixels;

    public static BufferedImage transformYIQ(BufferedImage image) {
        pixels = DIPUtils.grabPixels(image);

        int r, g, b;
        ColorModel cm = ColorModel.getRGBdefault();
        for (int i = 0; i < DIM; i++) {
            for (int j = 0; j < DIM; j++) {
                r = cm.getRed(pixels[i * DIM + j]);
                g = cm.getGreen(pixels[i * DIM + j]);
                b = cm.getBlue(pixels[i * DIM + j]);

                y[i][j] = YIQ_MATRIX[0][0] * r + YIQ_MATRIX[0][1] * g + YIQ_MATRIX[0][2] * b;

                if (i % 2 == 0 && j % 2 == 0) {
                    ii[i / 2][j / 2] = 0;
                    q[i / 2][j / 2] = 0;
                }
                ii[i / 2][j / 2] += (YIQ_MATRIX[1][0] * r + YIQ_MATRIX[1][1] * g + YIQ_MATRIX[1][2] * b) / 4;
                q[i / 2][j / 2] += (YIQ_MATRIX[2][0] * r + YIQ_MATRIX[2][1] * g + YIQ_MATRIX[2][2] * b) / 4;
            }
        }
        return transformToRGB(image);
    }

    private static int processes = 1;

    private static BufferedImage transformToRGB(BufferedImage image) {
        BufferedImage result = image;
        int r;
        int g;
        int b;
        for (int i = 0; i < DIM; i++) {
            for (int j = 0; j < DIM; j++) {

                float py = y[i][j];
                float pi = ii[i / 2][j / 2];
                float pq = q[i / 2][j / 2];

                if (processes % 2 == 0) {
                    py = pi = 0;
                } else if (processes % 3 == 0) {
                    py = pq = 0;
                } else {
                    pi = pq = 0;
                }

                r = makeCorrections(Math.round(py + pi * 0.956f + pq * 0.621f));
                g = makeCorrections(Math.round(py + pi * -0.272f + pq * -0.647f));
                b = makeCorrections(Math.round(py + pi * -1.106f + pq * 1.703f));



                Color newColor = new Color(r, g, b);
                result.setRGB(j, i, newColor.getRGB());
            }
        }
        processes++;
        return result;
    }

}
