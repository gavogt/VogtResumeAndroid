package glbeukox.httpsgoo.vogtresume;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;

/**
 * Created by AQLMAOBCQ on 2/14/2016.
 */
public class linkedInVogt extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //intent for LinkedIn
        //follow Resume comments if different
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launch_resume);
        String url = "https://goo.gl/9aMbCm";
        WebView mobileView = (WebView) this.findViewById(R.id.WebView);
        mobileView.getSettings().setJavaScriptEnabled(true);
        mobileView.getSettings().setLoadWithOverviewMode(true);
        mobileView.getSettings().setUseWideViewPort(true);

        //url try and catch
        try {
            mobileView.loadUrl(url);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
