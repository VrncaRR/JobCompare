package edu.gatech.seclass.jobcompare6300;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CompareSettings extends AppCompatActivity {
    private EditText entrySalaryWeight;
    private EditText entryBonusWeight;
    private EditText entryRSUWeight;
    private EditText entryReloWeight;
    private EditText entryPCHWeight;

    private DatabaseHelper dbHelper;
    private ComparisonSettings settings = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compare_settings);


        //Initialize Edit Text Fields
        entrySalaryWeight = (EditText) findViewById(R.id.entrySalaryWeight);
        entryBonusWeight = (EditText) findViewById(R.id.entryBonusWeight);
        entryRSUWeight = (EditText) findViewById(R.id.entryRSUWeight);
        entryReloWeight = (EditText) findViewById(R.id.entryReloWeight);
        entryPCHWeight = (EditText) findViewById(R.id.entryPCHWeight);


        dbHelper = new DatabaseHelper(CompareSettings.this);
        //get current comparison setting, if no, get default comparison setting
        settings = dbHelper.getCurrentSetting();

        entrySalaryWeight.setText(String.valueOf(settings.getSalaryWeight()));
        entryBonusWeight.setText(String.valueOf(settings.getBonusWeight()));
        entryRSUWeight.setText(String.valueOf(settings.getRSUWeight()));
        entryReloWeight.setText(String.valueOf(settings.getRelocationStipendWeight()));
        entryPCHWeight.setText(String.valueOf(settings.getPTOWeight()));

        configureSettingsCancelButton();
        handleSaveSettings();
    }

    public void handleSaveSettings(){
        Button saveSettings = (Button) findViewById(R.id.saveSettingsButton);
        saveSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String ERROR_MESSAGE = "Invalid Entry";
                Boolean error = false;

                try {
                    int salaryWeight = Integer.parseInt(entrySalaryWeight.getText().toString());
                    int bonusWeight = Integer.parseInt(entryBonusWeight.getText().toString());
                    int rSUWeight = Integer.parseInt(entryRSUWeight.getText().toString());
                    int reloWeight = Integer.parseInt(entryReloWeight.getText().toString());
                    int pCHWeight = Integer.parseInt(entryPCHWeight.getText().toString());

                    //TODO: Add Any Input Error Checking Here
                    //TODO: change xml file, set text field type to number
                    if(!error){
                        //TODO: ADD Actions for savings Settings here
                        //create new setting object
                        ComparisonSettings newSettings = new ComparisonSettings(salaryWeight, bonusWeight, rSUWeight, reloWeight, pCHWeight);

                        if(dbHelper.updateComparisonSetting(newSettings)) {
                            Toast.makeText(CompareSettings.this, "Successfully update settings!", Toast.LENGTH_LONG).show();
                        } else {
                            Toast.makeText(CompareSettings.this, "fail to update settings, please check!", Toast.LENGTH_LONG).show();
                        }
                    }
                }   catch(Exception e) {
                    Toast.makeText(CompareSettings.this, "Unable to update settings, please check input!", Toast.LENGTH_LONG).show();
                }
            }
        });
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