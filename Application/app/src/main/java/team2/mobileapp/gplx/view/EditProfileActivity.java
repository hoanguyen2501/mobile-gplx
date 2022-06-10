package team2.mobileapp.gplx.view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import team2.mobileapp.gplx.R;
import team2.mobileapp.gplx.Retrofit.callbacks.AccountCallbackListener;
import team2.mobileapp.gplx.Retrofit.controllers.AccountController;
import team2.mobileapp.gplx.Retrofit.models.Account;
import team2.mobileapp.gplx.VariableGlobal.VariableGlobal;

public class EditProfileActivity extends AppCompatActivity implements AccountCallbackListener {

    private EditText etFullName;
    private EditText etUsername;
    private EditText etEmail;
    private EditText etPassword;
    private EditText etConfirmPassword;
    private Button btnSave, Logout;
    private RelativeLayout checkOutFocus;
    private Account accountView;
    private AccountController accountController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        overridePendingTransition(R.anim.slide_in_bottom, R.anim.slide_out_bottom);

        setContentView(R.layout.activity_edit_profile);
        VariableGlobal.SetNavigationBar(this);
        InitialVariables();
        Logout();
        getUser();
        try {
            accountController.startFetching(VariableGlobal.idUser);
            btnSave.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    try {
                        if (etPassword.getText().toString().equals(etConfirmPassword.getText().toString())) {
                            accountView.setFullName(etFullName.getText().toString());
                            accountView.setPassword(etPassword.getText().toString());
                            accountController.updateAccount(accountView.getId(), accountView);
                            VariableGlobal.showToast(EditProfileActivity.this, "Cập nhật thành công!!");
                        } else {
                            VariableGlobal.showToast(EditProfileActivity.this, "Mật khẩu xác nhận không khớp");
                        }
                    } catch (Exception e) {
                        Log.d("Error:", e.getMessage());
                    }
                }
            });
        } catch (Exception e) {
            Log.d("Error", e.getMessage());
        }

        checkOutFocus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hideKeyboard();
            }
        });
    }

    public void hideKeyboard() {
        View view = this.getCurrentFocus();
        if (view != null) {
            InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Activity.INPUT_METHOD_SERVICE);
            inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }

    }

    private void Logout() {
        Logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sharedPreferences = getSharedPreferences("User", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.remove("UserId");
                editor.apply();
                editor.clear();
                Intent login = new Intent(EditProfileActivity.this, LoginActivity.class);
                login.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(login);
            }
        });

    }

    private void getUser() {
        SharedPreferences sharedPreferences = getSharedPreferences("User", Context.MODE_PRIVATE);
        if (sharedPreferences != null) {
            String Id = sharedPreferences.getString("UserId", "");
            VariableGlobal.idUser = Id;
        }
    }

    private void InitialVariables() {
        accountController = new AccountController(this);
        etFullName = (EditText) findViewById(R.id.et_fullname);
        etUsername = (EditText) findViewById(R.id.et_username);
        etEmail = (EditText) findViewById(R.id.et_email_profile);
        etPassword = (EditText) findViewById(R.id.et_password_profile);
        etConfirmPassword = (EditText) findViewById(R.id.et_confirm_password_profile);
        btnSave = (Button) findViewById(R.id.btn_save);
        checkOutFocus = findViewById(R.id.check_out_focus);
        Logout = findViewById(R.id.logout);
    }

    @Override
    public void onFetchAccountProgress(Account account) {
        if (account != null) {
            this.accountView = account;
            etFullName.setText(account.getFullName());
            etUsername.setText(account.getUsername());
            etPassword.setText(account.getPassword());
            etEmail.setText(account.getEmail());
        }
    }

    @Override
    public void onFetchComplete(String message) {
        Log.d("message", message);
    }

}