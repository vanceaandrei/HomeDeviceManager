package com.hdm.controllers.modules.devices;

import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * Created by andrei.vancea on 10/28/2016.
 */

@RestController
@RequestMapping(value = "/devices")
public class DevicesController {

    /**
     * @param deviceName
     * @param deviceType
     * @return
     */
    @RequestMapping(value = "/addDevice", method = RequestMethod.POST)
    public
    @ResponseBody
    Map<String, Object> addDevice(@RequestParam String deviceName, @RequestParam String deviceType) {

        //register device to database

        return null;
    }

}
