package com.aiteu.framework.util;

import android.util.Log;

public class LogUtils {
	public static final String TAG = LogUtils.class.getSimpleName();
	public static final boolean isOff = true;
	
	public static boolean debugMode(){
		return isOff;
	}
	
	public static void d(String message){
		d(TAG, message);
	}
	
	public static void d(String tag, String message){
		if(debugMode()){
			Log.d(tag, message);
		}
	}
	
	public static void e(String message){
		e(TAG, message);
	}
	
	public static void e(String tag, String message){
		if(debugMode()){
			Log.e(tag, message);
		}
	}
}
