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

import java.util.ArrayList;
import java.util.List;

public class ListJobs extends AppCompatActivity {
    private List<Job> jobList;
    private RecyclerView recyclerView;
    private DatabaseHelper dbHelper;

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
        jobListAdapter adapter = new jobListAdapter(jobList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);

        List<Job> chosenJobs = adapter.getSelectedJobs();
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
                List<Job> selections = ((jobListAdapter) recyclerView.getAdapter()).getSelectedJobs();

                // to load to the bundle
                ArrayList<String> firstJob = new ArrayList<>();
                processJobData(selections.get(0), firstJob);
                ArrayList<String> secondJob = new ArrayList<>();
                processJobData(selections.get(1), secondJob);

                Intent i = new Intent(ListJobs.this, CompareJobs.class);
                Bundle extras = new Bundle();
                extras.putStringArrayList("First", firstJob);
                extras.putStringArrayList("Second", secondJob);
                i.putExtras(extras);
                startActivity(i);
//                startActivity(new Intent(ListJobs.this, CompareJobs.class));
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



