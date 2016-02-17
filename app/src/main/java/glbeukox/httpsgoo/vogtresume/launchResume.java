package glbeukox.httpsgoo.vogtresume;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;

public class launchResume extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //assign
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launch_resume);
        String url = "https://goo.gl/oXJq73";

        //intent
        WebView mobileView = (WebView) this.findViewById(R.id.WebView);
        mobileView.getSettings().setJavaScriptEnabled(true);

        //fix screen
        mobileView.getSettings().setLoadWithOverviewMode(true);
        mobileView.getSettings().setUseWideViewPort(true);

        try {
            mobileView.loadUrl(url);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}





