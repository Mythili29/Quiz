package com.example.quiz;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class C_Plus_notes extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.c__plus_notes);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.c__plus_notes, menu);
		return true;
	}

}
