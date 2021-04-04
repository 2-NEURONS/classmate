package com.neuroapis.classmate.neura_classmate_services;

import com.neuroapis.classmate.dataLayer.UserRepository;
import com.neuroapis.classmate.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService
{

    @Autowired
    private UserRepository userRepository;
    public User save(User user)
    {
       return userRepository.save(user);
    }


}
