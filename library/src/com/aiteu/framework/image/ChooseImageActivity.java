package com.aiteu.framework.image;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.widget.GridView;

import com.aiteu.framework.BaseActivity;
import com.aiteu.framework.R;

public class ChooseImageActivity extends BaseActivity implements PictureLoadListener{

	private GridView mGridView;
	private ImageAdapter mAdapter;
	private List<String> mCurrentImages;
	private ImageVideoChooser mChooser;
	
	@Override
	protected void onCreate(Bundle bundle) {
		// TODO Auto-generated method stub
		super.onCreate(bundle);
		setContentView(R.layout.activity_choose_image);
		mGridView = (GridView)findViewById(R.id.gridView1);
		mCurrentImages = new ArrayList<String>();
		mAdapter = new ImageAdapter(this, mCurrentImages);
		mGridView.setAdapter(mAdapter);
		
		mChooser = new ImageVideoChooser(this);
		mChooser.scan(this);
	}

	@Override
	public void startScanning() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void endScanning(ImageScanResult result) {
		mCurrentImages.clear();
		List<String> allDirImages = result.getImageFromDir(ImageVideoChooser.ALL_IMAGES);
		if(allDirImages != null){
			mCurrentImages.addAll(allDirImages);
			mAdapter.notifyDataSetChanged();
		}
	}
}
