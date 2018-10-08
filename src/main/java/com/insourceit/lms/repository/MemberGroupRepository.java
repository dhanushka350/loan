package com.insourceit.lms.repository;

import com.insourceit.lms.modal.MemberGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberGroupRepository extends JpaRepository<MemberGroup,Integer>{
}
