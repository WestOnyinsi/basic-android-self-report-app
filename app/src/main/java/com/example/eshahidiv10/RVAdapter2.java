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

public class RVAdapter2 extends RecyclerView.Adapter<RVAdapter.ViewHolder> {

    // variable for our array list and context
    private ArrayList<Modal> ModalArrayList;
    private Context context;

    // constructor
    public RVAdapter2(ArrayList<Modal> ModalArrayList, Context context) {
        this.ModalArrayList = ModalArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public RVAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // on below line we are inflating our layout
        // file for our recycler view items.
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_rv_item, parent, false);
        return new RVAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RVAdapter.ViewHolder holder, int position) {
        // on below line we are setting data
        // to our views of recycler view item.
        Modal modal = ModalArrayList.get(position);
        holder.activityNameTV.setText(modal.getActivityName());
        holder.activityDateTV.setText(modal.getActivityDate());
        holder.activityLocationTV.setText(modal.getActivityLocation());
        holder.activityTimeTV.setText(modal.getActivityTime());
        holder.activityReporterTV.setText(modal.getActivityReporter());
        holder.activityDescriptionTV.setText(modal.getActivityDescription());

    }

    @Override
    public int getItemCount() {
        // returning the size of our array list
        return ModalArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        // creating variables for our text views.
        private TextView activityNameTV, activityLocationTV, activityDateTV, activityReporterTV, activityTimeTV , activityDescriptionTV;

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
