package com.example.textactivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class B extends Activity{
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.bactivity);
		Button button=(Button) findViewById(R.id.ton);
		
		Log.e("B-----","onCreate");
		button.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				Intent intent=new Intent(getApplicationContext(), C.class);
				startActivity(intent);
			}
		});
	}
	
	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
		Log.e("B----","onStart");
	}
	
	@Override
	protected void onStop() {
		Log.e("B----","onStop");
		// TODO Auto-generated method stub
		super.onStop();
	}
	
	@Override
	protected void onPause() {
		Log.e("B----","onPause");
		// TODO Auto-generated method stub
		super.onPause();
	}
	
	@Override
	protected void onRestart() {
		Log.e("B----","onRestart");
		// TODO Auto-generated method stub
		super.onRestart();
	}
	
	@Override
	protected void onResume() {
		Log.e("B----","onResume");
		// TODO Auto-generated method stub
		super.onResume();
	}
	
	@Override
	protected void onDestroy() {
		Log.e("B----","onDestroy");
		// TODO Auto-generated method stub
		super.onDestroy();
	}
	
}
