package com.bnzls.app.android.user.activity;

import java.util.ArrayList;

import com.bnzls.app.android.model.Lawyer;
import com.bnzls.app.android.user.R;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

public class LawyerListFragment extends Fragment{

	public final static int TAB_INDEX=1;
	
	private LawyerListAdapter _adapter;
	private ArrayList<Lawyer> _lawyerList;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		_lawyerList = new ArrayList<Lawyer>();
		_lawyerList.add(new Lawyer());
		_lawyerList.add(new Lawyer());
		_lawyerList.add(new Lawyer());
		_lawyerList.add(new Lawyer());
		_adapter = new LawyerListAdapter(getActivity(), _lawyerList);
		
		
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		//return super.onCreateView(inflater, container, savedInstanceState);
		View root = inflater.inflate(R.layout.fragment_lawyer_list ,container, false);
		
		ListView lst = (ListView)root.findViewById(R.id.lst_lawyer);
		if(lst != null){
			lst.setAdapter(_adapter);
			lst.setOnItemClickListener(new OnItemClickListener() {

				@Override
				public void onItemClick(AdapterView<?> parent, View view,
						int position, long id) {
					// TODO Auto-generated method stub
					Intent intent =new Intent(LawyerListFragment.this.getActivity(), LawyerDetailActivity.class);
//					intent.putExtra(CaseDetailActivity.CLIENT_NAME, "Ms Zhao");
//					intent.putExtra(CaseDetailActivity.CLIENT_PHONE, "1333333333");
					
					LawyerListFragment.this.getActivity().startActivity(intent);
				}
			});
		}
		
		
		return root;
	}
}
