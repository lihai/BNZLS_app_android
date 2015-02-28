package com.bnzls.app.android.lawyer.activity;

import com.bnzls.app.android.lawyer.R;

import android.app.Activity;
import android.os.Bundle;

public class CaseDetailActivity extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		//get bundle data, and fill the UI
		setContentView(R.layout.fragment_case_detail);
	}
}
