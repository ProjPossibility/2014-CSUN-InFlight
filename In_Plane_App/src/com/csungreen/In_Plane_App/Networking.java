package com.csungreen.In_Plane_App;

import android.app.Activity;
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
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }

    public void onClickEntertainment() {
        final Button entertainmentButton = (Button) findViewById(R.id.bEntertainment);
        entertainmentButton.setOnClickListener();
    }

        public void onClickBathroomAction () {
            Button lavatory = (Button) findViewById(R.id.bLavatory);
                HttpClient ourServer = new DefaultHttpClient();
            if ()
                HttpPost postServer = new HttpPost("http://172.31.176.125/bathroom_queue.php");

            }
   /* public void onClick (View go) {
        setContentView(R.layout.lavatory);
        ToggleButton bathroom = new ToggleButton();
    }*/
}
