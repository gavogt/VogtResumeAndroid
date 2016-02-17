package glbeukox.httpsgoo.vogtresume;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ProgressBar;

/**
 * Created by AQLMAOBCQ on 2/13/2016.
 */
public class splash_intro extends AppCompatActivity {

    //progressbar
    protected static final int TIMER_RUNTIME = 3000;
    protected boolean barActive;
    protected ProgressBar inProgressBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splashintro);

        inProgressBar = (ProgressBar) findViewById(R.id.splashLoad);

        //progress bar run
        final Thread timerOfThread = new Thread() {
            public void run() {
                barActive = true;
                try {
                    int waitTime = 0;
                    while (barActive && (waitTime < TIMER_RUNTIME)) {
                        sleep(200);
                        if (barActive) {
                            waitTime += 200;
                            updateBar(waitTime);
                        }
                    }
                } catch (InterruptedException e) {

                }
            }

            public void updateBar(final int timeHasPassed) {
                if (null != inProgressBar) {
                    final int progress = inProgressBar.getMax() * timeHasPassed / TIMER_RUNTIME;
                    inProgressBar.setProgress(progress);
                }
            }

            public void onContinue() {
                Log.d("Continue!", "No!");
            }
        };
        timerOfThread.start();


        Thread introThread = new Thread() {
            public void run() {
                try {
                    sleep(3000);
                    Intent startHome = new Intent(getApplicationContext(), vogtResume.class);
                    startActivity(startHome);
                    finish();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }


            }
        };
        introThread.start();
    }
}
