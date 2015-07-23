package com.example.textactivity;
//somebody
import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class AFragment extends Fragment {
	@Override
	public void onAttach(Activity activity) {
		Log.i("..AFragment","onAttach");
		super.onAttach(activity);
	}   

	@Override
	public void onCreate(Bundle savedInstanceState) {
		Log.i("..AFragment","onCreate");
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		Log.i("..AFragment","onCreateView");
		View view=inflater.inflate(R.layout.fragment, container, false);
		return view;
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		Log.i("..AFragment","onActivityCreated");
		// TODO Auto-generated method stub
		super.onActivityCreated(savedInstanceState);
	}

	@Override
	public void onStart() {
		Log.i("..AFragment","onStart");
		// TODO Auto-generated method stub
		super.onStart();
	}

	@Override
	public void onResume() {
		Log.i("..AFragment","onResume");
		// TODO Auto-generated method stub
		super.onResume();
	}

	@Override
	public void onPause() {
		Log.i("..AFragment","onPause");
		// TODO Auto-generated method stub
		super.onPause();
	}

	@Override
	public void onStop() {
		Log.i("..AFragment","onStop");
		// TODO Auto-generated method stub
		super.onStop();
	}

	@Override
	public void onDestroyView() {
		Log.i("..AFragment","onDestroyView");
		// TODO Auto-generated method stub
		super.onDestroyView();
	}

	@Override
	public void onDestroy() {
		Log.i("..AFragment","onDestroy");
		// TODO Auto-generated method stub
		super.onDestroy();
	}

	@Override
	public void onDetach() {
		Log.i("..AFragment","onDetach");
		// TODO Auto-generated method stub
		super.onDetach();
	}

	@Override
	public void onInflate(Activity activity, AttributeSet attrs,
			Bundle savedInstanceState) {
		Log.i("..AFragment","onInflate");
		// TODO Auto-generated method stub
		super.onInflate(activity, attrs, savedInstanceState);
	}

	@Override
	public void onViewCreated(View view, Bundle savedInstanceState) {
		Log.i("..AFragment","onViewCreated");
		// TODO Auto-generated method stub
		super.onViewCreated(view, savedInstanceState);
	}

}
