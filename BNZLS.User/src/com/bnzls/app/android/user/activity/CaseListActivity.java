package com.bnzls.app.android.user.activity;


import com.bnzls.app.android.user.R;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class CaseListActivity extends Activity{

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.fragment_case_list);
		
		initUI();
	}

	private void initUI() {
		// TODO Auto-generated method stub
		
	}
	
}
