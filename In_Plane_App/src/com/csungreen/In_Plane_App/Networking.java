package com.csungreen.In_Plane_App;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
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
    public RequestLine getRequestLine() {
        RequestLine req = new RequestLine() {
            @Override
            public String getMethod() {
                return null;
            }

            @Override
            public ProtocolVersion getProtocolVersion() {
                return null;
            }

            @Override
            public String getUri() {
                HttpClient ourServer = new DefaultHttpClient();
                HttpPost postServer = new HttpPost("http://172.31.176.125");
                return null;
            }
        };


        display.setText("Here's your video: " + video);
        return req;

    }
}
