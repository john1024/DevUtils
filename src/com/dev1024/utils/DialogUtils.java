package com.dev1024.utils;

import android.app.Activity;
import android.app.Dialog;
import android.view.LayoutInflater;
import android.view.View;

import com.dev1024.johnliu.R;

public class DialogUtils {

	private static Dialog loadingDialog = null;

	/**
	 * ���ؼ��ضԻ���
	 */
	public static void hideLoading() {
		if (loadingDialog != null) {
			loadingDialog.dismiss();
			loadingDialog = null;
		}
	}

	/**
	 * ��ʾ���ضԻ���
	 * 
	 * @param act
	 */
	public static void showLoading(Activity act) {
		if (loadingDialog == null)
			loadingDialog = buildLoading(act);
		loadingDialog.show();
	}

	private static Dialog buildLoading(Activity context) {
		loadingDialog = new Dialog(context, R.style.dialog);
		View progressView = LayoutInflater.from(context).inflate(
				R.layout.loading, null);
		loadingDialog.setContentView(progressView);
		loadingDialog.setCancelable(false);
		return loadingDialog;
	}

}
