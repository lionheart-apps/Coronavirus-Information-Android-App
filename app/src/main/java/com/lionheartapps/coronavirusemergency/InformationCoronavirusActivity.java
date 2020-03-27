package com.lionheartapps.coronavirusemergency;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;

import com.bumptech.glide.Glide;
import com.shashank.sony.fancygifdialoglib.FancyGifDialog;


public class InformationCoronavirusActivity extends AppCompatActivity implements View.OnClickListener {

    ImageView covid19Img;
    CardView cardWhatIsCoronaVirus, cardWhatIsCorid19,cardCorid19Symptom,cardCorid19Spread,cardCorid19Catch,cardCorid19Worry,cardCorid19SevereIllness,cardCorid19Antibiotic,
                    cardCorid19Vaccine,cardCorid19Sars,cardCorid19MaskProtectMe,cardCorid19MaskDispose,cardCorid19Incubation,cardCorid19Animal,cardCorid19Pet,cardCorid19SurfaceSurvive,cardCorid19SPackage,cardCorid19SNotTo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information_coronavirus);

        Toolbar toolbar = findViewById(R.id.toolbar);
        // toolbar.setTitle(getString(R.string.text_button));
        TextView textView = findViewById(R.id.toolbar_title);
        textView.setText(getString(R.string.text_information_coronavirus));
        setSupportActionBar(toolbar);

        if (getSupportActionBar() != null){
            getSupportActionBar().setDisplayShowTitleEnabled(false);
              getSupportActionBar().setDisplayHomeAsUpEnabled(true);
             getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        covid19Img = findViewById(R.id.imgCovid19);
       // Picasso.with(this).load(R.drawable.covid19).into(covid19Img);
        Glide.with(this).load(R.drawable.covid19).into(covid19Img);


        cardWhatIsCoronaVirus = findViewById(R.id.card_whatIs_coronavirus);
        cardWhatIsCorid19 = findViewById(R.id.card_whatIs_corvid19);
        cardCorid19Symptom = findViewById(R.id.card_corvid19_symptom);
        cardCorid19Spread = findViewById(R.id.card_spread_corvid19);
        cardCorid19Catch = findViewById(R.id.card_catch_corvid19);
        cardCorid19Worry = findViewById(R.id.card_worry_corvid19);
        cardCorid19SevereIllness = findViewById(R.id.card_severe_illness_corvid19);
        cardCorid19Antibiotic = findViewById(R.id.card_antibiotic_corvid19);
        cardCorid19Vaccine = findViewById(R.id.card_vaccine_corvid19);
        cardCorid19Sars = findViewById(R.id.card_sars_corvid19);
        cardCorid19MaskProtectMe = findViewById(R.id.card_mask_protect_me_corvid19);
        cardCorid19MaskDispose = findViewById(R.id.card_mask_dispose_corvid19);
        cardCorid19Incubation = findViewById(R.id.card_incubation_corvid19);
        cardCorid19Animal = findViewById(R.id.card_animal_corvid19);
        cardCorid19Pet = findViewById(R.id.card_pet_corvid19);
        cardCorid19SurfaceSurvive = findViewById(R.id.card_surface_survive_corvid19);
        cardCorid19SPackage = findViewById(R.id.card_package_corvid19);
        cardCorid19SNotTo = findViewById(R.id.card_not_to_corvid19);

        cardWhatIsCoronaVirus.setOnClickListener(this);
        cardWhatIsCorid19.setOnClickListener(this);
        cardCorid19Symptom.setOnClickListener(this);
        cardCorid19Spread.setOnClickListener(this);
        cardCorid19Catch.setOnClickListener(this);
        cardCorid19Worry.setOnClickListener(this);
        cardCorid19SevereIllness.setOnClickListener(this);
        cardCorid19Antibiotic.setOnClickListener(this);
        cardCorid19Vaccine.setOnClickListener(this);
        cardCorid19Sars.setOnClickListener(this);
        cardCorid19MaskProtectMe.setOnClickListener(this);
        cardCorid19MaskDispose.setOnClickListener(this);
        cardCorid19Incubation.setOnClickListener(this);
        cardCorid19Animal.setOnClickListener(this);
        cardCorid19Pet.setOnClickListener(this);
        cardCorid19SurfaceSurvive.setOnClickListener(this);
        cardCorid19SPackage.setOnClickListener(this);
        cardCorid19SNotTo.setOnClickListener(this);

     /*   ExpandableCardView whatIsCoronaCard = findViewById(R.id.ex_whatIsCoronavirus);
        whatIsCoronaCard.setCardTitle(getString(R.string.text_what_is_coronavirus));
        whatIsCoronaCard.setCardDescription(getString(R.string.text_what_is_coronavirus_answer));*/



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


    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void onClick(View v) {

        switch (v.getId()){

            case R.id.card_whatIs_coronavirus:
                //action
               new FancyGifDialog.Builder(this)
                        .setTitle(getString(R.string.text_what_is_coronavirus))
                        .setMessage(getString(R.string.text_what_is_coronavirus_answer))
                        .setPositiveBtnText("Ok")
                        .setPositiveBtnBackground("#232323")
                        .setGifResource(R.drawable.bcorangecompress)   //Pass your Gif here
                        .isCancellable(true)
                        .build();
                break;

            case R.id.card_whatIs_corvid19:
                //action
                new FancyGifDialog.Builder(this)
                        .setTitle(getString(R.string.text_what_is_covid19))
                        .setMessage(getString(R.string.text_what_is_covid19_answer))
                        .setPositiveBtnText("Ok")
                        .setPositiveBtnBackground("#232323")
                        .setGifResource(R.drawable.bcorangecompress)   //Pass your Gif here
                        .isCancellable(true)
                        .build();
                break;

            case R.id.card_corvid19_symptom:
                //action
                new FancyGifDialog.Builder(this)
                        .setTitle(getString(R.string.text_symtom_covid19))
                        .setMessage(getString(R.string.text_symtom_covid19_answer))
                        .setPositiveBtnText("Ok")
                        .setPositiveBtnBackground("#232323")
                        .setGifResource(R.drawable.lungcompress)   //Pass your Gif here
                        .isCancellable(true)
                        .build();
                break;

            case R.id.card_spread_corvid19:
                //action
                new FancyGifDialog.Builder(this)
                        .setTitle(getString(R.string.text_covid19_spread))
                        .setMessage(getString(R.string.text_covid19_spread_answer))
                        .setPositiveBtnText("Ok")
                        .setPositiveBtnBackground("#232323")
                        .setGifResource(R.drawable.coronaspread)   //Pass your Gif here
                        .isCancellable(true)
                        .build();
                break;

            case R.id.card_catch_corvid19:
                //action
                new FancyGifDialog.Builder(this)
                        .setTitle(getString(R.string.text_covid19_catch))
                        .setMessage(getString(R.string.text_covid19_catch_answer))
                        .setPositiveBtnText("Ok")
                        .setPositiveBtnBackground("#232323")
                        .setGifResource(R.drawable.bcorangecompress)   //Pass your Gif here
                        .isCancellable(true)
                        .build();
                break;

            case R.id.card_worry_corvid19:
                //action
                new FancyGifDialog.Builder(this)
                        .setTitle(getString(R.string.text_covid19_worry))
                        .setMessage(getString(R.string.text_covid19_worry_answer))
                        .setPositiveBtnText("Ok")
                        .setPositiveBtnBackground("#232323")
                        .setGifResource(R.drawable.bcorangecompress)   //Pass your Gif here
                        .isCancellable(true)
                        .build();
                break;

            case R.id.card_severe_illness_corvid19:
                //action
                new FancyGifDialog.Builder(this)
                        .setTitle(getString(R.string.text_covid19_severe_illness))
                        .setMessage(getString(R.string.text_covid19_severe_illness_answer))
                        .setPositiveBtnText("Ok")
                        .setPositiveBtnBackground("#232323")
                        .setGifResource(R.drawable.bcorangecompress)   //Pass your Gif here
                        .isCancellable(true)
                        .build();
                break;

            case R.id.card_antibiotic_corvid19:
                //action
                new FancyGifDialog.Builder(this)
                        .setTitle(getString(R.string.text_covid19_antibiotic))
                        .setMessage(getString(R.string.text_covid19_antibiotic_answer))
                        .setPositiveBtnText("Ok")
                        .setPositiveBtnBackground("#232323")
                        .setGifResource(R.drawable.bcorangecompress)   //Pass your Gif here
                        .isCancellable(true)
                        .build();
                break;

            case R.id.card_vaccine_corvid19:
                //action
                new FancyGifDialog.Builder(this)
                        .setTitle(getString(R.string.text_covid19_vacccine))
                        .setMessage(getString(R.string.text_covid19_vacccine_answer))
                        .setPositiveBtnText("Ok")
                        .setPositiveBtnBackground("#232323")
                        .setGifResource(R.drawable.bcorangecompress)   //Pass your Gif here
                        .isCancellable(true)
                        .build();
                break;

            case R.id.card_sars_corvid19:
                //action
                new FancyGifDialog.Builder(this)
                        .setTitle(getString(R.string.text_covid19_sars))
                        .setMessage(getString(R.string.text_covid19_sars_answer))
                        .setPositiveBtnText("Ok")
                        .setPositiveBtnBackground("#232323")
                        .setGifResource(R.drawable.bcorangecompress)   //Pass your Gif here
                        .isCancellable(true)
                        .build();
                break;

            case R.id.card_mask_protect_me_corvid19:
                //action
                new FancyGifDialog.Builder(this)
                        .setTitle(getString(R.string.text_covid19_mask_protect_me))
                        .setMessage(getString(R.string.text_covid19_mask_protect_me_answer))
                        .setPositiveBtnText("Ok")
                        .setPositiveBtnBackground("#232323")
                        .setGifResource(R.drawable.bcorangecompress)   //Pass your Gif here
                        .isCancellable(true)
                        .build();
                break;

            case R.id.card_mask_dispose_corvid19:
                //action
                new FancyGifDialog.Builder(this)
                        .setTitle(getString(R.string.text_covid19_mask_dispose))
                        .setMessage(getString(R.string.text_covid19_mask_dispose_answer))
                        .setPositiveBtnText("Ok")
                        .setPositiveBtnBackground("#232323")
                        .setGifResource(R.drawable.bcorangecompress)   //Pass your Gif here
                        .isCancellable(true)
                        .build();
                break;

            case R.id.card_incubation_corvid19:
                //action
                new FancyGifDialog.Builder(this)
                        .setTitle(getString(R.string.text_covid19_incubation))
                        .setMessage(getString(R.string.text_covid19_incubation_answer))
                        .setPositiveBtnText("Ok")
                        .setPositiveBtnBackground("#232323")
                        .setGifResource(R.drawable.lungcompress)   //Pass your Gif here
                        .isCancellable(true)
                        .build();
                break;

            case R.id.card_animal_corvid19:
                //action
                new FancyGifDialog.Builder(this)
                        .setTitle(getString(R.string.text_covid19_animal))
                        .setMessage(getString(R.string.text_covid19_animal_answer))
                        .setPositiveBtnText("Ok")
                        .setPositiveBtnBackground("#232323")
                        .setGifResource(R.drawable.bcorangecompress)   //Pass your Gif here
                        .isCancellable(true)
                        .build();
                break;

            case R.id.card_pet_corvid19:
                //action
                new FancyGifDialog.Builder(this)
                        .setTitle(getString(R.string.text_covid19_pet))
                        .setMessage(getString(R.string.text_covid19_pet_answer))
                        .setPositiveBtnText("Ok")
                        .setPositiveBtnBackground("#232323")
                        .setGifResource(R.drawable.bcorangecompress)   //Pass your Gif here
                        .isCancellable(true)
                        .build();
                break;

            case R.id.card_surface_survive_corvid19:
                //action
                new FancyGifDialog.Builder(this)
                        .setTitle(getString(R.string.text_covid19_surface_survice))
                        .setMessage(getString(R.string.text_covid19_surface_survice_answer))
                        .setPositiveBtnText("Ok")
                        .setPositiveBtnBackground("#232323")
                        .setGifResource(R.drawable.bcorangecompress)   //Pass your Gif here
                        .isCancellable(true)
                        .build();
                break;

            case R.id.card_package_corvid19:
                //action
                new FancyGifDialog.Builder(this)
                        .setTitle(getString(R.string.text_covid19_package))
                        .setMessage(getString(R.string.text_covid19_package_answer))
                        .setPositiveBtnText("Ok")
                        .setPositiveBtnBackground("#232323")
                        .setGifResource(R.drawable.bcorangecompress)   //Pass your Gif here
                        .isCancellable(true)
                        .build();
                break;


            case R.id.card_not_to_corvid19:
                //action
                new FancyGifDialog.Builder(this)
                        .setTitle(getString(R.string.text_covid19_not_to))
                        .setMessage(getString(R.string.text_covid19_not_to_answer))
                        .setPositiveBtnText("Ok")
                        .setPositiveBtnBackground("#232323")
                        .setGifResource(R.drawable.bcorangecompress)   //Pass your Gif here
                        .isCancellable(true)
                        .build();
                break;


        }

    }
}
