package com.insourceit.lms.modal;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "t_loan")
public class Loan implements Serializable {
    private static final long serialVersionUID = 9178083216783938702L;

    @Id
    @Column(name = "idt_loan")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int LID;

    @Column(name = "t_loan_id")
    private String loanID;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "t_loan_type")
    private LoanType type;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "t_loan_borrower")
    private Borrower borrower;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "t_loan_added_officer")
    private User addedOfficer;

    @Column(name = "t_loan_added_date")
    private String addedDate;

    @Column(name = "t_loan_payment_method")
    private String paymentMethod;

    @Column(name = "t_loan_description")
    private String description;

    @Column(name = "t_loan_loan_status")
    private String status;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "t_loan_primary_approval_officer")
    private User primaryApprovalOfficer;

    @Column(name = "t_loan_primary_approval_date")
    private String primaryApprovalDate;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "t_loan_secondary_approval_officer")
    private User secondaryApprovalOfficer;

    @Column(name = "t_loan_secondary_approval_date")
    private String secondaryApprovalDate;

    @Column(name = "t_loan_loan_release_date")
    private String release;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "t_loan_release_officer")
    private User loanReleaseOfficer;

    @Column(name = "t_loan_doc_charge")
    private String docCharge;

    @Column(name = "t_loan_insurance_charge")
    private String insuranceCharge;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "loan", fetch = FetchType.LAZY)
    private List<Repayment> repayments = new ArrayList<>();

    public Loan() {
    }

    public Loan(String loanID, LoanType type, Borrower borrower, User addedOfficer, String addedDate, String paymentMethod, String description, String status, User primaryApprovalOfficer, String primaryApprovalDate, User secondaryApprovalOfficer, String secondaryApprovalDate, String release, User loanReleaseOfficer, String docCharge, String insuranceCharge, List<Repayment> repayments) {
        this.loanID = loanID;
        this.type = type;
        this.borrower = borrower;
        this.addedOfficer = addedOfficer;
        this.addedDate = addedDate;
        this.paymentMethod = paymentMethod;
        this.description = description;
        this.status = status;
        this.primaryApprovalOfficer = primaryApprovalOfficer;
        this.primaryApprovalDate = primaryApprovalDate;
        this.secondaryApprovalOfficer = secondaryApprovalOfficer;
        this.secondaryApprovalDate = secondaryApprovalDate;
        this.release = release;
        this.loanReleaseOfficer = loanReleaseOfficer;
        this.docCharge = docCharge;
        this.insuranceCharge = insuranceCharge;
        this.repayments = repayments;
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

    public LoanType getType() {
        return type;
    }

    public void setType(LoanType type) {
        this.type = type;
    }

    public Borrower getBorrower() {
        return borrower;
    }

    public void setBorrower(Borrower borrower) {
        this.borrower = borrower;
    }

    public User getAddedOfficer() {
        return addedOfficer;
    }

    public void setAddedOfficer(User addedOfficer) {
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

    public User getPrimaryApprovalOfficer() {
        return primaryApprovalOfficer;
    }

    public void setPrimaryApprovalOfficer(User primaryApprovalOfficer) {
        this.primaryApprovalOfficer = primaryApprovalOfficer;
    }

    public String getPrimaryApprovalDate() {
        return primaryApprovalDate;
    }

    public void setPrimaryApprovalDate(String primaryApprovalDate) {
        this.primaryApprovalDate = primaryApprovalDate;
    }

    public User getSecondaryApprovalOfficer() {
        return secondaryApprovalOfficer;
    }

    public void setSecondaryApprovalOfficer(User secondaryApprovalOfficer) {
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

    public User getLoanReleaseOfficer() {
        return loanReleaseOfficer;
    }

    public void setLoanReleaseOfficer(User loanReleaseOfficer) {
        this.loanReleaseOfficer = loanReleaseOfficer;
    }

    public List<Repayment> getRepayments() {
        return repayments;
    }

    public void setRepayments(List<Repayment> repayments) {
        this.repayments = repayments;
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

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Loan{");
        sb.append("LID=").append(LID);
        sb.append(", loanID='").append(loanID).append('\'');
        sb.append(", type=").append(type);
        sb.append(", borrower=").append(borrower);
        sb.append(", addedOfficer=").append(addedOfficer);
        sb.append(", addedDate='").append(addedDate).append('\'');
        sb.append(", paymentMethod='").append(paymentMethod).append('\'');
        sb.append(", description='").append(description).append('\'');
        sb.append(", status='").append(status).append('\'');
        sb.append(", primaryApprovalOfficer=").append(primaryApprovalOfficer);
        sb.append(", primaryApprovalDate='").append(primaryApprovalDate).append('\'');
        sb.append(", secondaryApprovalOfficer=").append(secondaryApprovalOfficer);
        sb.append(", secondaryApprovalDate='").append(secondaryApprovalDate).append('\'');
        sb.append(", release='").append(release).append('\'');
        sb.append(", loanReleaseOfficer=").append(loanReleaseOfficer);
        sb.append(", docCharge='").append(docCharge).append('\'');
        sb.append(", insuranceCharge='").append(insuranceCharge).append('\'');
        sb.append(", repayments=").append(repayments);
        sb.append('}');
        return sb.toString();
    }
}
