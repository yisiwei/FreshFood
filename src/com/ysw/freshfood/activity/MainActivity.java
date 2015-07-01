package com.ysw.freshfood.activity;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

import com.ysw.freshfood.R;
import com.ysw.freshfood.fragment.IndexHomeFragment;
import com.ysw.freshfood.fragment.IndexMyFragment;
import com.ysw.freshfood.fragment.IndexNewsFragment;
import com.ysw.freshfood.fragment.IndexOrderFragment;
import com.ysw.freshfood.utils.Toast;

public class MainActivity extends BaseActivity implements OnClickListener{

	private FragmentManager mFragmentManager;
	private FragmentTransaction mTransaction;

	private long mTouchTime = 0;
	private long mWaitTime = 2000;// 再按一次退出等待时间

	private TextView mTabHome,mTabNews,mTabOrder,mTabMy;// Tab导航

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		mLeftBtn.setVisibility(View.GONE);//隐藏返回按钮

		initView();

		mFragmentManager = getFragmentManager();

		setTabSelection(1);
	}

	/**
	 * 初始化View
	 */
	private void initView() {

		mTabHome = (TextView) findViewById(R.id.index_home);
		mTabNews = (TextView) findViewById(R.id.index_news);
		mTabOrder = (TextView) findViewById(R.id.index_order);
		mTabMy = (TextView) findViewById(R.id.index_my);

		mTabHome.setOnClickListener(this);
		mTabNews.setOnClickListener(this);
		mTabOrder.setOnClickListener(this);
		mTabMy.setOnClickListener(this);

	}

	/**
	 * Tab选项
	 * 
	 * @param index
	 */
	public void setTabSelection(int index) {
		Fragment fragment = null;
		mTransaction = mFragmentManager.beginTransaction();
		Drawable homeDrawable = null;
		Drawable newsDrawable = null;
		Drawable orderDrawable = null;
		Drawable myDrawable = null;
		
		switch (index) {
		case 1:
			fragment = new IndexHomeFragment();
			mTitle.setText("生鲜");

			homeDrawable = getTopDrawable(R.drawable.index_home_on);
			newsDrawable = getTopDrawable(R.drawable.index_news);
			orderDrawable = getTopDrawable(R.drawable.index_order);
			myDrawable = getTopDrawable(R.drawable.index_my);

			mTabHome.setTextColor(getResources().getColor(R.color.title_color));
			mTabNews.setTextColor(getResources().getColor(R.color.title_color_normal));
			mTabOrder.setTextColor(getResources().getColor(R.color.title_color_normal));
			mTabMy.setTextColor(getResources().getColor(R.color.title_color_normal));
			
			break;
		case 2:
			fragment = new IndexNewsFragment();
			mTitle.setText("资讯");

			homeDrawable = getTopDrawable(R.drawable.index_home);
			newsDrawable = getTopDrawable(R.drawable.index_news_on);
			orderDrawable = getTopDrawable(R.drawable.index_order);
			myDrawable = getTopDrawable(R.drawable.index_my);

			mTabHome.setTextColor(getResources().getColor(R.color.title_color_normal));
			mTabNews.setTextColor(getResources().getColor(R.color.title_color));
			mTabOrder.setTextColor(getResources().getColor(R.color.title_color_normal));
			mTabMy.setTextColor(getResources().getColor(R.color.title_color_normal));
			break;
		case 3:
			fragment = new IndexOrderFragment();
			mTitle.setText("订单");

			homeDrawable = getTopDrawable(R.drawable.index_home);
			newsDrawable = getTopDrawable(R.drawable.index_news);
			orderDrawable = getTopDrawable(R.drawable.index_order_on);
			myDrawable = getTopDrawable(R.drawable.index_my);

			mTabHome.setTextColor(getResources().getColor(R.color.title_color_normal));
			mTabNews.setTextColor(getResources().getColor(R.color.title_color_normal));
			mTabOrder.setTextColor(getResources().getColor(R.color.title_color));
			mTabMy.setTextColor(getResources().getColor(R.color.title_color_normal));
			break;
		case 4:
			fragment = new IndexMyFragment();
			mTitle.setText("我的");

			homeDrawable = getTopDrawable(R.drawable.index_home);
			newsDrawable = getTopDrawable(R.drawable.index_news);
			orderDrawable = getTopDrawable(R.drawable.index_order);
			myDrawable = getTopDrawable(R.drawable.index_my_on);

			mTabHome.setTextColor(getResources().getColor(R.color.title_color_normal));
			mTabNews.setTextColor(getResources().getColor(R.color.title_color_normal));
			mTabOrder.setTextColor(getResources().getColor(R.color.title_color_normal));
			mTabMy.setTextColor(getResources().getColor(R.color.title_color));
			break;
		}
		
		mTabHome.setCompoundDrawables(null, homeDrawable, null, null);
		mTabNews.setCompoundDrawables(null, newsDrawable, null, null);
		mTabOrder.setCompoundDrawables(null, orderDrawable, null, null);
		mTabMy.setCompoundDrawables(null, myDrawable, null, null);

		mTransaction.replace(R.id.index_content, fragment);
		mTransaction.commit();
	}
	
	@SuppressWarnings("deprecation")
	private Drawable getTopDrawable(int resId) {
		Drawable drawable = getResources().getDrawable(resId);
		drawable.setBounds(0, 0, drawable.getMinimumWidth(),
				drawable.getMinimumHeight());
		return drawable;
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.index_home:
			setTabSelection(1);
			break;
		case R.id.index_news:
			setTabSelection(2);
			break;
		case R.id.index_order:
			setTabSelection(3);
			break;
		case R.id.index_my:
			setTabSelection(4);
			break;
		}
	}


	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if (keyCode == KeyEvent.KEYCODE_BACK) {// 返回键监听
			long currentTime = System.currentTimeMillis();
			if ((currentTime - mTouchTime) > mWaitTime) {
				Toast.show(this, "再按一次退出程序");
				mTouchTime = currentTime;
			} else {
				this.finish();
			}
			return true;
		}
		return super.onKeyDown(keyCode, event);
	}

}
