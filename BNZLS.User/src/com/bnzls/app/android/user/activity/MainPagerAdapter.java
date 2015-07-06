package com.bnzls.app.android.user.activity;

import android.app.Fragment;
import android.app.FragmentManager;
import android.support.v13.app.FragmentPagerAdapter;

public class MainPagerAdapter extends FragmentPagerAdapter{

	private static final int TAB_COUNT = 3;
	
	public MainPagerAdapter(FragmentManager fm) {
		super(fm);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Fragment getItem(int position) {
		// TODO Auto-generated method stub
		switch(position){
		case HomeFragment.TAB_INDEX:
			return new HomeFragment();
			
		case LawyerListFragment.TAB_INDEX:
			return new LawyerListFragment();
			
//		case CommentsListFragment.TAB_INDEX:
//			return new CommentsListFragment();
//			
//		case StatisticFragment.TAB_INDEX:
//			return new StatisticFragment();
//			
		case MyAccountFragment.TAB_INDEX:
			return new MyAccountFragment();
		}
		return new Fragment();
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		//Logger.getLog
		return TAB_COUNT;
	}

}
