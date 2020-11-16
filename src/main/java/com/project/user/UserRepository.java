package com.project.user;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
//        List<User> findByNameAndAddressAndEmailAndPhone(String name, String address, String email, String phone, Pageable pageable);

//    Object getByName();

    @Query(value = "select u from User u where u.name = ?1 ")
    Page<User> getUserByName(String name, Pageable pageable);
}
