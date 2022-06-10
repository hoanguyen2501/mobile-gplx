package team2.mobileapp.gplx.Retrofit.callbacks;

import java.util.ArrayList;

import team2.mobileapp.gplx.Retrofit.models.QuestionSet;
import team2.mobileapp.gplx.Retrofit.models.QuestionCountByType;

public interface QuestionSetCallBackListener {
    void onFetchProgress(ArrayList<QuestionSet> questionSets);
    void onFetchProgressQuestionSize(ArrayList<QuestionCountByType> questionCountByTypes);
    void onFetchComplete(String message);
}
