package models.dip;

import models.dip.api.IColorSpace;
import models.dip.api.IDigitalImage;
import util.DIPConstants;

import java.awt.image.BufferedImage;

/**
 * Created by andrei.vancea on 10/6/2016.
 */
public class DigitalImage implements IDigitalImage {

    private IColorSpace cs;

    public DigitalImage(BufferedImage image) {
        cs = new ColorSpace(image);
    }

    @Override
    public byte[] getDefault() {
        return cs.getDefault().getResultBytes();
    }

    @Override
    public byte[] getYIQImage() {
        return cs.setYIQImage().getResultBytes();
    }

    @Override
    public byte[] getYCbCrImage() {
        return cs.setYCbCrImage().getResultBytes();
    }

    @Override
    public byte[] adjustBrightness(int adjustment) {
        return cs.adjustBrightness(adjustment).getResultBytes();
    }

    @Override
    public byte[] adjustContrast(int adjustment) {
        return cs.adjustContrast(adjustment).getResultBytes();
    }

}

