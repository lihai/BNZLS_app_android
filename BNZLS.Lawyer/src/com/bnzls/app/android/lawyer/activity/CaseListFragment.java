package com.bnzls.app.android.lawyer.activity;

import java.util.ArrayList;

import com.bnzls.app.android.lawyer.R;
import com.bnzls.app.android.model.ServiceCase;

import android.app.Fragment;
import android.content.Intent;
import android.database.DataSetObserver;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListAdapter;
import android.widget.ListView;

public class CaseListFragment extends Fragment{
	
	public static final int TAB_INDEX = 0;
	
	private CaseListAdapter _adapter;
	private ArrayList<ServiceCase> _caseList;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		//test code:
		_caseList = new ArrayList<ServiceCase>();
		_caseList.add(new ServiceCase());
		_caseList.add(new ServiceCase());
		_adapter = new CaseListAdapter(getActivity(), _caseList);
		
	}
	
		
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
//		return super.onCreateView(inflater, container, savedInstanceState);
		View root = inflater.inflate(R.layout.fragment_case_list,container, false);
		ListView lst = (ListView)root.findViewById(R.id.lst_case);
		if(lst != null){
			lst.setAdapter(_adapter);
			lst.setOnItemClickListener(new OnItemClickListener() {

				@Override
				public void onItemClick(AdapterView<?> parent, View view,
						int position, long id) {
					// TODO Auto-generated method stub
					Intent intent =new Intent(CaseListFragment.this.getActivity(), CaseDetailActivity.class);
//					intent.setc
					CaseListFragment.this.getActivity().startActivity(intent);
				}
			});
		}
		return root;
	}
	
	@Override
	public void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
		
	}

}
