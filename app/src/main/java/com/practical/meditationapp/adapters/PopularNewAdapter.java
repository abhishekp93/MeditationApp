package com.practical.meditationapp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.practical.meditationapp.R;
import com.practical.meditationapp.model.PopularNewListModel;

import java.util.ArrayList;

public class PopularNewAdapter extends RecyclerView.Adapter<PopularNewAdapter.ViewHolder> {

    Context context;
    ArrayList<PopularNewListModel> list;

    public PopularNewAdapter(Context context, ArrayList<PopularNewListModel> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public PopularNewAdapter.ViewHolder onCreateViewHolder(@NonNull  ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_popular_new_list, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull  PopularNewAdapter.ViewHolder holder, int position) {

        holder.imagePopular.setImageResource(list.get(position).getImage());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imagePopular;

        public ViewHolder(@NonNull  View itemView) {
            super(itemView);

            imagePopular = itemView.findViewById(R.id.imagePopular);
        }
    }
}
