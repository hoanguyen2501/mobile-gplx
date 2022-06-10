package team2.mobileapp.gplx.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import team2.mobileapp.gplx.R;
import team2.mobileapp.gplx.Retrofit.callbacks.AccountCallbackListener;
import team2.mobileapp.gplx.Retrofit.controllers.AccountController;
import team2.mobileapp.gplx.Retrofit.models.Account;
import team2.mobileapp.gplx.VariableGlobal.VariableGlobal;

public class SplashActivity extends AppCompatActivity implements AccountCallbackListener {
    AccountController accountController;
    Button btnStart;
    Intent toLogin, toCategory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        overridePendingTransition(R.anim.slide_in_bottom, R.anim.slide_out_bottom);
        setContentView(R.layout.activity_splash);

        btnStart = findViewById(R.id.btn_start);
        toLogin = new Intent(SplashActivity.this, LoginActivity.class);
        toCategory = new Intent(SplashActivity.this, SelectCategoryActivity.class);
        accountController = new AccountController(SplashActivity.this);


        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CheckId();
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
            else{
                startActivity(toLogin);
            }
        }else{
            startActivity(toLogin);
        }
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
        if (account!=null) {
            VariableGlobal.idUser = account.getId();
            toCategory.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(toCategory);

        } else {
            startActivity(toLogin);
        }
    }

    @Override
    public void onFetchComplete(String message) {

    }
}