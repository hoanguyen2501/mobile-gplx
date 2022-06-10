package team2.mobileapp.gplx.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import team2.mobileapp.gplx.R;
import team2.mobileapp.gplx.Retrofit.models.License;
import team2.mobileapp.gplx.VariableGlobal.VariableGlobal;


public class A1_TestActivity extends AppCompatActivity {
    private TextView tvLicense;
    private RelativeLayout btnRandom, btnSet, btnBoard, btnReviewQuestion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a1_test);

        overridePendingTransition(R.anim.slide_in_bottom, R.anim.slide_out_bottom);

        InitialVariable();

        VariableGlobal.SetNavigationBar(A1_TestActivity.this);
        License license = (License) getIntent().getSerializableExtra("License");
        tvLicense.setText("Hạng " +   VariableGlobal.typeCode);
        overridePendingTransition(R.anim.slide_in_bottom, R.anim.slide_out_bottom);
        btnRandom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(A1_TestActivity.this, GuideActivity.class);
                intent.putExtra("License", license);
                intent.putExtra("TITLE", "Hướng dẫn");
                startActivity(intent);
            }
        });

        btnSet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(A1_TestActivity.this, GroupTestActivity.class);
                intent.putExtra("License", license);
                intent.putExtra("TITLE", "Thi theo bộ đề");
                startActivity(intent);
            }
        });

        btnBoard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(A1_TestActivity.this, GroupBoardingActivity.class);
                intent.putExtra("TITLE", "Các loại biển báo");
                startActivity(intent);
            }
        });

        btnReviewQuestion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(A1_TestActivity.this, ReviewTestActivity.class);
                intent.putExtra("License", license);
                intent.putExtra("TITLE", "Ôn tập câu hỏi");
                startActivity(intent);
            }
        });

    }

    private void InitialVariable() {
        tvLicense = findViewById(R.id.text_choice_category);
        btnRandom = findViewById(R.id.btn_radom);
        btnSet = findViewById(R.id.btn_set);
        btnBoard = findViewById(R.id.btn_board);
        btnReviewQuestion = findViewById(R.id.btn_review_question);
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
}