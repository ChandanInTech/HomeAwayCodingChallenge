package com.example.kurella.homeawaycodingchallenge.view;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.kurella.homeawaycodingchallenge.R;
import com.example.kurella.homeawaycodingchallenge.model.RvItemPojo;
import com.squareup.picasso.Picasso;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    List<RvItemPojo> rvData;
    Context context;

    private static final String TAG = "MyAdapter";

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView title, location, date;
        ImageView imageView, favIcon;
        public MyViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            title = itemView.findViewById(R.id.tv_title);
            location = itemView.findViewById(R.id.tv_location);
            date = itemView.findViewById(R.id.tv_time);
            imageView = itemView.findViewById(R.id.imageView);
            favIcon = itemView.findViewById(R.id.imageView2);
        }

        @Override
        public void onClick(View view) {
            Intent i = new Intent(context, ItemDetailsActivity.class);
            i.putExtra("pass", rvData.get(getAdapterPosition()));
            context.startActivity(i);
        }
    }

    public MyAdapter(List<RvItemPojo> rvData, Context context) {
        this.rvData = rvData;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_item, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        RvItemPojo item = rvData.get(position);
        holder.title.setText(item.getTitle());
        holder.location.setText(item.getLocation());
        holder.date.setText(item.getDate());
        if (!item.getIsFav())
            holder.favIcon.setVisibility(View.INVISIBLE);
        Picasso.get()
                .load(item.getImageUrl())
                .placeholder(R.drawable.ic_launcher_foreground)
                .error(R.drawable.ic_launcher_foreground)
                .transform(new CircleTransform())
                .into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        if(rvData == null)
            return 0;
        else
            return rvData.size();
    }

}
