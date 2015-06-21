package com.bnzls.app.android.lawyer.activity;

import com.bnzls.app.android.lawyer.R;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class HomeFragment extends Fragment {

	public static final int TAB_INDEX = 0;
	
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
	}
	
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View rootView = inflater.inflate(R.layout.fragment_home, container, false);
		TextView txtTitle = (TextView)rootView.findViewById(R.id.title_txt);
		txtTitle.setText(getResources().getString(R.string.label_main_title));
		//to check weather logon
		TextView txtLogin = (TextView)rootView.findViewById(R.id.login_txt);
		//TODO:set the txtlogin text
		
		return rootView;
	}
	
	private void updateUIElements(){
		//TODO: update the UI.
	}
	
	
}
