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

                    if(!error){
                        //TODO: ADD Actions for savings Settings here
                        Toast.makeText(CompareSettings.this, "Successfully update settings!", Toast.LENGTH_LONG).show();
                    }
                }   catch(Exception e) {
                    Toast.makeText(CompareSettings.this, "Unable to update settings, please check input!", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

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