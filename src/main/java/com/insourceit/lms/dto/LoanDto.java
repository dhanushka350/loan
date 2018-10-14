package com.insourceit.lms.dto;

import java.util.List;

public class LoanDto {

    private int LID;
    private String loanID;
    private String type;
    private String borrower;
    private String addedOfficer;
    private String addedDate;
    private String paymentMethod;
    private String description;
    private String status;
    private String primaryApprovalOfficer;
    private String primaryApprovalDate;
    private String secondaryApprovalOfficer;
    private String secondaryApprovalDate;
    private String release;
    private String loanReleaseOfficer;
    private String docCharge;
    private String insuranceCharge;

    public LoanDto() {
    }

    public int getLID() {
        return LID;
    }

    public void setLID(int LID) {
        this.LID = LID;
    }

    public String getLoanID() {
        return loanID;
    }

    public void setLoanID(String loanID) {
        this.loanID = loanID;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getBorrower() {
        return borrower;
    }

    public void setBorrower(String borrower) {
        this.borrower = borrower;
    }

    public String getAddedOfficer() {
        return addedOfficer;
    }

    public void setAddedOfficer(String addedOfficer) {
        this.addedOfficer = addedOfficer;
    }

    public String getAddedDate() {
        return addedDate;
    }

    public void setAddedDate(String addedDate) {
        this.addedDate = addedDate;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPrimaryApprovalOfficer() {
        return primaryApprovalOfficer;
    }

    public void setPrimaryApprovalOfficer(String primaryApprovalOfficer) {
        this.primaryApprovalOfficer = primaryApprovalOfficer;
    }

    public String getPrimaryApprovalDate() {
        return primaryApprovalDate;
    }

    public void setPrimaryApprovalDate(String primaryApprovalDate) {
        this.primaryApprovalDate = primaryApprovalDate;
    }

    public String getSecondaryApprovalOfficer() {
        return secondaryApprovalOfficer;
    }

    public void setSecondaryApprovalOfficer(String secondaryApprovalOfficer) {
        this.secondaryApprovalOfficer = secondaryApprovalOfficer;
    }

    public String getSecondaryApprovalDate() {
        return secondaryApprovalDate;
    }

    public void setSecondaryApprovalDate(String secondaryApprovalDate) {
        this.secondaryApprovalDate = secondaryApprovalDate;
    }

    public String getRelease() {
        return release;
    }

    public void setRelease(String release) {
        this.release = release;
    }

    public String getLoanReleaseOfficer() {
        return loanReleaseOfficer;
    }

    public void setLoanReleaseOfficer(String loanReleaseOfficer) {
        this.loanReleaseOfficer = loanReleaseOfficer;
    }

    public String getDocCharge() {
        return docCharge;
    }

    public void setDocCharge(String docCharge) {
        this.docCharge = docCharge;
    }

    public String getInsuranceCharge() {
        return insuranceCharge;
    }

    public void setInsuranceCharge(String insuranceCharge) {
        this.insuranceCharge = insuranceCharge;
    }
}
