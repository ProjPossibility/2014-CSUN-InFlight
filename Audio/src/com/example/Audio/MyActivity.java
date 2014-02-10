package com.example.Audio;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.app.Activity;
import android.content.Intent;

public class MyActivity extends Activity {

    Button video;
    Button music;
    //Button map;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Get the layout from video_main.xml
        setContentView(R.layout.main);

        // Locate the button in activity_main.xml
       video = (Button) findViewById(R.id.MyVideoButton);
       music = (Button) findViewById(R.id.MyMusicButton);
       //map = (Button) findViewById(R.id.MyMapButton);

        // Capture button clicks
        video.setOnClickListener(new OnClickListener() {
            public void onClick(View arg0) {

                // Start NewActivity.class
                Intent myIntent = new Intent(MyActivity.this,
                        VideoViewActivity.class);
                myIntent.putExtra("streamType", "video");
                startActivity(myIntent);
            }
        });
        music.setOnClickListener(new OnClickListener() {
            public void onClick(View arg0) {

                // Start NewActivity.class
                Intent myIntent = new Intent(MyActivity.this,
                        VideoViewActivity.class);
                myIntent.putExtra("streamType", "music");
                startActivity(myIntent);
            }
        });
        //Code for Map Not Working
//        map.setOnClickListener(new OnClickListener() {
//            public void onClick(View arg0) {
//
//                // Start NewActivity.class
//                Intent myIntent = new Intent(MyActivity.this,
//                        MapViewActivity.class);
//                myIntent.putExtra("streamType", "map");
//                startActivity(myIntent);
//            }
//        });


    }

}
