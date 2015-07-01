package com.ysw.freshfood.fragment;

import java.util.ArrayList;
import java.util.List;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ListView;

import com.ysw.freshfood.R;
import com.ysw.freshfood.adapter.ProductAdapter;
import com.ysw.freshfood.model.Product;

public class IndexHomeFragment extends Fragment implements OnClickListener,
		OnRefreshListener {

	private SwipeRefreshLayout mSwipeRefreshLayout;
	private ListView mProductLv;
	private List<Product> mProducts;
	private ProductAdapter mAdapter;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_index_home, container,
				false);

		mSwipeRefreshLayout = (SwipeRefreshLayout) view
				.findViewById(R.id.product_swipeRefreshLayout);
		mSwipeRefreshLayout.setOnRefreshListener(this);
		mSwipeRefreshLayout
				.setProgressBackgroundColorSchemeResource(R.color.line);
		mSwipeRefreshLayout.setColorSchemeResources(
				android.R.color.holo_blue_bright,
				android.R.color.holo_green_light,
				android.R.color.holo_orange_light,
				android.R.color.holo_red_light);
		
		mProductLv = (ListView) view.findViewById(R.id.product_list);
		initData();
		mAdapter = new ProductAdapter(getActivity(), mProducts);
		mProductLv.setAdapter(mAdapter);

		return view;
	}

	private void initData() {
		mProducts = new ArrayList<Product>();
		for (int i = 0; i < 5; i++) {
			Product pdt = new Product();
			pdt.setProductName("商品"+i);
			pdt.setProductPrice(100+i);
			pdt.setVendorName("商家"+i);
			mProducts.add(pdt);
		}
	}

	@Override
	public void onClick(View v) {

	}

	@Override
	public void onRefresh() {
		mSwipeRefreshLayout.setRefreshing(false);
	}

}
