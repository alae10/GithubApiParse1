package com.example.githubjson;

import java.util.ArrayList;
import java.util.HashMap;

import com.example.githubjson.R;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class ListViewAdapter extends BaseAdapter {

	
	Context context;
	LayoutInflater inflater;
	ArrayList<HashMap<String, String>> data;
	ImageLoader imageLoader;
	HashMap<String, String> resultp = new HashMap<String, String>();

	public ListViewAdapter(Context context,
			ArrayList<HashMap<String, String>> arraylist) {
		this.context = context;
		data = arraylist;
		imageLoader = new ImageLoader(context);
	}

	@Override
	public int getCount() {
		return data.size();
	}

	@Override
	public Object getItem(int position) {
		return null;
	}

	@Override
	public long getItemId(int position) {
		return 0;
	}

	public View getView(final int position, View convertView, ViewGroup parent) {
		TextView name;
		TextView description;
		TextView stargazers_count;
		ImageView avatar;
		TextView owner;
		inflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

		View itemView = inflater.inflate(R.layout.listview_item, parent, false);
		resultp = data.get(position);
		name = (TextView) itemView.findViewById(R.id.name);
		description = (TextView) itemView.findViewById(R.id.description);
		stargazers_count = (TextView) itemView.findViewById(R.id.stargazers_count);
		avatar = (ImageView) itemView.findViewById(R.id.avatar);
		owner = (TextView) itemView.findViewById(R.id.owner);
		name.setText(resultp.get(MainActivity.NAME));
		description.setText(resultp.get(MainActivity.DESCRIPTION));
		stargazers_count.setText(resultp.get(MainActivity.STARGAZERS));
		imageLoader.DisplayImage(resultp.get(MainActivity.AVATAR), avatar);
		owner.setText(resultp.get(MainActivity.OWNER));
		itemView.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				resultp = data.get(position);
				Intent intent = new Intent(context, SingleItemView.class);
				intent.putExtra("name", resultp.get(MainActivity.NAME));
				intent.putExtra("description", resultp.get(MainActivity.DESCRIPTION));
				intent.putExtra("stargazers_count",resultp.get(MainActivity.STARGAZERS));
				intent.putExtra("avatar", resultp.get(MainActivity.AVATAR));
				context.startActivity(intent);

			}
		});
		return itemView;
	}
}
