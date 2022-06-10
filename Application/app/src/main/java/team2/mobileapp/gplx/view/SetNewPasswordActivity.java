package team2.mobileapp.gplx.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import team2.mobileapp.gplx.R;

public class SetNewPasswordActivity extends AppCompatActivity {

//    EditText et_new_password, et_confirm_password;
//    Button btn_accept;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        overridePendingTransition(R.anim.slide_in_bottom, R.anim.slide_out_bottom);
        setContentView(R.layout.activity_set_new_password);

//        et_new_password = findViewById(R.id.et_set_new_pass);
//        et_confirm_password = findViewById(R.id.et_confirm_set_new_pass);
//        btn_accept = findViewById(R.id.btn_accept);
//
//        Intent login = new Intent(this, LoginActivity.class);
//        Accept(login);
    }

    private void Accept(Intent login) {
//        btn_accept.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                if(!et_new_password.getText().toString().equals(et_confirm_password.getText().toString()))
//                    Toast.makeText(SetNewPasswordActivity.this, "Check confirm password again!", Toast.LENGTH_LONG).show();
//                else
//                    startActivity(login);
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

    }  @Override
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