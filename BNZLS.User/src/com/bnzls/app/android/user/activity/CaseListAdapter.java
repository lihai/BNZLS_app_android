package com.bnzls.app.android.user.activity;


import java.util.ArrayList;

import com.bnzls.app.android.model.ServiceCase;
import com.bnzls.app.android.user.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

public class CaseListAdapter extends BaseAdapter{

	private Context _context;
	private LayoutInflater _inflater;
	private ArrayList<ServiceCase> _caseList;
	
	
	public CaseListAdapter(Context ctx, ArrayList<ServiceCase> cases){
		this._context = ctx;
		this._caseList = cases;
		this._inflater = LayoutInflater.from(ctx);
	}
	
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return _caseList.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return _caseList.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		if(convertView == null){
			convertView = _inflater.inflate(R.layout.case_list_item, parent, false);
		}
		return convertView;
	}
	

}
