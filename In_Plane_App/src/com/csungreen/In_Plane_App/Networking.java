package com.csungreen.In_Plane_App;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.*;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ClipDrawable;
import android.graphics.PorterDuff;
import org.apache.http.ProtocolVersion;
import org.apache.http.RequestLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import android.view.accessibility.AccessibilityManager;


public class Networking extends Activity
{
    TextView display;
    String video;
    Button media,map,menu,bathroom,accessibility;
    SeekBar seekBar;
    DigitalClock clock;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);



        media = (Button) findViewById(R.id.bEntertainment);
        map = (Button) findViewById(R.id.bMap);
        menu = (Button) findViewById(R.id.bFoodnBev);
        bathroom = (Button) findViewById(R.id.bLavatory);
        seekBar = (SeekBar) findViewById(R.id.seekBar);
        seekBar.setMax(15);
        seekBar.setProgress(10);
        clock = (DigitalClock) findViewById(R.id.digitalClock);
        accessibility = (Button) findViewById(R.id.accessibility);

        // Capture button clicks
        media.setOnClickListener(new OnClickListener() {
            public void onClick(View arg0) {

                // Start NewActivity.class
                Intent myIntent = new Intent(Networking.this,
                        MediaActivity.class);
                startActivity(myIntent);
            }
        });
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {


                map.setTextSize(20+progress);
                menu.setTextSize(20+progress);
                bathroom.setTextSize(20+progress);
                media.setTextSize(20+progress);
                clock.setTextSize(20+progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        /*map.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {

                // Start NewActivity.class
                Intent myIntent = new Intent(Networking.this,
                        MapActivity.class);
                startActivity(myIntent);
            }
        });
        menu.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {

                // Start NewActivity.class
                Intent myIntent = new Intent(Networking.this,
                        MenuActivity.class);
                startActivity(myIntent);
            }
        });*/
        bathroom.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                bathroomRequest(arg0);
            }
        });
        accessibility.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                startActivity(new Intent(Settings.ACTION_ACCESSIBILITY_SETTINGS));
            }
        });
    }
    // This function is called whenever the customer hits the bathroom button.
    public void bathroomRequest( View view ){
        AlertDialog.Builder builder = new AlertDialog.Builder( this );
        // TODO: PHP check, how full is the DB
        builder.setMessage("Do you need to go to the bathroom?  The wait is about 10 minutes.");
        builder.setTitle("Restroom Queue");
        builder.setPositiveButton("Queue", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id){
                doAnEnqueue();
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                // Do nothing.  User cancelled the dialog
            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();
    }

    public void doAnEnqueue(){
        EnqueueTask eTask = new EnqueueTask();
        eTask.init( this );
        eTask.execute();
    }
    /*public void onClickEntertainment() {
        final Button entertainmentButton = (Button) findViewById(R.id.bEntertainment);
        entertainmentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent activity
            }
        }
    }

        public void onClickBathroomAction () {
            Button lavatory = (Button) findViewById(R.id.bLavatory);
                HttpClient ourServer = new DefaultHttpClient();
            if ()
                HttpPost postServer = new HttpPost("http://172.31.176.125/bathroom_queue.php");

            }
    public void onClick (View go) {
        setContentView(R.layout.lavatory);
        ToggleButton bathroom = new ToggleButton();
    }*/

}
