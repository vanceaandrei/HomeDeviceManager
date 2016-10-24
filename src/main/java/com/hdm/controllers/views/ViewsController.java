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
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView getLoginPage() {
        return new ModelAndView("Login");
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public ModelAndView getRegisterPage() {
        return new ModelAndView("RegisterView");
    }

    @RequestMapping(value = "/profile", method = RequestMethod.GET)
    public ModelAndView getProfileView() {
        return new ModelAndView("Profile");
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView get() {
        return new ModelAndView("Welcome");
    }

    @RequestMapping(value = "/modules/dip", method = RequestMethod.GET)
    public ModelAndView getDIPView() {
        return new ModelAndView("DigitalImageProcessing");
    }

}
