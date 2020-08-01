package com.jdots.coinhunt;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.VideoView;

public class Splash extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        try {


            setTheme(android.R.style.Theme_NoTitleBar_Fullscreen);
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_splash);


            VideoView videoHolder = findViewById(R.id.SplashVideo);
            Uri video = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.splash);
            videoHolder.setVideoURI(video);
            videoHolder.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                public void onCompletion(MediaPlayer mp) {
                    jump();
                }
            });
            videoHolder.start();

        } catch (Exception ex) {

            jump();
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        jump();
        return true;
    }

    private void jump() {
        if (isFinishing())
            return;
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }}