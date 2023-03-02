package edu.gatech.seclass.jobcompare6300;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class CompareSettings extends AppCompatActivity {

    DatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compare_settings);



        configureSettingsCancelButton();
    }

    //create comparisonSetting object
    //save comparisonSetting to db
    //add score to Job attribute, but don't save it to database
    //when rank job offers, get all the job offer from database
    //user the second constructor (constructor that has score in it)to create job offer
    //list.sort() to sort list


    public void configureSettingsCancelButton(){
        Button settingsCancelButton = (Button) findViewById(R.id.SettingsCancelButton);
        settingsCancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}