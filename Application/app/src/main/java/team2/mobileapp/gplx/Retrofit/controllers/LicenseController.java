package team2.mobileapp.gplx.Retrofit.controllers;

import android.util.Log;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import team2.mobileapp.gplx.Retrofit.api.RestAPIManager;
import team2.mobileapp.gplx.Retrofit.callbacks.LicenseByIdCallBackListener;
import team2.mobileapp.gplx.Retrofit.callbacks.LicenseCallBackListener;
import team2.mobileapp.gplx.Retrofit.models.License;

public class LicenseController {
    private LicenseCallBackListener licenseCallBackListener;
    private LicenseByIdCallBackListener licenseByIdCallBackListener;
    private RestAPIManager restAPIManager;
    private String message;

    public LicenseController(LicenseCallBackListener listener) {
        licenseCallBackListener = listener;
        restAPIManager = new RestAPIManager();
    }
    public LicenseController(LicenseByIdCallBackListener listener){
        licenseByIdCallBackListener = listener;
        restAPIManager = new RestAPIManager();
    }

    public void startFetching() {
        restAPIManager.getLicenseAPI().getLicense().enqueue(new Callback<ArrayList<License>>() {
            @Override
            public void onResponse(Call<ArrayList<License>> call, Response<ArrayList<License>> response) {
                try {
                    message = response.code() == 200 ? "Successfully" : "Error";
                    ArrayList<License> licenses = response.body();
                    licenseCallBackListener.onFetchProgress(licenses);
                } catch (Exception ex) {
                    Log.d("Error", ex.getMessage());
                }
                licenseCallBackListener.onFetchComplete(message);
            }

            @Override
            public void onFailure(Call<ArrayList<License>> call, Throwable t) {
                Log.d("FAIL", "Failed");
            }
        });
    }

    public void startFetchingLicenseById(String id){
        restAPIManager.getLicenseAPI().getLicenseById(id).enqueue(new Callback<License>() {
            @Override
            public void onResponse(Call<License> call, Response<License> response) {
                try {
                    message = response.code() == 200 ? "Successfully" : "Error";
                    License license = response.body();
                    Log.i("LicenseById", license.toString());
                    licenseByIdCallBackListener.onFetchProgress(license);
                } catch (Exception ex) {
                    Log.d("Error", ex.getMessage());
                }
                licenseByIdCallBackListener.onFetchComplete(message);
            }

            @Override
            public void onFailure(Call<License> call, Throwable t) {
                Log.d("FAIL", "Failed");
            }
        });
    }
}
