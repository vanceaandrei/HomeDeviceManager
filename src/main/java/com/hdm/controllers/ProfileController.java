package com.hdm.controllers;

import models.Device;
import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.web.bind.annotation.*;
import persistence.user.UserFactory;
import util.Const;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by andrei.vancea on 10/5/2016.
 */

@CrossOrigin(origins = "*", methods = {RequestMethod.POST, RequestMethod.PUT, RequestMethod.GET, RequestMethod.DELETE})
@RestController
@RequestMapping(value = "/profile")
public class ProfileController {

    private static final Logger logger = LoggerFactory.getLogger(ProfileController.class);

    @RequestMapping(value = "/loadDevices", method = RequestMethod.POST)
    public
    @ResponseBody
    Map<String, Object> loadDevices(@RequestBody String userEmail) {
        Map<String, Object> response = new HashMap<>();
        try {
            List<Device> devices = UserFactory.getUserRepository().getUserDevices(userEmail);
            JSONArray listToJson = new JSONArray(devices);
            String d = listToJson.toString();

            response.put(Const.STATUS_CODE, Const.STATUS_OK);
            response.put(Const.DEVICES, d);
            logger.debug("Request /HomeDeviceManager/profile/loadDevices", "success");
        } catch (DataAccessException dae) {
            response.put(Const.STATUS_CODE, Const.STATUS_SERVER_ERROR);
            response.put(Const.MESSAGE, Const.SERVER_ERROR);
        }
        return response;
    }
}
