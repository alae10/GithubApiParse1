package com.example.githubjson;

import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.example.githubjson.R;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
import android.util.Log;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.ListView;

public class MainActivity extends Activity {
	JSONObject jsonobject;
	JSONArray jsonarray;
	ListView listview;
	ListViewAdapter adapter;
	ProgressDialog mProgressDialog;
	//ArrayList<HashMap<String, String>> arraylist;
	static String NAME = "name";
	static String DESCRIPTION = "description";
	static String STARGAZERS = "stargazers_count";
	static String AVATAR = "avatar";
	static String OWNER = "owner";
	ArrayList<HashMap<String, String>> arraylist = new ArrayList<HashMap<String, String>>();
	ArrayList<HashMap<String, String>> arraylist1 = new ArrayList<HashMap<String, String>>();
	private int pageCount=0;
	 int a=1;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.listview_main);
		//mProgressDialog = new ProgressDialog(MainActivity.this);
		new DownloadJSON().execute();
		listview = (ListView) findViewById(R.id.listview);
		//listview.setOnScrollListener(onScrollListener());
	}

	private class DownloadJSON extends AsyncTask<Void, Void, Void>  {

		@Override
		protected void onPreExecute() {
			super.onPreExecute();
			mProgressDialog = new ProgressDialog(MainActivity.this);
			mProgressDialog.setTitle("Github API Json Parse");
			mProgressDialog.setMessage("Loading...");
			mProgressDialog.setIndeterminate(false);
			mProgressDialog.show();
			/*if (mProgressDialog != null) {
				mProgressDialog.dismiss();
			}*/
		}
	
		@Override
		protected Void doInBackground(Void... params) {
			arraylist = new ArrayList<HashMap<String, String>>();
	
			jsonobject = JSONfunctions.getJSONfromURL("https://api.github.com/search/repositories?q="+URLEncoder.encode("created:>2017-10-22")+"&sort="+URLEncoder.encode("stars")+"&order="+URLEncoder.encode("desc"));
			
			try {
				jsonarray = jsonobject.getJSONArray("items");

				for (int i = 0; i < jsonarray.length(); i++) {
					HashMap<String, String> map = new HashMap<String, String>();
					jsonobject = jsonarray.getJSONObject(i);
					map.put("name", jsonobject.getString("name"));
					map.put("description", jsonobject.getString("description"));
					map.put("stargazers_count", jsonobject.getString("stargazers_count"));
					map.put("avatar", jsonobject.getJSONObject("owner").getString("avatar_url"));
					map.put("owner", jsonobject.getJSONObject("owner").getString("login"));
					arraylist.add(map);
				}
			} catch (JSONException e) {
				Log.e("Error", e.getMessage());
				e.printStackTrace();
			}
			//String url="https://api.github.com/search/repositories?q="+URLEncoder.encode("created:>2017-10-22")+"&sort="+URLEncoder.encode("stars")+"&order="+URLEncoder.encode("desc");
			
		//	load(2);

			
//String url1="https://api.github.com/search/repositories?q="+URLEncoder.encode("created:>2017-10-22")+"&sort="+URLEncoder.encode("stars")+"&order="+URLEncoder.encode("desc")+"&page="+URLEncoder.encode("2");
			
		//	load(url1);
			return null;
		}
		@Override
		protected void onPostExecute(Void args) {
			listview = (ListView) findViewById(R.id.listview);
			adapter = new ListViewAdapter(MainActivity.this, arraylist);
			listview.setAdapter(adapter);
			listview.setOnScrollListener(onScrollListener());
			
	 
			if (mProgressDialog != null) {
				mProgressDialog.dismiss();
			}
		}


		
	/*	private void load(int j){
			String a= Integer.toString(j);
			
			jsonobject = JSONfunctions.getJSONfromURL("https://api.github.com/search/repositories?q="+URLEncoder.encode("created:>2017-10-22")+"&sort="+URLEncoder.encode("stars")+"&order="+URLEncoder.encode("desc")+"&page="+URLEncoder.encode(a));
			
			try {
				jsonarray = jsonobject.getJSONArray("items");

				for (int i = 0; i < jsonarray.length(); i++) {
					HashMap<String, String> map = new HashMap<String, String>();
					jsonobject = jsonarray.getJSONObject(i);
					map.put("name", jsonobject.getString("name"));
					map.put("description", jsonobject.getString("description"));
					map.put("stargazers_count", jsonobject.getString("stargazers_count"));
					map.put("avatar", jsonobject.getJSONObject("owner").getString("avatar_url"));
					arraylist.add(map);
				}
			} catch (JSONException e) {
				Log.e("Error", e.getMessage());
				e.printStackTrace();
			}
		}*/
			
		}
	private class DownloadMoreJSON extends AsyncTask<Void, Void, Void>  {

		@Override
		protected void onPreExecute() {
			super.onPreExecute();
			
			//mProgressDialog = new ProgressDialog(MainActivity.this);
			//mProgressDialog.setTitle("Github API Json Parse");
			//mProgressDialog.setMessage("Loading...");
			//mProgressDialog.setIndeterminate(true);
			//mProgressDialog.show();
			//mProgressDialog.dismiss();
		}
	
		@Override
		protected Void doInBackground(Void... params) {
			//arraylist1 = new ArrayList<HashMap<String, String>>();
	a+=1;
	String b=Integer.toString(a);
			jsonobject = JSONfunctions.getJSONfromURL("https://api.github.com/search/repositories?q="+URLEncoder.encode("created:>2017-10-22")+"&sort="+URLEncoder.encode("stars")+"&order="+URLEncoder.encode("desc")+"&page="+URLEncoder.encode(b));
			
			try {
				jsonarray = jsonobject.getJSONArray("items");

				for (int i = 0; i < jsonarray.length(); i++) {
					HashMap<String, String> map = new HashMap<String, String>();
					jsonobject = jsonarray.getJSONObject(i);
					map.put("name", jsonobject.getString("name"));
					map.put("description", jsonobject.getString("description"));
					map.put("stargazers_count", jsonobject.getString("stargazers_count"));
					map.put("avatar", jsonobject.getJSONObject("owner").getString("avatar_url"));
					map.put("owner", jsonobject.getJSONObject("owner").getString("login"));
					arraylist.add(map);
				}
			} catch (JSONException e) {
				Log.e("Error", e.getMessage());
				e.printStackTrace();
			}
			//String url="https://api.github.com/search/repositories?q="+URLEncoder.encode("created:>2017-10-22")+"&sort="+URLEncoder.encode("stars")+"&order="+URLEncoder.encode("desc");
			
		//	load(2);

			
//String url1="https://api.github.com/search/repositories?q="+URLEncoder.encode("created:>2017-10-22")+"&sort="+URLEncoder.encode("stars")+"&order="+URLEncoder.encode("desc")+"&page="+URLEncoder.encode("2");
			
		//	load(url1);
			return null;
		}
		@Override
		protected void onPostExecute(Void args) {
			//arraylist.addAll(arraylist1);
			int position =listview.getLastVisiblePosition();
			//listview = (ListView) findViewById(R.id.listview)
			//adapter = new ListViewAdapter(MainActivity.this, arraylist1);
			adapter.notifyDataSetChanged();
			//listview.setSelectionFromTop(position,0);
			Parcelable state = listview.onSaveInstanceState();
			
			listview.setAdapter(adapter);
			//adapter.notifyDataSetChanged();
			listview.onRestoreInstanceState(state);
			
			
	 
			if (mProgressDialog != null) {
				mProgressDialog.dismiss();
			}
		}


		
	/*	private void load(int j){
			String a= Integer.toString(j);
			
			jsonobject = JSONfunctions.getJSONfromURL("https://api.github.com/search/repositories?q="+URLEncoder.encode("created:>2017-10-22")+"&sort="+URLEncoder.encode("stars")+"&order="+URLEncoder.encode("desc")+"&page="+URLEncoder.encode(a));
			
			try {
				jsonarray = jsonobject.getJSONArray("items");

				for (int i = 0; i < jsonarray.length(); i++) {
					HashMap<String, String> map = new HashMap<String, String>();
					jsonobject = jsonarray.getJSONObject(i);
					map.put("name", jsonobject.getString("name"));
					map.put("description", jsonobject.getString("description"));
					map.put("stargazers_count", jsonobject.getString("stargazers_count"));
					map.put("avatar", jsonobject.getJSONObject("owner").getString("avatar_url"));
					arraylist.add(map);
				}
			} catch (JSONException e) {
				Log.e("Error", e.getMessage());
				e.printStackTrace();
			}
		}*/
			
		}

	private OnScrollListener onScrollListener() {
		  return new OnScrollListener() {

		   @Override
		   public void onScrollStateChanged(AbsListView view, int scrollState) {
		    int threshold = 1;
		    int count = listview.getCount();

		    if (scrollState == SCROLL_STATE_IDLE) {
		     if (listview.getLastVisiblePosition()+1 >= count -threshold && pageCount < 2) {
		    	 int position =listview.getLastVisiblePosition();
		    	 new DownloadMoreJSON().execute();
		    	/* adapter.notifyDataSetChanged();
				//listview.setSelectionFromTop(position,0);
		    	 listview.smoothScrollToPosition(position);
					listview.setAdapter(adapter);*/
					
		     }
		    }
		   }

		 

		@Override
		   public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount,
		     int totalItemCount) {
		   }

		  };
		 }
	}
