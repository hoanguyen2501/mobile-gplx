package team2.mobileapp.gplx.view;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

import team2.mobileapp.gplx.R;
import team2.mobileapp.gplx.Retrofit.callbacks.HistoricalExamCalBackListenter;
import team2.mobileapp.gplx.Retrofit.controllers.HistoricalExamController;
import team2.mobileapp.gplx.Retrofit.models.HistoricalExam;
import team2.mobileapp.gplx.VariableGlobal.VariableGlobal;


public class HistoryActivity extends AppCompatActivity implements HistoricalExamCalBackListenter {
    public HistoryAdapter historyAdapter;
    private ListView listView;
    private TextView titleActivity;
    private HistoricalExamController heController;

    //
//    BottomNavigationItemView btn_home, btn_menu, btn_noti, btn_profile;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        overridePendingTransition(R.anim.slide_in_bottom, R.anim.slide_out_bottom);
        setContentView(R.layout.activity_history);


        heController = new HistoricalExamController(HistoryActivity.this);

        titleActivity = findViewById(R.id.tv_title_activity_app);
        VariableGlobal.SetNavigationBar(this);
        titleActivity.setText("Lịch sử");
        listView = (ListView) findViewById(R.id.lvItems);
        heController.startFetching();
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
    public void onFetchProgress(ArrayList<HistoricalExam> histories) {
        if (!histories.isEmpty()) {
            historyAdapter = new HistoryAdapter(HistoryActivity.this, 1, histories);
            listView.setAdapter(historyAdapter);
        }
    }

    @Override
    public void onFetchComplete(String message) {

    }
}