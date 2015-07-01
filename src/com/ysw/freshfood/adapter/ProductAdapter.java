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
import com.ysw.freshfood.model.Product;

public class ProductAdapter extends BaseAdapter {
	
	private Context mContext;
	private LayoutInflater mInflater;
	private List<Product> mProducts;
	
	public ProductAdapter(Context context,List<Product> products) {
		this.mContext = context;
		this.mInflater = LayoutInflater.from(mContext);
		this.mProducts = products;
	}

	@Override
	public int getCount() {
		return mProducts.size();
	}

	@Override
	public Object getItem(int position) {
		return mProducts.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		
		ViewHolder holder;
		if (null == convertView) {
			convertView = mInflater.inflate(R.layout.item_product, parent, false);
			holder = new ViewHolder();
			holder.mProductImg = (ImageView) convertView.findViewById(R.id.iv_product_img);
			holder.mProductNameTv = (TextView) convertView.findViewById(R.id.tv_product_name);
			holder.mProductPriceTv = (TextView) convertView.findViewById(R.id.tv_product_price);
			holder.mVendorNameTv = (TextView) convertView.findViewById(R.id.tv_vendor_name);
			convertView.setTag(holder);
		}else{
			holder = (ViewHolder) convertView.getTag();
		}
		
		Product pdt = mProducts.get(position);
		holder.mProductNameTv.setText(pdt.getProductName());
		holder.mProductPriceTv.setText(""+pdt.getProductPrice());
		holder.mVendorNameTv.setText(pdt.getVendorName());
		
		return convertView;
	}
	
	class ViewHolder{
		public ImageView mProductImg;
		public TextView mProductNameTv;
		public TextView mProductPriceTv;
		public TextView mVendorNameTv;
	}

}
