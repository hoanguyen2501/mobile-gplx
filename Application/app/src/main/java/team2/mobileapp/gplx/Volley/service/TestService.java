package team2.mobileapp.gplx.Volley.service;

import android.content.Context;
import android.os.Build;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import team2.mobileapp.gplx.Volley.callback.MySingleton;
import team2.mobileapp.gplx.Volley.model.Answer;
import team2.mobileapp.gplx.Volley.model.Question;
import team2.mobileapp.gplx.Volley.model.QuestionSet;
import team2.mobileapp.gplx.Volley.model.dto.DtoQuestionSet;

public class TestService {
    public static final String BASE_IP = "http://10.0.2.2:8080/api";

    Context context;

    public TestService(Context context){
        this.context = context;
    }

    public interface GetByQuestionSetCallBack {
        void onError(String message);

        void onResponse(DtoQuestionSet dto);
    }
    public void GetByQuestionSet(String questionSetId, GetByQuestionSetCallBack getByQuestionSetCallBack){
        String requestMapping = "/questionset/" + questionSetId;
        String url = BASE_IP + requestMapping;
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                DtoQuestionSet dto = new DtoQuestionSet();
                try {
                    List<Question> questionList = new ArrayList<>();
                    List<Answer> answerList = new ArrayList<>();

                    JSONObject set = response.getJSONObject("questionSet");
                    QuestionSet questionSet = new QuestionSet(set.getString("id"), set.getString("Name"), set.getBoolean("Status"),
                            set.getInt("Quantity"), set.getString("LicenseId"));
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                        dto.setQuestionSet(questionSet);
                        Log.i("Question Set", dto.getQuestionSet().toString());
                    }
                    JSONArray questList = response.getJSONArray("questList");
                    for(int i = 0; i < questList.length(); i++){
                        Question newQuestion = new Question();
                        JSONObject eachQuestion = (JSONObject) questList.get(i);

                        newQuestion.setId(eachQuestion.getString("id"));
                        newQuestion.setIndex(eachQuestion.getInt("Index"));
                        newQuestion.setQuery(eachQuestion.getString("Query"));
                        newQuestion.setPhoto(eachQuestion.getString("Photo"));
                        newQuestion.setLicenseId(eachQuestion.getString("LicenseId"));
                        newQuestion.setQuestionSetId(eachQuestion.getString("QuestionSetId"));
                        newQuestion.setQuestionTypeId(eachQuestion.getString("QuestionTypeId"));

                        Log.i("Each Question", newQuestion.toString());

                        questionList.add(newQuestion);
                    }

                    JSONArray ansList = response.getJSONArray("ansList");
                    for(int i = 0; i < ansList.length(); i++){
                        Answer newAnswer = new Answer();

                        JSONObject eachAnswer = (JSONObject) ansList.get(i);

                        newAnswer.setId(eachAnswer.getString("id"));
                        newAnswer.setResult(eachAnswer.getInt("Result"));
                        newAnswer.setQuestionId(eachAnswer.getString("QuestionId"));

                        List<Answer> AnswerList = new ArrayList<>();
                        JSONArray eachAnswerName = eachAnswer.getJSONArray("AnswerName");
                        String[] arrayAnswerName = new String[eachAnswerName.length()];
                        for(int j = 0; j < eachAnswerName.length(); j++){
                            arrayAnswerName[j] = (String) eachAnswerName.get(j);
                            Log.i("Array Answer Name", arrayAnswerName[j]);
                        }
                        newAnswer.setAnswerList(arrayAnswerName);
                        Log.i("Each Answer", newAnswer.toString());
                        answerList.add(newAnswer);
                    }
                    dto.setQuestList(questionList);
                    dto.setAnsList(answerList);
                } catch (JSONException e) {
                    Log.d("JSON Exception:", e.toString());
                }
                getByQuestionSetCallBack.onResponse(dto);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                getByQuestionSetCallBack.onError(error.getMessage());
            }
        });

        MySingleton.getInstance(context).addToRequestQueue(request);

    }
}
