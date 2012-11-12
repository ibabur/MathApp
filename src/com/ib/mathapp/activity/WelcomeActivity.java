package com.ib.mathapp.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;

public class WelcomeActivity extends Activity {
	
	private ImageView loadingImg;
	private static int count;
	final Handler ibHandler = new Handler();
	final Runnable splashHandler = new Runnable() {
		public void run() {

			if(count==3)
			{
				Intent intent = new Intent(WelcomeActivity.this,MenuActivity.class);
				startActivity(intent);
				WelcomeActivity.this.finish();
			}
			else{
				count++;
				if(count==2)
					loadingImg.setImageResource(R.drawable.loading_02);
				if(count==3)
					loadingImg.setImageResource(R.drawable.loading_03);
				
				ibHandler.postDelayed(splashHandler, 2000);
			}
		}
	};

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		loadingImg = (ImageView) findViewById(R.id.loadImg);
		count=1;
		ibHandler.postDelayed(splashHandler, 2000);
	}
}