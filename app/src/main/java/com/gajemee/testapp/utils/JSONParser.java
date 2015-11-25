package com.gajemee.testapp.utils;

import android.util.Log;

import com.gajemee.testapp.network.GetHTTPDataHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.InputStream;

/**
 * Created by Gajemee on 11/25/2015.
 */
public class JSONParser {
    static InputStream is = null;
    static JSONArray jObj = null;
    static String json = "";
    static GetHTTPDataHandler httpData = null;
    static String className = "JSONParser";
    //constructor
    public JSONParser(){}

    public JSONArray getJSONFromUrl(String url){
        //Making HTTP request
        Log.d(className, "Starting");
        httpData = new GetHTTPDataHandler();
        try{
            Log.d(className, "getting http data");
            jObj = new JSONArray(httpData.GetHttpData(url));
            Log.d(className, "got http data: " + jObj.toString());
        } catch (JSONException e){
            Log.e("JSON Parser", "Error parsing data " + e.toString());
        }
        //return json
        return jObj;
    }
}
