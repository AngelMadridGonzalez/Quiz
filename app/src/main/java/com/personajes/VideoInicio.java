package com.personajes;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.widget.VideoView;

/**
 * Created by Engueru on 22/07/2016.
 */
public class VideoInicio extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /*
        setContentView(R.layout.video_layout);
        //PRUEBA VIDEO
        VideoView videoView = (VideoView) findViewById(R.id.video_intro);

        Uri path = Uri.parse("android.resource://"+getPackageName()+"/"+ R.raw.intro_prueba);

        videoView.setVideoURI(path);
        videoView.start();
        videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            public void onCompletion(MediaPlayer mp) {
                Intent i = new Intent(Intent.ACTION_MAIN);
            }
        });
        */
    }

}
