package com.bnzls.app.android.lawyer.activity;

import com.bnzls.app.android.lawyer.R;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.view.WindowManager.LayoutParams;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class AccountFunctionActivity extends Activity implements OnClickListener{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_setting);
		
		initUI();
	}

	private void initUI() {
		// TODO Auto-generated method stub
		TextView txtTitle = (TextView)findViewById(R.id.nav_title);
		txtTitle.setText("Account Setting");
		
		Button btnBack = (Button)findViewById(R.id.nav_back);
		Button btnNext = (Button)findViewById(R.id.nav_next);
		btnNext.setVisibility(View.GONE);
		btnBack.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				finish();
			}
		});
		
		TextView txtCate = (TextView)findViewById(R.id.txtCate);
		TextView txtDesc = (TextView)findViewById(R.id.txtDesc);
		TextView txtGellary = (TextView)findViewById(R.id.txtGellary);
		TextView txtQuota = (TextView)findViewById(R.id.txtQuota);
		TextView txtResponseTime = (TextView)findViewById(R.id.txtResponseTime);
		TextView txtVoice = (TextView)findViewById(R.id.txtVoice);
		
		txtCate.setOnClickListener(this);
		txtDesc.setOnClickListener(this);
		txtGellary.setOnClickListener(this);
		txtQuota.setOnClickListener(this);
		txtResponseTime.setOnClickListener(this);
		txtVoice.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		int id = v.getId();
		switch (id) {
		case R.id.txtCate:
			openCateDialog();
			break;
			
		case R.id.txtDesc:
			openDescDialog();
			break;
			
		case R.id.txtGellary:
			Intent intent = new Intent(this, GellaryActivity.class);
			startActivity(intent);
			break;
			
		case R.id.txtQuota:
			openQuotaDialog();
			break;
		case R.id.txtResponseTime:
			openResponseTimeDialog();
			break;
			
		case R.id.txtVoice:
			break;

		default:
			break;
		}
	}

	private void openResponseTimeDialog() {
		// TODO Auto-generated method stub
		final Dialog editDialog = new Dialog(this, android.R.style.Theme_NoTitleBar);
		WindowManager.LayoutParams winParam = new LayoutParams();
		winParam.copyFrom(editDialog.getWindow().getAttributes());
		winParam.width = WindowManager.LayoutParams.MATCH_PARENT;
		winParam.height = WindowManager.LayoutParams.WRAP_CONTENT;
		editDialog.getWindow().setAttributes(winParam);
		editDialog.setContentView(R.layout.page_response_time);
//		editDialog.set
		Button btnOK = (Button) editDialog.findViewById(R.id.btnOK);
		Button btnCancel = (Button) editDialog.findViewById(R.id.btnCancel);
		//final EditText edit = (EditText) editDialog.findViewById(R.id.edit_content);
		btnOK.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				//txt.setText(edit.getText());
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

	private void openQuotaDialog() {
		// TODO Auto-generated method stub
		final Dialog editDialog = new Dialog(this, android.R.style.Theme_NoTitleBar);
		WindowManager.LayoutParams winParam = new LayoutParams();
		winParam.copyFrom(editDialog.getWindow().getAttributes());
		winParam.width = WindowManager.LayoutParams.MATCH_PARENT;
		winParam.height = WindowManager.LayoutParams.WRAP_CONTENT;
		editDialog.getWindow().setAttributes(winParam);
		editDialog.setContentView(R.layout.page_case_limit);
//		editDialog.set
		Button btnOK = (Button) editDialog.findViewById(R.id.btnOK);
		Button btnCancel = (Button) editDialog.findViewById(R.id.btnCancel);
		//final EditText edit = (EditText) editDialog.findViewById(R.id.edit_content);
		btnOK.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				//txt.setText(edit.getText());
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

	private void openDescDialog() {
		// TODO Auto-generated method stub
		
	}

	private void openCateDialog() {
		// TODO Auto-generated method stub
		final Dialog editDialog = new Dialog(this, android.R.style.Theme_NoTitleBar);
		WindowManager.LayoutParams winParam = new LayoutParams();
		winParam.copyFrom(editDialog.getWindow().getAttributes());
		winParam.width = WindowManager.LayoutParams.MATCH_PARENT;
		winParam.height = WindowManager.LayoutParams.WRAP_CONTENT;
		editDialog.getWindow().setAttributes(winParam);
		editDialog.setContentView(R.layout.page_categrory_selection);
//		editDialog.set
		Button btnOK = (Button) editDialog.findViewById(R.id.btnOK);
		Button btnCancel = (Button) editDialog.findViewById(R.id.btnCancel);
		//final EditText edit = (EditText) editDialog.findViewById(R.id.edit_content);
		btnOK.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				//txt.setText(edit.getText());
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
}
