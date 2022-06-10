package team2.mobileapp.gplx.Retrofit.callbacks;

import team2.mobileapp.gplx.Retrofit.models.License;

public interface LicenseByIdCallBackListener {
    void onFetchProgress(License license);
    void onFetchComplete(String message);
}
