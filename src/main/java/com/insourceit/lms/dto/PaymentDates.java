package com.insourceit.lms.dto;

public class PaymentDates {
    private double amount;
    private String date;
    private double withoutInterest;
    private double interest;

    public PaymentDates() {
    }

    public PaymentDates(double amount, String date, double withoutInterest) {
        this.amount = amount;
        this.date = date;
        this.withoutInterest = withoutInterest;
    }

    public double getAmount() {
        return amount;
    }

    public double getInterest() {
        return interest;
    }

    public void setInterest(double interest) {
        this.interest = interest;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getWithoutInterest() {
        return withoutInterest;
    }

    public void setWithoutInterest(double withoutInterest) {
        this.withoutInterest = withoutInterest;
    }
}
