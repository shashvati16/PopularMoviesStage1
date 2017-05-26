package com.example.android.popularmovies;



import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.GridView;
import android.widget.TextView;


import com.example.android.popularmovies.utilities.MoviesUtil;
import com.example.android.popularmovies.utilities.NetworkUtil;
import org.json.JSONException;
import org.w3c.dom.Text;

import java.io.IOException;
import java.net.URL;




public class MainActivity extends AppCompatActivity {



    GridView gridView;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        URL moviesUrl = NetworkUtil.buildUrl();
        new FetchMoviesTask().execute(moviesUrl);


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.settings, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_mostpopular) {
            URL moviesUrl = NetworkUtil.buildUrl();
            new FetchMoviesTask().execute(moviesUrl);
            return true;
        }
        else if (id == R.id.action_toprated) {
            URL moviesUrl = NetworkUtil.buildURL();
            new FetchMoviesTask().execute(moviesUrl);
            return true;

        }
        return super.onOptionsItemSelected(item);
    }
    public class FetchMoviesTask extends AsyncTask<URL,Void,String> {
        @Override
        protected String doInBackground(URL... params) {
            URL movieSearchUrl = params[0];
            String movieResults = null;
            if(isOnline()==true){
                try {
                    movieResults = NetworkUtil.getResponseFromHttpUrl(movieSearchUrl);
                } catch (IOException i) {
                    i.printStackTrace();
                }
            }
            return movieResults;
        }
        public boolean isOnline() {
            Runtime runtime = Runtime.getRuntime();
            try {
                Process ipProcess = runtime.exec("/system/bin/ping -c 1 8.8.8.8");
                int     exitValue = ipProcess.waitFor();
                return (exitValue == 0);
            }
            catch (IOException e)          { e.printStackTrace(); }
            catch (InterruptedException e) { e.printStackTrace(); }

            return false;
        }
        @Override
        protected void onPostExecute(String movieResults){
            Movies[] movie_posters = new Movies[20];
            try {
                movie_posters= MoviesUtil.getMovieObjectsFromJson(movieResults);
            }catch (JSONException e){
                e.printStackTrace();
            }catch (Exception e){
                e.printStackTrace();
            }
            if (movieResults!=null) {
                gridView = (GridView) findViewById(R.id.movies_grid);
                MovieAdapter movieAdapter = new MovieAdapter(MainActivity.this, movie_posters);
                gridView.setAdapter(movieAdapter);

            }


        }
    }
}























