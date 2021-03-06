package com.dev1024.utils;

import android.content.Context;

/**
 * DisplayUtils
 * 
 * Created by John on 2014-5-19.
 */
public class DisplayUtils {

	public static int px2dip(Context context, float px) {
		final float scale = context.getResources().getDisplayMetrics().density;
		return (int) (px / scale + 0.5f);
	}

	public static int dip2px(Context context, float dip) {
		final float scale = context.getResources().getDisplayMetrics().density;
		return (int) (dip * scale + 0.5f);
	}

	public static int px2sp(Context context, float pxValue) {
		final float fontScale = context.getResources().getDisplayMetrics().scaledDensity;
		return (int) (pxValue / fontScale + 0.5f);
	}

	public static int sp2px(Context context, float spValue) {
		final float fontScale = context.getResources().getDisplayMetrics().scaledDensity;
		return (int) (spValue * fontScale + 0.5f);
	}

	/**
	 * Scale the height by Density and Resolution.
	 * 
	 * @param context
	 * @param height
	 * @param screenHeight
	 * @return
	 */
	public static int scaleHeight(Context context, float height,
			int screenHeight) {
		final float scale = context.getResources().getDisplayMetrics().density;
		float targetHeight = screenHeight / scale;
		return (int) ((targetHeight / 480) * height);
	}

}
