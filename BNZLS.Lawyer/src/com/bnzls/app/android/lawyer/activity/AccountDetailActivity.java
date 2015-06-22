package com.bnzls.app.android.lawyer.activity;


import com.bnzls.app.android.lawyer.R;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class AccountDetailActivity extends Activity {
	
	private AvatarSelector selector;
	
	private OnClickListener _textListener = new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			final TextView txt = (TextView)v;
			final Dialog editDialog = new Dialog(AccountDetailActivity.this, android.R.style.Theme_NoTitleBar);
			WindowManager.LayoutParams winParam = new LayoutParams();
			winParam.copyFrom(editDialog.getWindow().getAttributes());
			winParam.width = WindowManager.LayoutParams.MATCH_PARENT;
			winParam.height = WindowManager.LayoutParams.WRAP_CONTENT;
			editDialog.getWindow().setAttributes(winParam);
			editDialog.setContentView(R.layout.page_text_edit);
//			editDialog.set
			Button btnOK = (Button) editDialog.findViewById(R.id.btnOK);
			Button btnCancel = (Button) editDialog.findViewById(R.id.btnCancel);
			final EditText edit = (EditText) editDialog.findViewById(R.id.edit_content);
			btnOK.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					txt.setText(edit.getText());
					editDialog.dismiss();
				}
			});
			
			btnCancel.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					editDialog.cancel();
				}
			});
			editDialog.show();
		}
	};
	
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_myaccount);
		
		initUI();
	}
	
	private void initUI() {
		// TODO Auto-generated method stub
		TextView txtBarTitle = (TextView)findViewById(R.id.nav_title);
		txtBarTitle.setText("My");
		
		
		TextView txtLicense = (TextView)findViewById(R.id.txtLicenseNum);
		txtLicense.setText("12121212132323223232");
		txtLicense.setOnClickListener(_textListener);
		
		TextView txtFirm = (TextView)findViewById(R.id.txtFirm);
		txtFirm.setText("Brilliant Legal Service");
		txtFirm.setOnClickListener(_textListener);
		
		TextView txtLoc = (TextView)findViewById(R.id.txtLocation);
		txtLoc.setText("Beijing");
		txtLoc.setOnClickListener(_textListener);
		
		TextView txtEdu = (TextView)findViewById(R.id.txtEdu);
		txtEdu.setText("CUPL");
		txtEdu.setOnClickListener(_textListener);
		
		TextView txtCert = (TextView)findViewById(R.id.txtCert);
		txtCert.setText("CPA, CFA");
		txtCert.setOnClickListener(_textListener);
		
		TextView txtTitle = (TextView)findViewById(R.id.nav_title);
		txtTitle.setText("My infomation");
		Button btnNext =(Button)findViewById(R.id.nav_next);
		btnNext.setVisibility(View.GONE);
		Button btnBack = (Button)findViewById(R.id.nav_back);
		btnBack.setText("Back");
		btnBack.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				finish();
			}
		});
		
		ImageView img = (ImageView)findViewById(R.id.camera_icon);
		img.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				showAvatarSelect(v);
			}
		});
	
	}
	
	
	
	private void showAvatarSelect(View v) {
        if (selector != null && selector.isShowing()) return;
        
        selector = new AvatarSelector(this);
        selector.showAtBottom(getWindow().getDecorView().findViewById(android.R.id.content));
    }

	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
		
	}
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, data);
		if(selector == null) selector = new AvatarSelector(this);
		selector.onActivityResult(requestCode, resultCode, data);
	}
}
