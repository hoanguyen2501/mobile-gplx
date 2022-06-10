package team2.mobileapp.gplx.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import team2.mobileapp.gplx.R;

public class ForgotPasswordActivity extends AppCompatActivity {

    private Button btnSendEmail;
    private EditText etEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        overridePendingTransition(R.anim.slide_in_bottom, R.anim.slide_out_bottom);
        setContentView(R.layout.activity_forgot_password);
        etEmail = findViewById(R.id.edit_email_forgot_pass);
        btnSendEmail = findViewById(R.id.btn_forgot_pass);
        btnSendEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (ContextCompat.checkSelfPermission(ForgotPasswordActivity.this, Manifest.permission.SEND_SMS) == PackageManager.PERMISSION_GRANTED) {


                }
            }
        });
//
//        btn_send_email = findViewById(R.id.btn_send_email);
//        et_email = findViewById(R.id.et_email);
//        Intent verfify = new Intent(this, VerifyActivity.class);
//
//
//        btn_send_email.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                startActivity(verfify);
//            }
//        });

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

}