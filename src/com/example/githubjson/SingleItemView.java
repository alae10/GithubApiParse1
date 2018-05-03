package com.example.githubjson;

import com.example.githubjson.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class SingleItemView extends Activity {
	// Declare Variables
	String name;
	String description;
	String stargazers_count;
	String avatar;
	String position;
	ImageLoader imageLoader = new ImageLoader(this);
	String owner;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.singleitemview);
		Intent i = getIntent();
		name = i.getStringExtra("name");
		description = i.getStringExtra("description");
		stargazers_count = i.getStringExtra("stargazers_count");
		avatar = i.getStringExtra("avatar");
		owner = i.getStringExtra("owner");
		TextView nametxt = (TextView) findViewById(R.id.name);
		TextView descriptiontxt = (TextView) findViewById(R.id.description);
		TextView startxt = (TextView) findViewById(R.id.stargazers_count);
		ImageView av = (ImageView) findViewById(R.id.avatar);
		TextView ownertxt = (TextView) findViewById(R.id.stargazers_count);
		nametxt.setText(name);
		descriptiontxt.setText(description);
		startxt.setText(stargazers_count);
		imageLoader.DisplayImage(avatar, av);
		ownertxt.setText(stargazers_count);
	}
}