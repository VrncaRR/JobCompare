package edu.gatech.seclass.jobcompare6300;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class jobListAdapter extends RecyclerView.Adapter<jobListAdapter.jobViewHolder> {

    private List<Job> jobList;

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

    @Override
    public void onBindViewHolder(@NonNull jobListAdapter.jobViewHolder holder, int position) {

        Job job = jobList.get(position);
        holder.titleText.setText(job.getTitle());
        holder.companyText.setText(job.getCompany());
        holder.currentText.setText(String.valueOf(job.isCurrentJob()));
        holder.scoreText.setText(String.valueOf(job.getScore()));

    }


}