package com.example.gq.ma.model;

import com.example.gq.ma.bean.User;
import com.example.gq.ma.model.inter.LoginModelInter;
import com.example.gq.ma.utils.GLog;

import org.litepal.crud.DataSupport;

import java.util.List;

public class LoginModel implements LoginModelInter {

    private static LoginModel instance = new LoginModel();
    public static LoginModel getInstance(){
        return instance;
    }

    @Override
    public User getUserByID(int id) {
        return DataSupport.find(User.class, id);
    }

    @Override
    public List<User> getUserByEmail(String email) {
        return DataSupport.where("email = ?", email).find(User.class);
    }

    @Override
    public boolean addUser(User user) {
        boolean suc = user.save();
        GLog.d("suc = "+ suc);
        return suc;
    }
}
