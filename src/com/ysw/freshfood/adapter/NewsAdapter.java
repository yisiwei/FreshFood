package com.ysw.freshfood.adapter;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.ysw.freshfood.R;
import com.ysw.freshfood.model.News;

public class NewsAdapter extends BaseAdapter {
	
	private Context mContext;
	private LayoutInflater mInflater;
	private List<News> mNewsList;
	
	public NewsAdapter(Context context,List<News> newsList) {
		this.mContext = context;
		this.mInflater = LayoutInflater.from(mContext);
		this.mNewsList = newsList;
	}

	@Override
	public int getCount() {
		return mNewsList.size();
	}

	@Override
	public Object getItem(int position) {
		return mNewsList.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		
		ViewHolder holder;
		if (null == convertView) {
			convertView = mInflater.inflate(R.layout.item_order, parent, false);
			holder = new ViewHolder();
			holder.mProductImg = (ImageView) convertView.findViewById(R.id.iv_product_img);
			holder.mProductNameTv = (TextView) convertView.findViewById(R.id.tv_product_name);
			holder.mProductPriceTv = (TextView) convertView.findViewById(R.id.tv_product_price);
			holder.mVendorNameTv = (TextView) convertView.findViewById(R.id.tv_vendor_name);
			convertView.setTag(holder);
		}else{
			holder = (ViewHolder) convertView.getTag();
		}
		
		News news = mNewsList.get(position);
		holder.mProductNameTv.setText(news.getTitle());
		holder.mProductPriceTv.setText(news.getContent());
		
		return convertView;
	}
	
	class ViewHolder{
		public ImageView mProductImg;
		public TextView mProductNameTv;
		public TextView mProductPriceTv;
		public TextView mVendorNameTv;
	}

}
