package com.zigtang.fitnesscoach;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;

import com.zigtang.fitnesscoach.dummy.MuscleContent;
import com.zigtang.fitnesscoach.util.DoMobUtil;

public class MuscleListActivity extends FragmentActivity implements MuscleListFragment.Callbacks, OnClickListener {

	private boolean mTwoPane;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		DoMobUtil.checkUpdate(this);
		MuscleContent.initItem(this);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_muscle_list);
		if (findViewById(R.id.muscle_detail_container) != null) {
			mTwoPane = true;
			((MuscleListFragment) getSupportFragmentManager().findFragmentById(R.id.muscle_list))
					.setActivateOnItemClick(true);
		}
		findViewById(R.id.btn_title).setOnClickListener(this);
	}

	@Override
	public void onItemSelected(String id) {
		if (mTwoPane) {
			Bundle arguments = new Bundle();
			arguments.putString(MuscleDetailFragment.ARG_ITEM_ID, id);
			MuscleDetailFragment fragment = new MuscleDetailFragment();
			fragment.setArguments(arguments);
			getSupportFragmentManager().beginTransaction().replace(R.id.muscle_detail_container, fragment).commit();

		} else {
			Intent detailIntent = new Intent(this, MuscleDetailActivity.class);
			detailIntent.putExtra(MuscleDetailFragment.ARG_ITEM_ID, id);
			startActivity(detailIntent);
		}
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btn_title:
			sendEmail();
			break;
		default:
			break;
		}

	}

	private void sendEmail() {
		Uri emailUri = Uri.parse("mailto:zigtang@gmail.com");
		Intent intent = new Intent(Intent.ACTION_SENDTO, emailUri);
		// Intent intent = new Intent();
		// intent.putExtra(Intent.EXTRA_EMAIL, new String[] { "mailto:zigtang@gmail.com" });
		intent.putExtra(Intent.EXTRA_SUBJECT, "我爱练肌肉：用户反馈");
		intent.putExtra(Intent.EXTRA_TEXT, "阿弥陀佛，终于有好心人愿意为这个程序做点贡献了，好人有好报，说吧，您有何指教？");
		startActivity(intent);
	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if (keyCode == KeyEvent.KEYCODE_BACK) {
			AlertDialog.Builder builder = new Builder(this);
			builder.setTitle("很温馨的提示~");
			builder.setMessage("这么快就放弃，你不练肌肉了吗？");
			builder.setPositiveButton("来日方长", new DialogInterface.OnClickListener() {
				@Override
				public void onClick(DialogInterface dialog, int which) {
					finish();
				}
			});
			builder.setNegativeButton("再坚持会", null);
			builder.create().show();
		}
		return false;
	}

}
