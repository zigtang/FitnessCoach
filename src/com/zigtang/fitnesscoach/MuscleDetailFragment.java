package com.zigtang.fitnesscoach;

import com.zigtang.fitnesscoach.dummy.MuscleContent;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class MuscleDetailFragment extends Fragment implements OnItemClickListener {

	public static final String ARG_ITEM_ID = "item_id";
	private Callbacks mCallbacks = sDummyCallbacks;
	MuscleContent.MuscleInfo muscleInfo;

	public interface Callbacks {
		public void onItemSelected(String id);
	}

	private static Callbacks sDummyCallbacks = new Callbacks() {
		@Override
		public void onItemSelected(String id) {
		}
	};

	public MuscleDetailFragment() {
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		if (getArguments().containsKey(ARG_ITEM_ID)) {
			muscleInfo = MuscleContent.ITEM_MAP.get(getArguments().getString(ARG_ITEM_ID));
		}
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.fragment_muscle_detail, container, false);
		if (muscleInfo != null) {
			ListView lv;
			lv = (ListView) rootView.findViewById(R.id.lv_fragment);
			lv.setAdapter(new Adapter());
			lv.setOnItemClickListener(this);
		}
		return rootView;
	}

	class Adapter extends BaseAdapter {

		@Override
		public int getCount() {
			return muscleInfo == null ? 0 : muscleInfo.sportName.length;
		}

		@Override
		public Object getItem(int arg0) {
			return null;
		}

		@Override
		public long getItemId(int arg0) {
			return arg0;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup arg2) {
			if (convertView == null) {
				convertView = LayoutInflater.from(getActivity()).inflate(R.layout.item_fragment, null);
			}
			((ImageView) convertView.findViewById(R.id.img_item_fragment)).setImageResource(muscleInfo.imgId[position]);
			((TextView) convertView.findViewById(R.id.tv_sport_name)).setText(muscleInfo.sportName[position]);
			((TextView) convertView.findViewById(R.id.tv_sport_description)).setText(muscleInfo.description[position]);
			return convertView;
		}

	}

	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		if (!(activity instanceof Callbacks)) {
			throw new IllegalStateException("Activity must implement fragment's callbacks.");
		}
		mCallbacks = (Callbacks) activity;
	}

	@Override
	public void onDetach() {
		super.onDetach();
		mCallbacks = sDummyCallbacks;
	}

	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {

		String id = muscleInfo.id + arg2;
		System.out.println("onItemclick-id:" + id);
		mCallbacks.onItemSelected(id);
	}
}
