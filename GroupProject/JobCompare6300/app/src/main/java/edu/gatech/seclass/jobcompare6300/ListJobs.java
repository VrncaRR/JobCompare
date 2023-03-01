package edu.gatech.seclass.jobcompare6300;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ListJobs extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_jobs);

        configureListMainMenuButton();
        configureCompareButton();
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