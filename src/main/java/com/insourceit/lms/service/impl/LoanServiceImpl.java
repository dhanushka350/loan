package com.insourceit.lms.service.impl;

import com.insourceit.lms.dto.LoanDto;
import com.insourceit.lms.dto.LoanTypeDto;
import com.insourceit.lms.dto.PaymentDates;
import com.insourceit.lms.dto.ResponseDto;
import com.insourceit.lms.modal.Loan;
import com.insourceit.lms.modal.LoanType;
import com.insourceit.lms.modal.Repayment;
import com.insourceit.lms.repository.*;
import com.insourceit.lms.service.LoanService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class LoanServiceImpl implements LoanService {
    @Autowired
    private LoanRepository loanRepository;
    @Autowired
    private RepaymentRepository repaymentRepository;
    @Autowired
    private BorrowerRepository borrowerRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private LoanTypeRepository loanTypeRepository;

    private static final Logger LOG = LoggerFactory.getLogger(LoanServiceImpl.class);

    @Transactional
    @Override
    public ResponseDto saveLoan(LoanDto dto) {
        LOG.info("[APP-LOAN-SERVICE] - add new loan" + dto.getDisbursed());
        ResponseDto responseDto = new ResponseDto();
        Loan loan = new Loan();
        loan.setBorrower(borrowerRepository.getByUniqueID(dto.getBorrower()));
        loan.setDescription(dto.getDesc());
        loan.setDisbursed(dto.getDisbursed());
        loan.setOfficer(userRepository.findByNameEquals(dto.getOfficer()));
        loan.setRelease(dto.getDate());
        loan.setStatus(dto.getStatus());
        loan.setType(loanTypeRepository.getOne(dto.getLoanType()));
        loan = loanRepository.save(loan);
        makeLoanRepaymentDates(loan);
        responseDto.setMessage("Successfully Added.");
        responseDto.setStatus(1);
        return responseDto;
    }

    @Override
    public List<PaymentDates> getPaymentDatesForWeeklyPayment(int duration, int loanType) {
        List<PaymentDates> list = new ArrayList<>();
        LoanType one = loanTypeRepository.getOne(loanType);
        double i1 = Double.parseDouble(one.getCharge());
        PaymentDates dto = null;
        LocalDate today = LocalDate.now();

        double amount = Double.parseDouble(one.getAmount());
        double withoutInterest = i1 - (amount / 100) * Integer.parseInt(one.getInterest());

        for (int i = 0; i < duration; i++) {
            today = today.plusDays(7);
            dto = new PaymentDates();
            dto.setDate(today.toString());
            dto.setAmount(i1);
            dto.setWithoutInterest(withoutInterest);
            dto.setInterest((amount / 100) * Integer.parseInt(one.getInterest()));
            list.add(dto);
            LOG.info("[APP-LOAN-SERVICE] - created payment date - " + withoutInterest);
        }
        return list;
    }

    @Override
    public List<LoanTypeDto> allLoanTypes() {
        List<LoanTypeDto> list = new ArrayList<>();
        LoanTypeDto dto = null;
        for (LoanType loanType : loanTypeRepository.findAll()) {
            dto = new LoanTypeDto();
            dto.setId(loanType.getID());
            dto.setLoan(loanType.getType() + " - amount = " + loanType.getAmount());
            list.add(dto);
        }
        return list;
    }

    @Override
    public LoanTypeDto getLoanTypeDetails(int id) {
        LoanType one = loanTypeRepository.getOne(id);
        LoanTypeDto dto = new LoanTypeDto();
        if (one != null) {
            dto.setLoan(one.getType());
            dto.setId(one.getID());
            dto.setAmount(one.getAmount());
            dto.setCharge(one.getCharge());
            dto.setDuration(one.getDuration());
            dto.setInterest(one.getInterest());
        }
        return dto;
    }

    private void makeLoanRepaymentDates(Loan loan) {
        LOG.info("[APP-LOAN-SERVICE] - adding repayment dates");
        int duration = Integer.parseInt(loan.getType().getDuration());
        LocalDate today = LocalDate.now();
        List<Repayment> repayments = new ArrayList<>();
        Repayment repayment = null;
        for (int i = 0; i < duration; i++) {
            today = today.plusDays(7);
            repayment = new Repayment();
            repayment.setDate(today.toString());
            repayment.setAmount(loan.getType().getCharge());
            repayment.setStatus("PENDING");
            repayment.setLoan(loan);
            repayments.add(repayment);
            LOG.info("[APP-LOAN-SERVICE] - created payment date - " + loan.getStatus());
        }
        repaymentRepository.saveAll(repayments);
    }
}
