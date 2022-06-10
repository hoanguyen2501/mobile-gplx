package team2.mobileapp.gplx.Retrofit.callbacks;
import team2.mobileapp.gplx.Retrofit.dto.TokenFireBase;

public interface TokenCallbackListener {
    void onFetchProgress(TokenFireBase tokenFireBase);
    void onFetchComplete(String message);
}
