package team2.mobileapp.gplx.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import team2.mobileapp.gplx.R;
import team2.mobileapp.gplx.Retrofit.callbacks.QuestionSetCallBackListener;
import team2.mobileapp.gplx.Retrofit.controllers.QuestionSetController;
import team2.mobileapp.gplx.Retrofit.dto.GroupTestItem;
import team2.mobileapp.gplx.Retrofit.models.QuestionSet;
import team2.mobileapp.gplx.Retrofit.models.QuestionCountByType;
import team2.mobileapp.gplx.VariableGlobal.VariableGlobal;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ReviewTestActivity extends AppCompatActivity implements QuestionSetCallBackListener {
    private QuestionSetController questionSetController;
    private ListView groupTest;
    private TextView titleActivity;
    private GroupTestAdapter groupTestAdapter;
    private List<GroupTestItem> listGroupTests = new ArrayList<>();;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        overridePendingTransition(R.anim.slide_in_bottom, R.anim.slide_out_bottom);
        setContentView(R.layout.activity_review_test);
        String license=VariableGlobal.typeCode;
        String title= getIntent().getStringExtra("TITLE");
        titleActivity = findViewById(R.id.tv_title_activity_app);
        groupTest = findViewById(R.id.lv_group_test);
        VariableGlobal.SetNavigationBar(this);

        titleActivity.setText(title);

        questionSetController = new QuestionSetController(this);
        questionSetController.GetquestionSize(license);

        setOnclickType();
    }
    public void setOnclickType(){
        groupTest.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                GroupTestItem groupTestItem= (GroupTestItem) adapterView.getItemAtPosition(i);
                Intent intent = new Intent(ReviewTestActivity.this,QuestionViewListActivity.class);
                intent.putExtra("TITLE_QUESTION_LIST",groupTestItem.getName());
                intent.putExtra("LICENSE_QUESTION_LIST",   VariableGlobal.typeCode);
                intent.putExtra("TYPE_QUESTION_LIST",groupTestItem.getType());
                startActivity(intent);
            }
        });

    }

    @Override
    public void onFetchProgress(ArrayList<QuestionSet> questionSets) {

    }

    @Override
    public void onFetchProgressQuestionSize(ArrayList<QuestionCountByType> questionCountByTypes) {
        if(!questionCountByTypes.isEmpty()){
            for (QuestionCountByType questionCountByType : questionCountByTypes ) {
                if(questionCountByType.getNum()>0)
                {
                    GroupTestItem groupTestItem = new GroupTestItem();
                    groupTestItem.setName(questionCountByType.getName());
                    groupTestItem.setType(questionCountByType.getType());
                    groupTestItem.setNum(questionCountByType.getNum());
                    groupTestItem.setId(questionCountByType.getType()+questionCountByType.getNum());
                    listGroupTests.add(groupTestItem);
                }


            }
            groupTestAdapter = new GroupTestAdapter(this, 1,listGroupTests );
            groupTest.setAdapter(groupTestAdapter);
        }

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

    }  @Override
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