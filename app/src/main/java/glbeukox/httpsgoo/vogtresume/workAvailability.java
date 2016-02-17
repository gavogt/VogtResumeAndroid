package glbeukox.httpsgoo.vogtresume;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;

/**
 * Created by AQLMAOBCQ on 2/14/2016.
 */

public class workAvailability extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.worktimes);
        String url = "https://goo.gl/WQLTgR";

        //intent for webview
        WebView mobileView = (WebView)
                findViewById(R.id.WebView);
        mobileView.getSettings().setJavaScriptEnabled(true);

        //zoom out of screen
        mobileView.getSettings().setLoadWithOverviewMode(true);
        mobileView.getSettings().setUseWideViewPort(true);

        //try and catch
        try {
            mobileView.loadUrl(url);
        } catch (Exception e)
        {
            //print out catch
            e.printStackTrace();
        }
    }
}
