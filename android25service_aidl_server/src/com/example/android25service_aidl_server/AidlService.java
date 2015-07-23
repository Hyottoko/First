package com.example.android25service_aidl_server;

import com.example.service.DataService;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;

public class AidlService extends Service {

	
	public class MyStubBind extends DataService.Stub{

		@Override
		public int getData(String name) throws RemoteException {
			if(name.equals("hello")){
				return 1;
			}
			return -1;
		}
		
	}
	
	@Override
	public IBinder onBind(Intent arg0) {
		
		return new MyStubBind();
	}

}
