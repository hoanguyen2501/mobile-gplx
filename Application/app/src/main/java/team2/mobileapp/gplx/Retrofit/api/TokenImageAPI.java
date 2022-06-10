package team2.mobileapp.gplx.Retrofit.api;

import retrofit2.Call;
import retrofit2.http.GET;
import team2.mobileapp.gplx.Retrofit.dto.TokenFireBase;


public interface TokenImageAPI {
    @GET("firebase/token")
    Call<TokenFireBase> getToken();
}
