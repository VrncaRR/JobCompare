package edu.gatech.seclass.jobcompare6300;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

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
        jobListAdapter adapter = new jobListAdapter(jobList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
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

                startActivity(new Intent(ListJobs.this, CompareJobs.class));
            }
        });
    }

}