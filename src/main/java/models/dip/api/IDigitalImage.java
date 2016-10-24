package models.dip.api;

/**
 * Created by andrei.vancea on 10/13/2016.
 */
public interface IDigitalImage {

    byte[] getDefault();

    byte[] getYIQImage();

    byte[] getYCbCrImage();

    byte[] adjustBrightness(int adjustment);

    byte[] adjustContrast(int adjustment);
}
