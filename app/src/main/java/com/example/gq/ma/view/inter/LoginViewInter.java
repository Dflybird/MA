package com.example.gq.ma.view.inter;

public interface LoginViewInter {

    void onLoginSuccess();
    void onLoginFailed();
    void showEmailErrorInfo(String err);
    void showPasswordErrorInfo(String err);
    void loginButtonEnabled(boolean isEnable);
    void onShowProgressBar();
    void dismissProgressBar();
}
