package com.lionheartapps.coronavirusemergency;

import android.app.ProgressDialog;
import android.content.Context;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.appcompat.app.AppCompatActivity;

public class WorldMapSituationActivity extends AppCompatActivity {

    WebView worldMapSituationWebview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // remove title
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_world_map_situation);

     /*   Toolbar toolbar = findViewById(R.id.toolbar);
        // toolbar.setTitle(getString(R.string.text_button));
        TextView textView = findViewById(R.id.toolbar_title);
        textView.setText(getString(R.string.text_infection_world_map_dashboard));
        setSupportActionBar(toolbar);

        if (getSupportActionBar() != null){
            getSupportActionBar().setDisplayShowTitleEnabled(false);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }*/

        worldMapSituationWebview = findViewById(R.id.webview_worldMapSituation);

        if(isNetworkAvailable(getApplicationContext())) {

            // Set the url or assetfolder path
            startWebView("https://experience.arcgis.com/experience/685d0ace521648f8a5beeeee1b9125cd");

        }else {

            // Load from asset folder
            startWebView("file:///android_asset/dance.html");
        }

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

    private void startWebView(String url) {

        //Create new webview Client to show progress dialog
        worldMapSituationWebview.setWebViewClient(new WebViewClient() {
            ProgressDialog progressDialog;

            //If you will not use this method url links are opeen in new brower not in webview
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }

            //Show loader on url load
            public void onLoadResource(WebView view, String url) {
                if (progressDialog == null) {
                    // in standard case YourActivity.this
                    progressDialog = new ProgressDialog(WorldMapSituationActivity.this);
                    progressDialog.setMessage("Loading...");
                    progressDialog.show();

                }
            }

            public void onPageFinished(WebView view, String url) {
                try {
                    if (progressDialog.isShowing()) {
                        progressDialog.dismiss();

                    }
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            }


            public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                //place you error code here
                worldMapSituationWebview.loadUrl("file:///android_asset/dance.html");
            }

        });

        // Javascript enabled on webview
        worldMapSituationWebview.getSettings().setJavaScriptEnabled(true);
        worldMapSituationWebview.getSettings().setDisplayZoomControls(true);
        worldMapSituationWebview.getSettings().setSupportZoom(true);
        worldMapSituationWebview.getSettings().setBuiltInZoomControls(true);

        worldMapSituationWebview.getSettings().setLoadWithOverviewMode(true);
        worldMapSituationWebview.getSettings().setUseWideViewPort(true);
        worldMapSituationWebview.setScrollBarStyle(WebView.SCROLLBARS_OUTSIDE_OVERLAY);
        worldMapSituationWebview.setScrollbarFadingEnabled(false);

        //Load url in webview
        worldMapSituationWebview.loadUrl(url);

    }


    // Check for the Internet Connectivity
    public boolean isNetworkAvailable(Context context) {
        ConnectivityManager connectivityManager = ((ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE));
        return connectivityManager.getActiveNetworkInfo() != null && connectivityManager.getActiveNetworkInfo().isConnected();
    }
}
