package com.bnzls.app.android.lawyer.activity;

import java.util.logging.Logger;

import android.app.Fragment;
import android.app.FragmentManager;
import android.support.v13.app.FragmentPagerAdapter;
import android.view.View;

public class MainPagerAdapter extends FragmentPagerAdapter{

	private static final int TAB_COUNT = 4;
	
	public MainPagerAdapter(FragmentManager fm) {
		super(fm);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Fragment getItem(int position) {
		// TODO Auto-generated method stub
		switch(position){
		case CaseListFragment.TAB_INDEX:
			return new CaseListFragment();
			
		case CommentsListFragment.TAB_INDEX:
			return new CommentsListFragment();
			
		case StatisticFragment.TAB_INDEX:
			return new StatisticFragment();
			
		case AccountFragment.TAB_INDEX:
			return new AccountFragment();
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
