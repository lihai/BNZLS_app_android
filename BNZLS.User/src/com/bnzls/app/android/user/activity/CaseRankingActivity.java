package com.bnzls.app.android.user.activity;

import com.bnzls.app.android.user.R;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.view.WindowManager.LayoutParams;
import android.widget.Button;

public class CaseRankingActivity extends Activity{
	
	private OnClickListener _clickListener = new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			int id=v.getId();
			switch(id){
			case R.id.btn_prof:
			case R.id.btn_service:
				//
				openRankingSelectionDialog();
				break;
				
			case R.id.btn_commit:
				//
				CaseRankingActivity.this.finish();
				break;
				
				default:
					break;
			}
		}
	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.fragment_case_ranking);
		
		this.initUI();
	}

	private void initUI() {
		// TODO Auto-generated method stub
		
		View btnProf = findViewById(R.id.btn_prof);
		View btnServ = findViewById(R.id.btn_service);
		View btnCommit = findViewById(R.id.btn_commit);
		
		btnCommit.setOnClickListener(_clickListener);
		btnProf.setOnClickListener(_clickListener);
		btnServ.setOnClickListener(_clickListener);
	}
	
	private void openRankingSelectionDialog() {
		// TODO Auto-generated method stub
		final Dialog editDialog = new Dialog(this, android.R.style.Theme_NoTitleBar);
		WindowManager.LayoutParams winParam = new LayoutParams();
		winParam.copyFrom(editDialog.getWindow().getAttributes());
		winParam.width = WindowManager.LayoutParams.MATCH_PARENT;
		winParam.height = WindowManager.LayoutParams.WRAP_CONTENT;
		editDialog.getWindow().setAttributes(winParam);
		editDialog.setContentView(R.layout.page_level_selection);
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
