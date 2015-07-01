package com.ysw.freshfood.activity;

import android.app.ActionBar;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.TextView;

import com.ysw.freshfood.R;
import com.ysw.freshfood.view.MyProgressDialog;

public class BaseActivity extends Activity {

	private ActionBar mBar;

	public ImageButton mLeftBtn;
	public TextView mRightBtn;
	public TextView mTitle;
	
	public MyProgressDialog mProgressDialog;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		mBar = getActionBar();

		mBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
		mBar.setCustomView(R.layout.action_bar);// 自定义ActionBar布局
		View view = mBar.getCustomView();

		mTitle = (TextView) view.findViewById(R.id.title_text);
		mLeftBtn = (ImageButton) view.findViewById(R.id.title_left_btn);
		mRightBtn = (TextView) view.findViewById(R.id.title_right_btn);

		mLeftBtn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				finish();
				closeAnimRight();
			}
		});
		
		mProgressDialog = new MyProgressDialog(this);

	}

	/**
	 * 打开-从右往左进
	 */
	public void startAnimLeft() {
		overridePendingTransition(R.anim.push_left_in, R.anim.push_left_out);
	}
	
	/**
	 * 打开-从下往上进
	 */
	public void startAnimBottom() {
		overridePendingTransition(R.anim.push_bottom_in, R.anim.push_bottom_out);
	} 
	
	
	/**
	 * 关闭-从左往右出
	 */
	public void closeAnimRight() {
		overridePendingTransition(R.anim.push_right_in, R.anim.push_right_out);
	}
	
	/**
	 * 关闭-从上往下出
	 */
	public void closeAnimBottom() {
		overridePendingTransition(R.anim.push_top_in, R.anim.push_top_out);
	}

}
