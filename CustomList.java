package com.example.quiz;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomList extends ArrayAdapter<String> {

	private final Activity context;
	private final String[] web;
	private final Integer[] imageId;

	public CustomList(Activity context, String[] web, Integer[] imageId) {
		super(context, R.layout.subject_details_view, web);
		this.context = context;
		this.web = web;
		this.imageId = imageId;

	}

	@Override
	public View getView(int position, View view, ViewGroup parent) {
		LayoutInflater inflater = context.getLayoutInflater();
		View rowView = inflater.inflate(R.layout.subject_details_view, null,
				true);
		TextView txtTitle = (TextView) rowView.findViewById(R.id.txt_view);

		ImageView imageView = (ImageView) rowView.findViewById(R.id.img_view);
		txtTitle.setText(web[position]);

		imageView.setImageResource(imageId[position]);
		return rowView;
	}
}