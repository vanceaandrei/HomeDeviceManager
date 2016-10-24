package com.hdm.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by andrei.vancea on 10/5/2016.
 */

@CrossOrigin(origins = "*", methods = {RequestMethod.POST, RequestMethod.PUT, RequestMethod.GET, RequestMethod.DELETE})
@RestController
@RequestMapping(value = "/profile")
public class ProfileController {

//    @RequestMapping(consumes = {"*/*"}, method = RequestMethod.POST)
//    public
//    @ResponseBody
//    Map<String, Object> getPicture(@RequestParam("file") MultipartFile file) {
//        byte[] output = null;
//
//        if (!file.isEmpty()) {
//            try {
//
//                InputStream in = file.getInputStream();
//                BufferedImage image = ImageIO.read(in);
//
//                DigitalImage digitalImage = new DigitalImage(image);
//                output = digitalImage.getProcessedImage(true);
//
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//
//
//        Map<String, Object> response = new HashMap<>();
//
//        String fileToBase64 = Base64.encode(output);
//
//        response.put(Const.STATUS_CODE, Const.STATUS_OK);
//        response.put(Const.FILE, fileToBase64);
//
//        return response;
//    }

}
