package com.bnzls.app.android.lawyer.activity;

import com.bnzls.app.android.lawyer.R;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class CaseDetailActivity extends Activity{

	public static final String CLIENT_NAME = "client name";
	public static final String CLIENT_PHONE="client phone";
	public static final String CASE_ID = "case id";
	
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		//get bundle data, and fill the UI
		setContentView(R.layout.fragment_case_detail);
		
	}
	
	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
		
		Button btnBack = (Button)findViewById(R.id.nav_back);
		Button btnNext = (Button)findViewById(R.id.nav_next);
		btnNext.setVisibility(View.GONE);
		ImageButton btnDail = (ImageButton)findViewById(R.id.dialButton);
		TextView txtTitle = (TextView)findViewById(R.id.nav_title);
		txtTitle.setText(getIntent().getStringExtra(CLIENT_NAME));
		
		btnBack.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				CaseDetailActivity.this.finish();
			}
		});
		btnDail.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				//TelephonyManager telphony=(TelephonyManager) CaseDetailActivity.this.getSystemService(TELEPHONY_SERVICE);
//				telphony.
				
				Intent callIntent = new Intent(Intent.ACTION_CALL);
				callIntent.setData(Uri.parse("tel:"+CaseDetailActivity.this.getIntent().getStringExtra(CLIENT_PHONE)));
				startActivity(callIntent);
			}
		});
		
	}
}
