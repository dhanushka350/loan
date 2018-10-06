package com.insourceit.lms.controller.rest;

import com.insourceit.lms.dto.BorrowerDto;
import com.insourceit.lms.dto.UserLogin;
import com.insourceit.lms.service.Staff_Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value = "/api/rest/system_user")
public class System_User {

    @Autowired
    private Staff_Service userService;

    private static final Logger LOG = LoggerFactory.getLogger(System_User.class);
    Date date = new Date();
    DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");


    // login and logout
    @RequestMapping(value = {"/login"}, method = RequestMethod.POST)
    @ResponseBody
    private String userLogin(@RequestBody UserLogin login) {
        LOG.info("[APP-API-REST-CONTROLLER-LOGIN] - data received - " + login.getName() + " - " + dateFormat.format(date));
        return userService.userLogin(login);
    }

    @RequestMapping(value = {"/log_out"}, method = RequestMethod.POST)
    @ResponseBody
    private boolean userLogout(@RequestBody UserLogin login) {
        LOG.info("[APP-API-REST-CONTROLLER-LOGOUT] - data received - " + login.getName());
        return userService.userLogout(login.getName());
    }

    @RequestMapping(value = {"/staffList"}, method = RequestMethod.GET)
    @ResponseBody
    private List<String> staffList() {
        LOG.info("[APP-API-REST-CONTROLLER-STAFF-LIST]");
        return userService.allUsers();
    }
}