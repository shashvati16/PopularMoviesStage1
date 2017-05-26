package com.example.android.popularmovies;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Date;

/**
 * Created by Shash on 3/10/2017.
 */

public class Movies implements Parcelable{
    String posterPath;
    String orignalTitle;
    String imageBasePath="https://image.tmdb.org/t/p/w185";
    String plotSynopsis;
    int movieId;
    String releaseDate;
    double userRating;

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }



    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = "Release: "+releaseDate;
    }



    public String getPosterPath() {
        return posterPath;
    }

    public void setPosterPath(String posterPath) {
        this.posterPath =  imageBasePath.concat(posterPath);
    }

    public String getOrignalTitle() {
        return orignalTitle;
    }

    public void setOrignalTitle(String orignalTitle) {
        this.orignalTitle = orignalTitle;
    }


    public String getPlotSynopsis() {
        return plotSynopsis;
    }

    public void setPlotSynopsis(String plotSynopsis) {
        this.plotSynopsis = plotSynopsis;
    }

    public double getUserRating() {
        return userRating;
    }

    public void setUserRating(double userRating) {
        this.userRating = userRating;
    }
    public Movies(){}
    private Movies(Parcel in){
        posterPath=in.readString();
        orignalTitle=in.readString();
        plotSynopsis=in.readString();
        movieId=in.readInt();
        releaseDate=in.readString();
        userRating=in.readFloat();

    }
    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i){
        parcel.writeString(posterPath);
        parcel.writeString(orignalTitle);
        parcel.writeString(plotSynopsis);
        parcel.writeInt(movieId);
        parcel.writeString(releaseDate);
        parcel.writeDouble(userRating);
    }
    public final Parcelable.Creator<Movies> CREATOR = new Parcelable.Creator<Movies>() {
        @Override
        public Movies createFromParcel(Parcel parcel){
            return new Movies(parcel);
        }
        @Override
        public Movies[] newArray(int i){
            return new Movies[i];
        }

    };







}
