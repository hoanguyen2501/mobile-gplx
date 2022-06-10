package team2.mobileapp.gplx.Retrofit.callbacks;

import java.util.ArrayList;

import team2.mobileapp.gplx.Retrofit.models.HistoricalExam;

public interface HistoricalExamCalBackListenter {
    void onFetchProgress(ArrayList<HistoricalExam> histories);
    void onFetchComplete(String message);
}
