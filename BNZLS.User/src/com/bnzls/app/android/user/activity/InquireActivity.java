package com.bnzls.app.android.user.activity;

import com.bnzls.app.android.user.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class InquireActivity extends Activity{

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.activity_new_case);
		
		initUI();
	}

	private void initUI() {
		// TODO Auto-generated method stub
		Button btnBack = (Button)findViewById(R.id.nav_back);
		btnBack.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				InquireActivity.this.finish();
			}
		});
		
		Button btnNext = (Button)findViewById(R.id.nav_next);
		btnNext.setVisibility(View.VISIBLE);
		btnNext.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(InquireActivity.this, CaseConfirmActivity.class);
				InquireActivity.this.startActivity(intent);
			}
		});
	}
}
