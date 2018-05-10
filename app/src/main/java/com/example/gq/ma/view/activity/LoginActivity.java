package com.example.gq.ma.view.activity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.gq.ma.R;
import com.example.gq.ma.base.BaseActivity;
import com.example.gq.ma.presenter.LoginPresenter;
import com.example.gq.ma.view.inter.LoginViewInter;

public class LoginActivity extends BaseActivity implements LoginViewInter {

    private EditText emailET;
    private EditText passwordET;
    private Button loginBT;
    private TextView signUpLinkTV;
    private ProgressDialog progressDialog;
    private LoginPresenter presenter;

    public static void actionStart(Context context){
        Intent intent = new Intent(context, LoginActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        presenter = new LoginPresenter(this);

        emailET = findViewById(R.id.input_email_et);
        passwordET = findViewById(R.id.input_password_et);
        loginBT = findViewById(R.id.login_bt);
        signUpLinkTV = findViewById(R.id.link_signup_tv);

        loginBT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.login(emailET.getText().toString(), passwordET.getText().toString());
            }
        });

        signUpLinkTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SignUpActivity.actionStart(LoginActivity.this);
                finish();
                overridePendingTransition(R.anim.push_left_in, R.anim.push_left_out);
            }
        });
    }

    @Override
    public void onLoginSuccess() {
        loginBT.setEnabled(true);
        MainActivity.actionStart(this, emailET.getText().toString());
        finish();
    }

    @Override
    public void onLoginFailed() {
        Toast.makeText(getBaseContext(), "登录失败", Toast.LENGTH_SHORT).show();
        loginBT.setEnabled(true);
    }

    @Override
    public void showEmailErrorInfo(String err) {
        emailET.setError(err);
    }

    @Override
    public void showPasswordErrorInfo(String err) {
        passwordET.setError(err);
    }

    @Override
    public void loginButtonEnabled(boolean isEnable) {
        loginBT.setEnabled(isEnable);
    }

    @Override
    public void onShowProgressBar() {
        progressDialog = new ProgressDialog(LoginActivity.this,
                R.style.MyAppTheme_Dialog);
        progressDialog.setIndeterminate(true);
        progressDialog.setMessage("正在验证...");
        progressDialog.show();
    }

    @Override
    public void dismissProgressBar() {
        progressDialog.dismiss();
        getWindow().clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
    }
}
