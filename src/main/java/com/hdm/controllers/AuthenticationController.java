package com.hdm.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import exception.AuthValidationException;
import models.User;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import persistence.user.UserFactory;
import util.Const;
import util.FileUtil;
import validation.AuthValidator;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Created by andrei.vancea on 9/22/2016.
 */

@RestController
public class AuthenticationController {

    /**
     * Login method
     *
     * @param rawUser Data received by submitting Login form.
     * @return JSON String response
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public
    @ResponseBody
    Map<String, Object> loginUser(@RequestBody String rawUser) {
        // TODO: 10/3/2016
        Map<String, Object> response = new HashMap<>();
        ObjectMapper mapper = new ObjectMapper();

        User user;
        try {
            user = mapper.readValue(rawUser, User.class);
            try {
                User dbUser = UserFactory.getUserRepository().getUser(user.getUsername());
                BCryptPasswordEncoder decoder = new BCryptPasswordEncoder();
                if (decoder.matches(user.getPassword(), dbUser.getPassword())) {
                    response.put(Const.STATUS_CODE, Const.STATUS_OK);
                    response.put(Const.MESSAGE, Const.MESSAGE_LOGGED_IN);
                    response.put(Const.EMAIL, dbUser.getEmail());

                    String sessionId = UUID.randomUUID().toString();
                    response.put(Const.SESSION_COOKIE, sessionId);
                } else {
                    // user doesn't exist in dataBase
                    response.put(Const.STATUS_CODE, Const.STATUS_INVALID_CREDENTIALS);
                    response.put(Const.MESSAGE, Const.INVALID_CREDENTIALS);
                }
            } catch (EmptyResultDataAccessException e) {
                // user doesn't exist in dataBase
                response.put(Const.STATUS_CODE, Const.STATUS_INVALID_CREDENTIALS);
                response.put(Const.MESSAGE, Const.INVALID_CREDENTIALS);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return response;

    }

    /**
     * POST method
     *
     * @param rawUser Data received by submitting Register form.
     * @return JSON String response
     */
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public
    @ResponseBody
    Map<String, Object> registerUser(@RequestBody String rawUser) {
        Map<String, Object> response = new HashMap<>();

        ObjectMapper mapper = new ObjectMapper();

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        User user;
        try {
            user = mapper.readValue(rawUser, User.class);
            user.setPassword(encoder.encode(user.getPassword()));
            try {
                AuthValidator.validateUserForRegister(user);
                //save user into DB
                UserFactory.getUserRepository().registerUser(user);
                //generate SessionId
                String sessionId = UUID.randomUUID().toString();

                response.put(Const.STATUS_CODE, Const.STATUS_OK);
                response.put(Const.MESSAGE, Const.MESSAGE_REGISTERED);
                response.put(Const.SESSION_COOKIE, sessionId);
                response.put(Const.USERNAME, user.getUsername());

            } catch (DataAccessException | AuthValidationException dae) {
                response.put(Const.STATUS_CODE, String.valueOf(HttpStatus.SERVICE_UNAVAILABLE.value()));
                response.put(Const.MESSAGE, Const.SERVER_ERROR);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return response;
    }

}


