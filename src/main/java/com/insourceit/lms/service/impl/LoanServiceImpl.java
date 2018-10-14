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
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
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
        LOG.info("[APP-LOAN-SERVICE-ADD-LOAN] - add new loan for - " + dto.getBorrower());
        Date date = new Date();
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        ResponseDto responseDto = new ResponseDto();
        Loan loan = new Loan();

        loan.setType(loanTypeRepository.getOne(Integer.parseInt(dto.getType())));
        loan.setBorrower(borrowerRepository.getByUniqueID(dto.getBorrower()));
        loan.setDescription(dto.getDescription());
        loan.setStatus("WAITING FOR APPROVALS");
        loan.setAddedOfficer(userRepository.findByNameEquals(dto.getAddedOfficer()));
        loan.setAddedDate(dateFormat.format(date));
        loan.setLoanID(dto.getLoanID());

        LOG.info("[APP-LOAN-SERVICE-ADD-LOAN] - object created");
        Loan save = loanRepository.save(loan);
        LOG.info("[APP-LOAN-SERVICE-ADD-LOAN] - saved.. returning response");

        if (save != null) {
            responseDto.setMessage("Successfully Added. \n waiting for approvals.");
            responseDto.setStatus(1);
        } else {
            responseDto.setMessage("Can not add this loan.. \n Request not accepted.");
            responseDto.setStatus(0);
        }

        return responseDto;
    }

    @Override
    public ResponseDto approveLoan(LoanDto dto) {
        LOG.info("[APP-LOAN-SERVICE-APPROVE-LOAN] - approve loan id - " + dto.getLoanID());
        Date date = new Date();
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        DateFormat timeFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        ResponseDto responseDto = new ResponseDto();
        Loan loan = loanRepository.findLoanByLoanIDEquals(dto.getLoanID());
        if (loan != null) {
            LOG.info("[APP-LOAN-SERVICE-APPROVE-LOAN] - loan found.");
            if (loan.getPrimaryApprovalOfficer() == null) {
                loan.setStatus(dto.getStatus());
                loan.setPrimaryApprovalDate(dateFormat.format(date));
                loan.setPrimaryApprovalOfficer(userRepository.findByNameEquals(dto.getPrimaryApprovalOfficer()));
                loan.setDescription(dto.getDescription());
                Loan approval1 = loanRepository.saveAndFlush(loan);
                if (approval1 != null) {
                    if (approval1.getStatus().equalsIgnoreCase("REJECTED")) {
                        LOG.info("[APP-LOAN-SERVICE-APPROVE-LOAN] - REJECTED LOAN - " + dto.getLoanID());
                        responseDto.setStatus(3);
                        responseDto.setMessage("Loan " + dto.getLoanID() + " has been rejected by - " + approval1.getPrimaryApprovalOfficer().getName() + ". \n Terminated loan process at - " + timeFormat.format(date));
                    } else if (approval1.getStatus().equalsIgnoreCase("HOLD")) {
                        LOG.info("[APP-LOAN-SERVICE-APPROVE-LOAN] - HOLD LOAN - " + dto.getLoanID());
                        responseDto.setStatus(2);
                        responseDto.setMessage("Loan " + dto.getLoanID() + " has been hold by - " + approval1.getPrimaryApprovalOfficer().getName() + ". \n Terminated secondary approval process at - " + timeFormat.format(date));
                    } else if (approval1.getStatus().equalsIgnoreCase("APPROVED")) {
                        LOG.info("[APP-LOAN-SERVICE-APPROVE-LOAN] - APPROVED LOAN - " + dto.getLoanID());
                        responseDto.setStatus(1);
                        responseDto.setMessage("Loan " + dto.getLoanID() + " has been approved by - " + approval1.getPrimaryApprovalOfficer().getName() + ". \n waiting for secondary approval");
                    }

                } else {
                    responseDto.setStatus(0);
                    responseDto.setMessage("Something went terribly wrong. Please come back later. \n Requesting Developers Support.");
                }
            } else {
                loan.setStatus(dto.getStatus());
                loan.setSecondaryApprovalDate(dateFormat.format(date));
                loan.setSecondaryApprovalOfficer(userRepository.findByNameEquals(dto.getPrimaryApprovalOfficer()));
                loan.setDescription(dto.getDescription());
                Loan approval1 = loanRepository.saveAndFlush(loan);
                if (approval1 != null) {
                    if (approval1.getStatus().equalsIgnoreCase("REJECTED")) {
                        LOG.info("[APP-LOAN-SERVICE-APPROVE-LOAN] - REJECTED LOAN - " + dto.getLoanID());
                        responseDto.setStatus(3);
                        responseDto.setMessage("Loan " + dto.getLoanID() + " has been rejected by - " + approval1.getSecondaryApprovalOfficer().getName() + ". \n Terminated loan process at - " + timeFormat.format(date));
                    } else if (approval1.getStatus().equalsIgnoreCase("HOLD")) {
                        LOG.info("[APP-LOAN-SERVICE-APPROVE-LOAN] - HOLD LOAN - " + dto.getLoanID());
                        responseDto.setStatus(2);
                        responseDto.setMessage("Loan " + dto.getLoanID() + " has been hold by - " + approval1.getSecondaryApprovalOfficer().getName() + ". \n Terminated loan release process at - " + timeFormat.format(date));
                    } else if (approval1.getStatus().equalsIgnoreCase("APPROVED")) {
                        LOG.info("[APP-LOAN-SERVICE-APPROVE-LOAN] - APPROVED LOAN - " + dto.getLoanID());
                        responseDto.setStatus(1);
                        responseDto.setMessage("Loan " + dto.getLoanID() + " has been approved by - " + approval1.getSecondaryApprovalOfficer().getName() + ". \n all approvals are granted.. \n Informing Borrower..");
                    }

                } else {
                    responseDto.setStatus(0);
                    responseDto.setMessage("Something went terribly wrong. Please come back later. \n Requesting Developers Support.");
                }
            }
        } else {
            responseDto.setStatus(0);
            responseDto.setMessage("Can not find this loan. \n make sure loan id is correct and try again.");
        }

        return responseDto;
    }

    @Override
    @Transactional
    public ResponseDto releasingLoan(LoanDto dto) {
        LOG.info("[APP-LOAN-SERVICE-RELEASING-LOAN] - releasing loan - " + dto.getLoanID());
        Date date = new Date();
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        ResponseDto responseDto = new ResponseDto();
        Loan loan = loanRepository.findLoanByLoanIDEquals(dto.getLoanID());

        if (loan != null && loan.getStatus().equalsIgnoreCase("APPROVED")) {
            loan.setDocCharge(dto.getDocCharge());
            loan.setInsuranceCharge(dto.getInsuranceCharge());
            loan.setPaymentMethod(dto.getPaymentMethod());
            loan.setLoanReleaseOfficer(userRepository.findByNameEquals(dto.getLoanReleaseOfficer()));
            loan.setRelease(dateFormat.format(date));
            loan.setStatus("ON GOING");
            Loan flush = loanRepository.saveAndFlush(loan);
            if (flush != null) {
                makeLoanRepaymentDates(flush);
                LOG.info("[APP-LOAN-SERVICE-RELEASE-LOAN] - RELEASED LOAN - " + dto.getLoanID());
                responseDto.setStatus(1);
                responseDto.setMessage("Loan Released..");
            } else {
                LOG.info("[APP-LOAN-SERVICE-RELEASE-LOAN] - REJECTED BY THE SYSTEM LOAN - " + dto.getLoanID());
                responseDto.setStatus(0);
                responseDto.setMessage("REJECTED BY THE SYSTEM \n Something went terribly wrong. Stopping releasing loan. \n Please come back later. \n Requesting Developers Support.");
            }
        } else {
            LOG.info("[APP-LOAN-SERVICE-RELEASE-LOAN] -  LOAN NOT APPROVED - " + dto.getLoanID());
            responseDto.setStatus(2);
            responseDto.setMessage("This loan not approved. Stopping releasing loan. \n Please come back later.");
        }
        return responseDto;
    }

    @Override
    public ResponseDto checkBorrowerQualifications(String id) {
        LOG.info("[APP-LOAN-SERVICE-CHECKING-BORROWER-QUALIFICATION] borrower id +" + id);
        ResponseDto responseDto = new ResponseDto();
        Loan on_going = loanRepository.findFirstByBorrowerEqualsAndStatusEquals(borrowerRepository.getByUniqueID(id), "ON GOING");
        if (on_going != null) {
            LOG.info("[APP-LOAN-SERVICE-CHECKING-BORROWER-QUALIFICATION] Found Some Ongoing Loan(s).." + on_going.getLoanID());
            responseDto.setStatus(0);
            responseDto.setMessage("Found Some Ongoing Loan(s). \n check loan ID - " + on_going.getLoanID());
        } else {
            LOG.info("[APP-LOAN-SERVICE-CHECKING-BORROWER-QUALIFICATION] Clear Person.");
            responseDto.setStatus(1);
            responseDto.setMessage("Person Accepted.");
        }
        LOG.info("[APP-LOAN-SERVICE-CHECKING-BORROWER-QUALIFICATION] Returning Response.");
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
            dto.setDocumentCharge(one.getDocumentCharge());
            dto.setInsuranceCharge(one.getInsuranceCharge());
            System.out.println(dto.getDocumentCharge());
        }
        return dto;
    }

    @Override
    public List<LoanDto> getBorrowerLoansByNIC(String nic) {
        LOG.info("[APP-LOAN-SERVICE-GET-LOAN-LIST-BY-NIC] - finding loans using nic - " + nic);
        List<LoanDto> list = new ArrayList<>();
        LoanDto dto = null;
        for (Loan loan : borrowerRepository.getByUniqueID(nic).getBorrowedLoans()) {
            dto = new LoanDto();
            try {
                dto.setAddedDate(loan.getAddedDate());
                dto.setAddedOfficer(loan.getAddedOfficer().getName());
                dto.setBorrower(loan.getBorrower().getUniqueID());
                dto.setStatus(loan.getStatus());
                dto.setType(loan.getType().getType());
                dto.setDescription(loan.getDescription());
                dto.setLID(loan.getLID());
                dto.setLoanID(loan.getLoanID());
                dto.setPrimaryApprovalDate(loan.getPrimaryApprovalDate());
                dto.setPrimaryApprovalOfficer(loan.getPrimaryApprovalOfficer().getName());
                dto.setSecondaryApprovalDate(loan.getSecondaryApprovalDate());
                dto.setSecondaryApprovalOfficer(loan.getSecondaryApprovalOfficer().getName());
                dto.setDocCharge(loan.getDocCharge());
                dto.setInsuranceCharge(loan.getInsuranceCharge());
                dto.setLoanReleaseOfficer(loan.getLoanReleaseOfficer().getName());
                dto.setPaymentMethod(loan.getPaymentMethod());
                dto.setRelease(loan.getRelease());
            } catch (NullPointerException e) {
                LOG.info("[APP-LOAN-SERVICE-GET-LOAN-LIST-BY-NIC] - some data can be null here.. it's not a bug..");
            }
            list.add(dto);
        }
        LOG.info("[APP-LOAN-SERVICE-GET-LOAN-LIST-BY-NIC] - returning result");
        return list;
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
