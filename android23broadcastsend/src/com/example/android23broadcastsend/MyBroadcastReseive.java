package com.example.android23broadcastsend;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class MyBroadcastReseive extends BroadcastReceiver {

	@Override
	public void onReceive(Context arg0, Intent arg1) {
		if(arg1.getAction().equals("practice")){
			Toast.makeText(arg0, "接收到广播", 0).show();
		}

	}

}
