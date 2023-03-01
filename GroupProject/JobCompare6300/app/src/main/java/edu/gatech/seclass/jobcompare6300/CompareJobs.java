package edu.gatech.seclass.jobcompare6300;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class CompareJobs extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compare_jobs);

        configureCompareMainMenuButton();
        configureAnotherButton();
    }

    public void configureCompareMainMenuButton(){
        Button compareMainMenuButton = (Button) findViewById(R.id.CompareMainMenuButton);
        compareMainMenuButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    public void configureAnotherButton(){
        Button compareAnotherButton = (Button) findViewById(R.id.SettingsSaveButton);
        compareAnotherButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}