package com.jamontes79.tdd_ejemplo.login;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.jamontes79.tdd_ejemplo.R;

public class LoginActivity extends AppCompatActivity implements LoginView {

    private LoginPresenter loginPresenter;
    private EditText txtUserName;
    private EditText txtPassword;
    private Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initializePresenter();
        initializeViews();
    }


    private void initializePresenter() {
        loginPresenter = new LoginPresenter(this);
    }

    private void initializeViews() {
        txtUserName = (EditText) findViewById(R.id.txt_user_name);
        txtPassword = (EditText) findViewById(R.id.txt_password);
        btnLogin = (Button) findViewById(R.id.btn_login);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginPresenter.checkUserPassword(txtUserName.getText().toString().trim(),
                        txtPassword.getText().toString().trim());
            }
        });
    }
    @Override
    public void showErrorMessageForUserPassword() {
        Snackbar.make(txtPassword, "Usuario o contraseña incorrectos.", Snackbar.LENGTH_LONG).show();
    }

    @Override
    public void showErrorMessageForMaxLoginAttempt() {
        Snackbar.make(btnLogin, "Ha superado el número máximo de intentos.", Snackbar.LENGTH_LONG).show();
    }

    @Override
    public void showLoginSuccessMessage() {
        Snackbar.make(btnLogin, "Login correcto.", Snackbar.LENGTH_LONG).show();
    }
}
