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

public class HealthMapActivity extends AppCompatActivity {

    WebView healthMapWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_health_map);

        healthMapWebView = findViewById(R.id.webview_healthmap);

        if(isNetworkAvailable(getApplicationContext())) {

            // Set the url or assetfolder path
            startWebView("https://www.healthmap.org/covid-19/");

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
        healthMapWebView.setWebViewClient(new WebViewClient() {
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
                    progressDialog = new ProgressDialog(HealthMapActivity.this);
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
                healthMapWebView.loadUrl("file:///android_asset/dance.html");
            }

        });

        // Javascript enabled on webview
        healthMapWebView.getSettings().setJavaScriptEnabled(true);
        healthMapWebView.getSettings().setDisplayZoomControls(true);
        healthMapWebView.getSettings().setSupportZoom(true);
        healthMapWebView.getSettings().setBuiltInZoomControls(true);

        healthMapWebView.getSettings().setLoadWithOverviewMode(true);
        healthMapWebView.getSettings().setUseWideViewPort(true);
        // worldMapDashboardWebview.setScrollBarStyle(WebView.SCROLLBARS_OUTSIDE_OVERLAY);
        //   worldMapDashboardWebview.setScrollbarFadingEnabled(false);

        //Load url in webview
        healthMapWebView.loadUrl(url);

    }


    // Check for the Internet Connectivity
    public boolean isNetworkAvailable(Context context) {
        ConnectivityManager connectivityManager = ((ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE));
        return connectivityManager.getActiveNetworkInfo() != null && connectivityManager.getActiveNetworkInfo().isConnected();
    }
}
