package com.example.quiz;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class LearnSubjectDetails extends Activity {

	ListView list;
	String[] web = { "C", "C++", "Java", "OS", "DBMS" };
	Integer[] imageId = { R.drawable.c, R.drawable.cpp, R.drawable.java,
			R.drawable.os, R.drawable.dbms };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.learn_subject_details);
		CustomList adapter = new CustomList(LearnSubjectDetails.this, web,
				imageId);
		list = (ListView) findViewById(R.id.subject);
		list.setAdapter(adapter);
		list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				Toast.makeText(LearnSubjectDetails.this,
						"You Clicked at " + web[+position], Toast.LENGTH_SHORT)
						.show();

				switch (position) {
				case 0:
					Intent c = new Intent(getApplicationContext(),
							C_Notes.class);
					startActivity(c);

					break;
				case 1:
					Intent cpp = new Intent(getApplicationContext(),
							C_Plus_notes.class);
					startActivity(cpp);

					break;
				case 2:
					Intent java = new Intent(getApplicationContext(),
							JavaNotes.class);
					startActivity(java);

					break;
				case 3:
					Intent os = new Intent(getApplicationContext(),
							Operating_System_notes.class);
					startActivity(os);
				case 4:
					Intent dbms = new Intent(getApplicationContext(),
							DBMS.class);
					startActivity(dbms);
				default:
					break;
				}

			}
		});

	}

}
