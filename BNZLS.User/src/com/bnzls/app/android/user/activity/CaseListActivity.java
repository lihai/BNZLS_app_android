package com.bnzls.app.android.user.activity;


import java.util.ArrayList;

import com.bnzls.app.android.model.ServiceCase;
import com.bnzls.app.android.user.R;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

public class CaseListActivity extends Activity{

	private CaseListAdapter _adapter;
	private ArrayList<ServiceCase> _caseList;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.fragment_case_list);
		
		_caseList = new ArrayList<ServiceCase>();
		_caseList.add(new ServiceCase());
		_caseList.add(new ServiceCase());
		_caseList.add(new ServiceCase());
		
		_adapter = new CaseListAdapter(this, _caseList);
		
		initUI();
	}

	private void initUI() {
		// TODO Auto-generated method stub
		ListView lst = (ListView)findViewById(R.id.lst_case);
		if(lst != null){
			lst.setAdapter(_adapter);
			lst.setOnItemClickListener(new OnItemClickListener() {

				@Override
				public void onItemClick(AdapterView<?> parent, View view,
						int position, long id) {
					// TODO Auto-generated method stub
					Intent intent =new Intent(CaseListActivity.this, CaseRankingActivity.class);
//					intent.putExtra(CaseDetailActivity.CLIENT_NAME, "Ms Zhao");
//					intent.putExtra(CaseDetailActivity.CLIENT_PHONE, "1333333333");
					
					CaseListActivity.this.startActivity(intent);
				}
			});
		}
	}
	
}
