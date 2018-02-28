package com.example.aheat.sidebar.Adapter;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.BottomSheetDialogFragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.aheat.sidebar.Helper.DatabaseModel;
import com.example.aheat.sidebar.R;
import com.example.aheat.sidebar.fragment.BottomSheetFragment;

import java.util.ArrayList;

/**
 * Created by aheat on 1/15/18.
 */

public class ListAdapter extends BaseAdapter {

    Context context;
    ArrayList<DatabaseModel> databaseModels;
    TextView judul;

    public ListAdapter(Context context, ArrayList<DatabaseModel> dataModel) {
        this.context = context;
        this.databaseModels = dataModel;
    }

    @Override
    public int getCount() {
        return databaseModels.size();
    }

    @Override
    public Object getItem(int position) {
        return databaseModels.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup container) {
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.item_data_favorite, container, false);
        }

        judul = view.findViewById(R.id.list_title);

        final DatabaseModel s = (DatabaseModel) this.getItem(position);
        judul.setText(s.getJudul());

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDetail(s.getJudul(), s.getIsi());
            }
        });

        return view;
    }

    private void openDetail(String judul, String isi) {

        Bundle bundle = new Bundle();
        bundle.putString("judul", judul);
        bundle.putString("isi", isi);

        BottomSheetDialogFragment bottomSheetDialogFragment= new BottomSheetDialogFragment();
        bottomSheetDialogFragment.setArguments(bundle);
        bottomSheetDialogFragment.show(((FragmentActivity)context).getSupportFragmentManager(), bottomSheetDialogFragment.getTag());
    }
}
