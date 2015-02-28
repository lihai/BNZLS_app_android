package com.bnzls.app.android.lawyer.activity;

import com.bnzls.app.android.lawyer.R;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;

public class MainActivity extends Activity{
	
	private ViewPager _viewpager;
	private MainPagerAdapter _pageAdapter;  

	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.activity_main);
		
		this.initPagers();
		
	}
	

	private void initPagers() {
		// TODO Auto-generated method stub
		this._pageAdapter = new MainPagerAdapter(getFragmentManager());
		
		this._viewpager = (ViewPager)findViewById(R.id.viewpager);
		
		this._viewpager.setAdapter(_pageAdapter);
		
		this._viewpager.setOnPageChangeListener(new OnPageChangeListener() {
			
			@Override
			public void onPageSelected(int arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onPageScrollStateChanged(int arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		
		
	}
}
