package com.example.quiz;

import java.util.concurrent.TimeUnit;

import com.example.quiz.Java.CounterClass;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class OperatingSystem extends Activity {

	String[] JavaQuestion, getJava_A, getJava_B, getJava_C, getJava_D,
			get_JavaAnswer;

	TextView tvx, tvy, tvanswer, tvquestiontitlebar;
	TextView javaTime;
	EditText tvquest;
	Button getA, getB, getC, getD, left, right, check;
	int index;
	String s1;
	int count = 0;
	int marks = 0;
	public String[] Question = new String[15];

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.operating_system);

		Question[0] = "a";
		Question[1] = "c";
		Question[2] = "d";
		Question[3] = "b";
		Question[4] = "c";
		Question[5] = "a";
		Question[6] = "c";
		Question[7] = "b";
		Question[8] = "a";
		Question[9] = "b";
		Question[10] = "c";
		Question[11] = "b";
		Question[12] = "b";
		Question[13] = "a";
		Question[14] = "b";

		javaTime = (TextView) findViewById(R.id.Os_Timer);
		javaTime.setText("00:02:00");
		final CounterClass timer = new CounterClass(180000, 1000);
		timer.start();

		JavaQuestion = getResources().getStringArray(R.array.get_OS_Question);
		getJava_A = getResources().getStringArray(R.array.get_OS_A);
		getJava_B = getResources().getStringArray(R.array.get_OS_B);
		getJava_C = getResources().getStringArray(R.array.get_OS_C);
		getJava_D = getResources().getStringArray(R.array.get_OS_D);

		left = (Button) findViewById(R.id.Os_left);
		right = (Button) findViewById(R.id.Os_right);

		tvx = (TextView) findViewById(R.id.Os_tvxx);
		tvy = (TextView) findViewById(R.id.Os_tvyy);
		tvquest = (EditText) findViewById(R.id.Os_tvQuestion);

		getA = (Button) findViewById(R.id.Os_getA);
		getB = (Button) findViewById(R.id.Os_getB);
		getC = (Button) findViewById(R.id.Os_getC);
		getD = (Button) findViewById(R.id.Os_getD);

		index = 0;
		tvquest.setText(JavaQuestion[index]);
		getA.setText(getJava_A[index]);
		getB.setText(getJava_B[index]);
		getC.setText(getJava_C[index]);
		getD.setText(getJava_D[index]);

		tvquest.setEnabled(false);
		// tvanswer.setText("press \"A\" Button for the Answer ");
		tvx.setText(String.valueOf(index + 1));
		tvy.setText(String.valueOf("/" + JavaQuestion.length));

		getA.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				count = Integer.valueOf(tvx.getText().toString());
				changeButtonState(count);
				marks += 10;

			}
		});
		getB.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				count = Integer.valueOf(tvx.getText().toString());
				changeButtonState(count);
				marks += 10;
			}
		});
		getC.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				count = Integer.valueOf(tvx.getText().toString());
				changeButtonState(count);
				marks += 10;
			}
		});
		getD.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				count = Integer.valueOf(tvx.getText().toString());
				changeButtonState(count);
				marks += 10;
			}
		});
		left.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				index--;
				if (index == -1) {
					index = getJava_A.length - 1;
					index = getJava_B.length - 1;
					index = getJava_C.length - 1;
					index = getJava_D.length - 1;
					index = JavaQuestion.length - 1;

					tvquest.setText(JavaQuestion[index]);
					getA.setText(getJava_A[index]);
					getB.setText(getJava_B[index]);
					getC.setText(getJava_C[index]);
					getD.setText(getJava_D[index]);
					tvx.setText(String.valueOf(index + 1));
				} else {

					getA.setText(getJava_A[index]);
					getB.setText(getJava_B[index]);
					getC.setText(getJava_C[index]);
					getD.setText(getJava_D[index]);

					tvquest.setText(JavaQuestion[index]);
					tvx.setText(String.valueOf(index + 1));
				}

			}
		});

	}

	private void changeButtonState(int count) {

		String answer = Question[--count];
		Log.d("Java", "" + answer);
		if (answer.equals("a")) {

			getA.setBackgroundColor(Color.GREEN);
			getB.setBackgroundColor(Color.RED);
			getC.setBackgroundColor(Color.RED);
			getD.setBackgroundColor(Color.RED);
		}
		if (answer.equals("c")) {

			getA.setBackgroundColor(Color.RED);
			getB.setBackgroundColor(Color.RED);
			getC.setBackgroundColor(Color.GREEN);
			getD.setBackgroundColor(Color.RED);
		}
		if (answer.equals("d")) {

			getA.setBackgroundColor(Color.RED);
			getB.setBackgroundColor(Color.RED);
			getC.setBackgroundColor(Color.RED);
			getD.setBackgroundColor(Color.GREEN);
		}
		if (answer.equals("b")) {

			getA.setBackgroundColor(Color.RED);
			getB.setBackgroundColor(Color.GREEN);
			getC.setBackgroundColor(Color.RED);
			getD.setBackgroundColor(Color.RED);
		}
		if (answer.equals("c")) {

			getA.setBackgroundColor(Color.RED);
			getB.setBackgroundColor(Color.RED);
			getC.setBackgroundColor(Color.GREEN);
			getD.setBackgroundColor(Color.RED);
		}
		if (answer.equals("a")) {

			getA.setBackgroundColor(Color.GREEN);
			getB.setBackgroundColor(Color.RED);
			getC.setBackgroundColor(Color.RED);
			getD.setBackgroundColor(Color.RED);
		}
		if (answer.equals("c")) {

			getA.setBackgroundColor(Color.RED);
			getB.setBackgroundColor(Color.RED);
			getC.setBackgroundColor(Color.GREEN);
			getD.setBackgroundColor(Color.RED);
		}
		if (answer.equals("b")) {

			getA.setBackgroundColor(Color.RED);
			getB.setBackgroundColor(Color.RED);
			getC.setBackgroundColor(Color.RED);
			getD.setBackgroundColor(Color.GREEN);
		}
		if (answer.equals("a")) {

			getA.setBackgroundColor(Color.GREEN);
			getB.setBackgroundColor(Color.RED);
			getC.setBackgroundColor(Color.RED);
			getD.setBackgroundColor(Color.RED);
		}
		if (answer.equals("b")) {

			getA.setBackgroundColor(Color.RED);
			getB.setBackgroundColor(Color.GREEN);
			getC.setBackgroundColor(Color.RED);
			getD.setBackgroundColor(Color.RED);
		}
		if (answer.equals("c")) {

			getA.setBackgroundColor(Color.RED);
			getB.setBackgroundColor(Color.RED);
			getC.setBackgroundColor(Color.GREEN);
			getD.setBackgroundColor(Color.RED);
		}
		if (answer.equals("a")) {

			getA.setBackgroundColor(Color.GREEN);
			getB.setBackgroundColor(Color.RED);
			getC.setBackgroundColor(Color.RED);
			getD.setBackgroundColor(Color.RED);
		}
		if (answer.equals("b")) {

			getA.setBackgroundColor(Color.RED);
			getB.setBackgroundColor(Color.RED);
			getC.setBackgroundColor(Color.RED);
			getD.setBackgroundColor(Color.GREEN);
		}
		if (answer.equals("b")) {

			getA.setBackgroundColor(Color.RED);
			getB.setBackgroundColor(Color.GREEN);
			getC.setBackgroundColor(Color.RED);
			getD.setBackgroundColor(Color.RED);
		}
		if (answer.equals("a")) {

			getA.setBackgroundColor(Color.GREEN);
			getB.setBackgroundColor(Color.RED);
			getC.setBackgroundColor(Color.RED);
			getD.setBackgroundColor(Color.RED);
		}
		if (answer.equals("c")) {

			getA.setBackgroundColor(Color.RED);
			getB.setBackgroundColor(Color.RED);
			getC.setBackgroundColor(Color.GREEN);
			getD.setBackgroundColor(Color.RED);
		}

		right.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				getA.setBackgroundColor(getResources().getColor(
						R.color.buttonColor));
				getB.setBackgroundColor(getResources().getColor(
						R.color.buttonColor));
				getC.setBackgroundColor(getResources().getColor(
						R.color.buttonColor));
				getD.setBackgroundColor(getResources().getColor(
						R.color.buttonColor));

				index++;
				if ((index == JavaQuestion.length)
						& (index == getJava_A.length)
						& (index == getJava_B.length)
						& (index == getJava_D.length))
				{
					Intent i = new Intent(getApplicationContext(), Result.class);
					i.putExtra("mt3", marks);
					startActivity(i);

					index = 0;
					Toast.makeText(getApplicationContext(),
							"your Score is" + marks, Toast.LENGTH_LONG).show();
					getA.setText(getJava_A[index]);
					getB.setText(getJava_B[index]);
					getC.setText(getJava_C[index]);
					getD.setText(getJava_D[index]);
					tvquest.setText(JavaQuestion[index]);
					tvx.setText(String.valueOf(index + 1));
				} else {
					getA.setText(getJava_A[index]);
					getB.setText(getJava_B[index]);
					getC.setText(getJava_C[index]);
					getD.setText(getJava_D[index]);

					tvquest.setText(JavaQuestion[index]);
					tvx.setText(String.valueOf(index + 1));

				}

			}
		});

	}

	public class CounterClass extends CountDownTimer {
		public CounterClass(long millisInFuture, long countDownInterval) {
			super(millisInFuture, countDownInterval);
		}

		@Override
		public void onFinish() {
			Toast.makeText(getApplicationContext(), "Time over ",
					Toast.LENGTH_LONG).show();
			finish();
		}

		public void onTick(long millisUntilFinished) {
			long millis = millisUntilFinished;
			String hms = String.format(
					"%02d:%02d:%02d",
					TimeUnit.MILLISECONDS.toHours(millis),
					TimeUnit.MILLISECONDS.toMinutes(millis)
							- TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS
									.toHours(millis)),
					TimeUnit.MILLISECONDS.toSeconds(millis)
							- TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS
									.toMinutes(millis)));
			System.out.println(hms);
			javaTime.setText(hms);
		}
	}

}
