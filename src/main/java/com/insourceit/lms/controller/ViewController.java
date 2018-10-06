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


    // error pages
    @GetMapping(value = "/error/offline")
    @ResponseBody
    public ModelAndView offline() {
        return new ModelAndView("error_offline");
    }
}
