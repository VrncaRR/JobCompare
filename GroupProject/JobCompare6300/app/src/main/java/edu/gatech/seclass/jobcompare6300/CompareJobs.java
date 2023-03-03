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
        Intent i = getIntent();
        ArrayList<String> firstJobData = i.getStringArrayListExtra("First");
        ArrayList<String> secondJobData = i.getStringArrayListExtra("Second");


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


        firstTitle.setText(firstJobData.get(0));
        firstCompany.setText(firstJobData.get(1));
        firstLoc.setText(firstJobData.get(2));
        firstCOL.setText(firstJobData.get(3));
        firstSalary.setText(firstJobData.get(4));
        firstBonus.setText(firstJobData.get(5));
        firstRSU.setText(firstJobData.get(6));
        firstStipend.setText(firstJobData.get(7));
        firstPTO.setText(firstJobData.get(8));

        secondTitle.setText(secondJobData.get(0));
        secondCompany.setText(secondJobData.get(1));
        secondLoc.setText(secondJobData.get(2));
        secondCOL.setText(secondJobData.get(3));
        secondSalary.setText(secondJobData.get(4));
        secondBonus.setText(secondJobData.get(5));
        secondRSU.setText(secondJobData.get(6));
        secondStipend.setText(secondJobData.get(7));
        secondPTO.setText(secondJobData.get(8));


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