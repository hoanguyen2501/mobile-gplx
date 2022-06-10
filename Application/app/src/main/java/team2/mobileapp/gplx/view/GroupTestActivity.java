package team2.mobileapp.gplx.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import team2.mobileapp.gplx.R;
import team2.mobileapp.gplx.Retrofit.callbacks.QuestionSetCallBackListener;
import team2.mobileapp.gplx.Retrofit.controllers.QuestionSetController;
import team2.mobileapp.gplx.Retrofit.dto.GroupTestItem;
import team2.mobileapp.gplx.Retrofit.models.License;
import team2.mobileapp.gplx.Retrofit.models.QuestionSet;
import team2.mobileapp.gplx.Retrofit.models.QuestionCountByType;
import team2.mobileapp.gplx.VariableGlobal.VariableGlobal;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class GroupTestActivity extends AppCompatActivity implements QuestionSetCallBackListener {
    private QuestionSetController questionSetController;
    private ArrayList<QuestionSet> sets;
    private License license;
    private ListView lvGroupExam;
    private TextView titleActivity;
    private GroupTestAdapter groupTestAdapter;
    private List<GroupTestItem> listGroupTests = new ArrayList<>();
    ;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        overridePendingTransition(R.anim.slide_in_bottom, R.anim.slide_out_bottom);
        setContentView(R.layout.activity_group_test);
        VariableGlobal.SetNavigationBar(this);
        license = (License) getIntent().getSerializableExtra("License");
        String title = getIntent().getStringExtra("TITLE");

        titleActivity = findViewById(R.id.tv_title_activity_app);

        titleActivity.setText(title);

        InitialVariable();

        questionSetController = new QuestionSetController(this);
        questionSetController.startFetching(license.getId());
        SetOnClickType();
    }

    private void InitialVariable() {
        lvGroupExam = findViewById(R.id.lv_exam_group);
    }

    @Override
    public void onFetchProgress(ArrayList<QuestionSet> questionSets) {
        sets = questionSets;
        ShowSet(sets);
    }

    @Override
    public void onFetchProgressQuestionSize(ArrayList<QuestionCountByType> questionCountByType) {

    }

    private void SetOnClickType() {
        lvGroupExam.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                GroupTestItem groupTestItem = (GroupTestItem) adapterView.getItemAtPosition(i);
                Intent intent = new Intent(GroupTestActivity.this, TestActivity.class);
                intent.putExtra("QuestionSetId", groupTestItem.getId());
                startActivity(intent);
            }
        });

    }

    private void ShowSet(ArrayList<QuestionSet> sets) {
        for (QuestionSet set : sets) {
            if (set.getQuantity() > 0) {
                GroupTestItem groupTestItem = new GroupTestItem();
                groupTestItem.setName(set.getName().split("-")[0].trim());
                groupTestItem.setType(set.getLicenseId());
                groupTestItem.setNum(set.getQuantity());
                groupTestItem.setId(set.getId());
                listGroupTests.add(groupTestItem);
            }
        }
        groupTestAdapter = new GroupTestAdapter(this, 1, listGroupTests);
        lvGroupExam.setAdapter(groupTestAdapter);

    }

    @Override
    public void onFetchComplete(String message) {

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