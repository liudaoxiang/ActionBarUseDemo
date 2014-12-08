package com.example.actionbartest;

import android.app.Application;
import android.content.Context;
import android.widget.Toast;

public class MyAPP extends Application {

	private static Context mContext;

	@Override
	public void onCreate() {
		super.onCreate();
		mContext = this;
	}

	public static void showToast(String msg, int time) {
		Toast.makeText(mContext, msg, time).show();
	}

	public static void showToast(String msg) {
		showToast(msg, Toast.LENGTH_SHORT);
	}

}
