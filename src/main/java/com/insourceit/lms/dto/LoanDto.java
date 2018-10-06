package com.insourceit.lms.dto;

import java.util.List;

public class LoanDto {
    private int LID;
    private String disbursed;
    private String date;
    private String status;
    private String desc;
    private String borrower;
    private String officer;
    private int loanType;


    public LoanDto() {
    }

    public LoanDto(int LID, String disbursed, String date, String status, String desc, String borrower, String officer, int loanType) {
        this.LID = LID;
        this.disbursed = disbursed;
        this.date = date;
        this.status = status;
        this.desc = desc;
        this.borrower = borrower;
        this.officer = officer;
        this.loanType = loanType;
    }

    public int getLID() {
        return LID;
    }

    public void setLID(int LID) {
        this.LID = LID;
    }

    public String getDisbursed() {
        return disbursed;
    }

    public void setDisbursed(String disbursed) {
        this.disbursed = disbursed;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getBorrower() {
        return borrower;
    }

    public void setBorrower(String borrower) {
        this.borrower = borrower;
    }

    public String getOfficer() {
        return officer;
    }

    public void setOfficer(String officer) {
        this.officer = officer;
    }

    public int getLoanType() {
        return loanType;
    }

    public void setLoanType(int loanType) {
        this.loanType = loanType;
    }

}
