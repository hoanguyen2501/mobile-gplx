package team2.mobileapp.gplx.Volley.service;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import team2.mobileapp.gplx.Volley.callback.MySingleton;
//import team2.mobileapp.gplx.callback.VolleyResponseListener;
import team2.mobileapp.gplx.Volley.model.License;

public class LicenseService {
    public static final String BASE_IP = "http://10.0.2.2:8080/api";
//    public static final String QUERY_FOR_GET_ALL = "http://10.0.2.2:8080/api/license";
//    public static final String QUERY_FOR_POST = "http://10.0.2.2:8080/api/license/add";
//    public static final String QUERY_FOR_PUT = "http://10.0.2.2:8080/api/license/edit";
//    public static final String QUERY_FOR_DELETE = "http://10.0.2.2:8080/api/license/delete";

    Context context;

    public LicenseService(Context context) {
        this.context = context;
    }

    public void Delete(String id) {
        String requestMapping = "/license/delete/" + id;
        String url = BASE_IP + requestMapping;

        // creating a new variable for our request queue
        RequestQueue queue = Volley.newRequestQueue(context);

        // making a string request to update our data and
        // passing method as PUT. to update our data.
        StringRequest request = new StringRequest(Request.Method.DELETE, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                // on below line we are displaying a toast message as data updated.
                Toast.makeText(context, "Data Deleted..", Toast.LENGTH_SHORT).show();
                try {
                    // on below line we are extracting data from our json object
                    // and passing our response to our json object.
                    JSONObject jsonObject = new JSONObject(response);

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                // displaying toast message on response failure.
                Toast.makeText(context, "Fail to delete data..", Toast.LENGTH_SHORT).show();
            }
        }) {
            @Override
            protected Map<String, String> getParams() {

                // below line we are creating a map for storing
                // our values in key and value pair.
                Map<String, String> params = new HashMap<String, String>();

                // on below line we are passing our key
                // and value pair to our parameters.
                params.put("id",id);

                // at last we are
                // returning our params.
                return params;
            }
        };
        // below line is to make
        // a json object request.
        queue.add(request);
    }

    public interface GetALLLicenseCallBack {
        void onError(String message);

        void onResponse(List<License> licenses);
    }
    public void GetAll(GetALLLicenseCallBack getALLLicenseCallBack) {
        String requestMapping = "/license";
        String url = BASE_IP + requestMapping;
        List<License> licenses = new ArrayList<>();
        JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                try {
                    for(int i = 0; i < response.length(); i++){
                        License license = new License();
                        JSONObject eachLicense = response.getJSONObject(i);

                        license.setId(eachLicense.getString("id"));
                        license.setName(eachLicense.getString("Name"));
                        license.setStatus(eachLicense.getString("Status"));
                        license.setDesciption(eachLicense.getString("Description"));

                        licenses.add(license);
                    }
                } catch (JSONException e) {
                    Log.d("JSON Exception:", e.toString());
                }
                getALLLicenseCallBack.onResponse(licenses);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                getALLLicenseCallBack.onError(error.getMessage());
            }
        });

        MySingleton.getInstance(context).addToRequestQueue(request);
    }

    public void Add(String name, String status, String description){
        String requestMapping = "/license/add";
        String url = BASE_IP + requestMapping;

        // creating a new variable for our request queue
        RequestQueue queue = Volley.newRequestQueue(context);

        // on below line we are calling a string
        // request method to post the data to our API
        // in this we are calling a post method.
        StringRequest request = new StringRequest(Request.Method.POST, url, new com.android.volley.Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.e("TAG", "RESPONSE IS " + response);
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    // on below line we are displaying a success toast message.
                    Toast.makeText(context, jsonObject.getString("message"), Toast.LENGTH_SHORT).show();
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new com.android.volley.Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                // method to handle errors.
                Toast.makeText(context, "Fail to get response = " + error, Toast.LENGTH_SHORT).show();
            }
        }) {
            @Override
            public String getBodyContentType() {
                // as we are passing data in the form of url encoded
                // so we are passing the content type below
                return "application/x-www-form-urlencoded; charset=UTF-8";
            }

            @Override
            protected Map<String, String> getParams() {

                // below line we are creating a map for storing
                // our values in key and value pair.
                Map<String, String> params = new HashMap<String, String>();

                // on below line we are passing our
                // key and value pair to our parameters.
                params.put("Name", name);
                params.put("Status", status);
                params.put("Description", description);

                // at last we are returning our params.
                return params;
            }
        };
        // below line is to make
        // a json object request.
        queue.add(request);
    }

    public void Update(String id, String name, String status, String description){
        String requestMapping = "/license/edit/" + id;
        String url = BASE_IP + requestMapping;

        // creating a new variable for our request queue
        RequestQueue queue = Volley.newRequestQueue(context);

        // making a string request to update our data and
        // passing method as PUT. to update our data.
        StringRequest request = new StringRequest(Request.Method.PUT, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                // on below line we are displaying a toast message as data updated.
                Toast.makeText(context, "Data Updated..", Toast.LENGTH_SHORT).show();
                try {
                    // on below line we are extracting data from our json object
                    // and passing our response to our json object.
                    JSONObject jsonObject = new JSONObject(response);

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                // displaying toast message on response failure.
                Toast.makeText(context, "Fail to update data..", Toast.LENGTH_SHORT).show();
            }
        }) {
            @Override
            protected Map<String, String> getParams() {

                // below line we are creating a map for storing
                // our values in key and value pair.
                Map<String, String> params = new HashMap<String, String>();

                // on below line we are passing our key
                // and value pair to our parameters.
                params.put("id",id);
                params.put("Name", name);
                params.put("Status", status);
                params.put("Description", description);

                // at last we are
                // returning our params.
                return params;
            }
        };
        // below line is to make
        // a json object request.
        queue.add(request);
    }
}
