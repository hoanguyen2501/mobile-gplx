package team2.mobileapp.gplx.Retrofit.callbacks;

import java.util.ArrayList;

import team2.mobileapp.gplx.Retrofit.models.License;

public interface LicenseCallBackListener {
    void onFetchProgress(ArrayList<License> licenses);
    void onFetchComplete(String message);
}
