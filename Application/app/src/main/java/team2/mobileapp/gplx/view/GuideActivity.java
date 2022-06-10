package team2.mobileapp.gplx.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;
import com.wooplr.spotlight.SpotlightConfig;

import team2.mobileapp.gplx.Animation.SpotlightSequence;
import team2.mobileapp.gplx.R;

public class GuideActivity extends AppCompatActivity {
    private TextView Question, QuestionButton1, QuestionButton2;
    private RadioGroup rgAnswer;
    private FloatingActionButton fab;
    private ProgressBar progressBar;
    private DrawerLayout mDrawerLayout;
    private Button btnNext, btnPrev;
    private SpotlightSequence spotlightSequence;
    private SpotlightConfig config;
    private NavigationView navigationView;
    private int[] check = {0};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        overridePendingTransition(R.anim.slide_in_bottom, R.anim.slide_out_bottom);
        setContentView(R.layout.activity_guide);
        InitialVariable();

        spotlightSequence = new SpotlightSequence(GuideActivity.this, config);
        ShowIntro(progressBar, "Vị trí câu hỏi", "Hiển thị vị trí câu hỏi mà bạn đang làm bài", "1");
        ShowIntro(Question, "Phần câu hỏi", "Hãy đọc kỹ câu hỏi và đưa ra câu trả lời đúng nhất nhé ", "2");
        ShowIntro(rgAnswer, "Phần câu trả lời", "Hãy chọn câu trả lời đúng nhất bạn nhé <3 ", "3");
        ShowIntro(btnPrev, "Câu trước", "Nút bấm quay lại câu trước đó", "4");
        ShowIntro(btnNext, "Câu sau", "Nút bấm làm câu tiếp theo", "5");
        ShowIntro(fab, "Thanh trượt", "Kéo qua phải để xem các câu trả lời đã chọn", "6");

        final Handler handler = new Handler();
        final Runnable r = new Runnable() {
            @Override
            public void run() {
                if (check[0] == 1 && spotlightSequence.queue.size() == 1) {

                    mDrawerLayout.openDrawer(GravityCompat.END);
                    spotlightSequence.resetSpotlights(GuideActivity.this);
                }
                if (check[0] == 0 && spotlightSequence.queue.isEmpty()) {
                    check[0]++;
                    ShowIntro(QuestionButton1, "Câu hỏi chưa trả lời", "Câu hỏi nào CHƯA được lựa chọn sẽ có màu xanh ", "9");
                    ShowIntro(QuestionButton2, "Số câu hỏi đã chọn", "Câu hỏi nào ĐÃ được lựa chọn sẽ có màu vàng ", "8");
                }


            }
        };

        Thread t = new Thread() {
            @Override
            public void run() {
                try {
                    while (check[0] < 2) {
                        sleep(500);
                        handler.post(r);
                    }

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        t.start();
        spotlightSequence.startSequence();
    }

    private void InitialVariable() {
        fab = findViewById(R.id.fab);
        Question = findViewById(R.id.tv_question);
        QuestionButton1 = findViewById(R.id.btn_question);
        QuestionButton2 = findViewById(R.id.btn_question2);
        progressBar = findViewById(R.id.determinateBar);
        rgAnswer = findViewById(R.id.rg_answer);
        mDrawerLayout = findViewById(R.id.drawer_test);
        btnNext = findViewById(R.id.btn_next);
        btnPrev = findViewById(R.id.btn_prev);
        navigationView = findViewById(R.id.navigation_bar_question);
    }

    private void ShowIntro(View view, String Title, String Text, String Id) {
        spotlightSequence.resetSpotlights(GuideActivity.this);
        spotlightSequence.addSpotlight(view, Title, Text, Id);


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