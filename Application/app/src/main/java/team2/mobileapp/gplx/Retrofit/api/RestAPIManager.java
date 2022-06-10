package team2.mobileapp.gplx.Retrofit.api;


import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RestAPIManager {
    private QuestionSetAPI questionSetAPI;
    private TrafficSignAPI trafficSignAPI;
    private QuestionDetailsAPI questionDetailsAPI;
    private LicenseAPI licenseAPI;
    private AccountAPI accountAPI;
    private TokenImageAPI tokenImageAPI;
    private HistoricalExamAPI historicalExamAPI;
    public static final String BASE_URL = "http://10.0.2.2:8080/api/";

    public QuestionSetAPI getQuestionSetAPI() {
        if (questionSetAPI == null) {
            questionSetAPI = new Retrofit.Builder()
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl(BASE_URL)
                    .build()
                    .create(QuestionSetAPI.class);
        }
        return questionSetAPI;
    }

    public LicenseAPI getLicenseAPI() {
        if (licenseAPI == null) {
            licenseAPI = new Retrofit.Builder()
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl(BASE_URL)
                    .build()
                    .create(LicenseAPI.class);
        }
        return licenseAPI;
    }

    public TrafficSignAPI getTrafficSignApi() {
        if (trafficSignAPI == null) {
            trafficSignAPI = new Retrofit.Builder()
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl(BASE_URL)
                    .build()
                    .create(TrafficSignAPI.class);
        }
        return trafficSignAPI;
    }

    public QuestionDetailsAPI getTestApi() {
        if (questionDetailsAPI == null) {
            questionDetailsAPI = new Retrofit.Builder()
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl(BASE_URL)
                    .build()
                    .create(QuestionDetailsAPI.class);
        }
        return questionDetailsAPI;
    }

    public TokenImageAPI getTokenApi() {
        if (tokenImageAPI == null) {
            tokenImageAPI = new Retrofit.Builder()
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl(BASE_URL)
                    .build()
                    .create(TokenImageAPI.class);
        }
        return tokenImageAPI;
    }

    public AccountAPI getAccountAPI() {
        if (accountAPI == null) {
            accountAPI = new Retrofit.Builder()
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl(BASE_URL)
                    .build()
                    .create(AccountAPI.class);
        }
        return accountAPI;
    }

    public HistoricalExamAPI getHistoricalExamAPI() {
        if (historicalExamAPI == null) {
            historicalExamAPI = new Retrofit.Builder()
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl(BASE_URL).build().create(HistoricalExamAPI.class);
        }
        return historicalExamAPI;
    }
}