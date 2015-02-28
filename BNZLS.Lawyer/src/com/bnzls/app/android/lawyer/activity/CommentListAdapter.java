package com.bnzls.app.android.lawyer.activity;

import java.util.ArrayList;

import com.bnzls.app.android.lawyer.R;
import com.bnzls.app.android.model.ServiceComment;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

public class CommentListAdapter extends BaseAdapter {

	private Context _ctx;
	private ArrayList<ServiceComment> _list;
	
	
	public CommentListAdapter(Context ctx, ArrayList<ServiceComment> list){
		this._ctx = ctx;
		this._list = list;
	}
	
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return _list.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return _list.get(position);
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
			LayoutInflater inflater = LayoutInflater.from(this._ctx);
			convertView = inflater.inflate(R.layout.comments_list_item, parent, false);
			//todo correct the convertView
		}
		return convertView;
	}

}
