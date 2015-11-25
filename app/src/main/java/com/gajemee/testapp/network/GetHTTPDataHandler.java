package com.gajemee.testapp.network;

import android.util.Log;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.MalformedInputException;

/**
 * Created by Gajemee on 11/25/2015.
 */
public class GetHTTPDataHandler {
    static String stream = null;
    static String className = "GetHTTPDataHandler";
    public GetHTTPDataHandler(){}

    public String GetHttpData(String urlString){
        Log.d(className, "Starting gethttpdata");
        int statusCode;
        try {
            Log.d(className, "url");
            URL url = new URL(urlString);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            statusCode = urlConnection.getResponseCode();
            Log.d(className, "status code: " + statusCode);
            //Check the connection status
            if (statusCode == 200) {
                //if response code = 200 ok
                InputStream in = new BufferedInputStream(urlConnection.getInputStream());
                //Read the buffered input stream
                BufferedReader r = new BufferedReader(new InputStreamReader(in, "iso-8859-1"), 8);
                StringBuilder sb = new StringBuilder();
                String line;
                while ((line = r.readLine()) != null) {
                    sb.append(line);
                }
                stream = sb.toString();
                urlConnection.disconnect();
                Log.d(className, "disconnected");
            } else {
                //Do something here!
                Log.e("GetHttpData", "request returned status code: " + statusCode);

            }
        } catch (MalformedInputException e){
            Log.e("GetHttpData", " MalformedInputException " + e.toString());
        } catch (IOException e){
            Log.e("GetHttpData", " IOException " + e.toString());
        } catch (Exception e){
            Log.e("GetHttpData", " Buffer error: Error converting result " + e.toString());
        } finally {
            //anything else to do???
        }
        Log.d(className, "returning");
        return stream;
    }
}
