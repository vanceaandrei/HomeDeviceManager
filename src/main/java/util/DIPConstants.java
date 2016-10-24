package util;

/**
 * Created by andrei.vancea on 10/11/2016.
 */
public class DIPConstants {

    public static final String GREY_SCALE = "greyScale";
    public static final String YIQ = "YIQ";
    public static final String YCBCR = "YCBCR";
    public static final String HSV = "HSV";
    public static final String BRIGHTNESS = "BRIGHTNESS";
    public static final String CONTRAST = "CONTRAST";


    //matrix
    public static final float[][] YIQ_MATRIX = {
            {0.299f, 0.587f, 0.114f},
            {0.596f, -0.274f, -0.322f},
            {0.211f, -0.523f, 0.312f}
    };
    public static final float[][] YCBCR_MATRIX = {
            {0.299f, 0.587f, 0.114f},
            {-0.101f, -0.339f, 0.439f},
            {0.439f, -0.399f, -0.040f}
    };

    public static final float[][] ORIGINAL_MATRIX = {
            {1, 0, 0},
            {0, 1, 0},
            {0, 0, 1}
    };
}
