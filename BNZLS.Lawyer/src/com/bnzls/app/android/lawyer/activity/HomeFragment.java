package com.bnzls.app.android.lawyer.activity;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import com.bnzls.app.android.lawyer.R;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.TextView;

public class HomeFragment extends Fragment {

	public static final int TAB_INDEX = 0;
	
	private ViewPager viewPager; // android-support-v4中的滑动组件
	private List<ImageView> imageViews; // 滑动的图片集合
	private String[] titles; // 图片标题
	private int[] imageResId; // 图片ID
	private List<View> dots; // 图片标题正文的那些点private int currentItem = 0; // 当前图片的索引号
	private int currentItem = 0; // 当前图片的索引号
	private TextView tv_title;
	private ScheduledExecutorService scheduledExecutorService;

	// 切换当前显示的图片
	private Handler handler = new Handler() {
		public void handleMessage(android.os.Message msg) {
			viewPager.setCurrentItem(currentItem);// 切换当前显示的图片
		};
	};
	
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
	}
	
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View rootView = inflater.inflate(R.layout.fragment_home, container, false);
		initUI(rootView);
		
		return rootView;
	}
	
	private void initUI(View rootView){
		
		TextView txtTitle = (TextView)rootView.findViewById(R.id.title_txt);
		txtTitle.setText(getResources().getString(R.string.label_main_title));
		//to check weather logon
		TextView txtLogin = (TextView)rootView.findViewById(R.id.login_txt);
		//TODO:set the txtlogin text
		txtLogin.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(HomeFragment.this.getActivity(), LoginActivity.class);
				getActivity().startActivity(intent);
			}
		});
		
		imageResId = new int[] { R.drawable.a, R.drawable.b, R.drawable.c, R.drawable.d, R.drawable.e };
		titles = new String[imageResId.length];
		titles[0] = "Recommand Today: Lawyer Zhang\n Star of Future Award \n Perfessional in Realestate affairs.";
		titles[1] = "Recommand Today: Lawyer Wang\n Star of Future Award \n Perfessional in Realestate affairs.";
		titles[2] = "Recommand Today: Lawyer Li\n Star of Future Award \n Perfessional in Realestate affairs.";
		titles[3] = "Recommand Today: Lawyer Zhao\n Star of Future Award \n Perfessional in Realestate affairs.";
		titles[4] = "Recommand Today: Lawyer Liu\n Star of Future Award \n Perfessional in Realestate affairs.";
		imageViews = new ArrayList<ImageView>();
		// 初始化图片资源
		for (int i = 0; i < imageResId.length; i++) {
			ImageView imageView = new ImageView(getActivity());
			imageView.setImageResource(imageResId[i]);
			imageView.setScaleType(ScaleType.CENTER_CROP);
			imageViews.add(imageView);
		}
		dots = new ArrayList<View>();
		dots.add(rootView.findViewById(R.id.v_dot0));
		dots.add(rootView.findViewById(R.id.v_dot1));
		dots.add(rootView.findViewById(R.id.v_dot2));
		dots.add(rootView.findViewById(R.id.v_dot3));
		dots.add(rootView.findViewById(R.id.v_dot4));
		
		tv_title = (TextView) rootView.findViewById(R.id.tv_title);
		tv_title.setText(titles[0]);//
		viewPager = (ViewPager) rootView.findViewById(R.id.imagepager);
		viewPager.setAdapter(new ImageViewPagerAdapter());// 设置填充ViewPager页面的适配器
		// 设置一个监听器，当ViewPager中的页面改变时调用
		viewPager.setOnPageChangeListener(new MyPageChangeListener());
	}
	
	private void updateUIElements(){
		//TODO: update the UI.
	}
	
	@Override
	public void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
		scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
		// 当Activity显示出来后，每两秒钟切换一次图片显示
		scheduledExecutorService.scheduleAtFixedRate(new ScrollTask(), 2, 4, TimeUnit.SECONDS);
	}
	
	@Override
	public void onStop() {
		// TODO Auto-generated method stub
		scheduledExecutorService.shutdown();
		super.onStop();
	}
	
	private class ScrollTask implements Runnable {

		public void run() {
			synchronized (viewPager) {
				System.out.println("currentItem: " + currentItem);
				currentItem = (currentItem + 1) % imageViews.size();
				handler.obtainMessage().sendToTarget(); // 通过Handler切换图片
			}
		}

	}
	
	private class MyPageChangeListener implements OnPageChangeListener {
		private int oldPosition = 0;

		/**
		 * This method will be invoked when a new page becomes selected.
		 * position: Position index of the new selected page.
		 */
		public void onPageSelected(int position) {
			currentItem = position;
			tv_title.setText(titles[position]);
			dots.get(oldPosition).setBackgroundResource(R.drawable.dot_normal);
			dots.get(position).setBackgroundResource(R.drawable.dot_focused);
			oldPosition = position;
		}

		public void onPageScrollStateChanged(int arg0) {

		}

		public void onPageScrolled(int arg0, float arg1, int arg2) {

		}
	}
	
	public class ImageViewPagerAdapter extends PagerAdapter{

		@Override
		public int getCount() {
			return imageResId.length;
		}

		@Override
		public Object instantiateItem(View arg0, int arg1) {
			View imgview = imageViews.get(arg1);
			((ViewPager) arg0).addView(imgview);
			imgview.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					Intent intent = new Intent(HomeFragment.this.getActivity(), LawyerDetailActivity.class);
					HomeFragment.this.getActivity().startActivity(intent);
				}
			});
			return imageViews.get(arg1);
		}

		@Override
		public void destroyItem(View arg0, int arg1, Object arg2) {
			((ViewPager) arg0).removeView((View) arg2);
		}

		@Override
		public boolean isViewFromObject(View arg0, Object arg1) {
			return arg0 == arg1;
		}

		@Override
		public void restoreState(Parcelable arg0, ClassLoader arg1) {

		}

		@Override
		public Parcelable saveState() {
			return null;
		}

		@Override
		public void startUpdate(View arg0) {

		}

		@Override
		public void finishUpdate(View arg0) {

		}
		
	}
	
	
}
