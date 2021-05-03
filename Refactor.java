package com.example.quiz;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class Refactor extends Activity {

	Button test, learn, exit, about;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.refactor);
		test = (Button) findViewById(R.id.test);
		learn = (Button) findViewById(R.id.learn);
		exit = (Button) findViewById(R.id.exit);
		about = (Button) findViewById(R.id.about_Us);
		about.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent i = new Intent(getApplicationContext(), About.class);
				startActivity(i);

			}
		});
		exit.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Toast.makeText(getApplicationContext(), "Thank You",
						Toast.LENGTH_SHORT).show();
				finish();

			}
		});
		learn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent i = new Intent(getApplicationContext(),
						LearnSubjectDetails.class);
				startActivity(i);

			}
		});
		test.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent i = new Intent(getApplicationContext(),
						SubjectDisplay.class);
				startActivity(i);
			}
		});
	}

}
