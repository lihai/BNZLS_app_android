package com.bnzls.app.android.user.activity;

import java.util.ArrayList;

import com.bnzls.app.android.user.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

public class LawyerListAdapter extends BaseAdapter{
	
	protected final Context _context;
	protected ArrayList _lawyers;
    protected String host;
//    protected AsyncImageLoader imageLoader;
    private final LayoutInflater _inflater;
    
    public LawyerListAdapter(Context ctx, ArrayList lawyerList){
    	this._context= ctx;
    	this._inflater = LayoutInflater.from(ctx);
    	this._lawyers = lawyerList;
    }
	
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return this._lawyers.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return this._lawyers.get(position);
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
			convertView = this._inflater.inflate(R.layout.lawyer_list_item, parent, false);
		}
		return convertView;
	}

}
