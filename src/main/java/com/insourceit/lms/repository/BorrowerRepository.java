package com.insourceit.lms.repository;

import com.insourceit.lms.modal.Borrower;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BorrowerRepository extends JpaRepository<Borrower, Integer> {
    Borrower getByUniqueID(String id);
}
