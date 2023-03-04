package edu.gatech.seclass.jobcompare6300;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;



public class CompareJobs extends AppCompatActivity {

    private EditText firstTitle;
    private EditText secondTitle;
    private EditText firstCompany;
    private EditText secondCompany;
    private EditText firstLoc;
    private EditText secondLoc;
    private EditText firstCOL;
    private EditText secondCOL;
    private EditText firstSalary;
    private EditText secondSalary;
    private EditText firstBonus;
    private EditText secondBonus;
    private EditText firstRSU;
    private EditText secondRSU;
    private EditText firstStipend;
    private EditText secondStipend;
    private EditText firstPTO;
    private EditText secondPTO;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compare_jobs);

        //Unpack bundle
        Intent in = getIntent();
        ArrayList<Job> selectedJobs = in.getParcelableArrayListExtra("jobList");
        Job firstJob = selectedJobs.get(0), secondJob = selectedJobs.get(1);
        setValue(firstJob,  secondJob);


        configureCompareMainMenuButton();
        configureAnotherButton();
    }

    void setValue(Job firstJob, Job secondJob) {

        firstTitle = (EditText) findViewById(R.id.J1Title);
        secondTitle = (EditText) findViewById(R.id.J2Title);
        firstCompany = (EditText) findViewById(R.id.J1Company);
        secondCompany = (EditText) findViewById(R.id.J2Company);
        firstLoc = (EditText) findViewById(R.id.J1Loc);
        secondLoc = (EditText) findViewById(R.id.J2Loc);
        firstCOL = (EditText) findViewById(R.id.J1COL);
        secondCOL = (EditText) findViewById(R.id.J2COL);
        firstSalary = (EditText) findViewById(R.id.J1Salary);
        secondSalary = (EditText) findViewById(R.id.J2Salary);
        firstBonus = (EditText) findViewById(R.id.J1Bonus);
        secondBonus = (EditText) findViewById(R.id.J2Bonus);
        firstRSU = (EditText) findViewById(R.id.J1RSU);
        secondRSU = (EditText) findViewById(R.id.J2RSU);
        firstStipend = (EditText) findViewById(R.id.J1Relo);
        secondStipend = (EditText) findViewById(R.id.J2Relo);
        firstPTO = (EditText) findViewById(R.id.J1Holiday);
        secondPTO = (EditText) findViewById(R.id.J2Holiday);


        firstTitle.setText(firstJob.getTitle());
        firstCompany.setText(firstJob.getCompany());
        firstLoc.setText(firstJob.getLocation());
        firstCOL.setText(String.valueOf(firstJob.getCostOfLiving()));
        firstSalary.setText(String.valueOf(firstJob.getYearlySalaryAdjusted()));
        firstBonus.setText(String.valueOf(firstJob.getYearlyBonusAdjusted()));
        firstRSU.setText(String.valueOf(firstJob.getRsu()));
        firstStipend.setText(String.valueOf(firstJob.getRelocationStipend()));
        firstPTO.setText(String.valueOf(firstJob.getPto()));


        secondTitle.setText(secondJob.getTitle());
        secondCompany.setText(secondJob.getCompany());
        secondLoc.setText(secondJob.getLocation());
        secondCOL.setText(String.valueOf(secondJob.getCostOfLiving()));
        secondSalary.setText(String.valueOf(secondJob.getYearlySalaryAdjusted()));
        secondBonus.setText(String.valueOf(secondJob.getYearlyBonusAdjusted()));
        secondRSU.setText(String.valueOf(secondJob.getRsu()));
        secondStipend.setText(String.valueOf(secondJob.getRelocationStipend()));
        secondPTO.setText(String.valueOf(secondJob.getPto()));

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
        Button compareAnotherButton = (Button) findViewById(R.id.SaveCurJobButton);
        compareAnotherButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clearDataFields();
//                finish();
            }
        });
    }

    public void clearDataFields(){
        firstTitle.setText("");
        firstCompany.setText("");
        firstLoc.setText("");
        firstCOL.setText("");
        firstSalary.setText("");
        firstBonus.setText("");
        firstRSU.setText("");
        firstStipend.setText("");
        firstPTO.setText("");
    }
}