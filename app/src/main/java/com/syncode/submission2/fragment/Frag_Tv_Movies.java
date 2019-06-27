package com.syncode.submission2.fragment;


import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.syncode.submission2.Model.MoviesModel;
import com.syncode.submission2.R;
import com.syncode.submission2.adapter.AdapterMovies;

import java.util.ArrayList;
import java.util.List;


public class Frag_Tv_Movies extends Fragment {


    private String[] title;
    private String[] description;
    private TypedArray img;
    private String[] date;
    private String[] runtime;

    private int[] score;
    private AdapterMovies adapterMovies;


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        RecyclerView rc = view.findViewById(R.id.rv_tv_movies);
        RecyclerView.LayoutManager lm = new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false);
        prepareSetData();
        if (setData().size() > 0) {
            adapterMovies = new AdapterMovies(setData(), this.getContext());
        }
        rc.setLayoutManager(lm);
        rc.setAdapter(adapterMovies);

    }

    private List<MoviesModel> setData() {
        List<MoviesModel> listMovies = new ArrayList<>();
        for (int i = 0; i < title.length; i++) {
            listMovies.add(new MoviesModel(title[i], img.getResourceId(i, 0), date[i], description[i], score[i], runtime[i]));
        }
        return listMovies;
    }

    private void prepareSetData() {
        title = getResources().getStringArray(R.array.tv_movie_title);
        date = getResources().getStringArray(R.array.tv_movie_date);
        img = getResources().obtainTypedArray(R.array.tv_movie_img);
        description = getResources().getStringArray(R.array.tv_movie_desc);
        runtime = getResources().getStringArray(R.array.tv_movie_minutes);
        score = getResources().getIntArray(R.array.tv_movie_score);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_tv__movies, container, false);
    }

}
