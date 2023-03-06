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
    private ArrayList<Integer> selectedJobs = new ArrayList<>();


    public jobListAdapter(List<Job> jobList) {
        this.jobList = jobList;
    }

    //view holder class
    class jobViewHolder extends RecyclerView.ViewHolder{

        private TextView titleText;
        private TextView companyText;

        private TextView currentText;



        public jobViewHolder(final View view) {
            super(view);
            titleText = view.findViewById(R.id.titleView);
            companyText = view.findViewById(R.id.companyView);
            currentText = view.findViewById(R.id.isCurrentView);

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

        final Job job = jobList.get(position);
        String current = job.isCurrentJob()? "Yes":"";
        holder.titleText.setText(job.getTitle());
        holder.companyText.setText(job.getCompany());
        holder.currentText.setText(current);


        //set color if selected
        holder.itemView.setBackgroundColor(job.isSelected()? Color.GREEN: Color.TRANSPARENT);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                onClickItem(holder, job, selectedJobs);
            }
        });

    }


    void onClickItem(@NonNull jobListAdapter.jobViewHolder holder, Job job, ArrayList<Integer> selectedJobs) {

        //click item, select or deselect the item, change color
        job.setSelected(!job.isSelected());
        holder.itemView.setBackgroundColor(job.isSelected()? Color.GREEN: Color.TRANSPARENT);


        if(job.isSelected()) {

            //item is selected, add the position to selectedJobs arraylist
            selectedJobs.add(holder.getAdapterPosition());
        } else {

            //deselected, remove the position from selectedJobs
            //since these are only two items in the list, check index 0 and 1 respectively
            if(selectedJobs.get(0) == holder.getAdapterPosition()) {
                selectedJobs.remove(0);
            } else {
                selectedJobs.remove(selectedJobs.size()-1);
            }
        }


        if(job.isSelected() && selectedJobs.size()>2) {

            //if there are already two jobs selected, set the job selected false
            jobList.get(selectedJobs.get(0)).setSelected(false);

            //Notify any registered observers that the item at position has changed, to change color
            notifyItemChanged(selectedJobs.get(0));

            //remove job position from the list
            selectedJobs.remove(0);
        }
    }

    public ArrayList<Job> getSelectedJob(){

        ArrayList<Job> list = new ArrayList<>();

        for(int i: selectedJobs) {
            list.add(jobList.get(i));
        }

        return list;
    }



}