package com.example.android.popularmovies.utilities;

import android.net.Uri;
import android.util.Log;

import com.example.android.popularmovies.Movies;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

/**
 * Created by Shash on 3/9/2017.
 */

public final class NetworkUtil {
    private static final String TAG = NetworkUtil.class.getSimpleName();

    private final static String baseUrl="https://api.themoviedb.org/3/movie/";

    private final static String popularity="popular";
    private final static String PARAM_Language="en-US";
    private final static String page="page";
    private final static String PARAM_PAGE="1";
    private final static String pLanguage="language";
    private final static String topRated="top_rated";
    private final static String PARAM_API="your API key";
    private final static String apiKey="api_key";


    public static URL buildUrl(){
        Uri builtUri=Uri.parse(baseUrl.concat(popularity)).buildUpon()
            .appendQueryParameter(apiKey,PARAM_API)
            .appendQueryParameter(pLanguage,PARAM_Language)
            .appendQueryParameter(page,PARAM_PAGE).build();
        URL url=null;
        try {
            url = new URL(builtUri.toString());
        }catch (MalformedURLException e){
            e.printStackTrace();
        }
        Log.v(TAG, "Built URI " + url);
        return url;

    }
    public static URL buildURL(){
        Uri builtUri=Uri.parse(baseUrl+topRated).buildUpon()
                .appendQueryParameter(apiKey,PARAM_API)
                .appendQueryParameter(pLanguage,PARAM_Language)
                .appendQueryParameter(page,PARAM_PAGE).build();
        URL url=null;
        try{
            url=new URL(builtUri.toString());
        }catch (MalformedURLException e){
            e.printStackTrace();
        }
        Log.v(TAG, "Built URI " + url);
        return url;
    }
    public static String getResponseFromHttpUrl(URL url) throws IOException {
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
        try {
            InputStream in = urlConnection.getInputStream();

            Scanner scanner = new Scanner(in);
            scanner.useDelimiter("\\A");

            boolean hasInput = scanner.hasNext();
            if (hasInput) {
                return scanner.next();
            } else {
                return null;
            }
        } finally {
            urlConnection.disconnect();
        }
    }
}
