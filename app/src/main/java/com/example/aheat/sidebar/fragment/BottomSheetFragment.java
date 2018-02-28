package com.example.aheat.sidebar.fragment;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.BottomSheetDialogFragment;
import android.support.design.widget.CoordinatorLayout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.aheat.sidebar.Helper.DBHelper;
import com.example.aheat.sidebar.Helper.DatabaseModel;
import com.example.aheat.sidebar.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by aheat on 1/8/18.
 */

public class BottomSheetFragment extends BottomSheetDialogFragment {

    TextView judul, isi;
    ImageView action_close, action_favorite, action_share;

    DBHelper dbHelper;
    List<DatabaseModel> dbList;
    int position;
    String SHARED_PREFERENCES = "sharedpreferences";


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.detail_bottom_sheet, container, false);

        judul = view.findViewById(R.id.judul);
        isi = view.findViewById(R.id.isi);
        action_close = view.findViewById(R.id.action_close);
        action_favorite = view.findViewById(R.id.action_favorite);
        action_share = view.findViewById(R.id.action_share);

        position = getArguments().getInt("position");

        dbHelper = new DBHelper(getContext());
        dbList = new ArrayList<>();
        dbList = dbHelper.getDataFromDB();

        final String _judul = dbList.get(position).getJudul();
        final String _isi = dbList.get(position).getIsi();

        if (dbList.size() > 0) {
            judul.setText(_judul);
            isi.setText(_isi);
        }

        action_share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                actionShare(_isi);
            }
        });

        action_favorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sharedPreferences = getContext().getSharedPreferences(SHARED_PREFERENCES, 0);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("judul", _judul);
                editor.putString("isi", _isi);
                editor.commit();
            }
        });

        action_close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                actionClose();
            }
        });

        return view;
    }

    private void actionShare(String message) {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_SUBJECT, "Subject/Title");
        intent.putExtra(Intent.EXTRA_TEXT, message);
        startActivity(intent);
    }


    private void actionClose() {
        dismiss();
    }


}
