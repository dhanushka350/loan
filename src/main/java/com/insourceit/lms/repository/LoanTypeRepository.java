package com.insourceit.lms.repository;

import com.insourceit.lms.modal.LoanType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoanTypeRepository extends JpaRepository<LoanType, Integer> {
}
