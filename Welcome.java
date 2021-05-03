package com.example.quiz;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Welcome extends Activity {

	EditText phoneNumber, password;
	Button forgetPassworrd, signIn;
	TextView signUp;
	SQLiteDatabase sql;
	Cursor cursor;
	String store_name[];

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.welcome);
		phoneNumber = (EditText) findViewById(R.id.phonenumber);
		password = (EditText) findViewById(R.id.password);
		forgetPassworrd = (Button) findViewById(R.id.forgotpassword);
		signIn = (Button) findViewById(R.id.signIn);
		signUp = (TextView) findViewById(R.id.signUp);
		sql = openOrCreateDatabase("inverter", MODE_PRIVATE, null);

		forgetPassworrd.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent i = new Intent(getApplicationContext(), Forgot.class);
				startActivity(i);

			}
		});

		signUp.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent i = new Intent(Welcome.this, SignUp.class);
				startActivity(i);
			}
		});
		signIn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				String user = phoneNumber.getText().toString();
				String pass = password.getText().toString();
				if ((user.length() > 0) & (pass.length() > 0)) {
					cursor = sql.rawQuery(
							"select password from detail where phone='" + user
									+ "';", null);
					String get_pass = null;
					if ((cursor != null) & (cursor.moveToFirst())) {
						do {
							get_pass = cursor.getString(0);
						} while (cursor.moveToNext());
					}

					try {
						if (pass.equals(get_pass)) {

							Toast.makeText(getApplicationContext(),
									"log in succes", Toast.LENGTH_LONG).show();
							Intent i = new Intent(getApplicationContext(),
									Instruction.class);
							startActivity(i);
						} else {
							Toast.makeText(getApplicationContext(),
									"username and password is not match",
									Toast.LENGTH_LONG).show();
						}

					} catch (Exception e) {
						// TODO: handle exception
					}

				} else {
					Toast.makeText(getApplicationContext(),
							"username and password is empty", Toast.LENGTH_LONG)
							.show();
				}
			}

		});

	}

}
