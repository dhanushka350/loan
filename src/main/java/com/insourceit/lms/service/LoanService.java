package com.insourceit.lms.service;

import com.insourceit.lms.dto.LoanDto;
import com.insourceit.lms.dto.LoanTypeDto;
import com.insourceit.lms.dto.PaymentDates;
import com.insourceit.lms.dto.ResponseDto;
import org.springframework.stereotype.Service;

import java.util.List;

public interface LoanService {

    public ResponseDto saveLoan(LoanDto dto);

    public List<PaymentDates> getPaymentDatesForWeeklyPayment(int duration, int loanType);

    public List<LoanTypeDto> allLoanTypes();

    public LoanTypeDto getLoanTypeDetails(int id);
}
