package edu.gatech.seclass.jobcompare6300;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;


public class EnterOffer extends AppCompatActivity {
    private EditText entryOfferTitle;
    private EditText entryOfferCompany;
    private EditText entryOfferLocation;
    private EditText entryOfferCOL;
    private EditText entryOfferSalary;
    private EditText entryOfferBonus;
    private EditText entryOfferRSU;
    private EditText entryOfferRelo;
    private EditText entryOfferPCH;
    private boolean offerEntered = false;

    //add job offer to database
    DatabaseHelper dbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_offer);
        dbHelper = new DatabaseHelper(EnterOffer.this);

        //Initialize Edit Text Fields
        entryOfferTitle = (EditText) findViewById(R.id.entryOfferTitle);
        entryOfferCompany = (EditText) findViewById(R.id.entryOfferCompany);
        entryOfferLocation = (EditText) findViewById(R.id.entryOfferLocation);
        entryOfferCOL = (EditText) findViewById(R.id.entryOfferCOL);
        entryOfferSalary = (EditText) findViewById(R.id.entryOfferSalary);
        entryOfferBonus = (EditText) findViewById(R.id.entryOfferBonus);
        entryOfferRSU = (EditText) findViewById(R.id.entryOfferRSU);
        entryOfferRelo = (EditText) findViewById(R.id.entryOfferRelo);
        entryOfferPCH = (EditText) findViewById(R.id.entryOfferPCH);

        configureOfferMainMenuButton();
        configureCancelButton();
        handleSaveOffer();
        handleAnotherOffer();
        handleCompareOffer();

    }
    //Handle Save OnClick
    public void handleSaveOffer(){
        Button saveOfferButton = (Button) findViewById(R.id.saveOfferButton);
        saveOfferButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean result = saveOffer();
                Log.d("Tag", String.valueOf(result));
                if (result) {
                    Toast.makeText(EnterOffer.this, "Unable to add new job offer, please check input!", Toast.LENGTH_LONG).show();
                }
                else {
                    Toast.makeText(EnterOffer.this, "Successfully added a new job offer!", Toast.LENGTH_LONG).show();
//                    Intent intent = new Intent(EnterOffer.this, MainActivity.class);
//                    startActivity(intent);
                }
            }
        });
    }

    //Handle Another OnClick
    public void handleAnotherOffer(){
        Button anotherOfferButton = (Button) findViewById(R.id.anotherOfferButton);
        anotherOfferButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Clear Text Fields for next offer
                clearDataFields();
            }
        });
    }

    //helper Functions //
    public boolean saveOffer(){
        String ERROR_MESSAGE = "Invalid Entry";
        Boolean error = validateNotEmpty(false);

        // Check that there are no empty strings
        if (!error) {
            String offerTitle = entryOfferTitle.getText().toString();
            String offerCompany = entryOfferCompany.getText().toString();
            String offerLocation = entryOfferLocation.getText().toString();
            int offerCOL = Integer.parseInt(entryOfferCOL.getText().toString());
            float offerSalary = Float.parseFloat(entryOfferSalary.getText().toString());
            float offerBonus = Float.parseFloat(entryOfferBonus.getText().toString());
            float offerRSU = Float.parseFloat(entryOfferRSU.getText().toString());
            float offerRelo = Float.parseFloat(entryOfferRelo.getText().toString());
            int offerPCH = Integer.parseInt(entryOfferPCH.getText().toString());
            Log.d("tag","HELLO");
            Log.d("title",offerTitle);
            Log.d("comp",offerCompany);
            Log.d("loc",offerLocation);
            Log.d("col",entryOfferCOL.getText().toString());
            Log.d("sal",entryOfferSalary.getText().toString());
            Log.d("bon",entryOfferBonus.getText().toString());
            Log.d("rsu",entryOfferRSU.getText().toString());
            Log.d("relo",entryOfferRelo.getText().toString());
            Log.d("pch",entryOfferPCH.getText().toString());

            Log.d("DEBUG","no error found");
            //TODO: Add create Current Job actions here
            Job newOffer = new Job(offerTitle, offerCompany, offerLocation,
                    offerCOL, offerSalary, offerBonus, offerRSU, offerRelo, offerPCH, false);


            if(!dbHelper.addJobOffer(newOffer)) {
                Log.d("TAG", "fail to add db");
                Toast.makeText(EnterOffer.this, "Unable to save offer, please check input", Toast.LENGTH_LONG).show();
            } else {
                //succesfully save the offer, change offerEntered
                this.offerEntered = true;
            }
        }

        else {
            Log.d("DEBUG","error found");
//            Toast.makeText(EnterOffer.this, "Please check inputs!", Toast.LENGTH_LONG).show();
            Log.d("Tag","Returning error " + String.valueOf(error));
        }
        return error;
    }

    public boolean validateNotEmpty(boolean isError) {

        if ((entryOfferTitle.getText().toString().length()) == 0) {
            isError = true;
        }
        if ((entryOfferCompany.getText().toString().length()) == 0) {
            isError = true;
        }
        if ((entryOfferLocation.getText().toString().length()) == 0) {
            isError = true;
        }
        if ((entryOfferCOL.getText().toString().length()) == 0) {
            isError = true;
        }
        if ((entryOfferSalary.getText().toString().length()) == 0) {
            isError = true;
        }
        if ((entryOfferBonus.getText().toString().length()) == 0) {
            isError = true;
        }
        if ((entryOfferRSU.getText().toString().length()) == 0) {
            isError = true;
        }
        if ((entryOfferRelo.getText().toString().length()) == 0) {
            isError = true;
        }
        if ((entryOfferPCH.getText().toString().length()) == 0) {
            isError = true;
        }
        return isError;
    }

    public void clearDataFields(){
        entryOfferTitle.setText("");
        entryOfferCompany.setText("");
        entryOfferLocation.setText("");
        entryOfferCOL.setText("");
        entryOfferSalary.setText("");
        entryOfferBonus.setText("");
        entryOfferRSU.setText("");
        entryOfferRelo.setText("");
        entryOfferPCH.setText("");
    }


    //NAVIGATION//

    public void configureCancelButton(){
        Button offerCancelButton = (Button) findViewById(R.id.offerCancelButton);
        offerCancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(EnterOffer.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
    public void configureOfferMainMenuButton(){
        Button offerMainMenuButton = (Button) findViewById(R.id.OfferMainMenuButton);
        offerMainMenuButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
    //handle Compare Offer OnClick
    public void handleCompareOffer(){
        Button compareOfferButton = (Button) findViewById(R.id.compareOfferButton);
        compareOfferButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //TODO: Add any special function here to keep track off what job is being compared

                if(EnterOffer.this.offerEntered) {
                    //if there is a job offer entered, compare the recently added offer to the current job

                    try{

                        ArrayList<Job> listJobsToCompare = new ArrayList<>();
                        listJobsToCompare.add(dbHelper.getRecentAddedJob());
                        listJobsToCompare.add(dbHelper.getCurrentJob());
                        Intent intent = new Intent(EnterOffer.this, CompareJobs.class);
                        intent.putParcelableArrayListExtra("jobList", listJobsToCompare);

                        startActivity(intent);
                    } catch (Exception e) {
                        Toast.makeText(EnterOffer.this, "Unable to compare the just added job with current job", Toast.LENGTH_LONG).show();
                    }
                } else {
                    Toast.makeText(EnterOffer.this, "Please add job first!", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}