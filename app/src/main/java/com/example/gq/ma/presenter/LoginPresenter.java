package com.example.gq.ma.presenter;

import android.util.Patterns;

import com.example.gq.ma.bean.User;
import com.example.gq.ma.model.LoginModel;
import com.example.gq.ma.presenter.inter.LoginPresenterInter;
import com.example.gq.ma.view.inter.LoginViewInter;

import java.util.List;

public class LoginPresenter implements LoginPresenterInter {

    private LoginViewInter loginViewInter;
    private LoginModel loginModel;

    public LoginPresenter(LoginViewInter loginViewInter) {
        this.loginViewInter = loginViewInter;
        loginModel =LoginModel.getInstance();
    }

    @Override
    public void login(final String email, final String password) {

        if (!validate(email, password)){
            loginViewInter.onLoginFailed();
            return;
        }

        loginViewInter.loginButtonEnabled(false);
        loginViewInter.onShowProgressBar();

        //TODO: 添加逻辑代码
        new android.os.Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                List<User> userList = loginModel.getUserByEmail(email);
                if (userList.size() == 1 && userList.get(0).getPassword().equals(password)){
                    loginViewInter.onLoginSuccess();
                } else
                    loginViewInter.onLoginFailed();
                loginViewInter.dismissProgressBar();
            }
        }, 2000);


    }

    private boolean validate(String email, String password){
        boolean valid = true;

        if (email.isEmpty() || !Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            loginViewInter.showEmailErrorInfo("输入邮箱地址不合法");
            valid = false;
        } else {
            loginViewInter.showEmailErrorInfo(null);
        }

        if (password.isEmpty() || password.length() < 6 || password.length() > 12){
            loginViewInter.showPasswordErrorInfo("6到12个数字、字母、符号");
            valid = false;
        } else {
            loginViewInter.showPasswordErrorInfo(null);
        }

        return valid;
    }
}
