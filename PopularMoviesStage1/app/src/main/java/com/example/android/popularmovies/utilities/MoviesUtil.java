package com.example.android.popularmovies.utilities;

import android.content.Context;

import com.example.android.popularmovies.Movies;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Shash on 3/10/2017.
 */

public final class MoviesUtil {


   public static Movies[] getMovieObjectsFromJson(String resultJsonString) throws JSONException{
       final String poster="poster_path";
       final String plotSummary="overview";
       final String releaseDate="release_date";
       final String movieId="id";
       final String title="title";
       final String userRating="vote_average";

       JSONObject movieObject=new JSONObject(resultJsonString);
       JSONArray movieArray=movieObject.getJSONArray("results");
       int size=movieArray.length();
       Movies[] movieList=new Movies[size];

       for (int i=0;i<20;i++){
           JSONObject movieDetail=movieArray.getJSONObject(i);
           movieList[i]=new Movies();
           movieList[i].setPosterPath(movieDetail.getString(poster));
           movieList[i].setPlotSynopsis(movieDetail.getString(plotSummary));
           movieList[i].setReleaseDate(movieDetail.getString(releaseDate));
           movieList[i].setMovieId(movieDetail.getInt(movieId));
           movieList[i].setOrignalTitle(movieDetail.getString(title));
           movieList[i].setUserRating(movieDetail.getDouble(userRating));

       }
        return movieList;


    }
}
