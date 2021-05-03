package com.example.quiz;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Typeface;
import android.view.Menu;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.TextView;

public class Result extends Activity {

	TextView tv, tv1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.result);
		tv = (TextView) findViewById(R.id.Result);
		tv1 = (TextView) findViewById(R.id.textView1);
		Animation animation = new AlphaAnimation(0.0f, 1.0f);
		animation.setDuration(50); // You can manage the blinking time with this
									// parameter
		animation.setStartOffset(20);
		animation.setRepeatMode(Animation.REVERSE);
		animation.setRepeatCount(Animation.INFINITE);
		tv1.startAnimation(animation);
		tv1.setTypeface(Typeface.SANS_SERIF);
		SharedPreferences pref = getApplicationContext().getSharedPreferences(
				"MyPref", MODE_PRIVATE);
		Editor editor = pref.edit();

		Intent tcm3 = getIntent();
		int tm3 = tcm3.getIntExtra("mt3", 0);
		tv1.setText("Your Score Is" + tm3);

		String s1 = pref.getString("name", null);
		tv.setText("Welcome  " + s1 + "\n ");
		editor.commit();

	}

}
