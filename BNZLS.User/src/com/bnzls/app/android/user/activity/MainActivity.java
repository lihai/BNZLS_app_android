package com.bnzls.app.android.user.activity;

import com.bnzls.app.android.user.R;
import com.bnzls.app.android.user.R.layout;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

public class MainActivity extends Activity {
	
	private ViewPager _viewpager;
	private MainPagerAdapter _pageAdapter;  
	private OnClickListener _tabButtonClickListener = new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			if(v.getId() == R.id.tab_home){
				//TODO:
				MainActivity.this._viewpager.setCurrentItem(HomeFragment.TAB_INDEX);
			}else if(v.getId() == R.id.tab_service){
				MainActivity.this._viewpager.setCurrentItem(LawyerListFragment.TAB_INDEX);
			}else if(v.getId() == R.id.tab_settings){
				MainActivity.this._viewpager.setCurrentItem(MyAccountFragment.TAB_INDEX);
			}
		}
	};
	

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        this.initPagers();
        
        TextView btnHome = (TextView)findViewById(R.id.tab_home);
		btnHome.setOnClickListener(_tabButtonClickListener);
		TextView btnCaseList = (TextView)findViewById(R.id.tab_service);
		btnCaseList.setOnClickListener(_tabButtonClickListener);
		TextView btnMy = (TextView)findViewById(R.id.tab_settings);
		btnMy.setOnClickListener(_tabButtonClickListener);
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
    
    public void trunPager(int idx){
    	if(this._pageAdapter != null){
    		this._viewpager.setCurrentItem(idx);
    	}
    }
}
