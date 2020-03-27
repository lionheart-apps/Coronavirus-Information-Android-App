package com.lionheartapps.coronavirusemergency;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

import yanzhikai.textpath.AsyncTextPathView;

public class Splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

     //  ImageView imageView = findViewById(R.id.imageViewSplash);

      // Picasso.with(this).load(R.drawable.covid19virus).into(imageView);
      //  Glide.with(this).load(R.drawable.covid19virus).into(imageView);

        AsyncTextPathView atpv1 = findViewById(R.id.atpv_1);
        AsyncTextPathView atpv2 = findViewById(R.id.atpv_2);
        AsyncTextPathView atpv3 = findViewById(R.id.atpv_3);
        AsyncTextPathView atpv4 = findViewById(R.id.atpv_4);
        AsyncTextPathView atpv5 = findViewById(R.id.atpv_5);
       // AsyncTextPathView atpv5 = findViewById(R.id.atpv_5);
        //从无到显示
        atpv1.setText("CORONAVIRUS");
        atpv2.setText("( COVID-19 )");
        atpv3.setText("INFORMATION");
        atpv4.setText("AND");
        atpv5.setText("PRECAUTION");
     //   atpv5.setText("APP");

        atpv1.startAnimation(0,1);
        atpv2.startAnimation(0,1);
        atpv3.startAnimation(0,1);
        atpv4.startAnimation(0,1);
        atpv5.startAnimation(0,1);
     //   atpv5.startAnimation(0,1);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // This method will be executed once the timer is over
                Intent i = new Intent(Splash.this, MainActivity.class);
                startActivity(i);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                finish();
            }
        }, 6000);

    }
}
