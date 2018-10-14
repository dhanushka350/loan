package com.insourceit.lms.repository;

import com.insourceit.lms.modal.Borrower;
import com.insourceit.lms.modal.Loan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LoanRepository extends JpaRepository<Loan, Integer> {
    Loan findLoanByLoanIDEquals(String s);

    Loan findFirstByBorrowerEqualsAndStatusEquals(Borrower borrower, String status);
}
