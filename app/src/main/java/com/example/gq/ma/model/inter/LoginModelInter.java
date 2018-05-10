package com.example.gq.ma.model.inter;

import com.example.gq.ma.bean.User;

import java.util.List;

public interface LoginModelInter {

    User getUserByID(int id);
    List<User> getUserByEmail(String email);
    boolean addUser(User user);
}
