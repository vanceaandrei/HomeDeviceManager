package models.dip.api;

/**
 * Created by andrei.vancea on 10/13/2016.
 */
public interface IColorSpace {

    IColorSpace setYIQImage();

    IColorSpace setYCbCrImage();

    IColorSpace adjustBrightness(int adjustment);

    IColorSpace adjustContrast(int adjustment);

    IColorSpace getDefault();

    byte[] getResultBytes();

}
