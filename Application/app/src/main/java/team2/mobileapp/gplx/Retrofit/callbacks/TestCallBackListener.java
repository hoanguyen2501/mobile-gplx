package team2.mobileapp.gplx.Retrofit.callbacks;

import java.util.ArrayList;


import team2.mobileapp.gplx.Retrofit.dto.QuestionDetails;


public interface TestCallBackListener {
    void onFetchProgress(ArrayList<QuestionDetails> trafficSign);
    void onFetchComplete(String message);
}
