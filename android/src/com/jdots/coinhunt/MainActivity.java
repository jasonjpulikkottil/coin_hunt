package com.jdots.coinhunt;


import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.graphics.Point;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.app.Activity;
import android.os.Vibrator;
import android.view.Display;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AnimateButtons();

        SharedPreferences prefs = getSharedPreferences("CoinHuntPreferences",MODE_PRIVATE);
        int score=prefs.getInt("score", 0);




        Button Btn1 = (Button) findViewById(R.id.Bresume);
        Button Btn3 = (Button) findViewById(R.id.Babout);
        Button Btn4 = (Button) findViewById(R.id.Bexit);

        if(score<=0)Btn1.setText("Start");
        if(score>0)Btn1.setText("Resume");


        Btn1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                ButtonBlop();
                Intent i = new Intent(MainActivity.this, AndroidLauncher.class);

                startActivity(i);
				finish();
            }
        });
        Btn3.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                ButtonBlop();

                About_Box();

            }
        });
        Btn4.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                ButtonBlop();

                System.exit(0);
            }
        });




    }


	

	
	
	
	public void About_Box() {
        ImageView img = new ImageView(this);
        img.setImageResource(R.drawable.jdotslab);

        AlertDialog.Builder br =
                new AlertDialog.Builder(this,AlertDialog.THEME_HOLO_LIGHT)
                        .setView(img)

                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        });

        AlertDialog alertDialog = br.create();
        alertDialog.show();
        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        int width = size.x;
        int height = size.y;
        try {
            int orientation = getResources().getConfiguration().orientation;

            if (orientation == Configuration.ORIENTATION_LANDSCAPE) {
                width = size.x/2;
                height = size.x * 3 / 4;
            }

            alertDialog.getWindow().setLayout(width * 3 / 4, height / 2);
        }catch(Exception ignored){}

    }
	
	
	
	
	
	
	
	
	
	
	
	
	
    public void AnimateButtons() {
        final Button puz1 = (Button) findViewById(R.id.Bresume);
        final Button puz3 = (Button) findViewById(R.id.Babout);
        final Button puz4 = (Button) findViewById(R.id.Bexit);

        final Animation Anim1 = AnimationUtils.loadAnimation(this, R.anim.zoomslow);

        puz1.setAnimation(Anim1);
        puz3.setAnimation(Anim1);
        puz4.setAnimation(Anim1);
    }
    public void ButtonBlop() {

        final MediaPlayer mp = MediaPlayer.create(this, R.raw.blop);
        mp.start();
        Vibrator vib = (Vibrator) getApplicationContext().getSystemService(Context.VIBRATOR_SERVICE);
        vib.vibrate(50);

    }
    @Override
    public void onBackPressed(){
        System.exit(0);
    }
}
