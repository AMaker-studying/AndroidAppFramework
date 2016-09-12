package com.aiteu.framework.image;

import java.io.File;
import java.util.List;

import com.aiteu.framework.R;
import com.bumptech.glide.Glide;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

public class ImageAdapter extends BaseAdapter{
	
	private Context mContext;
	private List<String> mImagesList;
	private LayoutInflater mInflater;
	public ImageAdapter(Context context, List<String> images){
		this.mContext = context;
		this.mImagesList = images;
		mInflater = (LayoutInflater)mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return mImagesList.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return mImagesList.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		ImageHolder holder = null;
		if(convertView == null){
			convertView = mInflater.inflate(R.layout.choose_image_item, null);
			holder = new ImageHolder();
			holder.itemImage = (ImageView)convertView.findViewById(R.id.imageView1);
			convertView.setTag(holder);
		}else{
			holder = (ImageHolder)convertView.getTag();
		}
		
		Glide.with(mContext).load(new File(mImagesList.get(position))).thumbnail(0.5f).centerCrop().into(holder.itemImage);
		
		return convertView;
	}
	
	class ImageHolder{
		public ImageView itemImage;
	}
}
