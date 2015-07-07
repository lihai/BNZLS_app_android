package com.bnzls.app.android.user.activity;

import java.util.ArrayList;

import javax.security.auth.PrivateCredentialPermission;

import com.bnzls.app.android.model.Lawyer;
import com.bnzls.app.android.user.R;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Spinner;

public class LawyerListFragment extends Fragment{

	public final static int TAB_INDEX=1;
	
	private LawyerListAdapter _adapter;
	private ArrayList<Lawyer> _lawyerList;
	
	private ArrayList<String> _cities;
	private ArrayList<String> _cates;
	private ArrayList<String> _sorts;
	
	private ArrayAdapter<String> _cityAdapter;
	private ArrayAdapter<String> _cateAdapter;
	private ArrayAdapter<String> _sortAdapter;
	
	private OnItemClickListener _itemClickListener = new OnItemClickListener() {

		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position,
				long id) {
			// TODO Auto-generated method stub
			view.setVisibility(view.VISIBLE);
		}
	};
	
	
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
		
		_cities = new ArrayList<String>();
		_cities.add("Beijing");
		_cities.add("Shanghai");
		_cities.add("Guangzhou");
		_cities.add("Shenzhen");
		
		_cates= new ArrayList<String>();
		_cates.add("Criminal");
		_cates.add("Labor");
		_cates.add("Realestate");
		_cates.add("Traffic");
		_cates.add("Divoce");
		
		_sorts = new ArrayList<String>();
		_sorts.add("By rate");
		_sorts.add("By years");
		
		_cityAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, _cities);
		_cityAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		_cateAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, _cates);
		_cateAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		_sortAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, _sorts);
		_sortAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		
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
		
		Spinner spnCity = (Spinner)root.findViewById(R.id.spn_loc);
		spnCity.setAdapter(_cityAdapter);
		Spinner spnCate= (Spinner)root.findViewById(R.id.spn_cat);
		spnCate.setAdapter(_cateAdapter);
		Spinner spnSort = (Spinner)root.findViewById(R.id.spn_sort);
		spnSort .setAdapter(_sortAdapter);
		
		
		return root;
	}
}
