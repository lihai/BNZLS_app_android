package com.bnzls.app.android.lawyer.activity;

import com.bnzls.app.android.lawyer.R;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class CommentDetailActivity extends Activity {

	public static final String CLIENT_NAME = "client name";
	public static final String CLIENT_ID = "client id";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.fragment_comments_detail);
		
		initUI();
	}
	
	private void initUI() {
		// TODO Auto-generated method stub
		Button btnBack = (Button)findViewById(R.id.nav_back);
		
		Button btnNext = (Button)findViewById(R.id.nav_next);
		btnNext.setVisibility(View.GONE);
		
		TextView txtTitle = (TextView)findViewById(R.id.nav_title);
		txtTitle.setText(this.getIntent().getStringExtra(CLIENT_NAME));
		
		btnBack.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				CommentDetailActivity.this.finish();
			}
		});
	}

	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
		

	}
}
