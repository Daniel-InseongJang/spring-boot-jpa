package com.example.jpa.domain.user;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public List<User> getUsers(){
        return userRepository.findAll();
    }

    public List<User> addAll(List<User> insertUesrList) {
        if(insertUesrList.isEmpty()){
            new Exception("insert list is empty");
        }
        return userRepository.saveAll(insertUesrList);
    }
}
