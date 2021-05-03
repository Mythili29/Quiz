package com.example.quiz;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.Button;

public class Instruction extends Activity {

	Button proceed;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.instruction);
		proceed = (Button) findViewById(R.id.Proceed);
		Animation animation = new AlphaAnimation(0.0f, 1.0f);
		animation.setDuration(50); // You can manage the blinking time with this
									// parameter
		animation.setStartOffset(20);
		animation.setRepeatMode(Animation.REVERSE);
		animation.setRepeatCount(Animation.INFINITE);
		proceed.startAnimation(animation);
		proceed.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent i = new Intent(getApplicationContext(), Refactor.class);
				startActivity(i);

			}
		});

	}

}
