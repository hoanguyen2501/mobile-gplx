package team2.mobileapp.gplx.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

//import team2.mobileapp.gplx.callback.VolleyResponseListener;
import team2.mobileapp.gplx.R;
import team2.mobileapp.gplx.Volley.model.License;
import team2.mobileapp.gplx.Volley.service.LicenseService;

public class TestAPIActivity extends AppCompatActivity {

    private Button btnGetAll, btnAdd, btnUpdate, btnDelete;
    private EditText etId, etName, etStatus, etDescription;
    private ListView lvLicenseShow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_api);

        btnGetAll = findViewById(R.id.btn_get_all_license);
        btnAdd = findViewById(R.id.btn_post_license);
        btnUpdate = findViewById(R.id.btn_update_license);
        btnDelete = findViewById(R.id.btn_delete_license);

        etId = findViewById(R.id.et_id_license);
        etName = findViewById(R.id.et_name_license);
        etDescription = findViewById(R.id.et_description_license);
        etStatus = findViewById(R.id.et_status_license);

        lvLicenseShow = findViewById(R.id.lv_licenses);

        final LicenseService licenseService = new LicenseService(TestAPIActivity.this);

        GetAll(licenseService);

        Add(licenseService);

        Update(licenseService);

        Delete(licenseService);
    }

    private void ResetInput() {
        etId.setText("");
        etName.setText("");
        etStatus.setText("");
        etDescription.setText("");
    }

    private void Delete(LicenseService licenseService) {
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(etId.getText().toString().isEmpty()) Toast.makeText(TestAPIActivity.this, "Please enter id", Toast.LENGTH_LONG).show();
                else{
                    licenseService.Delete(etId.getText().toString());
                }
                ResetInput();
            }
        });
    }

    private void Update(LicenseService licenseService) {
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Toast.makeText(TestAPIActivity.this, "You clicked 'Update' button",Toast.LENGTH_LONG).show();
                if(etId.getText().toString().isEmpty()) Toast.makeText(TestAPIActivity.this, "Please enter id", Toast.LENGTH_LONG).show();
                else if(etName.getText().toString().isEmpty()) Toast.makeText(TestAPIActivity.this, "Please enter name", Toast.LENGTH_LONG).show();
                else if(etStatus.getText().toString().isEmpty()) Toast.makeText(TestAPIActivity.this, "Please enter status", Toast.LENGTH_LONG).show();
                else if(etDescription.getText().toString().isEmpty()) Toast.makeText(TestAPIActivity.this, "Please enter description", Toast.LENGTH_LONG).show();
                else{
//                    Toast.makeText(TestAPIActivity.this, "Hooray", Toast.LENGTH_LONG).show();
                    licenseService.Update(etId.getText().toString(), etName.getText().toString(), etStatus.getText().toString(), etDescription.getText().toString());
                }
                ResetInput();
            }
        });
    }

    private void Add(LicenseService licenseService) {
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!etId.getText().toString().isEmpty()) Toast.makeText(TestAPIActivity.this, "Please dont enter id input", Toast.LENGTH_LONG).show();
                else if(etName.getText().toString().isEmpty()) Toast.makeText(TestAPIActivity.this, "Please enter name", Toast.LENGTH_LONG).show();
                else if(etStatus.getText().toString().isEmpty()) Toast.makeText(TestAPIActivity.this, "Please enter status", Toast.LENGTH_LONG).show();
                else if(etDescription.getText().toString().isEmpty()) Toast.makeText(TestAPIActivity.this, "Please enter description", Toast.LENGTH_LONG).show();
                else{
                    licenseService.Add(etName.getText().toString(), etStatus.getText().toString(), etDescription.getText().toString());
                }
                ResetInput();
            }
        });
    }

    private void GetAll(LicenseService licenseService) {
        btnGetAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(TestAPIActivity.this, "You clicked 'Get All' button", Toast.LENGTH_SHORT).show();
                licenseService.GetAll(new LicenseService.GetALLLicenseCallBack() {
                    @Override
                    public void onError(String message) {
                        Toast.makeText(TestAPIActivity.this, "Something wrong", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onResponse(List<License> licenses) {
                        ArrayAdapter arrayAdapter = new ArrayAdapter(TestAPIActivity.this, android.R.layout.simple_list_item_1, licenses);
                        lvLicenseShow.setAdapter(arrayAdapter);
                    }
                });
                ResetInput();
            }
        });
    }
}