package com.example.aheat.sidebar.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.aheat.sidebar.Adapter.CardAdapter;
import com.example.aheat.sidebar.Helper.DBHelper;
import com.example.aheat.sidebar.Helper.DatabaseModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by aheat on 12/26/17.
 */

public class HomeFragment extends Fragment {

    LinearLayoutManager linearLayoutManager;
    CardAdapter adapter;
    DBHelper dbHelper;
    List<DatabaseModel> dbList;
    RecyclerView recyclerView;

    @Override
    public void onCreate(Bundle  savedInstaceState) {
        super.onCreate(savedInstaceState);

        dbHelper = new DBHelper(getActivity());
        dbList = new ArrayList<>();
        dbList= dbHelper.getDataFromDB();

        linearLayoutManager = new LinearLayoutManager(getActivity());

        recyclerView = new RecyclerView(getActivity());
        adapter = new CardAdapter(getActivity(), dbList);

    }

    @Override
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup contaner, Bundle savedInstanceState) {
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter);

        return recyclerView;

    }

}
