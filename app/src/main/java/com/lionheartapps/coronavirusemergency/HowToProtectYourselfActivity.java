package com.lionheartapps.coronavirusemergency;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.shashank.sony.fancygifdialoglib.FancyGifDialog;
import com.shashank.sony.fancygifdialoglib.FancyGifDialogListener;

public class HowToProtectYourselfActivity extends AppCompatActivity {

    CardView cardHowToProtect;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_protect_self_discrollview);

   /*     Toolbar toolbar = findViewById(R.id.toolbar);
        // toolbar.setTitle(getString(R.string.text_button));
        TextView textView = findViewById(R.id.toolbar_title);
        textView.setText(getString(R.string.text_how_to_protect_your));
        setSupportActionBar(toolbar);

        if (getSupportActionBar() != null){
            getSupportActionBar().setDisplayShowTitleEnabled(false);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }*/

      /*  cardHowToProtect = findViewById(R.id.card_corvid19_how_to_protect);

        cardHowToProtect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                new FancyGifDialog.Builder(HowToProtectYourselfActivity.this)
                        .setTitle(getString(R.string.text_how_to_protect_your_self_prevent))
                        .setMessage(getString(R.string.text_how_to_protect_your_self_prevent_answer))
                        .setPositiveBtnText("Ok")
                        .setNegativeBtnText("Share with Other")
                        .setPositiveBtnBackground("#232323")
                        .setNegativeBtnBackground("#9E82FF")
                        .setGifResource(R.drawable.bcorangecompress)   //Pass your Gif here
                        .isCancellable(true)
                        .OnNegativeClicked(new FancyGifDialogListener() {
                            @Override
                            public void OnClick() {
                                Toast.makeText(HowToProtectYourselfActivity.this,"Share clicked",Toast.LENGTH_SHORT).show();
                            }
                        })
                        .build();

            }
        });*/

    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

        overridePendingTransition(R.anim.push_down_in, R.anim.push_down_out);

    }
}
