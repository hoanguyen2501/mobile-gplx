package team2.mobileapp.gplx.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import team2.mobileapp.gplx.R;
import team2.mobileapp.gplx.Retrofit.callbacks.TestCallBackListener;
import team2.mobileapp.gplx.Retrofit.controllers.QuestionDetailsController;
import team2.mobileapp.gplx.Retrofit.dto.QuestionDetails;
import team2.mobileapp.gplx.VariableGlobal.VariableGlobal;

public class QuestionViewListActivity extends AppCompatActivity implements TestCallBackListener {
    private QuestionDetailsController questionDetailsController;
    public QuestionListViewAdapter questionListViewAdapter;
    private ListView listView;
    private TextView tvTitleBoard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        overridePendingTransition(R.anim.slide_in_bottom, R.anim.slide_out_bottom);
        setContentView(R.layout.activity_question_view_list);

        VariableGlobal.SetNavigationBar(this);
        listView = (ListView) findViewById(R.id.lvAllQuestion);
        tvTitleBoard = (TextView) findViewById(R.id.title_layouts);
        String title = getIntent().getExtras().getString("TITLE_QUESTION_LIST");
        String license = getIntent().getExtras().getString("LICENSE_QUESTION_LIST");
        String type = getIntent().getExtras().getString("TYPE_QUESTION_LIST");
        tvTitleBoard.setText(title);
        questionDetailsController = new QuestionDetailsController(this);
        questionDetailsController.startFetching(license, type);
    }

    @Override
    public void onFetchProgress(ArrayList<QuestionDetails> trafficSigns) {
        if (!trafficSigns.isEmpty()) {

            questionListViewAdapter = new QuestionListViewAdapter(QuestionViewListActivity.this, R.layout.question_view_list_item, trafficSigns);
            listView.setAdapter(questionListViewAdapter);
        }

    }

    @Override
    public void onFetchComplete(String message) {
        Log.d("onFetchComplete", message);
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