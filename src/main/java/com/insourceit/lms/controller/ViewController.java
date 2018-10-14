package com.insourceit.lms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/")
public class ViewController {

    @GetMapping(value = "/")
    @ResponseBody
    public ModelAndView loginForm() {
        return new ModelAndView("login");
    }

    @GetMapping(value = "/recover_password")
    @ResponseBody
    public ModelAndView passwordRecover() {
        return new ModelAndView("login_password_recover");
    }

    @GetMapping(value = "/admin_dash")
    @ResponseBody
    public ModelAndView adminDashboard() {
        return new ModelAndView("admin_dashboard");
    }

    // Borrowers

    @GetMapping(value = "/view_borrowers")
    @ResponseBody
    public ModelAndView view_Borrowers() {
        return new ModelAndView("view_borrowers");
    }

    @GetMapping(value = "/add_borrowers")
    @ResponseBody
    public ModelAndView add_Borrowers() {
        return new ModelAndView("add_borrower");
    }

    @GetMapping(value = "/borrower_group")
    @ResponseBody
    public ModelAndView Borrower_group() {
        return new ModelAndView("Borrower_Group");
    }

    @GetMapping(value = "/group_registration")
    @ResponseBody
    public ModelAndView add_Borrower_group() {
        return new ModelAndView("add_group");
    }

    @GetMapping(value = "/borrower_details")
    @ResponseBody
    public ModelAndView borrower_details() {
        return new ModelAndView("borrower_details");
    }


    // Loans
    @GetMapping(value = "/add_loan")
    @ResponseBody
    public ModelAndView add_Loan() {
        return new ModelAndView("add_loan");
    }

    @GetMapping(value = "/view_loans")
    @ResponseBody
    public ModelAndView view_Loan() {
        return new ModelAndView("view_loans");
    }

    @GetMapping(value = "/view_loan_history")
    @ResponseBody
    public ModelAndView view_Loan_history() {
        return new ModelAndView("loan_history");
    }

    @GetMapping(value = "/approve_loans")
    @ResponseBody
    public ModelAndView approve_loans() {
        return new ModelAndView("approve_loans");
    }

    // settings

    @GetMapping(value = "/settings/loans")
    @ResponseBody
    public ModelAndView loanSettings() {
        return new ModelAndView("loan_settings");
    }

    // error pages
    @GetMapping(value = "/error/offline")
    @ResponseBody
    public ModelAndView offline() {
        return new ModelAndView("error_offline");
    }

}
