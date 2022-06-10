package team2.mobileapp.gplx.Volley.callback;

import java.util.List;

import team2.mobileapp.gplx.Volley.model.License;

public class VolleyResponseListener {
    public interface GetALLLicense {
        void onError(String message);

        void onResponse(List<License> licenses);
    }
}
