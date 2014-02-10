package com.csungreen.In_Plane_App;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.*;


public class Networking extends Activity
{
    TextView display;
    String video;
    Button media,map,menu,bathroom,accessibility;
    SeekBar seekBar;
    DigitalClock clock;
    float size = 20;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);


        media = (Button) findViewById(R.id.bEntertainment);
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
                menu.setTextSize(20+progress);
                bathroom.setTextSize(20+progress);
                media.setTextSize(20+progress);
                clock.setTextSize(20+progress);
                accessibility.setTextSize(20+progress);
                size = 20+progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        menu.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {

                // Start NewActivity.class
                Intent myIntent = new Intent(Networking.this,
                        MenuActivity.class);
                myIntent.putExtra("FontSize", size);
                startActivity(myIntent);
            }
        });
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
}
