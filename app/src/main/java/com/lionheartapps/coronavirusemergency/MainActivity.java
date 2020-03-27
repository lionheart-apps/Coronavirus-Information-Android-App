package com.lionheartapps.coronavirusemergency;

import android.app.Dialog;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;

import com.shashank.sony.fancygifdialoglib.FancyGifDialog;
import com.shashank.sony.fancygifdialoglib.FancyGifDialogListener;

public class MainActivity extends AppCompatActivity {


   private CardView cardInformation,cardHowToProtect,cardWorldMapDashboard, cardWorldMapSituation, cardHealthMap,cardDisclaimer, cardAboutUs, cardShareUs;


    final String PREFS_NAME = "LionheartappsCoronaFirstTimePref";
    SharedPreferences sharedPref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        // toolbar.setTitle(getString(R.string.text_button));
        TextView textView = findViewById(R.id.toolbar_title);
        textView.setText(getString(R.string.app_name_title));
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null){
            getSupportActionBar().setDisplayShowTitleEnabled(false);
          //  getSupportActionBar().setDisplayHomeAsUpEnabled(true);
           // getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

         sharedPref = getSharedPreferences(PREFS_NAME, 0);
        // Button

        cardInformation = findViewById(R.id.cardInformationCorona);
        cardHowToProtect = findViewById(R.id.cardHowToProtect);
        cardWorldMapDashboard = findViewById(R.id.cardInfectedWorldMapDashboard);
        cardWorldMapSituation = findViewById(R.id.cardInfectedWorldMapSituation);
        cardHealthMap = findViewById(R.id.cardHealthMap);
        cardDisclaimer = findViewById(R.id.card_disclaimer);
        cardAboutUs = findViewById(R.id.card_about_us);
        cardShareUs = findViewById(R.id.card_share_us);


        cardInformation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent infoIntent = new Intent(getApplicationContext(), InformationCoronavirusActivity.class);
                startActivity(infoIntent);
                overridePendingTransition(R.anim.push_up_in, R.anim.push_up_out);

            }
        });

        cardHowToProtect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent howtoProtectIntent = new Intent(getApplicationContext(), HowToProtectYourselfActivity.class);
                startActivity(howtoProtectIntent);
                overridePendingTransition(R.anim.push_up_in, R.anim.push_up_out);

            }
        });


        cardWorldMapDashboard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent mapDashboardIntent = new Intent(getApplicationContext(), WorldMapDashboardActivity.class);
                startActivity(mapDashboardIntent);
                overridePendingTransition(R.anim.push_up_in, R.anim.push_up_out);

            }
        });

        cardWorldMapSituation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent mapSituationIntent = new Intent(getApplicationContext(), WorldMapSituationActivity.class);
                startActivity(mapSituationIntent);
                overridePendingTransition(R.anim.push_up_in, R.anim.push_up_out);

            }
        });


        cardHealthMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent healthmapIntent = new Intent(getApplicationContext(), HealthMapActivity.class);
                startActivity(healthmapIntent);
                overridePendingTransition(R.anim.push_up_in, R.anim.push_up_out);

            }
        });

        cardAboutUs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent aboutUsIntent = new Intent(getApplicationContext(), AboutApp.class);
                startActivity(aboutUsIntent);
                overridePendingTransition(R.anim.push_up_in, R.anim.push_up_out);

            }
        });


        cardDisclaimer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                new FancyGifDialog.Builder(MainActivity.this)
                        .setTitle(getString(R.string.text_disclaimer))
                        .setMessage(getString(R.string.text_data_disclaimer))
                        .setPositiveBtnText("Ok")
                        .setPositiveBtnBackground("#232323")
                        .setGifResource(R.drawable.ic_lionheartapps)   //Pass your Gif here
                        .isCancellable(true)
                        .build();
                overridePendingTransition(R.anim.push_up_in, R.anim.push_up_out);

            }
        });

        cardShareUs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT,
                        "Coronavirus prevention App -\n\n " + " Lionheart Apps (OPC) Pvt. Ltd. has developed this android application to enhance the national awareness amongst our citizens related to the coronavirus precautions and safety measures enlisted by the World Health Organisation [WHO] and other medical experts all over the globe.\n" +
                                "\n" +
                                "It's our small effort to spread this information via our android application platform to spread awareness among our users as quickly as possible. " +
                                "\n\ncheck out our app at:\n https://play.google.com/store/apps/details?id=" + BuildConfig.APPLICATION_ID);
                sendIntent.setType("text/plain");
                startActivity(sendIntent);
                overridePendingTransition(R.anim.push_up_in, R.anim.push_up_out);

            }
        });



    }

    @Override
    protected void onStart() {
        super.onStart();
        sharedPref = getSharedPreferences(PREFS_NAME, 0);
        if (sharedPref.getBoolean("my_first_time", true)) {
            //the app is being launched for first time, do something
            Log.d("Comments", "First time");

            // first time task
            new FancyGifDialog.Builder(MainActivity.this)
                    .setTitle(getString(R.string.text_disclaimer))
                    .setMessage(getString(R.string.text_data_disclaimer))
                    .setPositiveBtnText("Ok")
                    .setPositiveBtnBackground("#232323")
                    .setGifResource(R.drawable.ic_lionheartapps)   //Pass your Gif here
                    .isCancellable(true)
                    .build();
            overridePendingTransition(R.anim.push_up_in, R.anim.push_up_out);
            // record the fact that the app has been started at least once
            sharedPref.edit().putBoolean("my_first_time", false).commit();
        }
    }

    @Override
    public void onBackPressed() {
       // super.onBackPressed();

        AlertDialog.Builder builder = new AlertDialog.Builder(new ContextThemeWrapper(this, android.R.style.ThemeOverlay_Material_Dialog_Alert));
        builder.setTitle(getString(R.string.text_exit_title));
        builder.setIcon(R.drawable.ic_alert);
        builder.setCancelable(false);
        builder.setMessage(getString(R.string.text_exit_message));
        builder.setPositiveButton(getString(R.string.text_rate_it), new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {

                Intent intent = new Intent(Intent.ACTION_VIEW);
                // Try Google play
                intent.setData(Uri
                        .parse("market://details?id="+ BuildConfig.APPLICATION_ID));
                if (!MyStartActivity(intent)) {

                    intent.setData(Uri
                            .parse("https://play.google.com/store/apps/details?id="+ BuildConfig.APPLICATION_ID));
                    if (!MyStartActivity(intent)) {
                        // Well if this also fails, we have run out of options,
                        // inform the user.
                        Toast.makeText(
                                MainActivity.this,
                                getString(R.string.text_exit_response),
                                Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        builder.setNegativeButton(getString(R.string.text_exit), new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {

               // smartWatchDogStop();
                MainActivity.super.onBackPressed();
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);

            }
        });
        builder.setNeutralButton(getString(R.string.text_cancel), new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {

                dialog.dismiss();
            }
        });
        AlertDialog alert = builder.create();
        alert.show();

    }

    private boolean MyStartActivity(Intent aIntent) {
        // TODO Auto-generated method stub
        try {
            startActivity(aIntent);
            overridePendingTransition(R.anim.push_up_in, R.anim.push_up_out);

            return true;
        } catch (ActivityNotFoundException e) {
            return false;
        }
    }
}
