package com.insourceit.lms.repository;

import com.insourceit.lms.modal.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    User findByContactEquals(String contact);

    User findByNameEqualsAndPasswordEquals(String name, String password);

    User findByNameEquals(String name);


}
