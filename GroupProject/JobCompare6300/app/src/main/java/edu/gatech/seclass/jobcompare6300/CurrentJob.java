package edu.gatech.seclass.jobcompare6300;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

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
    private Job currentJob = null;

    DatabaseHelper dbHelper;

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
        //testingTextView = (TextView) findViewById(R.id.testingTextView);



        //get current job
        dbHelper = new DatabaseHelper(CurrentJob.this);
        currentJob = dbHelper.getCurrentJob();

        //set current job attributes
        if(currentJob!=null) {
            entryCurJobTitle.setText(currentJob.getTitle());
            entryCurJobCompany.setText(currentJob.getCompany());
            entryCurJobLocation.setText(currentJob.getLocation());
            entryCurJobCOL.setText(String.valueOf(currentJob.getCostOfLiving()));
            entryCurJobSalary.setText(String.valueOf(currentJob.getYearlySalary()));
            entryCurJobBonus.setText(String.valueOf(currentJob.getYearlyBonus()));
            entryCurJobRSU.setText(String.valueOf(currentJob.getRsu()));
            entryCurJobRelo.setText(String.valueOf(currentJob.getRelocationStipend()));
            entryCurJobPCH.setText(String.valueOf(currentJob.getPto()));

        }


        configureCancelJobButton();
        configureSaveCurJobButton();
        handleSaveCurJob();
        configureJob2Main();
    }

    //Handle Save
    public void handleSaveCurJob(){
        Button SaveCurJobButton = (Button) findViewById(R.id.SaveCurJobButton);
        SaveCurJobButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String ERROR_MESSAGE = "Invalid Entry";
                Boolean error = false;

                try{
                    String offerTitle = entryCurJobTitle.getText().toString();
                    String offerCompany = entryCurJobCompany.getText().toString();
                    String offerLocation = entryCurJobLocation.getText().toString();
                    int offerCOL = Integer.parseInt(entryCurJobCOL.getText().toString());
                    float offerSalary = Float.parseFloat(entryCurJobSalary.getText().toString());
                    float offerBonus = Float.parseFloat(entryCurJobBonus.getText().toString());
                    float offerRSU = Float.parseFloat(entryCurJobRSU.getText().toString());
                    float offerRelo = Float.parseFloat(entryCurJobRelo.getText().toString());
                    int offerPCH = Integer.parseInt(entryCurJobPCH.getText().toString());

                    if (offerTitle.length() == 0) {
                        entryCurJobTitle.setError(ERROR_MESSAGE);
                        error = true;
                    }
                    if (offerCompany.length() == 0) {
                        entryCurJobCompany.setError(ERROR_MESSAGE);
                        error = true;
                    }
                    if (offerLocation.length() == 0) {
                        entryCurJobLocation.setError(ERROR_MESSAGE);
                        error = true;
                    }
                    if (!error) {
                        Job newOffer = new Job(offerTitle, offerCompany, offerLocation,
                                offerCOL, offerSalary, offerBonus, offerRSU, offerRelo, offerPCH, true);


                        //check if current job is created, if so, update current job, else create new current job
                        if(currentJob!= null) {
                            //update current job
                            if(dbHelper.updateCurrentJob(newOffer)) {
                                Toast.makeText(CurrentJob.this, "Successfully update current Job!", Toast.LENGTH_LONG).show();
                            } else {
                                Toast.makeText(CurrentJob.this, "fail to add current job to db", Toast.LENGTH_LONG).show();
                            }

                        }
                        else if(dbHelper.addJobOffer(newOffer)) {
                            Toast.makeText(CurrentJob.this, "Successfully modify the current job!", Toast.LENGTH_LONG).show();
                        } else {
                            Toast.makeText(CurrentJob.this, "fail to add db", Toast.LENGTH_LONG).show();
                        }
                    }
                }  catch(Exception e) {
                    Toast.makeText(CurrentJob.this, "Unable to add new job offer, please check input!", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    public void configureCancelJobButton(){
        Button cancelJobButton = (Button) findViewById(R.id.CancelJobButton);
        cancelJobButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //get current job
                dbHelper = new DatabaseHelper(CurrentJob.this);
                currentJob = dbHelper.getCurrentJob();

                //set current job attributes
                entryCurJobTitle.setText(currentJob.getTitle());
                entryCurJobCompany.setText(currentJob.getCompany());
                entryCurJobLocation.setText(currentJob.getLocation());
                entryCurJobCOL.setText(String.valueOf(currentJob.getCostOfLiving()));
                entryCurJobSalary.setText(String.valueOf(currentJob.getYearlySalary()));
                entryCurJobBonus.setText(String.valueOf(currentJob.getYearlyBonus()));
                entryCurJobRSU.setText(String.valueOf(currentJob.getRsu()));
                entryCurJobRelo.setText(String.valueOf(currentJob.getRelocationStipend()));
                entryCurJobPCH.setText(String.valueOf(currentJob.getPto()));
            }
        });
    }

    public void configureJob2Main(){
        Button job2Main = (Button) findViewById(R.id.job2Main);
        job2Main.setOnClickListener(new View.OnClickListener() {
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