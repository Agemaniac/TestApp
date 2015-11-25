package com.gajemee.testapp.async;

import android.os.AsyncTask;
import android.util.Log;

import com.gajemee.testapp.utils.JSONParser;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Gajemee on 11/25/2015.
 */
public class GetJsonFromURLTest extends AsyncTask<Void, Integer, String>{
    private final String TAG = "GetJsonFromURLTest";

    protected void onPreExecute(){
        Log.d(TAG, "On preExceute...");
    }

    protected String doInBackground(Void...arg0) {

        Log.d(TAG, "On doInBackground...");

        String url = "http://jsonplaceholder.typicode.com/users";
        String keyId = "id";
        String keyName = "name";
        String keyEmail = "email";
        String keyAddress = "address";
        JSONArray json = new JSONArray();
        String methodName = "getJsonTest";
        //creating the json instance
        JSONParser jParser = new JSONParser();

        try {
            //getting json string from url
            Log.d(methodName, "getting json");
            json = jParser.getJSONFromUrl(url);
            Log.d(methodName, json.toString());
        } catch (Exception e) {
            Log.e(TAG, "Exception: " + e);
        }
        //getting array
        for (int i = 0; i < json.length(); i++) {
            try {
                JSONObject object = json.getJSONObject(i);
                String id = object.getString(keyId);
                String name = object.getString(keyName);
                String email = object.getString(keyEmail);
                String address = object.getString(keyAddress);

                Log.d(TAG, "JSON: " + id + " " + name + " " + email + " " + address);

            } catch (JSONException e) {
                Log.e(TAG, "JSONException: " + e);
            }
        }
        return "Do i return something?";
    }

    protected void onProgressUpdate(Integer...a){
        Log.d(TAG,"You are in progress update ... " + a[0]);
    }

    protected void onPostExecute(String result) {
        Log.d(TAG,result);
    }

}

