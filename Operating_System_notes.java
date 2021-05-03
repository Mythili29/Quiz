package com.example.quiz;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class Operating_System_notes extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.operating__system_notes);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.operating__system, menu);
		return true;
	}

}
