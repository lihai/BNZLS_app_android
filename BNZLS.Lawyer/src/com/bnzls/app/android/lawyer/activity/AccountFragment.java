package com.bnzls.app.android.lawyer.activity;

import com.bnzls.app.android.lawyer.R;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;

public class AccountFragment extends Fragment
{
	public static final int TAB_INDEX = 2;
	
	private OnClickListener _clickListener = new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			if(v.getId() == R.id.avatar_layout ){
				
			}else if(v.getId() == R.id.statistic){
				
			}else if(v.getId() == R.id.comments){
				Intent intent = new Intent(getActivity(), CommentsListActivity.class);
				getActivity().startActivity(intent);
			}else if(v.getId() == R.id.setting){
				
			}else if(v.getId() == R.id.my_account){
				
			}
		}
	};
	
	
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
//		return super.onCreateView(inflater, container, savedInstanceState);
		
		View root  = inflater.inflate(R.layout.fragment_setting, container, false);
		View avatarView = root.findViewById(R.id.avatar_layout);
		View statView = root.findViewById(R.id.statistic);
		View comView = root.findViewById(R.id.comments);
		View setView = root.findViewById(R.id.setting);
		View accountView = root.findViewById(R.id.my_account);
		
		avatarView.setOnClickListener(this._clickListener);
		statView.setOnClickListener(this._clickListener);
		comView.setOnClickListener(this._clickListener);
		setView.setOnClickListener(this._clickListener);
		accountView.setOnClickListener(this._clickListener);
		
		return root;
	}
	
}
