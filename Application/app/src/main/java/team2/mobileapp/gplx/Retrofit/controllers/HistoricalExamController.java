package team2.mobileapp.gplx.Retrofit.controllers;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import team2.mobileapp.gplx.Retrofit.api.RestAPIManager;
import team2.mobileapp.gplx.Retrofit.callbacks.HistoricalExamCalBackListenter;
import team2.mobileapp.gplx.Retrofit.models.HistoricalExam;
import team2.mobileapp.gplx.VariableGlobal.VariableGlobal;

public class HistoricalExamController {
    private HistoricalExamCalBackListenter historicalExamCalBackListenter;
    private RestAPIManager rest;
    private String message;

    public HistoricalExamController(HistoricalExamCalBackListenter historicalExamCalBackListenter) {
        this.historicalExamCalBackListenter = historicalExamCalBackListenter;
        this.rest = new RestAPIManager();
    }

    public void startFetching() {
        rest.getHistoricalExamAPI().getHistoriesByUserId(VariableGlobal.idUser).enqueue(new Callback<ArrayList<HistoricalExam>>() {
            @Override
            public void onResponse(Call<ArrayList<HistoricalExam>> call, Response<ArrayList<HistoricalExam>> response) {
                try {
                    ArrayList<HistoricalExam> results = response.body();
                    if (results != null) {
                        message = response.code() == 200 ? "Successfully fetched" : "Failed to fetch";
                        historicalExamCalBackListenter.onFetchProgress(results);
                    }
                    historicalExamCalBackListenter.onFetchComplete(message);
                } catch (Exception e) {
                    message = e.getMessage();
                }
            }

            @Override
            public void onFailure(Call<ArrayList<HistoricalExam>> call, Throwable t) {
                message = t.getMessage();
                historicalExamCalBackListenter.onFetchComplete(message);
            }
        });
    }
}
