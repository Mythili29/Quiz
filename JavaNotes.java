package com.example.quiz;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class JavaNotes extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.java_notes);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.java_notes, menu);
		return true;
	}

}
