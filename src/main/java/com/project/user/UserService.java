package com.project.user;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.*;

@Service

@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public Map<String, Object> createResponse(List<?> lst) {
        Map<String, Object> response = new HashMap<>();
        response.put("items", lst);
        response.put("totalItems", lst.size());
        return response;
    }

    public Map<String, Object> findAll(String keyword, Integer page, Integer limit) {
        Pageable pageable = PageRequest.of(page, limit);
        Page<User> Users = userRepository.getUserByName(keyword, pageable);
        List<User> results = Users.getContent();
        return createResponse(results);
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
