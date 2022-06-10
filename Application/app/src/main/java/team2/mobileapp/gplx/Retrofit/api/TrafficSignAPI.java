package team2.mobileapp.gplx.Retrofit.api;

import retrofit2.Call;
import java.util.List;
import retrofit2.http.GET;

import retrofit2.http.Path;
import team2.mobileapp.gplx.Retrofit.dto.TrafficSignTypes;
import team2.mobileapp.gplx.Volley.model.TrafficSign;

public interface TrafficSignAPI {
    @GET("trafficsign")
    Call<List<TrafficSign>> getTrafficSigns();
    @GET("trafficsign/{id}")
    Call<TrafficSign> getTrafficSign(@Path("id") String id);
    @GET("trafficsign/types")
    Call<List<TrafficSignTypes>> getTrafficSignTypes();
    @GET("trafficsign/type/{type}")
    Call<List<TrafficSign>> getTrafficSignByType();
}
