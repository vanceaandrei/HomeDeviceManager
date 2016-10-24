package com.hdm.controllers.modules.dip;

import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;
import models.dip.DigitalImage;
import models.dip.api.IDigitalImage;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import util.Const;
import util.DIPConstants;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by andrei.vancea on 10/11/2016.
 */

@CrossOrigin(origins = "*", methods = {RequestMethod.POST, RequestMethod.PUT, RequestMethod.GET, RequestMethod.DELETE})
@RestController
@RequestMapping(value = "/modules")
public class DIPController {

    @RequestMapping(value = "/dip", consumes = {"*/*"}, method = RequestMethod.POST)
    public
    @ResponseBody
    Map<String, Object> getPicture(@RequestParam("file") MultipartFile file) {
        byte[] output = new byte[0];
        try {
            output = file.getBytes();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Map<String, Object> response = new HashMap<>();

        String fileToBase64 = Base64.encode(output);

        response.put(Const.STATUS_CODE, Const.STATUS_OK);
        response.put(Const.FILE, fileToBase64);

        return response;
    }

    @RequestMapping(value = "/dip/command", method = RequestMethod.POST)
    public
    @ResponseBody
    Map<String, Object> doChanges(@RequestParam("file") MultipartFile file, @RequestParam("command") String command, @RequestParam("brightness") int brightness) {

        byte[] output = processImage(file, command, brightness);

        Map<String, Object> response = new HashMap<>();

        String fileToBase64 = Base64.encode(output);

        response.put(Const.STATUS_CODE, Const.STATUS_OK);
        response.put(Const.FILE, fileToBase64);

        return response;
    }

    private byte[] processImage(MultipartFile file, String command, int value) {
        byte[] output = null;
        if (!file.isEmpty()) {
            try {
                InputStream in = file.getInputStream();
                BufferedImage image = ImageIO.read(in);
                IDigitalImage digitalImage = new DigitalImage(image);
                if (value != 0) {
                    switch (command) {
                        case DIPConstants.BRIGHTNESS:
                            output = digitalImage.adjustBrightness(value);
                            break;
                        case DIPConstants.CONTRAST:
                            output = digitalImage.adjustContrast(value);
                            break;
                        default:
                            output = digitalImage.getDefault();
                    }
                } else {
                    switch (command) {
                        case DIPConstants.YIQ:
                            output = digitalImage.getYIQImage();
                            break;
                        case DIPConstants.YCBCR:
                            output = digitalImage.getYCbCrImage();
                            break;
                        default:
                            output = digitalImage.getDefault();
                    }
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return output;
    }

}

