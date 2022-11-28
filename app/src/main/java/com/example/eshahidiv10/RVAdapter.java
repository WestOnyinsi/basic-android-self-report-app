package com.example.eshahidiv10;


import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RVAdapter extends RecyclerView.Adapter<RVAdapter.ViewHolder> {

    // variable for our array list and context
    private ArrayList<Modal> ModalArrayList;
    private Context context;

    // constructor
    public RVAdapter(ArrayList<Modal> ModalArrayList, Context context) {
        this.ModalArrayList = ModalArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // on below line we are inflating our layout
        // file for our recycler view items.
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_rv_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        // on below line we are setting data
        // to our views of recycler view item.
        Modal modal = ModalArrayList.get(position);
        holder.activityNameTV.setText(modal.getActivityName());
        holder.activityDateTV.setText(modal.getActivityDate());
        holder.activityLocationTV.setText(modal.getActivityLocation());
        holder.activityTimeTV.setText(modal.getActivityTime());
        holder.activityReporterTV.setText(modal.getActivityReporter());
        holder.activityDescriptionTV.setText(modal.getActivityDescription());

        // below line is to add on click listener for our recycler view item.
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // on below line we are calling an intent.
                Intent i = new Intent(context, UpdateActivity.class);

                // below we are passing all our values.
                i.putExtra("name", modal.getActivityName());
                i.putExtra("date", modal.getActivityDate());
                i.putExtra("location", modal.getActivityLocation());
                i.putExtra("time", modal.getActivityTime());
                i.putExtra("reporter", modal.getActivityReporter());
                i.putExtra("description", modal.getActivityDescription());


                // starting our activity.
                context.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        // returning the size of our array list
        return ModalArrayList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        // creating variables for our text views.
        public TextView activityNameTV;
        public TextView activityLocationTV;
        public TextView activityDateTV;
        public TextView activityReporterTV;
        public TextView activityTimeTV;
        public TextView activityDescriptionTV;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            // initializing our text views
            activityNameTV = itemView.findViewById(R.id.idTVActivityName);
            activityDateTV = itemView.findViewById(R.id.idTVActivityDate);
            activityLocationTV = itemView.findViewById(R.id.idTVActivityLocation);
            activityTimeTV = itemView.findViewById(R.id.idTVActivityTime);
            activityReporterTV = itemView.findViewById(R.id.idTVActivityReporter);
            activityDescriptionTV = itemView.findViewById(R.id.idTVActivityDescription);
        }
    }
}
