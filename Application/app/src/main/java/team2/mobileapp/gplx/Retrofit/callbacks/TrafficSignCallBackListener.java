package team2.mobileapp.gplx.Retrofit.callbacks;

import java.util.List;

import team2.mobileapp.gplx.Retrofit.dto.TrafficSignTypes;
import team2.mobileapp.gplx.Volley.model.TrafficSign;

public interface TrafficSignCallBackListener {
    void onFetchProgress(TrafficSign trafficSign);
    void onFetchTrafficSignTypeProgress(List<TrafficSignTypes> trafficSignTypes);
    void onFetchComplete(String message);
}
