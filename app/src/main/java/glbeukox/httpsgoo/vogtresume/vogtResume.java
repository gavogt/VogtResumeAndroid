package glbeukox.httpsgoo.vogtresume;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import static android.content.Intent.ACTION_SENDTO;

public class vogtResume extends AppCompatActivity {

    // Display email format
    public String myEmailAdress = "gvogt@asu.edu";
    public String myBodyToEmail = "I would like to schedule an interview with you!";
    public String mySubjectForEmail = "Please open immediately";

    //Create android studio provided on create method for FAB
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        //super for override
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vogt_resume);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //fab intent
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //display snackbar for fab
                Snackbar.make(view, "Lets send you an email!", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();

                //use constance for intent
                Intent contGabe = new Intent(ACTION_SENDTO);
                contGabe.setData(Uri.parse("mailto:" + myEmailAdress));
                //Contact Gabe intent Subject line
                contGabe.putExtra(Intent.EXTRA_SUBJECT, mySubjectForEmail);
                contGabe.putExtra(Intent.EXTRA_TEXT, myBodyToEmail);
                //Determine user app
                startActivity(Intent.createChooser(contGabe, "Which would you prefer?"));


            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_vogt_resume, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        switch (id) {
            //noinspection SimplifiableIfStatement
            case R.id.resume: {

                //launch my google doc's resume
                Intent intent = new Intent(this, launchResume.class);
                Toast.makeText(getApplicationContext(), "Loading Resume...", Toast.LENGTH_SHORT).show();
                startActivity(intent);
                return true;
            }

            //launch my google resume
            case R.id.workAvailability: {
                Intent intent = new Intent(this, workAvailability.class);
                Toast.makeText(getApplicationContext(), "Loading Work Availability...", Toast.LENGTH_SHORT).show();
                startActivity(intent);
                return true;
            }

            //launch my linked in
            case R.id.linkedIn: {
                Intent intent = new Intent(this, linkedInVogt.class);
                Toast.makeText(getApplicationContext(), "Redirecting to LinkedIn...", Toast.LENGTH_SHORT).show();
                startActivity(intent);
                return true;
            }
        }

        //method call
        return super.onOptionsItemSelected(item);
    }


}



