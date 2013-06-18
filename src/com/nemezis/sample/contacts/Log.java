package com.nemezis.sample.contacts;

public class Log {
	private static String TAG = "com.nemezis.sample.contacts";
	
	public static void i(String message) {
		android.util.Log.i(TAG, message);
	}

}
