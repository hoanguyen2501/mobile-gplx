package team2.mobileapp.gplx.Retrofit.callbacks;

import team2.mobileapp.gplx.Retrofit.models.Account;

public interface AccountCallbackListener {
    void onFetchAccountProgress(Account account);
    void onFetchComplete(String message);
}
