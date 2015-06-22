package com.bnzls.app.android.lawyer.activity;
import java.util.ArrayList;

import com.bnzls.app.android.lawyer.R;
import com.bnzls.app.android.lawyer.activity.CommentDetailActivity;
import com.bnzls.app.android.lawyer.activity.CommentListAdapter;
import com.bnzls.app.android.lawyer.activity.CommentsListFragment;
import com.bnzls.app.android.model.ServiceComment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;


public class CommentsListActivity extends Activity{
	
public static final int TAB_INDEX = 1;
	
	private ArrayList<ServiceComment> _comList;
	private CommentListAdapter _adapter;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		//test code
				_comList = new ArrayList<ServiceComment>();
				_comList.add(new ServiceComment());
				_comList.add(new ServiceComment());
				_comList.add(new ServiceComment());
				_adapter = new CommentListAdapter(this, _comList);
				
		setContentView(R.layout.fragment_comments_list);
		
		initUI();
	}
	
	private void initUI() {
		// TODO Auto-generated method stub

		
		Button btnBack = (Button)findViewById(R.id.nav_back);
		
		Button btnNext = (Button)findViewById(R.id.nav_next);
		btnNext.setVisibility(View.GONE);
		
		TextView txtTitle = (TextView)findViewById(R.id.nav_title);
		txtTitle.setText(R.string.label_comments_lsit);
		
		ListView list = (ListView)findViewById(R.id.lst_comment);
		if(list != null){
			list.setAdapter(this._adapter);
		}
		list.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(CommentsListActivity.this, CommentDetailActivity.class);
				intent.putExtra(CommentDetailActivity.CLIENT_NAME, "Ms Zhao");
				CommentsListActivity.this.startActivity(intent);
			}
		});
		
		btnBack.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				CommentsListActivity.this.finish();
			}
		});
	}

	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
		
	}
}
