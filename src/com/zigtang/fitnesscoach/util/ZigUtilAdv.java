package com.zigtang.fitnesscoach.util;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.RelativeLayout;
import cn.domob.android.ads.DomobAdView;

import com.tencent.exmobwin.MobWINManager;
import com.tencent.exmobwin.Type;
import com.tencent.exmobwin.banner.TAdView;

public class ZigUtilAdv {
	public static View initAdv(Context context) {
		return getMobWinAdvView(context);
		// return getDomobAdvView(context);
	}

	public static void addAdv2Activity(View advView, RelativeLayout advContent) {
		RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.FILL_PARENT,
				RelativeLayout.LayoutParams.WRAP_CONTENT);
		params.addRule(RelativeLayout.CENTER_HORIZONTAL);
		// params.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
		advContent.addView(advView, params);
	}

	public static void destroyAdv() {
		MobWINManager.destroy();
	}

	private static View getDomobAdvView(Context context) {
		DomobAdView adView = DoMobUtil.getAdvView(context);
		return adView;
	}

	private static View getMobWinAdvView(Context context) {
		MobWINManager.init(context, Type.MOBWIN_BANNER);
		TAdView adView = new TAdView((Activity) context);
		// adView.setAdListener(activity); // 可选
		return adView;
	}
}
