package team2.mobileapp.gplx.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;

import team2.mobileapp.gplx.R;
import team2.mobileapp.gplx.Retrofit.callbacks.LicenseCallBackListener;
import team2.mobileapp.gplx.Retrofit.controllers.LicenseController;
import team2.mobileapp.gplx.Retrofit.models.License;
import team2.mobileapp.gplx.VariableGlobal.VariableGlobal;

import java.util.ArrayList;

public class SelectCategoryActivity extends AppCompatActivity implements LicenseCallBackListener {

    LicenseController licenseController;
    RelativeLayout btnA1, btnA2, btnB1, btnB2;
    ArrayList<License> licenses;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        overridePendingTransition(R.anim.slide_in_bottom, R.anim.slide_out_bottom);
        setContentView(R.layout.activity_select_category);
        VariableGlobal.SetNavigationBar(this);
        InitialVariable();

        licenseController = new LicenseController(this);
        licenseController.startFetching();



    }

    private void InitialVariable() {
        btnA1 = findViewById(R.id.btn_a1);
        btnA2 = findViewById(R.id.btn_a2);
        btnB1 = findViewById(R.id.btn_b1);
        btnB2 = findViewById(R.id.btn_b2);
    }

    @Override
    public void onFetchProgress(ArrayList<License> licenses) {
        if(!licenses.isEmpty()){
            this.licenses = licenses;
            btnA1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(SelectCategoryActivity.this, A1_TestActivity.class);
                    intent.putExtra("License", licenses.get(0));

                    VariableGlobal.typeCode="A1";
                    VariableGlobal.license = licenses.get(0);
                    startActivity(intent);
                }
            });

            btnA2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(SelectCategoryActivity.this, A1_TestActivity.class);
                    intent.putExtra("License", licenses.get(1));
                    VariableGlobal.typeCode="A2";
                    VariableGlobal.license = licenses.get(1);
                    startActivity(intent);
                }
            });

            btnB1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(SelectCategoryActivity.this, A1_TestActivity.class);
                    intent.putExtra("License", licenses.get(2));
                    VariableGlobal.license = licenses.get(2);
                    VariableGlobal.typeCode="B1";
                    startActivity(intent);
                }
            });

            btnB2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(SelectCategoryActivity.this, A1_TestActivity.class);
                    intent.putExtra("License", licenses.get(3));
                    VariableGlobal.license = licenses.get(3);
                    VariableGlobal.typeCode="B2";
                    startActivity(intent);
                }
            });
        }
    }

    @Override
    public void onFetchComplete(String message) {
        Log.d("onFetchComplete", message);
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