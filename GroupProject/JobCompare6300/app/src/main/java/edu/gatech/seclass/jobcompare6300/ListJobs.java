package edu.gatech.seclass.jobcompare6300;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ListJobs extends AppCompatActivity {
    private List<Job> jobList;
    private RecyclerView recyclerView;
    private DatabaseHelper dbHelper;

    jobListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_jobs);

        recyclerView = findViewById(R.id.recyclerView1);
        dbHelper = new DatabaseHelper(ListJobs.this);
        jobList = dbHelper.getAll();

        setAdapter();

        configureListMainMenuButton();
        configureCompareButton();
    }


    void setAdapter(){
        Log.d("adaptertag", "adapter");
        adapter = new jobListAdapter(jobList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);

        List<Job> chosenJobs = adapter.getSelectedJob();
        Log.d("JOBTAG", "chosen job entry");
        for (Job chosenJob : chosenJobs) {
            Log.d("JOBTAG", "chosen job " + chosenJob.getTitle());
        }
    }

    public void configureListMainMenuButton(){
        Button listMainMenuButton = (Button) findViewById(R.id.ListMainMenuButton);
        listMainMenuButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    public void configureCompareButton(){
        Button compareButton = (Button) findViewById(R.id.CompareButton);
        compareButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ArrayList<Job> listJobsToCompare = adapter.getSelectedJob();
                if(listJobsToCompare.size()< 2) {
                    Toast.makeText(ListJobs.this, "Please select two jobs to compare", Toast.LENGTH_LONG).show();
                } else {

                    Intent intent = new Intent(ListJobs.this, CompareJobs.class);
                    intent.putParcelableArrayListExtra("jobList", listJobsToCompare);

                    startActivity(intent);
                }

            }
        });
    }

    // helper for loading data into arraylist bundle
    public ArrayList<String> processJobData(Job jobToProcess, ArrayList<String> jobDataHolder) {

        jobDataHolder.add(jobToProcess.getTitle());
        jobDataHolder.add(jobToProcess.getCompany());
        jobDataHolder.add(jobToProcess.getLocation());
        jobDataHolder.add(String.valueOf(jobToProcess.getCostOfLiving()));
        jobDataHolder.add(String.valueOf(jobToProcess.getYearlySalaryAdjusted()));
        jobDataHolder.add(String.valueOf(jobToProcess.getYearlyBonusAdjusted()));
        jobDataHolder.add(String.valueOf(jobToProcess.getRsu()));
        jobDataHolder.add(String.valueOf(jobToProcess.getRelocationStipend()));
        jobDataHolder.add(String.valueOf(jobToProcess.getPto()));

        return jobDataHolder;
    } //end processJobData()

} //end class ListJobs



