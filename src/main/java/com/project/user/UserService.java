package com.project.user;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public List<User> findAll(String keyword, Integer page, Integer limit) {
        Pageable pageable = PageRequest.of(page, limit);
//        Page<User> Paging = userRepository.findAll(pageable);
//        List<User> results = Paging.getContent();
//        List<User> results = userRepository.findByNameAndAddressAndEmailAndPhone(keyword, keyword, keyword, keyword, pageable);
//        System.out.println(results);
//        List<User> results = userRepository.findAll();
        Page<User> Users = userRepository.getUserByName(keyword, pageable);
        return Users.getContent();
//        return results;
    }

    public Optional<User> findById(Long id) {
        Optional<User> results = userRepository.findById(id);
        return results;
    }

    public User save(User stock) {
        return userRepository.save(stock);
    }

    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }
}
