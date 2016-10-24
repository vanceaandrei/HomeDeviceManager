package models.dip.spaces;

import util.DIPUtils;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;

import static util.Const.DIM;
import static util.DIPConstants.YCBCR_MATRIX;
import static util.DIPUtils.makeCorrections;

/**
 * Created by andrei.vancea on 10/13/2016.
 */
public class YCbCrSpace {

    private static float y[][] = new float[DIM][DIM];
    private static float cB[][] = new float[DIM / 2][DIM / 2];
    private static float cR[][] = new float[DIM / 2][DIM / 2];

    private static int[] pixels;

    public static BufferedImage transformYCbCr(BufferedImage image) {
        pixels = DIPUtils.grabPixels(image);

        int r, g, b;
        ColorModel cm = ColorModel.getRGBdefault();
        for (int i = 0; i < DIM; i++) {
            for (int j = 0; j < DIM; j++) {
                r = cm.getRed(pixels[i * DIM + j]);
                g = cm.getGreen(pixels[i * DIM + j]);
                b = cm.getBlue(pixels[i * DIM + j]);

                y[i][j] = YCBCR_MATRIX[0][0] * r + YCBCR_MATRIX[0][1] * g + YCBCR_MATRIX[0][2] * b;

                if (i % 2 == 0 && j % 2 == 0) {
                    cB[i / 2][j / 2] = 0;
                    cR[i / 2][j / 2] = 0;
                }
                cB[i / 2][j / 2] += (YCBCR_MATRIX[1][0] * r + YCBCR_MATRIX[1][1] * g + YCBCR_MATRIX[1][2] * b + 128) / 4;
                cR[i / 2][j / 2] += (YCBCR_MATRIX[2][0] * r + YCBCR_MATRIX[2][1] * g + YCBCR_MATRIX[2][2] * b + 128) / 4;

            }
        }

        return transformToRGB(image);
    }

    private static int processes = 1;

    private static BufferedImage transformToRGB(BufferedImage image) {
        int r;
        int g;
        int b;
        for (int i = 0; i < DIM; i++) {
            for (int j = 0; j < DIM; j++) {

                float py = y[i][j];
                float pb = cB[i][j];
                float pr = cR[i][j];

                if (processes % 2 == 0) {
                    py = pb = 0;
                } else if (processes % 3 == 0) {
                    py = pr = 0;
                } else {
                    pb = pr = 0;
                }

                r = makeCorrections(Math.round(py + 0 + (pr - 128) * 1.402f));
                g = makeCorrections(Math.round(py + (pb - 128) * -0.34414f + (pr - 128) * -0.71414f));
                b = makeCorrections(Math.round(py + (pb - 128) * 1.772f + 0));

                Color newColor = new Color(r, g, b);
                image.setRGB(j, i, newColor.getRGB());
            }
        }
        return image;
    }
}
