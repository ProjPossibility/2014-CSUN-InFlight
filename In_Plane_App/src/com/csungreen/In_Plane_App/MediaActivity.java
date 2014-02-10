package com.csungreen.In_Plane_App;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.webkit.MimeTypeMap;
import android.widget.Button;
import android.view.View.OnClickListener;
import android.net.Uri;



public class MediaActivity extends Activity {

    Button video;
    Button music;
    Button periodical;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Get the layout from video_main.xml
        setContentView(R.layout.media);

        // Locate the button in activity_main.xml
        video = (Button) findViewById(R.id.MyVideoButton);
        music = (Button) findViewById(R.id.MyMusicButton);
        periodical = (Button) findViewById(R.id.MyPeriodicalButton);

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
        periodical.setOnClickListener(new OnClickListener() {
            public void onClick(View arg0) {

                // Start NewActivity.class
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://172.31.176.125/article.pdf"));
                startActivity(browserIntent);

            }
        });
    }

}
