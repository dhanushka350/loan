package com.insourceit.lms.controller.rest;

import com.insourceit.lms.dto.LoanDto;
import com.insourceit.lms.dto.LoanTypeDto;
import com.insourceit.lms.dto.PaymentDates;
import com.insourceit.lms.dto.ResponseDto;
import com.insourceit.lms.service.LoanService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/rest/loan")
public class LoanController {

    @Autowired
    private LoanService loanService;

    private static final Logger LOG = LoggerFactory.getLogger(LoanController.class);

    @RequestMapping(value = {"/registration"}, method = RequestMethod.POST)
    @ResponseBody
    private ResponseDto loanRegistration(@RequestBody LoanDto dto) {
        LOG.info("[APP-API-REST-CONTROLLER-LOAN-REGISTRATION]");
        return loanService.saveLoan(dto);
    }

    @RequestMapping(value = {"/generated/payments/dates"}, method = RequestMethod.GET)
    @ResponseBody
    private List<PaymentDates> loanDatesForWeeklyPayment(@RequestParam int loan, @RequestParam int duration) {
        LOG.info("[APP-API-REST-CONTROLLER-REPAYMENT-DATES]");
        return loanService.getPaymentDatesForWeeklyPayment(duration, loan);
    }

    @RequestMapping(value = {"/request/loan/types"}, method = RequestMethod.GET)
    @ResponseBody
    private List<LoanTypeDto> allLoanTypes() {
        LOG.info("[APP-API-REST-CONTROLLER-ALL-LOAN-TYPES]");
        return loanService.allLoanTypes();
    }

    @RequestMapping(value = {"/get/loan_type/details"}, method = RequestMethod.GET)
    @ResponseBody
    private LoanTypeDto loanTypeDetails(@RequestParam String id) {
        System.out.println();
        LOG.info("[APP-API-REST-CONTROLLER-LOAN-TYPE-DETAILS] for id - " + id);
        return loanService.getLoanTypeDetails(Integer.parseInt(id));
    }
}
