package team2.mobileapp.gplx.view;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;

import team2.mobileapp.gplx.R;
import team2.mobileapp.gplx.Retrofit.callbacks.TokenCallbackListener;
import team2.mobileapp.gplx.Retrofit.controllers.TokenFireBaseController;
import team2.mobileapp.gplx.Retrofit.dto.TokenFireBase;
import team2.mobileapp.gplx.VariableGlobal.VariableGlobal;

public class BoardingActivity extends AppCompatActivity implements TokenCallbackListener {
    private TokenFireBaseController tokenFireBaseController;
    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_boarding);
        overridePendingTransition(R.anim.slide_in_bottom, R.anim.slide_out_bottom);
        tokenFireBaseController = new TokenFireBaseController(this);
        tokenFireBaseController.startFetching();
        setTimeOut();

    }
   private void setTimeOut(){
       Handler handler = new Handler();
       handler.postDelayed(new Runnable() {
           @Override
           public void run() {
               Intent intent = new Intent(BoardingActivity.this,SplashActivity.class);
               intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
               startActivity(intent);
           }
       }, 3000);
   }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.slide_in_bottom, R.anim.slide_out_bottom);
    }

    @Override
    public boolean moveTaskToBack(boolean nonRoot) {
        overridePendingTransition(R.anim.slide_in_bottom, R.anim.slide_out_bottom);
        return super.moveTaskToBack(nonRoot);

    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }

    @Override
    public void onFetchProgress(TokenFireBase tokenFireBase) {
        VariableGlobal.Token=tokenFireBase.getDownloadTokens();
    }

    @Override
    public void onFetchComplete(String message) {

    }
}