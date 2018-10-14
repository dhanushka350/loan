package com.insourceit.lms.dto;

public class LoanTypeDto {
    private int id;
    private String loan;
    private String amount;
    private String interest;
    private String duration;
    private String charge;
    private Double documentCharge;
    private Double insuranceCharge;


    public LoanTypeDto() {
    }

    public Double getDocumentCharge() {
        return documentCharge;
    }

    public void setDocumentCharge(Double documentCharge) {
        this.documentCharge = documentCharge;
    }

    public Double getInsuranceCharge() {
        return insuranceCharge;
    }

    public void setInsuranceCharge(Double insuranceCharge) {
        this.insuranceCharge = insuranceCharge;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getInterest() {
        return interest;
    }

    public void setInterest(String interest) {
        this.interest = interest;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getCharge() {
        return charge;
    }

    public void setCharge(String charge) {
        this.charge = charge;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLoan() {
        return loan;
    }

    public void setLoan(String loan) {
        this.loan = loan;
    }
}
