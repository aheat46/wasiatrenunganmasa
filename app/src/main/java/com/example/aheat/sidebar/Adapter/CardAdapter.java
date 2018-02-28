package com.example.aheat.sidebar.Adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.BottomSheetDialogFragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.aheat.sidebar.Helper.DatabaseModel;
import com.example.aheat.sidebar.R;
import com.example.aheat.sidebar.fragment.BottomSheetFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by aheat on 6/10/17.
 */

public class CardAdapter extends RecyclerView.Adapter<CardAdapter.RecyclerViewHolder> {

    static List<DatabaseModel> dbList;
    static Context context;


    public CardAdapter(Context context, List<DatabaseModel> dbList){
        this.context = context;
        this.dbList = new ArrayList<>();
        this.dbList = dbList;

    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_adapter, parent, false);

        return new RecyclerViewHolder(view);
    }


    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, int position) {

        holder.judul.setText(dbList.get(position).getJudul());

    }


    @Override
    public int getItemCount() {
        return dbList.size();
    }


    public static class RecyclerViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView judul;
        ImageView image;


        RecyclerViewHolder(View view){
            super(view);

            image = view.findViewById(R.id.icon);
            judul = view.findViewById(R.id.judul);

            view.setOnClickListener(this);

        }

        @Override
        public void onClick(View view) {

            Bundle bundle = new Bundle();
            bundle.putInt("position", getAdapterPosition());


            BottomSheetDialogFragment bottomSheetDialogFragment = new BottomSheetFragment();
            bottomSheetDialogFragment.setArguments(bundle);
            bottomSheetDialogFragment.show(((FragmentActivity)context).getSupportFragmentManager(), bottomSheetDialogFragment.getTag());

        }

    }
}
