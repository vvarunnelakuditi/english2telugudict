package com.example.venkatavarun.english2telugu.adapters;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.venkatavarun.english2telugu.R;

/**
 * Created by venkatavarun on 16-05-2017.
 */

public class SingleItemView extends Activity {
    // Declare Variables
    TextView txtrank;
    TextView txtcountry;
    TextView txtpopulation;
    String rank;
    String country;
    String population;
    //private AdView mAdView,mAdView1;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.singleitemview);
        // Retrieve data from MainActivity on item click event

      //  MobileAds.initialize(this, "ca-app-pub-6794857582364422/9925375190");

        // Gets the ad view defined in layout/ad_fragment.xml with ad unit ID set in
        // values/strings.xml.
      //  mAdView = (AdView) findViewById(R.id.adView);
      //  mAdView1 = (AdView) findViewById(R.id.adView1);


        // Create an ad request. Check your logcat output for the hashed device ID to
        // get test ads on a physical device. e.g.
        // "Use AdRequest.Builder.addTestDevice("ABCDEF012345") to get test ads on this device."
      /*  AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .build();*/

        // Start loading the ad in the background.
        //mAdView.loadAd(adRequest);
        //mAdView1.loadAd(adRequest);
        Intent i = getIntent();
        // Get the results of rank
        // rank = i.getStringExtra("rank");
        // Get the results of country
        country = i.getStringExtra("country");
        // Get the results of population
        population = i.getStringExtra("population");

        // Locate the TextViews in singleitemview.xml
        // txtrank = (TextView) findViewById(R.id.rank);
        txtcountry = (TextView) findViewById(R.id.country);
        txtpopulation = (TextView) findViewById(R.id.population);

        // Load the results into the TextViews
        //txtrank.setText(rank);
        txtcountry.setText(country);
        txtpopulation.setText(population);
    }

}
