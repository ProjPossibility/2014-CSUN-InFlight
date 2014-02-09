package com.csungreen.In_Plane_App;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.view.View.OnClickListener;



public class MediaActivity extends Activity {

    Button video;
    Button music;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Get the layout from video_main.xml
        setContentView(R.layout.media);

        // Locate the button in activity_main.xml
        video = (Button) findViewById(R.id.MyVideoButton);
        music = (Button) findViewById(R.id.MyMusicButton);
        // Capture button clicks
        video.setOnClickListener(new OnClickListener() {
            public void onClick(View arg0) {

                // Start NewActivity.class
                Intent myIntent = new Intent(MediaActivity.this,
                        VideoViewActivity.class);
                myIntent.putExtra("streamType", "video");
                startActivity(myIntent);
            }
        });
        music.setOnClickListener(new OnClickListener() {
            public void onClick(View arg0) {

                // Start NewActivity.class
                Intent myIntent = new Intent(MediaActivity.this,
                        VideoViewActivity.class);
                myIntent.putExtra("streamType", "music");
                startActivity(myIntent);
            }
        });
    }

}
