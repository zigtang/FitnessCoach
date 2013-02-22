package com.zigtang.fitnesscoach.util;

import android.content.Context;
import android.util.Log;
import cn.domob.android.ads.DomobAdEventListener;
import cn.domob.android.ads.DomobAdView;
import cn.domob.android.ads.DomobUpdater;

public class DoMobUtil {
	private static final String publisherID = "56OJzgN4uMicgmwKJw";
	protected static final String TAG = "DoModSDK";

	public static DomobAdView getAdvView(Context context) {
		DomobAdView adView = new DomobAdView(context, publisherID, DomobAdView.INLINE_SIZE_320X50);
		adView.setKeyword("健身，健美，肌肉，锻炼");
		adView.setUserGender("male");
		adView.setUserBirthdayStr("null");
		adView.setUserPostcode("null");
		adView.setAdEventListener(new DomobAdEventListener() {
			@Override
			public void onDomobAdReturned(DomobAdView arg0) {
				Log.i(TAG, "onDomobAdReturned");
			}

			@Override
			public void onDomobAdOverlayPresented(DomobAdView arg0) {
				Log.i(TAG, "onDomobAdOverlayPresented");
			}

			@Override
			public void onDomobAdOverlayDismissed(DomobAdView arg0) {
				Log.i(TAG, "onDomobAdOverlayDismissed");

			}

			@Override
			public void onDomobAdFailed(DomobAdView arg0) {
				Log.i(TAG, "onDomobAdFailed");

			}
		});

		return adView;
	}

	public static void checkUpdate(Context context) {
		DomobUpdater.checkUpdate(context, publisherID);
	}
}
