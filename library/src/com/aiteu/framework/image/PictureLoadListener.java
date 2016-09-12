package com.aiteu.framework.image;

public interface PictureLoadListener {
	
	public void startScanning();
	
	public void endScanning(ImageScanResult result);
}
