package com.bnzls.app.android.user.activity;


import com.bnzls.app.android.user.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class LawyerDetailActivity extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.activity_lawyer_detail);
		initUI();
	}

	private void initUI() {
		// TODO Auto-generated method stub
		Button btnInquire = (Button)findViewById(R.id.btn_inquire);
		btnInquire.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(LawyerDetailActivity.this, InquireActivity.class);
				startActivity(intent);
			}
		});
		
		Button btnBack = (Button)findViewById(R.id.nav_back);
		btnBack.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				LawyerDetailActivity.this.finish();
			}
		});
	}
}
