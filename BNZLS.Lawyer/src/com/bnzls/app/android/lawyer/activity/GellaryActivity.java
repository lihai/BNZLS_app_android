package com.bnzls.app.android.lawyer.activity;

import com.bnzls.app.android.lawyer.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class GellaryActivity extends Activity implements OnClickListener{

	private AvatarSelector selector;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_gallery);
		
		initUI();
	}

	private void initUI() {
		// TODO Auto-generated method stub
		Button btnA = (Button)findViewById(R.id.first_btn);
		Button btnB = (Button)findViewById(R.id.sec_btn);
		Button btnC = (Button)findViewById(R.id.third_btn);
		
		btnA.setOnClickListener(this);
		btnB.setOnClickListener(this);
		btnC.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
	if (selector != null && selector.isShowing()) return;
	        
        selector = new AvatarSelector(this);
        selector.showAtBottom(getWindow().getDecorView().findViewById(android.R.id.content));
	}
}
