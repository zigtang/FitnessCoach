package com.zigtang.fitnesscoach;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.Window;

public class MuscleDetailActivity extends FragmentActivity implements MuscleDetailFragment.Callbacks {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_muscle_detail);
		findViewById(R.id.btn_title).setVisibility(View.GONE);

		// getActionBar().setDisplayHomeAsUpEnabled(true);

		if (savedInstanceState == null) {
			Bundle arguments = new Bundle();
			arguments.putString(MuscleDetailFragment.ARG_ITEM_ID,
					getIntent().getStringExtra(MuscleDetailFragment.ARG_ITEM_ID));
			MuscleDetailFragment fragment = new MuscleDetailFragment();
			fragment.setArguments(arguments);
			getSupportFragmentManager().beginTransaction().add(R.id.muscle_detail_container, fragment).commit();
		}
	}

	// @Override
	// public boolean onOptionsItemSelected(MenuItem item) {
	// if (item.getItemId() == android.R.id.home) {
	// NavUtils.navigateUpTo(this, new Intent(this, MuscleListActivity.class));
	// return true;
	// }
	//
	// return super.onOptionsItemSelected(item);
	// }

	@Override
	public void onItemSelected(String id) {
		Intent intent = new Intent();
		intent.putExtra("id", id);
		intent.setClass(this, FitnessActivity.class);
		this.startActivity(intent);
	}
}
