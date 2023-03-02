package edu.gatech.seclass.jobcompare6300;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class CurrentJob extends AppCompatActivity {
    //Declare EditText variables
    private EditText entryCurJobTitle;
    private EditText entryCurJobCompany;
    private EditText entryCurJobLocation;
    private EditText entryCurJobCOL;
    private EditText entryCurJobSalary;
    private EditText entryCurJobBonus;
    private EditText entryCurJobRSU;
    private EditText entryCurJobRelo;
    private EditText entryCurJobPCH;
    private TextView testingTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_current_job);

        //Initialize Edit Text Fields
        entryCurJobTitle = (EditText) findViewById(R.id.entryCurJobTitle);
        entryCurJobCompany = (EditText) findViewById(R.id.entryCurJobCompany);
        entryCurJobLocation = (EditText) findViewById(R.id.entryCurJobLocation);
        entryCurJobCOL = (EditText) findViewById(R.id.entryCurJobCOL);
        entryCurJobSalary = (EditText) findViewById(R.id.entryCurJobSalary);
        entryCurJobBonus = (EditText) findViewById(R.id.entryCurJobBonus);
        entryCurJobRSU = (EditText) findViewById(R.id.entryCurJobRSU);
        entryCurJobRelo = (EditText) findViewById(R.id.entryCurJobRelo);
        entryCurJobPCH = (EditText) findViewById(R.id.entryCurJobPCH);
        testingTextView = (TextView) findViewById(R.id.testingTextView);

        configureCancelJobButton();
        configureSaveCurJobButton();
        handleSaveCurJob();
    }

    //Handle Save
    public void handleSaveCurJob(){
        Button SaveCurJobButton = (Button) findViewById(R.id.SaveCurJobButton);
        SaveCurJobButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String curJobTitle = entryCurJobTitle.getText().toString();
                String curJobCompany = entryCurJobCompany.getText().toString();
                String curJobLocation = entryCurJobLocation.getText().toString();
                String curJobCOL = entryCurJobCOL.getText().toString();
                String curJobSalary = entryCurJobSalary.getText().toString();
                String curJobBonus = entryCurJobBonus.getText().toString();
                String curJobRSU = entryCurJobRSU.getText().toString();
                String curJobRelo = entryCurJobRelo.getText().toString();
                String curJobPCH = entryCurJobPCH.getText().toString();

                Boolean error = false;
                //TODO: ADD Error Handling for Invalid Entries
                if (curJobTitle.length() == 0) {
                    CharSequence errorMessage = "Invalid Entry";
                    entryCurJobTitle.setError(errorMessage);
                    error = true;
                }
                if (curJobCompany.length() == 0) {
                    CharSequence errorMessage = "Invalid Entry";
                    entryCurJobCompany.setError(errorMessage);
                    error = true;
                }
                if (curJobLocation.length() == 0) {
                    CharSequence errorMessage = "Invalid Entry";
                    entryCurJobLocation.setError(errorMessage);
                    error = true;
                }
                if (curJobCOL.length() == 0) {
                    CharSequence errorMessage = "Invalid Entry";
                    entryCurJobCOL.setError(errorMessage);
                    error = true;
                }
                if (curJobSalary.length() == 0) {
                    CharSequence errorMessage = "Invalid Entry";
                    entryCurJobSalary.setError(errorMessage);
                    error = true;
                }
                if (curJobBonus.length() == 0) {
                    CharSequence errorMessage = "Invalid Entry";
                    entryCurJobBonus.setError(errorMessage);
                    error = true;
                }
                if (curJobRSU.length() == 0) {
                    CharSequence errorMessage = "Invalid Entry";
                    entryCurJobRSU.setError(errorMessage);
                    error = true;
                }
                if (curJobRelo.length() == 0) {
                    CharSequence errorMessage = "Invalid Entry";
                    entryCurJobRelo.setError(errorMessage);
                    error = true;
                }
                if (curJobPCH.length() == 0) {
                    CharSequence errorMessage = "Invalid Entry";
                    entryCurJobPCH.setError(errorMessage);
                    error = true;
                }
                if(!error) {
                    //TODO: Add create Current Job actions here
                }
            }
        });
    }

    public void configureCancelJobButton(){
        Button cancelJobButton = (Button) findViewById(R.id.CancelJobButton);
        cancelJobButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    public void configureSaveCurJobButton(){
        Button saveCurJobButton = (Button) findViewById(R.id.SaveCurJobButton);
        saveCurJobButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //TODO: Put Save Current Job Actions Here

            }
        });
    }
}