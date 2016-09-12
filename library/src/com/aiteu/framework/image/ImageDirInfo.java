package com.aiteu.framework.image;

import java.util.List;

/**
 * 目录信息
 * @author liwei
 *
 */
public class ImageDirInfo {
	/**
	 * 图片目录
	 */
	public static final int TYPE_IMAGE = 0;
	/**
	 * 视频目录
	 */
	public static final int TYPE_VIDEO = 1;
	
	/**
	 * 目录的名字
	 */
	public String dirName;
	/**
	 * 目录下所有的文件
	 */
	public List<String> mImages;
	/**
	 * 目录类型：image, video
	 */
	public int dirType;
	
	/**
	 * 图片目录
	 * @param dirName 目录的名字
	 */
	public ImageDirInfo(String dirName){
		this.dirName = dirName;
		this.dirType = TYPE_IMAGE;
		this.mImages = null;
	}
	
	/**
	 * 获取该目录下所有的文件总数
	 * @return
	 */
	public int getCount(){
		return mImages == null ? 0 : mImages.size();
	}
	
	/**
	 * 取得列表的第一张
	 * @return
	 */
	public String getFirstImage(){
		return mImages == null ? "" : mImages.get(0);
	}
}
