package com.example.android.popularmovies;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class MovieDetail extends AppCompatActivity {
    private TextView movieTitle;
    private ImageView movieThumbNail;
    private TextView moviePlot;
    private TextView userRating;
    private TextView releaseDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);
        movieTitle=(TextView)findViewById(R.id.movie_title);
        movieThumbNail=(ImageView)findViewById(R.id.movie_thumbnail);
        moviePlot=(TextView)findViewById(R.id.movie_plot);
        userRating=(TextView)findViewById(R.id.user_rating);
        releaseDate=(TextView)findViewById(R.id.release_date);
        Intent i=getIntent();
        movieTitle.setText(i.getStringExtra("movieTitle"));
        Picasso.with(getApplicationContext()).load(i.getStringExtra("moviePoster")).into(movieThumbNail);
        moviePlot.setText(i.getStringExtra("moviePlot"));
        userRating.setText("Rating: "+i.getStringExtra("userRating")+ "\\10");
        releaseDate.setText(i.getStringExtra("releaseDate"));

    }


}
