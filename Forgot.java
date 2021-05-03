package com.example.quiz;

import android.os.Bundle;
import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.graphics.Typeface;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Forgot extends Activity {

	EditText getPhone;
	TextView dispPhone;
	Button pressPhone;
	SQLiteDatabase sql;
	Cursor cursor;
	String store_name[];

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.forgot);
		getPhone = (EditText) findViewById(R.id.getPhone);
		dispPhone = (TextView) findViewById(R.id.disPlay);
		pressPhone = (Button) findViewById(R.id.get_display);
		Animation animation = new AlphaAnimation(0.0f, 1.0f);
		animation.setDuration(50); // You can manage the blinking time with this
									// parameter
		animation.setStartOffset(20);
		animation.setRepeatMode(Animation.REVERSE);
		animation.setRepeatCount(Animation.INFINITE);
		dispPhone.startAnimation(animation);

		sql = openOrCreateDatabase("inverter", MODE_PRIVATE, null);
		pressPhone.setVisibility(View.INVISIBLE);
		getPhone.addTextChangedListener(new TextWatcher() {

			@Override
			public void onTextChanged(CharSequence arg0, int arg1, int arg2,
					int arg3) {
				// TODO Auto-generated method stub
				String phone = getPhone.getText().toString();

				if (phone.length() > 0) {
					pressPhone.setVisibility(View.VISIBLE);
				}
			}

			@Override
			public void beforeTextChanged(CharSequence arg0, int arg1,
					int arg2, int arg3) {
				// TODO Auto-generated method stub

			}

			@Override
			public void afterTextChanged(Editable arg0) {
				// TODO Auto-generated method stub

			}
		});
		pressPhone.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				String phone1 = getPhone.getText().toString();
				if (phone1.length() > 0) {
					cursor = sql.rawQuery(
							"select password from detail where phone='"
									+ phone1 + "';", null);
					String get_pass = null;
					if ((cursor != null) & (cursor.moveToFirst())) {
						do {
							get_pass = cursor.getString(0);
						} while (cursor.moveToNext());
					}
					dispPhone.setText("Your Password Is \n" + get_pass);
					dispPhone.setTextColor(Color.GREEN);
					dispPhone.setTypeface(Typeface.MONOSPACE);

				}

			}
		});

	}

}
