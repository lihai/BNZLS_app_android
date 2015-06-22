package com.bnzls.app.android.lawyer.activity;

import com.bnzls.app.android.lawyer.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class LoginActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.activity_login);
		
		initUI();
	}

	private void initUI() {
		// TODO Auto-generated method stub
		Button btnLogin = (Button)findViewById(R.id.sign_in_button);
		btnLogin.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(LoginActivity.this, MainActivity.class);
				startActivity(intent);
				finish();
			}
		});
		}
}
