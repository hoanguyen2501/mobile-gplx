package team2.mobileapp.gplx.Retrofit.controllers;

import android.util.Log;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import team2.mobileapp.gplx.Retrofit.api.RestAPIManager;
import team2.mobileapp.gplx.Retrofit.callbacks.TokenCallbackListener;
import team2.mobileapp.gplx.Retrofit.dto.TokenFireBase;

public class TokenFireBaseController {
    private TokenCallbackListener tokenCallbackListener;
    private RestAPIManager restAPI;
    private String message;
    private boolean isUpdated = false;

    public TokenFireBaseController(TokenCallbackListener tokenCallbackListener) {
        this.tokenCallbackListener = tokenCallbackListener;
        this.restAPI = new RestAPIManager();
    }

    public void startFetching() {
        restAPI.getTokenApi().getToken().enqueue(new Callback<TokenFireBase>() {
            @Override
            public void onResponse(Call<TokenFireBase> call, Response<TokenFireBase> response) {
                try {
                    message = response.code() == 200 ? "Successfully fetched" : "Failed to fetch";
                    TokenFireBase tokenFireBase = response.body();
                    tokenCallbackListener.onFetchProgress(tokenFireBase);
                } catch (Exception e) {
                    Log.d("Error: ", e.getMessage());

                }
                tokenCallbackListener.onFetchComplete(message);
            }

            @Override
            public void onFailure(Call<TokenFireBase> call, Throwable t) {
                Log.d("FAIL", "onResponse: True");
            }
        });
    }

}
