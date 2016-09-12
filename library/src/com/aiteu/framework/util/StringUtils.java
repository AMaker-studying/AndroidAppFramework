package com.aiteu.framework.util;

import java.text.SimpleDateFormat;
import java.util.Date;

import android.text.TextPaint;
import android.text.TextUtils;

public class StringUtils {
	public static final String EMPTY = "";
	/**
	 * 判断字符串是否为空
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isEmpty(String str) {
		return str == null || str.length() == 0 || str.equalsIgnoreCase("null");
	}

	public static boolean isNotEmpty(String str) {
		return !isEmpty(str);
	}
	
	/** 获取字符串宽度 */
	public static float getTextWidth(String Sentence, float Size) {
		if (isEmpty(Sentence))
			return 0;
		TextPaint FontPaint = new TextPaint();
		FontPaint.setTextSize(Size);
		return FontPaint.measureText(Sentence.trim()) + (int) (Size * 0.1); // 留点余地
	}
	
	/**
	 * 格式化日期字符串
	 * 
	 * @param date
	 * @param pattern
	 * @return
	 */
	public static String formatDate(Date date, String pattern) {
		SimpleDateFormat format = new SimpleDateFormat(pattern);
		return format.format(date);
	}

	public static String formatDate(long date, String pattern) {
		SimpleDateFormat format = new SimpleDateFormat(pattern);
		return format.format(new Date(date));
	}
	
	public static boolean isBlank(String s) {
		return TextUtils.isEmpty(s);
	}
	
	/**
	 * 格式化字符串
	 * @param source
	 * @return
	 */
	public static String formatString(String source){
		return isEmpty(source) ? EMPTY : source;
	}
	
	public static int parseInt(String sourceIntValue){
		try{
			return Integer.parseInt(sourceIntValue);
		}catch(NumberFormatException e){
			return 0;
		}
	}
	
	public static int formatInt(String source){
		return parseInt(source);
	}
}
