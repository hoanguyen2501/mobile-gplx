package team2.mobileapp.gplx.view;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;

import team2.mobileapp.gplx.R;
import team2.mobileapp.gplx.Retrofit.api.SMSAPI;

public class VerifyActivity extends AppCompatActivity {

    EditText etVerifyCode;
    Button btnVerifyCode;
    RelativeLayout checkOutFocus;
    SMSAPI sms = new SMSAPI();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        overridePendingTransition(R.anim.slide_in_bottom, R.anim.slide_out_bottom);
        checkOutFocus = findViewById(R.id.body_verify);
        setContentView(R.layout.activity_verify);
        checkOutFocus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hideKeyboard();
            }
        });
        etVerifyCode = findViewById(R.id.et_verify_code);
        btnVerifyCode = findViewById(R.id.btn_verify);

        Intent setNewPass = new Intent(this, SetNewPasswordActivity.class);

        Verify(setNewPass);
    }

    private void Verify(Intent setNewPass) {
        btnVerifyCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hideKeyboard();
                if(btnVerifyCode.getText().toString().isEmpty())
                   Toast .makeText(VerifyActivity.this, "Please enter verification code", Toast.LENGTH_LONG).show();
                else{
//                    startActivity(setNewPass);
                }
            }
        });
    }
public void hideKeyboard() {
    View view = this.getCurrentFocus();
    if(view  !=null){
        InputMethodManager inputMethodManager =(InputMethodManager)getSystemService(Activity.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
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
}