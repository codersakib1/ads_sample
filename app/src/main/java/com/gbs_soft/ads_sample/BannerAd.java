package com.gbs_soft.ads_sample;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.MobileAds;




public class BannerAd extends AppCompatActivity {

    /*
    >>Source Code provided by
    >>Jubayer Hossain [https://www.facebook.com/JubayerHossainbd]
    >>Please don't forget to put a review on my site [www.bongoacademy.com]
    >>Share my course with your friends on Facebook
    >>Your positive words help me doing even better
     */

    TextView textView;
    AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.banner_ad);

        //init Mobile Ads
        MobileAds.initialize(this, initializationStatus -> {
        });

        //init Variables
        mAdView = findViewById(R.id.mAdView);
        textView = findViewById(R.id.textView);

        // Load ad into Banner Adview
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);



        //ad event controlling
        mAdView.setAdListener(new AdListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onAdLoaded() {
                // Code to be executed when an ad finishes loading.
                textView.setText("Banner Ad is Loaded");
            }

            @SuppressLint("SetTextI18n")
            @Override
            public void onAdFailedToLoad(@NonNull LoadAdError adError) {
                // Code to be executed when an ad request fails.
                textView.setText("Banner Ad failed to load!");
            }

            @SuppressLint("SetTextI18n")
            @Override
            public void onAdOpened() {
                // Code to be executed when an ad opens an overlay that
                // covers the screen.
                textView.setText("Ad opened");
            }

            @SuppressLint("SetTextI18n")
            @Override
            public void onAdClicked() {
                // Code to be executed when the user clicks on an ad.
                textView.setText("User clicked Ad");
            }

            @SuppressLint("SetTextI18n")
            @Override
            public void onAdClosed() {
                // Code to be executed when the user is about to return
                // to the app after tapping on an ad.

                //Requesting a new ad when user already intracted with a old ad
                textView.setText("Ad Closed");
                AdRequest adRequest = new AdRequest.Builder().build();
                mAdView.loadAd(adRequest);
            }
        });



    }
    //============================================ oncreate Ends here





}