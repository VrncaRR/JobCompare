package edu.gatech.seclass.jobcompare6300;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class CompareJobs extends AppCompatActivity {

    private TextView firstTitle;
    private TextView secondTitle;
    private TextView firstCompany;
    private TextView secondCompany;
    private TextView firstLoc;
    private TextView secondLoc;
    private TextView firstCOL;
    private TextView secondCOL;
    private TextView firstSalary;
    private TextView secondSalary;
    private TextView firstBonus;
    private TextView secondBonus;
    private TextView firstRSU;
    private TextView secondRSU;
    private TextView firstStipend;
    private TextView secondStipend;
    private TextView firstPTO;
    private TextView secondPTO;


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

        firstTitle = (TextView) findViewById(R.id.J1Title);
        secondTitle = (TextView) findViewById(R.id.J2Title);
        firstCompany = (TextView) findViewById(R.id.J1Company);
        secondCompany = (TextView) findViewById(R.id.J2Company);
        firstLoc = (TextView) findViewById(R.id.J1Loc);
        secondLoc = (TextView) findViewById(R.id.J2Loc);
        firstCOL = (TextView) findViewById(R.id.J1COL);
        secondCOL = (TextView) findViewById(R.id.J2COL);
        firstSalary = (TextView) findViewById(R.id.J1Salary);
        secondSalary = (TextView) findViewById(R.id.J2Salary);
        firstBonus = (TextView) findViewById(R.id.J1Bonus);
        secondBonus = (TextView) findViewById(R.id.J2Bonus);
        firstRSU = (TextView) findViewById(R.id.J1RSU);
        secondRSU = (TextView) findViewById(R.id.J2RSU);
        firstStipend = (TextView) findViewById(R.id.J1Relo);
        secondStipend = (TextView) findViewById(R.id.J2Relo);
        firstPTO = (TextView) findViewById(R.id.J1Holiday);
        secondPTO = (TextView) findViewById(R.id.J2Holiday);


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
                Intent intent = new Intent(CompareJobs.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    public void configureAnotherButton(){
        Button compareAnotherButton = (Button) findViewById(R.id.SaveCurJobButton);
        compareAnotherButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CompareJobs.this, ListJobs.class);
                startActivity(intent);
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