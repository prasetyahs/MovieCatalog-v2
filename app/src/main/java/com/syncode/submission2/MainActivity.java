package com.syncode.submission2;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.syncode.submission2.fragment.Frag_Movies;
import com.syncode.submission2.fragment.Frag_Tv_Movies;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {


    BottomNavigationView bottomNavigationView;

    FragmentManager fm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        Frag_Movies fragMovies = new Frag_Movies();
        fm = getSupportFragmentManager();
        Intent getIntentLang = getIntent();
        try {
            String lang = getIntentLang.getStringExtra("lang");
            setLanguage(lang);
        } catch (NullPointerException ex) {
            ex.getStackTrace();
        }
        FragmentTransaction ft = fm.beginTransaction();
        if (savedInstanceState == null) {
            ft.add(R.id.container, fragMovies);
            ft.commit();
        }
        bottomNavigationView.setSelectedItemId(R.id.m_movies);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.m_movies:
                        Frag_Movies fragMovies = new Frag_Movies();
                        replaceFragment(fragMovies);
                        return true;
                    case R.id.m_tv_movies:
                        Frag_Tv_Movies fragTvMovies = new Frag_Tv_Movies();
                        replaceFragment(fragTvMovies);
                        return true;
                }

                return false;
            }
        });
    }


    public void replaceFragment(Fragment frag) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.container, frag, frag.getClass().getSimpleName());
        ft.commit();
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.m_language) {
            Intent gotoLanguage = new Intent(MainActivity.this, ActivityLanguage.class);
            startActivity(gotoLanguage);
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.options_menu, menu);
        return true;
    }

    @Override
    public void onBackPressed() {
        if (bottomNavigationView.getSelectedItemId() == R.id.m_movies) {
            super.onBackPressed();
        } else {
            bottomNavigationView.setSelectedItemId(R.id.m_movies);
        }
    }

    public void setLanguage(String language) {
        Locale locale = new Locale(language);
        Resources res = getResources();
        DisplayMetrics dm = res.getDisplayMetrics();
        Configuration configuration = res.getConfiguration();
        configuration.locale = locale;
        res.updateConfiguration(configuration, dm);
    }
}
