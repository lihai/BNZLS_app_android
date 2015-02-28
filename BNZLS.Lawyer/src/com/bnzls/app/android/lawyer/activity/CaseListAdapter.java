package com.bnzls.app.android.lawyer.activity;

import java.util.ArrayList;

import com.bnzls.app.android.lawyer.R;
import com.bnzls.app.android.lawyer.R.layout;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

public class CaseListAdapter extends BaseAdapter {

	protected final Context _context;
	protected ArrayList _cases;
//    protected ArrayList<Contact> _contacts;
//    protected ArrayList<Contact> _origList;
    protected String host;
//    protected AsyncImageLoader imageLoader;
    private final LayoutInflater _inflater;
    
    public CaseListAdapter(Context ctx, ArrayList caseList){
    	this._context= ctx;
    	this._inflater = LayoutInflater.from(ctx);
    	this._cases = caseList;
    }
	
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return _cases.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return this._cases.get(position);
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
			convertView = this._inflater.inflate(R.layout.case_list_item, parent, false);
		}
		//
		return convertView;
	}

}
