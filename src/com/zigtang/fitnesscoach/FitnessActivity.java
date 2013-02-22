package com.zigtang.fitnesscoach;

import android.app.Activity;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.VideoView;

import com.zigtang.fitnesscoach.bean.FitnessDetailInfo;
import com.zigtang.fitnesscoach.util.ZigUtilAdv;

public class FitnessActivity extends Activity {
	FitnessDetailInfo info;
	ListView lv;
	VideoView vv;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_fitness);
		findViews();
		int id = Integer.parseInt(getIntent().getExtras().getString("id"));
		info = getFitnessDetailInfo(id);
		initData();
		playVideo();
		advOperation();
	}

	private void advOperation() {
		View advView = ZigUtilAdv.initAdv(this);
		RelativeLayout advContent = (RelativeLayout) findViewById(R.id.adView);
		ZigUtilAdv.addAdv2Activity(advView, advContent);
	}

	// @Override
	// protected void onResume() {
	// super.onResume();
	// if (!ZigUtilNetwork.isNetworkAvailable(this)) {
	// AlertDialog.Builder builder = new Builder(this);
	// builder.setTitle("温馨提示");
	// builder.setMessage("大哥，开下网络呗，我也是出来混口饭吃~多不容易，您说是不是？我就是那个苦逼的程序猿，整天起早贪黑，天天加班，忙死忙活，您开下网络，让我赚点零花钱，买瓶大宝什么的，我也需要保养嘛，是不是。我就展示下广告，您要是嫌烦，不看他就是了，对吧~保证不耗流量，您要是发现耗流量，您立马删掉，我绝对没有意见~那可说好了哦，一定得开网络哦~，记住咯，一定得开哦~");
	// builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
	// @Override
	// public void onClick(DialogInterface dialog, int which) {
	// startActivity(new Intent(Settings.ACTION_WIRELESS_SETTINGS));
	// }
	// });
	//
	// builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
	// @Override
	// public void onClick(DialogInterface dialog, int which) {
	// FitnessActivity.this.finish();
	// }
	// });
	// builder.create().show();
	// } else {
	//
	// }
	// }

	private void findViews() {
		lv = (ListView) findViewById(R.id.lv_finess_detail);
		vv = (VideoView) findViewById(R.id.vv_finess_detail);
	}

	private void initData() {
		lv.setAdapter(new Adapter());
	}

	class Adapter extends BaseAdapter {
		String[] title = new String[] { "重点锻炼部位", "开始位置", "结束位置", "动作过程", "训练要点", "PS" };

		@Override
		public int getCount() {
			return info == null ? 0 : (info.description[5].equals("") ? 5 : 6);
		}

		@Override
		public Object getItem(int arg0) {
			return null;
		}

		@Override
		public long getItemId(int arg0) {
			return 0;
		}

		@Override
		public View getView(int position, View converView, ViewGroup parent) {
			if (converView == null) {
				converView = LayoutInflater.from(FitnessActivity.this).inflate(R.layout.item_fitness_detail, null);
			}
			((TextView) converView.findViewById(R.id.tv_item_front)).setText(title[position]);
			((TextView) converView.findViewById(R.id.tv_item_end)).setText(info.description[position]);

			return converView;
		}
	}

	private FitnessDetailInfo getFitnessDetailInfo(int id) {
		FitnessDetailInfo info = new FitnessDetailInfo();
		switch (id) {
		//
		case 0:
			info.description = getResources().getStringArray(R.array.gllzhc);
			info.videoResourceId = R.drawable.v_00;
			break;

		case 1:
			info.description = getResources().getStringArray(R.array.jpjylhgl);
			info.videoResourceId = R.drawable.v_01;
			break;
		case 2:
			info.description = getResources().getStringArray(R.array.fsylcpj);
			info.videoResourceId = R.drawable.v_02;
			break;
		case 3:
			info.description = getResources().getStringArray(R.array.zzyltj);
			info.videoResourceId = R.drawable.v_03;
			break;
		//
		case 10:
			info.description = getResources().getStringArray(R.array.glywtj);
			info.videoResourceId = R.drawable.v_10;
			break;
		case 11:
			info.description = getResources().getStringArray(R.array.xgjfwc);
			info.videoResourceId = R.drawable.v_11;
			break;
		case 12:
			info.description = getResources().getStringArray(R.array.yltj);
			info.videoResourceId = R.drawable.v_12;
			break;
		case 13:
			info.description = getResources().getStringArray(R.array.ylfn);
			info.videoResourceId = R.drawable.v_13;
			break;
		//
		case 20:
			info.description = getResources().getStringArray(R.array.ywss);
			info.videoResourceId = R.drawable.v_20;
			break;
		case 21:
			info.description = getResources().getStringArray(R.array.ywqz);
			info.videoResourceId = R.drawable.v_21;
			break;
		case 22:
			info.description = getResources().getStringArray(R.array.jtnzsf);
			info.videoResourceId = R.drawable.v_22;
			break;
		case 23:
			info.description = getResources().getStringArray(R.array.zzqst);
			info.videoResourceId = R.drawable.v_23;
			break;

		//
		case 30:
			info.description = getResources().getStringArray(R.array.kwytxs);
			info.videoResourceId = R.drawable.v_30;
			break;
		case 31:
			info.description = getResources().getStringArray(R.array.dbylhc);
			info.videoResourceId = R.drawable.v_31;
			break;
		case 32:
			info.description = getResources().getStringArray(R.array.ylztst);
			info.videoResourceId = R.drawable.v_32;
			break;
		case 33:
			info.description = getResources().getStringArray(R.array.flylhc);
			info.videoResourceId = R.drawable.v_33;
			break;

		//
		case 40:
			info.description = getResources().getStringArray(R.array.fwglwj);
			info.videoResourceId = R.drawable.v_40;
			break;
		case 41:
			info.description = getResources().getStringArray(R.array.zzylwj);
			info.videoResourceId = R.drawable.v_41;
			break;
		case 42:
			info.description = getResources().getStringArray(R.array.yljtwj);
			info.videoResourceId = R.drawable.v_42;
			break;
		case 43:
			info.description = getResources().getStringArray(R.array.ywylwj);
			info.videoResourceId = R.drawable.v_43;
			break;

		//
		case 50:
			info.description = getResources().getStringArray(R.array.flbqs);
			info.videoResourceId = R.drawable.v_50;
			break;
		case 51:
			info.description = getResources().getStringArray(R.array.ywcqs);
			info.videoResourceId = R.drawable.v_51;
			break;
		case 52:
			info.description = getResources().getStringArray(R.array.yljhqs);
			info.videoResourceId = R.drawable.v_52;
			break;
		case 53:
			info.description = getResources().getStringArray(R.array.yljhbqs);
			info.videoResourceId = R.drawable.v_53;
			break;

		//
		case 60:
			info.description = getResources().getStringArray(R.array.fshyt);
			info.videoResourceId = R.drawable.v_60;
			break;
		case 61:
			info.description = getResources().getStringArray(R.array.csxyjsq);
			info.videoResourceId = R.drawable.v_61;
			break;
		case 62:
			info.description = getResources().getStringArray(R.array.zztz);
			info.videoResourceId = R.drawable.v_62;
			break;
		case 63:
			info.description = getResources().getStringArray(R.array.ylsd);
			info.videoResourceId = R.drawable.v_63;
			break;
		case 64:
			info.description = getResources().getStringArray(R.array.qttt);
			info.videoResourceId = R.drawable.v_64;
			break;
		}
		System.out.println("info.description.length:" + info.description.length);
		return info;
	}

	void playVideo() {
		Uri localUri = Uri.parse("android.resource://" + getPackageName() + "/" + info.videoResourceId);
		vv.setVideoURI(localUri);
		vv.pause();
		vv.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
			public void onPrepared(MediaPlayer paramMediaPlayer) {
				vv.start();
			}
		});
		vv.setOnErrorListener(new MediaPlayer.OnErrorListener() {
			public boolean onError(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2) {
				return false;
			}
		});
		vv.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
			public void onCompletion(MediaPlayer paramMediaPlayer) {
				vv.seekTo(0);
				paramMediaPlayer.start();
			}
		});
	}

	@Override
	protected void onDestroy() {
		ZigUtilAdv.destroyAdv();
		super.onDestroy();
	}

	// public void onReceiveAd() {
	// // 广告接收成功并显示
	// Toast.makeText(getApplicationContext(), "广告请求成功！", Toast.LENGTH_SHORT).show();
	// }

	// @Override
	// public void onReceiveFailed(int errorId) {
	// switch (errorId) {
	// case AdListener.ERROR_CONNECTION_FAILED:
	// Toast.makeText(getApplicationContext(), "网络原因,广告请求失败！" + errorId, Toast.LENGTH_LONG).show();
	// break;
	// case AdListener.ERROR_GET_IMAGE_FAILED:
	// Toast.makeText(getApplicationContext(), "图片拉取错误,广告请求失败！" + errorId, Toast.LENGTH_LONG).show();
	// break;
	// case AdListener.ERROR_NO_AVAILABLE_ADS:
	// Toast.makeText(getApplicationContext(), "广告服务不可用,广告请求失败！" + errorId, Toast.LENGTH_LONG).show();
	// break;
	// case AdListener.ERROR_GIF_DECODE_FAILED:
	// Toast.makeText(getApplicationContext(), "GIF动画解码失败,广告请求失败！" + errorId, Toast.LENGTH_LONG).show();
	// break;
	// case AdListener.ERROR_SERVER_DATA_EXCEPTION:
	// Toast.makeText(getApplicationContext(), "服务器数据异常,广告请求失败！" + errorId, Toast.LENGTH_LONG).show();
	// break;
	// default:
	// Toast.makeText(getApplicationContext(), "未知原因,广告请求失败！" + errorId, Toast.LENGTH_LONG).show();
	// break;
	// }
	// }

}
