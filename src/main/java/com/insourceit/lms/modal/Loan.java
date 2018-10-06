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
    @Column(name = "t_loan_disbursed_by")
    private String disbursed;
    @Column(name = "t_loan_loan_release_date")
    private String release;
    @Column(name = "t_loan_loan_status")
    private String status;
    @Column(name = "t_loan_description")
    private String description;
    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "t_loan_officer")
    private User officer;
    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "t_loan_type")
    private LoanType type;
    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "t_loan_borrower")
    private Borrower borrower;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "loan", fetch = FetchType.LAZY)
    private List<Repayment> repayments = new ArrayList<>();

    public Loan() {
    }

    public Loan(int LID, String disbursed, String release, String status, String description, User officer, LoanType type, Borrower borrower, List<Repayment> repayments) {
        this.LID = LID;
        this.disbursed = disbursed;
        this.release = release;
        this.status = status;
        this.description = description;
        this.officer = officer;
        this.type = type;
        this.borrower = borrower;
        this.repayments = repayments;
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

    public String getRelease() {
        return release;
    }

    public void setRelease(String release) {
        this.release = release;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getOfficer() {
        return officer;
    }

    public void setOfficer(User officer) {
        this.officer = officer;
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

    public List<Repayment> getRepayments() {
        return repayments;
    }

    public void setRepayments(List<Repayment> repayments) {
        this.repayments = repayments;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Loan{");
        sb.append("LID=").append(LID);
        sb.append(", disbursed='").append(disbursed).append('\'');
        sb.append(", release='").append(release).append('\'');
        sb.append(", status='").append(status).append('\'');
        sb.append(", description='").append(description).append('\'');
        sb.append(", officer=").append(officer);
        sb.append(", type=").append(type);
        sb.append(", borrower=").append(borrower);
        sb.append(", repayments=").append(repayments);
        sb.append('}');
        return sb.toString();
    }
}
