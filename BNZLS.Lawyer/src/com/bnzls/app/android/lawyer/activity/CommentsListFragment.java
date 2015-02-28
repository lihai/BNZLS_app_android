package com.bnzls.app.android.lawyer.activity;

import java.util.ArrayList;

import com.bnzls.app.android.lawyer.R;
import com.bnzls.app.android.model.ServiceComment;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

public class CommentsListFragment extends Fragment{
	
	public static final int TAB_INDEX = 1;
	
	private ArrayList<ServiceComment> _comList;
	private CommentListAdapter _adapter;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		//test code
		_comList = new ArrayList<ServiceComment>();
		_comList.add(new ServiceComment());
		_comList.add(new ServiceComment());
		_comList.add(new ServiceComment());
		_adapter = new CommentListAdapter(getActivity(), _comList);
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
//		return super.onCreateView(inflater, container, savedInstanceState);
		View root = inflater.inflate(R.layout.fragment_comments_list, container, false);
		ListView list = (ListView)root.findViewById(R.id.lst_comment);
		if(list != null){
			list.setAdapter(this._adapter);
		}
		list.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(CommentsListFragment.this.getActivity(), CommentDetailActivity.class);
				CommentsListFragment.this.startActivity(intent);
			}
		});
		return root;
	}
}
