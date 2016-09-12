package com.aiteu.framework.image;

import java.util.ArrayList;
import java.util.List;

/**
 * 照片扫描结果
 * @author liwei
 *
 */
public class ImageScanResult {
	
	private List<ImageDirInfo> dirInfos;
	
	public ImageScanResult(){
		dirInfos = new ArrayList<ImageDirInfo>();
	}
	
	public void setImageDirInfos(List<ImageDirInfo> dirInfos){
		this.dirInfos = dirInfos;
	}
	
	public List<ImageDirInfo> getImageDirInfos(){
		return dirInfos;
	}
	
	public List<String> getImageFromDir(String dirName){
		if(dirInfos == null || dirInfos.isEmpty()) return null;
		for(ImageDirInfo dirInfo : dirInfos){
			if(dirInfo.dirName != null && dirInfo.dirName.equals(dirName)){
				return dirInfo.mImages;
			}
		}
		return null;
	}
	
	public ImageDirInfo getImageDirInfo(String dirName){
		for(ImageDirInfo dirInfo : dirInfos){
			if(dirInfo.dirName != null && dirInfo.dirName.equals(dirName)){
				return dirInfo;
			}
		}
		ImageDirInfo newDirInfo = new ImageDirInfo(dirName);
		dirInfos.add(newDirInfo);
		return newDirInfo;
	}
}
