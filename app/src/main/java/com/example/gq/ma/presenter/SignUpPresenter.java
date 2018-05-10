package com.example.gq.ma.presenter;

import android.os.Handler;
import android.util.Patterns;

import com.example.gq.ma.bean.User;
import com.example.gq.ma.model.LoginModel;
import com.example.gq.ma.presenter.inter.SignUpPresenterInter;
import com.example.gq.ma.view.inter.SignUpViewInter;

import java.util.List;

public class SignUpPresenter implements SignUpPresenterInter {

    private SignUpViewInter signUpViewInter;
    private LoginModel loginModel;

    public SignUpPresenter(SignUpViewInter signUpViewInter) {
        this.signUpViewInter = signUpViewInter;
        loginModel = LoginModel.getInstance();
    }

    @Override
    public void signUp(final String name, final String email, final String mobile,
                       final String password, String reEnterPassword) {
        if (!validate(name, email, mobile, password, reEnterPassword)){
            signUpViewInter.onSignUpFailed();
            return;
        }

        signUpViewInter.signUpButtonEnabled(false);
        signUpViewInter.onShowProgressBar();

        //TODO: 添加逻辑代码
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                User user = new User();
                user.setName(name);
                user.setEmail(email);
                user.setMobile(mobile);
                user.setPassword(password);
                List<User> userList = loginModel.getUserByEmail(email);
                if (userList.size() == 0 && loginModel.addUser(user)) {
                   signUpViewInter.onSignUpSuccess();
                } else
                    signUpViewInter.onSignUpFailed();
                signUpViewInter.dismissProgressBar();
            }
        }, 2000);

    }

    private boolean validate(String name, String email, String mobile, String password, String reEnterPassword){
        boolean valid = true;

        if (name.isEmpty() || name.length() < 2) {
            signUpViewInter.nameError("至少两个字符");
            valid = false;
        } else {
            signUpViewInter.nameError(null);
        }

        if (email.isEmpty() || !Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            signUpViewInter.emailError("请输入有效的邮箱地址");
            valid = false;
        } else {
            signUpViewInter.emailError(null);
        }

        if (mobile.isEmpty() || mobile.length() != 11) {
            signUpViewInter.mobileError("请输入有效的电话号码");
            valid = false;
        } else {
            signUpViewInter.mobileError(null);
        }

        if (password.isEmpty() || password.length() < 6 || password.length() > 12) {
            signUpViewInter.passwordError("6到12个数字、字母、符号");
            valid = false;
        } else {
            signUpViewInter.passwordError(null);
        }

        if (reEnterPassword.isEmpty() || reEnterPassword.length() < 6 || reEnterPassword.length() > 12 || !(reEnterPassword.equals(password))) {
            signUpViewInter.reEnterPasswordError("两次输入密码不匹配");
            valid = false;
        } else {
            signUpViewInter.reEnterPasswordError(null);
        }

        return valid;
    }
}
