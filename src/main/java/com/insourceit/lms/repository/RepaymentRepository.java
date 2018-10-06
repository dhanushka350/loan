package com.insourceit.lms.repository;

import com.insourceit.lms.modal.Repayment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepaymentRepository extends JpaRepository<Repayment,Integer>{
}
