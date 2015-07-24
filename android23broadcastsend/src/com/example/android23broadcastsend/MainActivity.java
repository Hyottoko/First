package com.example.android23broadcastsend;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.content.IntentFilter;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {
	private MyBroadcastReseive receiver;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		receiver=new MyBroadcastReseive();
		
		
		Button button=(Button) findViewById(R.id.button1);
		
		button.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
//				Intent intent=new Intent(MainActivity.this,MyBroadcastReseive.class);
				Intent intent=new Intent();
				intent.setAction("practice");
				sendBroadcast(intent);
			}
		});
	}
	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		IntentFilter filter=new IntentFilter("practice");
		registerReceiver(receiver, filter);
		
	}
	
}
