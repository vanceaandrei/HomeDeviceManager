package models.dip;

import models.dip.api.IColorSpace;
import models.dip.operations.DIPOperations;
import models.dip.spaces.YCbCrSpace;
import models.dip.spaces.YIQSpace;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * Created by andrei.vancea on 10/12/2016.
 */
public class ColorSpace implements IColorSpace {

    private BufferedImage image;

    private BufferedImage resultImage;

    public ColorSpace(BufferedImage image) {
        this.image = image;
        this.resultImage = image;
    }

    @Override
    public IColorSpace setYIQImage() {
        resultImage = YIQSpace.transformYIQ(image);
        return this;
    }

    @Override
    public IColorSpace setYCbCrImage() {
        resultImage = YCbCrSpace.transformYCbCr(image);
        return this;
    }

    @Override
    public IColorSpace adjustBrightness(int adjustment) {
        resultImage = DIPOperations.adjustBrightness(image, adjustment);
        return this;
    }

    @Override
    public IColorSpace adjustContrast(int adjustment) {
        resultImage = DIPOperations.adjustContrast(image, adjustment);
        return this;
    }

    @Override
    public IColorSpace getDefault() {
        resultImage = image;
        return this;
    }

    public byte[] getResultBytes() {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try {
            ImageIO.write(resultImage, "jpg", baos);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return baos.toByteArray();
    }

}
