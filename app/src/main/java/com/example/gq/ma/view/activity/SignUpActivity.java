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
import com.example.gq.ma.presenter.SignUpPresenter;
import com.example.gq.ma.view.inter.SignUpViewInter;

public class SignUpActivity extends BaseActivity implements SignUpViewInter {

    private EditText nameET;
    private EditText emailET;
    private EditText mobileET;
    private EditText passwordET;
    private EditText reEnterPasswordET;
    private Button signUpBT;
    private TextView loginLinkTV;
    private SignUpPresenter signUpPresenter;
    private ProgressDialog progressDialog;

    public static void actionStart(Context context){
        Intent intent = new Intent(context, SignUpActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        signUpPresenter = new SignUpPresenter(this);

        nameET = findViewById(R.id.input_name_et);
        emailET = findViewById(R.id.input_email_et);
        mobileET = findViewById(R.id.input_mobile_et);
        passwordET = findViewById(R.id.input_password_et);
        reEnterPasswordET = findViewById(R.id.input_reEnterPassword_et);
        signUpBT = findViewById(R.id.signup_bt);
        loginLinkTV = findViewById(R.id.link_login_tv);

        signUpBT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signUpPresenter.signUp(nameET.getText().toString(),
                        emailET.getText().toString(),
                        mobileET.getText().toString(),
                        passwordET.getText().toString(),
                        reEnterPasswordET.getText().toString());
            }
        });

        loginLinkTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LoginActivity.actionStart(SignUpActivity.this);
                finish();
                overridePendingTransition(R.anim.push_left_in, R.anim.push_left_out);
            }
        });
    }

    @Override
    public void onSignUpSuccess() {
        signUpBT.setEnabled(true);
        setResult(RESULT_OK, null);
        finish();
    }

    @Override
    public void onSignUpFailed() {
        Toast.makeText(getBaseContext(), "注册失败", Toast.LENGTH_LONG).show();
        signUpBT.setEnabled(true);
    }

    @Override
    public void nameError(String err) {
        nameET.setError(err);
    }

    @Override
    public void emailError(String err) {
        emailET.setError(err);
    }

    @Override
    public void mobileError(String err) {
        mobileET.setError(err);
    }

    @Override
    public void passwordError(String err) {
        passwordET.setError(err);
    }

    @Override
    public void reEnterPasswordError(String err) {
        reEnterPasswordET.setError(err);
    }

    @Override
    public void signUpButtonEnabled(boolean isEnable) {
        signUpBT.setEnabled(isEnable);
    }

    @Override
    public void onShowProgressBar() {
        progressDialog = new ProgressDialog(SignUpActivity.this,
                R.style.MyAppTheme_Dialog);
        progressDialog.setIndeterminate(true);
        progressDialog.setMessage("创建账户...");
        progressDialog.show();

    }

    @Override
    public void dismissProgressBar() {
        progressDialog.dismiss();
        getWindow().clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
    }
}
