package com.aiteu.framework.image;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.aiteu.framework.util.LogUtils;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;
import android.provider.MediaStore;

/**
 * 选择图片或者视频
 * 
 * @author liwei
 * 
 */
public class ImageVideoChooser implements IImageChooser {
	
	public static final String ALL_IMAGES = "所有照片";
	public static final String ALL_VIDEOS = "所有视频";

	private Context mContext;
	private ImageScanResult mScanResult;
	private PictureLoadListener mPictureLoadListener;

	public ImageVideoChooser(Context context) {
		this.mContext = context;
		mScanResult = new ImageScanResult();
	}

	@Override
	public void scan(PictureLoadListener listener) {
		this.mPictureLoadListener = listener;
		if (mPictureLoadListener != null)
			mPictureLoadListener.startScanning();
		new ScanTask().execute();
	}

	@Override
	public List<ImageDirInfo> getDirList() {
		// TODO Auto-generated method stub
		return mScanResult.getImageDirInfos();
	}

	@Override
	public List<String> getImageFromDir(String dirName) {
		// TODO Auto-generated method stub
		return mScanResult.getImageFromDir(dirName);
	}

	class ScanTask extends AsyncTask<Void, Void, Void> {

		@Override
		protected Void doInBackground(Void... params) {
			// TODO Auto-generated method stub
			Uri externalImgUri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
			scanImage(externalImgUri);
			Uri internalImgUri = MediaStore.Images.Media.INTERNAL_CONTENT_URI;
			scanImage(internalImgUri);
			return null;
		}

		@Override
		protected void onPostExecute(Void result) {
			if (mPictureLoadListener != null)
				mPictureLoadListener.endScanning(mScanResult);
		}

		private void scanImage(Uri uri) {
			LogUtils.d("scan image uri : "+uri.toString());
			if (mContext == null)
				return;
			String selection = MediaStore.Images.Media.MIME_TYPE + "=? or "
					+ MediaStore.Images.Media.MIME_TYPE + "=?";
			Cursor cursor = mContext.getContentResolver().query(uri, null,
					selection,
					new String[] { "image/jpeg", "image/png"},
					MediaStore.Images.Media.DATE_MODIFIED + " desc");
			if(cursor != null){
				while(!cursor.isClosed() && cursor.moveToNext()){
					String path = cursor.getString(cursor.getColumnIndex(MediaStore.Images.Media.DATA));
					String parentName = new File(path).getParentFile().getName();
					addImage(path, parentName);
					addImage(path, ALL_IMAGES);
				}
				cursor.close();
			}
		}
		
		private void addImage(String filePath, String parentName){
			ImageDirInfo dirInfo = mScanResult.getImageDirInfo(parentName);
			if(dirInfo.mImages == null){
				dirInfo.mImages = new ArrayList<String>();
			}
			dirInfo.mImages.add(filePath);
		}
	}
}
