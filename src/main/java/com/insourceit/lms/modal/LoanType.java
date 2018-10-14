package com.insourceit.lms.modal;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "t_loan_type")
public class LoanType implements Serializable {
    private static final long serialVersionUID = -5418237602202919559L;

    @Id
    @Column(name = "idt_loan_type")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int ID;
    @Column(name = "t_loan_type_name")
    private String type;
    @Column(name = "t_loan_type_amount")
    private String amount;
    @Column(name = "t_loan_type_interest")
    private String interest;
    @Column(name = "t_loan_type_weekly_charge")
    private String charge;
    @Column(name = "t_loan_type_duration")
    private String duration;
    @Column(name = "t_loan_document_charge")
    private Double documentCharge;
    @Column(name = "t_loan_insurance_charge")
    private Double insuranceCharge;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "type", fetch = FetchType.LAZY)
    private List<Loan> loans = new ArrayList<>();

    public LoanType() {
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

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

    public String getCharge() {
        return charge;
    }

    public void setCharge(String charge) {
        this.charge = charge;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public List<Loan> getLoans() {
        return loans;
    }

    public void setLoans(List<Loan> loans) {
        this.loans = loans;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("LoanType{");
        sb.append("ID=").append(ID);
        sb.append(", type='").append(type).append('\'');
        sb.append(", amount='").append(amount).append('\'');
        sb.append(", interest='").append(interest).append('\'');
        sb.append(", charge='").append(charge).append('\'');
        sb.append(", duration='").append(duration).append('\'');
        sb.append(", loans=").append(loans);
        sb.append('}');
        return sb.toString();
    }
}
