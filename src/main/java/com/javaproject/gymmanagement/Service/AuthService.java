package com.javaproject.gymmanagement.Service;

import com.javaproject.gymmanagement.Model.User;
import com.javaproject.gymmanagement.Repository.UserRepo;

public class AuthService {

    private final UserRepo userRepo;

    public AuthService(UserRepo userRepo){
        this.userRepo = userRepo;
    }
    public User login (String username, String password){
        User user = userRepo.findByUsername(username);

        if (user == null){
            return null;
        }

        if (!user.isActive()){
            return null;
        }
        if (!password.equals(user.getPassword())){
            return null;
        }
        return user;
    }

}
