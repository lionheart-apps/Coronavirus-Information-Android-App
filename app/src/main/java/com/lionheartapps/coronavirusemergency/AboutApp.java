package com.lionheartapps.coronavirusemergency;

import android.annotation.SuppressLint;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;


import java.util.Calendar;

import mehdi.sakout.aboutpage.AboutPage;
import mehdi.sakout.aboutpage.Element;

public class AboutApp extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // setContentView(R.layout.activity_about_app);

        simulateDayNight(/* DAY */ 1);
        Element adsElement = new Element();
        adsElement.setTitle("Advertise with us");

        String versionCode = "Version: v" + getAppVersion();

        View aboutPage = new AboutPage(this)
                .isRTL(false)
                .setImage(R.mipmap.ic_launcher_round)
                .addItem(new Element().setTitle(versionCode))
//                .addItem(adsElement)
                .setDescription("Lionheart Apps (OPC) Pvt. Ltd. has developed this android application to enhance the national awareness amongst our citizens related to the coronavirus precautions and safety measures enlisted by the World Health Organisation [WHO] and other medical experts all over the globe.\n" +
                        "\n" +
                        "It's our small effort to spread this information via our android application platform to spread awareness among our users as quickly as possible.." +
                        "\n ")
                .addGroup("Connect with us")
                .addEmail("contact@lionheartapps.com")
                .addWebsite("http://www.lionheartapps.com")
//                .addFacebook("lionheartapps")
               .addPlayStore("com.lionheartapps.coronavirusemergency")
//                .addInstagram("lionheartapps")
                .addItem(getCopyRightsElement())
                .create();

        setContentView(aboutPage);
    }

    private String getAppVersion() {
        String version = "Unknown";
        try {
            PackageInfo pInfo = this.getPackageManager().getPackageInfo(getPackageName(), 0);
            version = pInfo.versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return version;
    }


    Element getCopyRightsElement() {
        Element copyRightsElement = new Element();
        @SuppressLint({"StringFormatInvalid", "LocalSuppress"}) final String copyrights = String.format(getResources().getString(R.string.developer_copyright), Calendar.getInstance().get(Calendar.YEAR));
        copyRightsElement.setTitle(copyrights);
        copyRightsElement.setIconDrawable(R.drawable.card_lion);
        copyRightsElement.setIconTint(mehdi.sakout.aboutpage.R.color.about_item_icon_color);
        copyRightsElement.setIconNightTint(android.R.color.white);
        copyRightsElement.setGravity(Gravity.CENTER);
        copyRightsElement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(AboutApp.this, copyrights, Toast.LENGTH_SHORT).show();
            }
        });
        return copyRightsElement;
    }

    void simulateDayNight(int currentSetting) {
        final int DAY = 0;
        final int NIGHT = 1;
        final int FOLLOW_SYSTEM = 3;

        int currentNightMode = getResources().getConfiguration().uiMode
                & Configuration.UI_MODE_NIGHT_MASK;

            if (currentSetting == DAY && currentNightMode != Configuration.UI_MODE_NIGHT_NO) {
                AppCompatDelegate.setDefaultNightMode(
                        AppCompatDelegate.MODE_NIGHT_NO);
            } else if (currentSetting == NIGHT && currentNightMode != Configuration.UI_MODE_NIGHT_YES) {
                AppCompatDelegate.setDefaultNightMode(
                        AppCompatDelegate.MODE_NIGHT_YES);
            } else if (currentSetting == FOLLOW_SYSTEM) {
                AppCompatDelegate.setDefaultNightMode(
                        AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM);
            }
    }


}
