package com.project.user;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    //    List<User> findByNameAndAddressAndEmailAndPhone(String name, String address, String email, String phone, Pageable pageable);
}
