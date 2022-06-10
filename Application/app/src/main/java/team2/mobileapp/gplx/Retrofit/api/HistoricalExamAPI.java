package team2.mobileapp.gplx.Retrofit.api;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import team2.mobileapp.gplx.Retrofit.models.HistoricalExam;

public interface HistoricalExamAPI {
    @GET("histories/{id}")
    Call<ArrayList<HistoricalExam>> getHistoriesByUserId(@Path("id") String id);
}
