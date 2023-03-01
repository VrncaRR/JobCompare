package edu.gatech.seclass.jobcompare6300;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

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
        handleSaveOffer();

    }
    //Handle Save OnClick
    public void handleSaveOffer(){
        Button saveOfferButton = (Button) findViewById(R.id.saveOfferButton);
        saveOfferButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String offerTitle = entryOfferTitle.getText().toString();
                String offerCompany = entryOfferCompany.getText().toString();
                String offerLocation = entryOfferLocation.getText().toString();
                String offerCOL = entryOfferCOL.getText().toString();
                String offerSalary = entryOfferSalary.getText().toString();
                String offerBonus = entryOfferBonus.getText().toString();
                String offerRSU = entryOfferRSU.getText().toString();
                String offerRelo = entryOfferRelo.getText().toString();
                String offerPCH = entryOfferPCH.getText().toString();

                Boolean error = false;
                //TODO: ADD Error Handling for Invalid Entries
                if (offerTitle.length() == 0) {
                    CharSequence errorMessage = "Invalid Entry";
                    entryOfferTitle.setError(errorMessage);
                    error = true;
                }
                if (offerCompany.length() == 0) {
                    CharSequence errorMessage = "Invalid Entry";
                    entryOfferCompany.setError(errorMessage);
                    error = true;
                }
                if (offerLocation.length() == 0) {
                    CharSequence errorMessage = "Invalid Entry";
                    entryOfferLocation.setError(errorMessage);
                    error = true;
                }
                if (offerCOL.length() == 0) {
                    CharSequence errorMessage = "Invalid Entry";
                    entryOfferCOL.setError(errorMessage);
                    error = true;
                }
                if (offerSalary.length() == 0) {
                    CharSequence errorMessage = "Invalid Entry";
                    entryOfferSalary.setError(errorMessage);
                    error = true;
                }
                if (offerBonus.length() == 0) {
                    CharSequence errorMessage = "Invalid Entry";
                    entryOfferBonus.setError(errorMessage);
                    error = true;
                }
                if (offerRSU.length() == 0) {
                    CharSequence errorMessage = "Invalid Entry";
                    entryOfferRSU.setError(errorMessage);
                    error = true;
                }
                if (offerRelo.length() == 0) {
                    CharSequence errorMessage = "Invalid Entry";
                    entryOfferRelo.setError(errorMessage);
                    error = true;
                }
                if (offerPCH.length() == 0) {
                    CharSequence errorMessage = "Invalid Entry";
                    entryOfferPCH.setError(errorMessage);
                    error = true;
                }

                if (!error) {
                    //TODO: Add create Current Job actions here
                }
            }
        });
    }

    /*
    NAVIGATION
     */
    public void configureOfferMainMenuButton(){
        Button offerMainMenuButton = (Button) findViewById(R.id.OfferMainMenuButton);
        offerMainMenuButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}