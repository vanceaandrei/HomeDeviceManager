package com.hdm.controllers.views;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by andrei.vancea on 10/21/2016.
 */

@RestController
public class ViewsController {

    //GET Methods

    //*** Welcome view ***
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView get() {
        return new ModelAndView("welcome");
    }

    //*** Auth views ***
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView getLoginPage() {
        return new ModelAndView("Login");
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public ModelAndView getRegisterPage() {
        return new ModelAndView("RegisterView");
    }

    //*** User settings views ***
    @RequestMapping(value = "/profile", method = RequestMethod.GET)
    public ModelAndView getProfileView() {
        return new ModelAndView("Profile");
    }

    //*** HDM modules ***

    /* Devices */
    @RequestMapping(value = "/myDevices", method = RequestMethod.GET)
    public ModelAndView getDevicesView() {
        return new ModelAndView("Devices");
    }

}
