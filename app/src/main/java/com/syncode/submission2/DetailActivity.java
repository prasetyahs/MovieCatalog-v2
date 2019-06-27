package com.syncode.submission2;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.syncode.submission2.Model.MoviesModel;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ImageView imgMovie = findViewById(R.id.img_movie);
        ImageView imgMovieBanner = findViewById(R.id.img_movie_banner);
        TextView txtTitle = findViewById(R.id.txt_title);
        TextView txtMinutes = findViewById(R.id.txt_minutes);
        TextView txtDes = findViewById(R.id.txt_desc);
        TextView txtDate = findViewById(R.id.txt_date);
        MoviesModel moviesModel = getIntent().getParcelableExtra("movies");
        if (moviesModel != null) {
            imgMovie.setImageResource(moviesModel.getImg());
            imgMovieBanner.setImageResource(moviesModel.getImg());
            txtTitle.setText(moviesModel.getTitle());
            txtMinutes.setText(moviesModel.getRuntime());
            txtDes.setText(moviesModel.getDescription());
            txtDate.setText(moviesModel.getDate());
            int count = (int) Math.floor((moviesModel.getScore() / 100.0) * 5);
            countStar(count);
            showStar(count);
            txtDes.setMovementMethod(new ScrollingMovementMethod());
            if (getSupportActionBar() != null) {
                getSupportActionBar().setDisplayHomeAsUpEnabled(true);
                getSupportActionBar().setTitle(moviesModel.getTitle());

            }
        }
    }

    private ImageView[] countStar(int count) {
        ImageView[] starimg = new ImageView[count];
        for (int i = 0; i < count; i++) {
            ImageView star = new ImageView(this);
            star.setMaxWidth(20);
            star.setMaxHeight(20);
            star.setImageResource(R.drawable.ic_star_black_24dp);
            starimg[i] = star;
        }
        return starimg;
    }

    private void showStar(int count) {
        LinearLayout linearLayout = findViewById(R.id.container_count);
        for (int i = 0; i < count; i++) {
            linearLayout.addView(countStar(count)[i]);
        }
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return super.onSupportNavigateUp();
    }
}
