package team2.mobileapp.gplx.Retrofit.api;

import retrofit2.Call;
import retrofit2.http.*;
import team2.mobileapp.gplx.Retrofit.models.Account;

public interface AccountAPI {
    @GET("account/{id}")
    Call<Account> getAccount(@Path("id") String id);
    @PATCH("account/edit/{id}")
    Call<Account> updateAccount(@Path("id") String id, @Body Account account);
}
