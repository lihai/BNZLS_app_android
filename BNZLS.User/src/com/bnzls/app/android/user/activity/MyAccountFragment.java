package com.bnzls.app.android.user.activity;

import com.bnzls.app.android.user.R;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;

public class MyAccountFragment extends Fragment{

	public final static int TAB_INDEX=2;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		//return super.onCreateView(inflater, container, savedInstanceState);
		View rootView = inflater.inflate(R.layout.fragment_my, container, false);
		
		initUI(rootView);
		
		return rootView;
	}

	private void initUI(View rootView) {
		// TODO Auto-generated method stub
		Button btnCases = (Button)rootView.findViewById(R.id.btnCaseList);
		Button btnLawyers = (Button)rootView.findViewById(R.id.btnLawyerList);
		
		btnCases.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(MyAccountFragment.this.getActivity(), CaseListActivity.class);
				MyAccountFragment.this.getActivity().startActivity(intent);
				
			}
		});
	}
}
