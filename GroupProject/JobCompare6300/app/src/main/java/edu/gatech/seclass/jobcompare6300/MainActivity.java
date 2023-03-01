package edu.gatech.seclass.jobcompare6300;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        configureEnterCurrentJobButton();
        configureEnterJobOfferButton();
        configureSettingsButton();
        configureCompareOfferButton();
    }

    public void configureEnterCurrentJobButton(){
        Button enterCurrentJobButton = (Button) findViewById(R.id.EnterCurrentJobButton);
        enterCurrentJobButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, CurrentJob.class));
            }
        });
    }

    public void configureEnterJobOfferButton(){
        Button enterJobOfferButton = (Button) findViewById(R.id.EnterJobOfferButton);
        enterJobOfferButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, EnterOffer.class));
            }
        });
    }
    public void configureSettingsButton(){
        Button settingsButton = (Button) findViewById(R.id.SettingsButton);
        settingsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, CompareSettings.class));
            }
        });
    }
    public void configureCompareOfferButton(){
        Button compareOffersButton = (Button) findViewById(R.id.CompareOffersButton);
        compareOffersButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, ListJobs.class));
            }
        });
    }
}