package team2.mobileapp.gplx.view;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import team2.mobileapp.gplx.R;
import team2.mobileapp.gplx.Retrofit.callbacks.AccountCallbackListener;
import team2.mobileapp.gplx.Retrofit.controllers.AccountController;
import team2.mobileapp.gplx.Retrofit.models.Account;
import team2.mobileapp.gplx.VariableGlobal.VariableGlobal;
import team2.mobileapp.gplx.Volley.model.dto.LoginResponse;
import team2.mobileapp.gplx.Volley.service.AuthenService;

public class LoginActivity extends AppCompatActivity implements AccountCallbackListener {
    EditText etUsername, etPassword;
    Button btnLogin;
    TextView tvForgotPass, tvSignup;
    RelativeLayout checkOutFocusLogin;
    AccountController accountController;
    String Id;
    Intent category;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        overridePendingTransition(R.anim.slide_in_bottom, R.anim.slide_out_bottom);
        setContentView(R.layout.activity_login);

        InitialVariable();
        category = new Intent(this, SelectCategoryActivity.class);
        Intent tutorial = new Intent(this, TutorialActivity.class);
        Intent forgotPass = new Intent(this, ForgotPasswordActivity.class);
        Intent signup = new Intent(this, SignupActivity.class);
        final AuthenService authenService = new AuthenService(this);
        accountController = new AccountController(LoginActivity.this);
        CheckId();
        Login(authenService, tutorial);

        ForgotPass(forgotPass);

        Signup(signup);
        checkOutFocusLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hideKeyboard();
            }
        });
    }

    private void InitialVariable() {
        etUsername = findViewById(R.id.et_username_login);
        etPassword = findViewById(R.id.et_password_login);
        btnLogin = findViewById(R.id.btn_login);
        tvForgotPass = findViewById(R.id.tv_forgot_pass);
        tvSignup = findViewById(R.id.tv_signup);
        checkOutFocusLogin = findViewById(R.id.check_out_focus_login);
    }

    private void Signup(Intent signup) {
        tvSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(signup);
            }
        });
    }

    private void CheckId() {

        SharedPreferences sharedPreferences = getSharedPreferences("User", Context.MODE_PRIVATE);
        if (sharedPreferences != null) {
            String Id = sharedPreferences.getString("UserId", "");
            if (!Id.equals("") || !Id.isEmpty()) {
                accountController.startFetching(Id);
            }
        }
    }

    public void hideKeyboard() {
        View view = this.getCurrentFocus();
        if (view != null) {
            InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Activity.INPUT_METHOD_SERVICE);
            inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }

    }

    private void ForgotPass(Intent forgotPass) {
        tvForgotPass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(forgotPass);
            }
        });
    }

    private void ResetInput() {
        etUsername.setText("");
        etPassword.setText("");
    }

    private void Login(AuthenService authenService, Intent tutorial) {
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hideKeyboard();
                if (etUsername.getText().toString().isEmpty() && etPassword.getText().toString().isEmpty())
                    Toast.makeText(LoginActivity.this, "Hãy nhập tên đăng nhập và mật khẩu", Toast.LENGTH_LONG).show();
                else if (etUsername.getText().toString().isEmpty())
                    Toast.makeText(LoginActivity.this, "Hãy nhập tên đăng nhập", Toast.LENGTH_LONG).show();
                else if (etPassword.getText().toString().isEmpty())
                    Toast.makeText(LoginActivity.this, "Hãy nhập mật khẩu", Toast.LENGTH_LONG).show();
                else {

                    authenService.Login(etUsername.getText().toString(), etPassword.getText().toString(), new AuthenService.LoginCallBack() {
                        @Override
                        public void onError(String message) {
                            Toast.makeText(LoginActivity.this, message, Toast.LENGTH_LONG).show();
                        }

                        @Override
                        public void onResponse(LoginResponse loginResponse) {
                            VariableGlobal.idUser = loginResponse.getId();
                            // add session in android
                            SharedPreferences sharedPreferences = getSharedPreferences("User", Context.MODE_PRIVATE);
                            SharedPreferences.Editor editor = sharedPreferences.edit();
                            editor.putString("UserId", loginResponse.getId());
                            editor.commit();
                            //clear all stack and add activity new task
                            tutorial.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                            startActivity(tutorial);
                        }
                    });
                }
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.slide_in_bottom, R.anim.slide_out_bottom);
    }

    @Override
    public boolean moveTaskToBack(boolean nonRoot) {
        overridePendingTransition(R.anim.slide_in_bottom, R.anim.slide_out_bottom);
        return super.moveTaskToBack(nonRoot);

    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }

    @Override
    public void onFetchAccountProgress(Account account) {
        if (!account.getId().isEmpty()) {
            VariableGlobal.idUser = account.getId();
            category.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(category);

        }
    }

    @Override
    public void onFetchComplete(String message) {

    }
}