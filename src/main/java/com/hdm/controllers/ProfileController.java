package com.hdm.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import util.Const;
import util.FileUtil;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by andrei.vancea on 10/5/2016.
 */

@CrossOrigin(origins = "*", methods = {RequestMethod.POST, RequestMethod.PUT, RequestMethod.GET, RequestMethod.DELETE})
@RestController
@RequestMapping(value = "/profile")
public class ProfileController {

    private static final Logger logger = LoggerFactory.getLogger(ProfileController.class);

    /**
     * GetPicture method for showing the profile picture of user
     *
     * @param file    Profile picture of user
     * @param request
     * @return
     */
    @RequestMapping(consumes = {"*/*"}, method = RequestMethod.POST)
    public
    @ResponseBody
    Map<String, Object> getPicture(@RequestParam("file") MultipartFile file, HttpServletRequest request) {

        // TODO: 10/28/2016
//        Map<String, Object> response = new HashMap<>();
//
//        Cookie[] cookies = request.getCookies();
//        String userEmail = "";
//
//        for (Cookie cookie : cookies) {
//            if (Const.EMAIL.equalsIgnoreCase(cookie.getName())) {
//                userEmail = cookie.getValue();
//                break;
//            }
//        }
//
//        if (!file.isEmpty()) {
//            //save file in Users directory
//            try {
//                if (userEmail != null && userEmail.contains("@")) {
//                    File dest = FileUtil.createFile(userEmail + File.separator + Const.PROFILE_PICTURE);
//                    file.transferTo(dest);
//                    response.put(Const.STATUS_CODE, Const.STATUS_OK);
//                } else {
//                    response.put(Const.STATUS_CODE, Const.STATUS_BAD_REQUEST);
//                    response.put(Const.MESSAGE, Const.MESSAGE_BAD_REQUEST);
//                    logger.debug("\"email\" cookie broken.");
//                }
//            } catch (IOException e) {
//                response.put(Const.STATUS_CODE, Const.STATUS_BAD_REQUEST);
//                response.put(Const.MESSAGE, Const.MESSAGE_BAD_REQUEST);
//                logger.error("Error while trying to create file for saving profile picture");
//                e.printStackTrace();
//            }
//        }
//
//        return response;
        return null;
    }

    @RequestMapping(value = "/getProfilePicture", method = RequestMethod.GET)
    public void getProfilePicture(@RequestParam String email) {

        FileUtil.getEncodedProfilePicture(email);

    }


}
