package com.example.android.popularmovies;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;



/**
 * Created by Shash on 3/13/2017.
 */

public class MovieAdapter extends ArrayAdapter{
    private static final String LOG_TAG = MovieAdapter.class.getSimpleName();
    private Movies[] movie_posters;
    private Context context;
    private LayoutInflater layoutInflater;



    public MovieAdapter(Activity context, Movies[] movie_posters){
        super(context,R.layout.movie_posters,movie_posters);
        this.context=context;
        this.movie_posters=movie_posters;
        layoutInflater=LayoutInflater.from(context);

    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent){

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(
                    R.layout.movie_posters, parent, false);
        }




        ImageView iconView= (ImageView) convertView.findViewById(R.id.movie_posters);
        Picasso.with(getContext()).load(movie_posters[position].getPosterPath()).into((iconView));

        iconView.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intentMovie=new Intent(getContext(),MovieDetail.class);
                intentMovie.putExtra("moviePoster",movie_posters[position].getPosterPath());
                intentMovie.putExtra("movieTitle",movie_posters[position].getOrignalTitle());
                intentMovie.putExtra("moviePlot",movie_posters[position].getPlotSynopsis());
                intentMovie.putExtra("userRating",String.valueOf(movie_posters[position].getUserRating()));
                intentMovie.putExtra("releaseDate",movie_posters[position].getReleaseDate());
                getContext().startActivity(intentMovie);
            }


        });
        return convertView;
    }




}
