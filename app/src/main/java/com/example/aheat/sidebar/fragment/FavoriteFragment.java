package com.example.aheat.sidebar.fragment;


import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ListView;
import android.widget.Toolbar;

import com.example.aheat.sidebar.R;

/**
 * Created by aheat on 1/15/18.
 */

public class FavoriteFragment extends Fragment {

    ListView mListView;
    Adapter mAdapter;

    SharedPreferences preferences;


    @Override
    public void onStart() {
        super.onStart();

        preferences = getContext().getSharedPreferences("preferences", 0);

        Log.d("TAG",  "judul" + preferences.getString("judul", null));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.list_favorite, container, false);

        return view;
    }

}
