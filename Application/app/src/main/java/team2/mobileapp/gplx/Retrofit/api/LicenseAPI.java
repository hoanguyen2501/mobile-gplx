package team2.mobileapp.gplx.Retrofit.api;


import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import team2.mobileapp.gplx.Retrofit.models.License;

public interface LicenseAPI {
    @GET("license")
    Call<ArrayList<License>> getLicense();
    @GET("license/{id}")
    Call<License> getLicenseById(@Path("id") String id);
}
