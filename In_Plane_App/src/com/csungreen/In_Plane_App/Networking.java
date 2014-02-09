package com.csungreen.In_Plane_App;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.ToggleButton;
import org.apache.http.ProtocolVersion;
import org.apache.http.RequestLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;


public class Networking extends Activity
{
    TextView display;
    String video;
    Button media,map,menu,bathroom;
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

        // Capture button clicks
        media.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {

                // Start NewActivity.class
                Intent myIntent = new Intent(Networking.this,
                        MediaActivity.class);
                startActivity(myIntent);
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
        });
        bathroom.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {

                // Start NewActivity.class
                Intent myIntent = new Intent(Networking.this,
                        BathroomActivity.class);
                startActivity(myIntent);
            }
        });*/
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
