package com.javaproject.gymmanagement.Repository;

import com.javaproject.gymmanagement.Model.User;

public interface UserRepo {

    User findByUsername(String username);

}
