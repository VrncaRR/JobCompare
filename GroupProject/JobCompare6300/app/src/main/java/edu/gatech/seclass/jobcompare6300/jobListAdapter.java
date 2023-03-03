package edu.gatech.seclass.jobcompare6300;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class jobListAdapter extends RecyclerView.Adapter<jobListAdapter.jobViewHolder> {

    private List<Job> jobList;
    private ArrayList<Job> selectedJobs = new ArrayList<>();


    public jobListAdapter(List<Job> jobList) {
        this.jobList = jobList;
    }

    //view holder class
    class jobViewHolder extends RecyclerView.ViewHolder{

        private TextView titleText;
        private TextView companyText;
        private TextView scoreText;
        private TextView currentText;



        public jobViewHolder(final View view) {
            super(view);
            titleText = view.findViewById(R.id.titleView);
            companyText = view.findViewById(R.id.companyView);
            currentText = view.findViewById(R.id.isCurrentView);
            scoreText = view.findViewById(R.id.scoreView);
        }

    }

    @NonNull
    @Override
    public jobListAdapter.jobViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);

        return new jobViewHolder(itemView);
    }

    @Override
    public int getItemCount() {
        return jobList.size();
    }

    public List<Job> getSelectedJobs() {
        return selectedJobs;
    }

    @Override
    public void onBindViewHolder(@NonNull jobListAdapter.jobViewHolder holder, int position) {
        Job job = jobList.get(position);
        holder.titleText.setText(job.getTitle());
        holder.companyText.setText(job.getCompany());
        holder.currentText.setText(String.valueOf(job.isCurrentJob()));
        holder.scoreText.setText(String.valueOf(job.getScore()));


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClick(holder, position);
            }
        });

    }

    public void onItemClick(@NonNull jobListAdapter.jobViewHolder holder, int position) {
        Job job = jobList.get(position);
        if (!selectedJobs.contains(job)) {
            selectedJobs.add(job);
            holder.itemView.setBackgroundColor(Color.GREEN);
        }
        else {
            selectedJobs.remove(job);
            holder.itemView.setBackgroundColor(Color.TRANSPARENT);
        }
    }

} //end jobListAdapter
