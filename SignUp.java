package com.example.quiz;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class SignUp extends Activity {

	EditText r_Username, r_Password, r_RePassword, r_PhoneNumber;
	CheckBox r_Check;
	Button r_regiser;
	SQLiteDatabase sql;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.sign_up);

		r_Username = (EditText) findViewById(R.id.get_R_Username);
		r_Password = (EditText) findViewById(R.id.get_R_Password);
		r_RePassword = (EditText) findViewById(R.id.get_R_Repassword);
		r_PhoneNumber = (EditText) findViewById(R.id.get_R_Number);
		r_Check = (CheckBox) findViewById(R.id.get_R_Check);
		r_regiser = (Button) findViewById(R.id.register);

		sql = this.openOrCreateDatabase("inverter", MODE_PRIVATE, null);
		sql.execSQL("create table if not exists detail(username text,phone text primary key,password text);");

		r_regiser.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				String username = r_Username.getText().toString();
				String password = r_Password.getText().toString();
				String rePassword = r_RePassword.getText().toString();
				String phoneNumber = r_PhoneNumber.getText().toString();
				try {
					if ((username.length() > 0) & (password.length() > 0)
							& (rePassword.length() > 0)
							& (phoneNumber.length() > 0)) {
						if (phoneNumber.length() < 10) {

						}
						if (password.equals(rePassword)) {

							sql.execSQL("insert into detail values('"
									+ username + "','" + phoneNumber + "','"
									+ password + "');");
							SharedPreferences pref = getApplicationContext()
									.getSharedPreferences("MyPref",
											MODE_PRIVATE);
							Editor editor = pref.edit();
							editor.putString("name", username);
							editor.commit();

							Toast.makeText(getApplicationContext(), "success",
									Toast.LENGTH_LONG).show();
							Intent i = new Intent(getApplicationContext(),
									Welcome.class);
							startActivity(i);

						} else {
							Toast.makeText(getApplicationContext(),
									"Password is not match....!",
									Toast.LENGTH_SHORT).show();
						}
					} else {
						Toast.makeText(getApplicationContext(),
								"Enter all details..!", Toast.LENGTH_SHORT)
								.show();
					}

				} catch (SQLException e) {
					Toast.makeText(getApplicationContext(),
							"This user already exit..!", Toast.LENGTH_SHORT)
							.show();
				}
			}

		});

	}
}
