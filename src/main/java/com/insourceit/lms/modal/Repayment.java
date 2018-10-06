package com.insourceit.lms.modal;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "t_repayment")
public class Repayment implements Serializable {
    private static final long serialVersionUID = 5824235030623707112L;

    @Id
    @Column(name = "idt_repayment")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int RPID;
    @Column(name = "t_repayment_date")
    private String date;
    @Column(name = "t_repayment_amount")
    private String amount;
    @Column(name = "t_repayment_status")
    private String status;
    @Column(name = "t_repayment_paid_amount")
    private String paid;
    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "t_repayment_loan")
    private Loan loan;

    public Repayment() {
    }

    public Repayment(int RPID, String date, String amount, String status, String paid, Loan loan) {
        this.RPID = RPID;
        this.date = date;
        this.amount = amount;
        this.status = status;
        this.paid = paid;
        this.loan = loan;
    }

    public int getRPID() {
        return RPID;
    }

    public void setRPID(int RPID) {
        this.RPID = RPID;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPaid() {
        return paid;
    }

    public void setPaid(String paid) {
        this.paid = paid;
    }

    public Loan getLoan() {
        return loan;
    }

    public void setLoan(Loan loan) {
        this.loan = loan;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Repayment{");
        sb.append("RPID=").append(RPID);
        sb.append(", date='").append(date).append('\'');
        sb.append(", amount='").append(amount).append('\'');
        sb.append(", status='").append(status).append('\'');
        sb.append(", paid='").append(paid).append('\'');
        sb.append(", loan=").append(loan);
        sb.append('}');
        return sb.toString();
    }
}
