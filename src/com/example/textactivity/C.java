package com.example.textactivity;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

public class C extends Activity{
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.cactivity);
		Log.e("C-----","onCreate");
	}
	
	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
		Log.e("C----","onStart");
	}
	
	@Override
	protected void onStop() {
		Log.e("C----","onStop");
		// TODO Auto-generated method stub
		super.onStop();
	}
	
	@Override
	protected void onPause() {
		Log.e("C----","onPause");
		// TODO Auto-generated method stub
		super.onPause();
	}
	
	@Override
	protected void onRestart() {
		Log.e("C----","onRestart");
		// TODO Auto-generated method stub
		super.onRestart();
	}
	
	@Override
	protected void onResume() {
		Log.e("C----","onResume");
		// TODO Auto-generated method stub
		super.onResume();
	}
	
	@Override
	protected void onDestroy() {
		Log.e("C----","onDestroy");
		// TODO Auto-generated method stub
		super.onDestroy();
	}
	
}
