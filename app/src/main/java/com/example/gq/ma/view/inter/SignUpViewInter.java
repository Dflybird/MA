package com.example.gq.ma.view.inter;

public interface SignUpViewInter {

    void onSignUpSuccess();
    void onSignUpFailed();
    void nameError(String err);
    void emailError(String err);
    void mobileError(String err);
    void passwordError(String err);
    void reEnterPasswordError(String err);
    void signUpButtonEnabled(boolean isEnable);
    void onShowProgressBar();
    void dismissProgressBar();
}
