package com.aiteu.framework.image;

import java.util.List;

/**
 * 照片选择器
 * @author liwei
 *
 */
public interface IImageChooser {
	
	/**
	 * 扫描系统中的文件
	 * @param listener
	 */
	public void scan(PictureLoadListener listener);
	/**
	 * 获取目录列表信息
	 * @return
	 */
	public List<ImageDirInfo> getDirList();
	
	/**
	 * 获取目录下的文件列表
	 * @param dirName
	 * @return
	 */
	public List<String> getImageFromDir(String dirName);
}
