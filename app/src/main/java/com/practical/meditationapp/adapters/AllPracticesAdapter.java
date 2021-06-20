package com.practical.meditationapp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.practical.meditationapp.R;
import com.practical.meditationapp.interfaces.MusicInterface;
import com.practical.meditationapp.model.AllPracticesModel;

import java.util.ArrayList;

public class AllPracticesAdapter extends RecyclerView.Adapter<AllPracticesAdapter.ViewHolder> {

    Context context;
    ArrayList<AllPracticesModel> list;
    MusicInterface musicInterface;

    public AllPracticesAdapter(Context context, ArrayList<AllPracticesModel> list, MusicInterface musicInterface) {
        this.context = context;
        this.list = list;
        this.musicInterface = musicInterface;
    }

    @NonNull
    @Override
    public AllPracticesAdapter.ViewHolder onCreateViewHolder(@NonNull  ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_music, parent, false);
        return new AllPracticesAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull  AllPracticesAdapter.ViewHolder holder, int position) {

        holder.lblMusicName.setText(list.get(position).getMusicName());
        holder.lblMusicTime.setText(list.get(position).getMusicTime());
        holder.imgMusicBg.setImageResource(list.get(position).getBg());
        holder.imgLike.setImageResource(list.get(position).getLike());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                musicInterface.onClick();
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView lblMusicName,lblMusicTime;
        ImageView imgMusicBg,imgLike;

        public ViewHolder(@NonNull  View itemView) {
            super(itemView);

            lblMusicName = itemView.findViewById(R.id.lblMusicName);
            lblMusicTime = itemView.findViewById(R.id.lblMusicTime);
            imgMusicBg = itemView.findViewById(R.id.imgMusicBg);
            imgLike = itemView.findViewById(R.id.imgLike);
        }
    }
}
