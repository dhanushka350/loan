package com.insourceit.lms.controller.rest;

import com.insourceit.lms.dto.BorrowerDto;
import com.insourceit.lms.dto.ResponseDto;
import com.insourceit.lms.service.Staff_Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/rest/borrower")
public class BorrowerController {
    @Autowired
    private Staff_Service Service;

    private static final Logger LOG = LoggerFactory.getLogger(System_User.class);


    @RequestMapping(value = {"/registration"}, method = RequestMethod.POST)
    @ResponseBody
    private ResponseDto registration(@RequestBody BorrowerDto borrowerDto) {
        LOG.info("[APP-API-REST-CONTROLLER-BORROWER-REGISTRATION] - data received - " + borrowerDto.getFname());
        return Service.saveBorrower(borrowerDto);
    }

    @RequestMapping(value = {"/borrowersList"}, method = RequestMethod.GET)
    @ResponseBody
    private List<BorrowerDto> borrowersList() {
        LOG.info("[APP-API-REST-CONTROLLER-BORROWERS-LIST]");
        return Service.allBorrowers();
    }

    @RequestMapping(value = {"/check_id"}, method = RequestMethod.GET)
    @ResponseBody
    private BorrowerDto existingBorrower(@RequestParam String id) {
        LOG.info("[APP-API-REST-CONTROLLER-BORROWERS-ID-CHECK]");
        return Service.checkBorrowerID(id);
    }
}
