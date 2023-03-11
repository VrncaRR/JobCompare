package edu.gatech.seclass.jobcompare6300;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_offer);

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
                saveOffer();
                Intent intent = new Intent(EnterOffer.this, MainActivity.class);
                startActivity(intent);
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
    public void saveOffer(){
        String ERROR_MESSAGE = "Invalid Entry";
        Boolean error = false;

        try{
            String offerTitle = entryOfferTitle.getText().toString();
            String offerCompany = entryOfferCompany.getText().toString();
            String offerLocation = entryOfferLocation.getText().toString();
            int offerCOL = Integer.parseInt(entryOfferCOL.getText().toString());
            float offerSalary = Float.parseFloat(entryOfferSalary.getText().toString());
            float offerBonus = Float.parseFloat(entryOfferBonus.getText().toString());
            float offerRSU = Float.parseFloat(entryOfferRSU.getText().toString());
            float offerRelo = Float.parseFloat(entryOfferRelo.getText().toString());
            int offerPCH = Integer.parseInt(entryOfferPCH.getText().toString());

            if (offerTitle.length() == 0) {
                entryOfferTitle.setError(ERROR_MESSAGE);
                error = true;
            }
            if (offerCompany.length() == 0) {
                entryOfferCompany.setError(ERROR_MESSAGE);
                error = true;
            }
            if (offerLocation.length() == 0) {
                entryOfferLocation.setError(ERROR_MESSAGE);
                error = true;
            }
            if (!error) {
                //TODO: Add create Current Job actions here
                Job newOffer = new Job(offerTitle, offerCompany, offerLocation,
                        offerCOL, offerSalary, offerBonus, offerRSU, offerRelo, offerPCH, false);

                //add job offer to database
                DatabaseHelper dbHelper = new DatabaseHelper(EnterOffer.this);

                if(dbHelper.addJobOffer(newOffer)) {
                    Toast.makeText(EnterOffer.this, "Successfully add a new job offer!", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(EnterOffer.this, "fail to add db", Toast.LENGTH_LONG).show();
                }
            }
        }  catch(Exception e) {
            Toast.makeText(EnterOffer.this, "Unable to add new job offer, please check input!", Toast.LENGTH_LONG).show();
        }
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
                saveOffer();
                startActivity(new Intent(EnterOffer.this, CompareJobs.class));
            }
        });
    }
}