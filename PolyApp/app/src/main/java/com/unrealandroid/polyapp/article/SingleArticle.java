package com.unrealandroid.polyapp.article;

/**
 * Created by Rémy Kaloustian on 02/04/2016.
 */

import android.app.Fragment;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.unrealandroid.polyapp.DBHelper;
import com.unrealandroid.polyapp.R;
import com.unrealandroid.polyapp.article.Article;
import com.unrealandroid.polyapp.event.Event;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 * Represents an article page
 */
public class SingleArticle extends AppCompatActivity{

    private Article _article;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = getIntent();
        int id = intent.getIntExtra("id", 1);

        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_FULLSCREEN
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);


        try {
            DBHelper dbHelper = new DBHelper(this);
            dbHelper.createDataBase();
            dbHelper.openDataBase();
            _article = dbHelper.getArticle(id);

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        setContentView(R.layout.single_article);

        setTitle(_article._title);
        final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitleTextColor(Color.parseColor("#FFFFFF"));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        TextView title = (TextView) findViewById(R.id.ArticleTitle);
        title.setText(_article._title);

        title.setTextSize(30);
        title.setPadding(20, 20, 20, 5);
        title.setTextColor(Color.parseColor("#16a085"));


        /*TextView date = (TextView) findViewById(R.id.ArticleDate);
        title.setText(_article._date);
*/


        TextView content = (TextView) findViewById(R.id.ArticleContent);
      /*  content.setText(_article._content);*/

        if(id == 1)
        {
            content.setText(R.string.content_why_polytech);
        }
        else if(id== 2)
        {
            content.setText(R.string.content_why_IT);
        }

        else if(id == 3)
        {
            content.setText(R.string.content_why_android);
        }

        content.setTextSize(20);
        content.setPadding(20, 10, 20, 0);

        ImageView image = (ImageView) findViewById(R.id.ArticleImage);

        /*AsyncTaskImage img = new AsyncTaskImage(image);
        img.execute(_article._pathToImage);*/

        //TextView textView = (TextView) rootView.findViewById(R.id.section_label);
        //textView.setText(getString(R.string.section_format, getArguments().getInt(ARG_SECTION_NUMBER)));
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == android.R.id.home) {
            finish();
        }

        return super.onOptionsItemSelected(item);
    }
}//class SingleArticle
