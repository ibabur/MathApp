package com.ib.mathapp.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;

public class MenuActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);

        ImageButton homeBtnAdd = (ImageButton) findViewById(R.id.homeBtnAdd);
        homeBtnAdd.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {

				Intent vIntent = new Intent(MenuActivity.this,
						HomeActivity.class);
				startActivity(vIntent);
				finish();
			}
		});
    }
}