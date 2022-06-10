package team2.mobileapp.gplx.Retrofit.api;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import team2.mobileapp.gplx.Retrofit.models.QuestionSet;
import team2.mobileapp.gplx.Retrofit.models.QuestionCountByType;

public interface QuestionSetAPI {
    @GET("questionset/license/{id}")
    Call<ArrayList<QuestionSet>> GetQuestionSetByLicense(@Path("id") String id);
    @GET("question/num/{license}")
    Call<ArrayList<QuestionCountByType>> GetNumQuestion(@Path("license") String license);
}
