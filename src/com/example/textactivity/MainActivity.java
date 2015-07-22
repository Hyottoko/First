package com.example.textactivity;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Log.e("A----","onCreate");
		Button button=(Button) findViewById(R.id.button1);
		button.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				Intent intent=new Intent(MainActivity.this, B.class);
				startActivity(intent);
			}
		});
	}
	
	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
		Log.e("A----","onStart");
	}
	
	@Override
	protected void onStop() {
		Log.e("A----","onStop");
		// TODO Auto-generated method stub
		super.onStop();
	}
	
	@Override
	protected void onPause() {
		Log.e("A----","onPause");
		// TODO Auto-generated method stub
		super.onPause();
	}
	
	@Override
	protected void onRestart() {
		Log.e("A----","onRestart");
		// TODO Auto-generated method stub
		super.onRestart();
	}
	
	@Override
	protected void onResume() {
		Log.e("A----","onResume");
		// TODO Auto-generated method stub
		super.onResume();
	}
	
	@Override
	public void onBackPressed() {
		// TODO Auto-generated method stub
		super.onBackPressed();
		Log.e("A----","onBackPressed");

		
	}
	@Override
	protected void onDestroy() {
		Log.e("A----","onDestroy");
		// TODO Auto-generated method stub
		super.onDestroy();
	}
	
	
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
