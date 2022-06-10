package team2.mobileapp.gplx.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import team2.mobileapp.gplx.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void Splash(View view){
        Intent intent = new Intent(this,SplashActivity.class);
        startActivity(intent);
    }
    public void Boarding(View view){
        Intent intent = new Intent(this,BoardingActivity.class);
        startActivity(intent);
    }
    public void Login(View view){
        Intent intent = new Intent(this,LoginActivity.class);
        startActivity(intent);
    }
    public void SignUp(View view){
        Intent intent = new Intent(this,SignupActivity.class);
        startActivity(intent);
    }
    public void Verify(View view){
        Intent intent = new Intent(this,VerifyActivity.class);
        startActivity(intent);
    }
    public void ForgotPass(View view){
        Intent intent = new Intent(this,ForgotPasswordActivity.class);
        startActivity(intent);
    }
    public void SetNewPass(View view){
        Intent intent = new Intent(this,SetNewPasswordActivity.class);
        startActivity(intent);
    }
    public void History(View view){
        Intent intent = new Intent(this,HistoryActivity.class);
        startActivity(intent);
    }
    public void SelectCategory(View view){
        Intent intent = new Intent(this,SelectCategoryActivity.class);
        startActivity(intent);
    }
    public void Test(View view){
        Intent intent = new Intent(this,TestActivity.class);
        startActivity(intent);
    }
    public void Profile(View view){
        Intent intent = new Intent(this,EditProfileActivity.class);
        startActivity(intent);
    }
    public void A1_Test(View view){
        Intent intent = new Intent(this,A1_TestActivity.class);
        startActivity(intent);
    }
    public void Result(View view){
        Intent intent = new Intent(this,ResultActivity.class);
        startActivity(intent);
    }
    public void NoticeBoard(View view){
        Intent intent = new Intent(this,NoticeBoardActivity.class);
        startActivity(intent);
    }
    public void ReviewTest(View view){
        Intent intent = new Intent(this,ReviewTestActivity.class);
        startActivity(intent);
    }
    public void GroupTest(View view){
        Intent intent = new Intent(this,GroupTestActivity.class);
        startActivity(intent);
    }
    public void Tutorial(View view){
        Intent intent = new Intent(this,TutorialActivity.class);
        startActivity(intent);
    }
    public void DetailsNoticeBoard(View view){
        Intent intent = new Intent(this, DetailsNoticeBoardActivity.class);
        startActivity(intent);
    }
    public void AllQuestion(View view){
        Intent intent = new Intent(this,QuestionViewListActivity.class);
        startActivity(intent);
    }
    public void Guide(View view){
        Intent intent = new Intent(this,GuideActivity.class);
        startActivity(intent);
    }
    public void TrafficByType(View view){
        Intent intent = new Intent(this, GroupBoardingActivity.class);
        startActivity(intent);
    }
}