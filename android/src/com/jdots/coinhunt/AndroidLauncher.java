package com.jdots.coinhunt;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.badlogic.gdx.backends.android.AndroidApplication;
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration;

import com.jdots.coinhunt.JDotsGame;

public class AndroidLauncher extends AndroidApplication {

private TextView TV;
	@Override
	protected void onCreate (Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);


		RelativeLayout layout = new RelativeLayout(this);

		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		getWindow().clearFlags(WindowManager.LayoutParams.FLAG_FORCE_NOT_FULLSCREEN);

		AndroidApplicationConfiguration config = new AndroidApplicationConfiguration();

		View gameView = initializeForView(new JDotsGame(), config);



		// Add the gameView to the view hierarchy
		layout.addView(gameView);



		// Add the AdMob view
		RelativeLayout.LayoutParams adParams =
				new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT,
						RelativeLayout.LayoutParams.WRAP_CONTENT);
		adParams.addRule(RelativeLayout.ALIGN_PARENT_TOP);
		adParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);

		// Add the AdView to the view hierarchy.

		// Hook it all up
		setContentView(layout);

		//initialize(new DoubleDodge(new AndroidDatabaseAccess()), config);
	}

	@Override
	public void onResume() {
		super.onResume();


	}

	@Override
	public void onPause() {


		super.onPause();
	}

	@Override
	public void onDestroy() {


		super.onDestroy();
	}

 @Override
    public void onBackPressed(){
        try{
		Intent i = new Intent(AndroidLauncher.this, MainActivity.class);

                startActivity(i);
				finish();
				}
			catch(Exception ignored){}
    }


}
