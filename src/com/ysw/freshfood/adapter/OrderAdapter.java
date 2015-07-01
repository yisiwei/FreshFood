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
import com.ysw.freshfood.model.Order;

public class OrderAdapter extends BaseAdapter {
	
	private Context mContext;
	private LayoutInflater mInflater;
	private List<Order> mOrders;
	
	public OrderAdapter(Context context,List<Order> orders) {
		this.mContext = context;
		this.mInflater = LayoutInflater.from(mContext);
		this.mOrders = orders;
	}

	@Override
	public int getCount() {
		return mOrders.size();
	}

	@Override
	public Object getItem(int position) {
		return mOrders.get(position);
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
		
		Order pdt = mOrders.get(position);
		holder.mProductNameTv.setText(pdt.getProductName());
		holder.mProductPriceTv.setText(""+pdt.getProductPrice());
		
		return convertView;
	}
	
	class ViewHolder{
		public ImageView mProductImg;
		public TextView mProductNameTv;
		public TextView mProductPriceTv;
		public TextView mVendorNameTv;
	}

}
