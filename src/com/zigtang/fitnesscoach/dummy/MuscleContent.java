package com.zigtang.fitnesscoach.dummy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.content.Context;
import android.util.Log;

import com.zigtang.fitnesscoach.R;

public class MuscleContent {

	public static class MuscleInfo {

		public String id;
		public String muscleName;
		public String[] sportName;
		public String[] description;
		public int[] imgId;

		// public MuscleInfo(String id, String muscleName, String[] sportName, int imgId) {
		// this.id = id;
		// this.muscleName = muscleName;
		// this.sportName = sportName;
		// this.imgId = imgId;
		// }

		@Override
		public String toString() {
			return muscleName;
		}
	}

	private static final String TAG = "MuscleContent";

	public static List<MuscleInfo> ITEMS = new ArrayList<MuscleInfo>();
	public static Map<String, MuscleInfo> ITEM_MAP = new HashMap<String, MuscleInfo>();

	public static void initItem(Context context) {
		clearItem();// 静态数据在下次进来时候还存在
		MuscleInfo muscleInfo;
		String[] muscles = context.getResources().getStringArray(R.array.muscles);

		ArrayList<String[]> sportNames = getSportNames(context);
		ArrayList<String[]> descriptions = getDescriptions(context);
		ArrayList<int[]> imgIds = getImgId();

		for (int i = 0; i < muscles.length; i++) {
			muscleInfo = new MuscleInfo();
			muscleInfo.id = "" + i;
			muscleInfo.muscleName = muscles[i];
			muscleInfo.sportName = sportNames.get(i);
			muscleInfo.description = descriptions.get(i);
			muscleInfo.imgId = imgIds.get(i);
			if (muscleInfo.sportName.length != muscleInfo.description.length
					|| muscleInfo.description.length != muscleInfo.imgId.length
					|| muscleInfo.imgId.length != muscleInfo.sportName.length) {
				Log.e(TAG, "ERROR:initItem(),the count of the info's property is not corresponding");
				Log.e(TAG, "muscleInfo.muscleName:" + muscleInfo.muscleName);
				Log.e(TAG, "muscleInfo.sportName.length:" + muscleInfo.sportName.length);
				Log.e(TAG, "muscleInfo.description.length:" + muscleInfo.description.length);
				Log.e(TAG, "muscleInfo.imgId.length:" + muscleInfo.imgId.length);
			} else {
				addItem(muscleInfo);
			}

		}

		// addItem(new MuscleInfo("1", "肩肌", context.getResources().getStringArray(R.array.shoulder),
		// R.drawable.ic_launcher));
		// addItem(new MuscleInfo("2", "胸肌", context.getResources().getStringArray(R.array.shoulder),
		// R.drawable.ic_launcher));
		// addItem(new MuscleInfo("3", "腹肌", context.getResources().getStringArray(R.array.shoulder),
		// R.drawable.ic_launcher));
		// addItem(new MuscleInfo("4", "背肌", context.getResources().getStringArray(R.array.shoulder),
		// R.drawable.ic_launcher));
		// addItem(new MuscleInfo("5", "二头肌", context.getResources().getStringArray(R.array.shoulder),
		// R.drawable.ic_launcher));
		// addItem(new MuscleInfo("6", "三头肌", context.getResources().getStringArray(R.array.shoulder),
		// R.drawable.ic_launcher));
		// addItem(new MuscleInfo("7", "腿肌", context.getResources().getStringArray(R.array.shoulder),
		// R.drawable.ic_launcher));
	}

	private static ArrayList<int[]> getImgId() {
		ArrayList<int[]> imgIds = new ArrayList<int[]>();
		imgIds.add(new int[] { R.drawable.p_00_jj, R.drawable.p_01_jj, R.drawable.p_02_jj, R.drawable.p_03_jj });
		imgIds.add(new int[] { R.drawable.p_10_xj, R.drawable.p_11_xj, R.drawable.p_12_xj, R.drawable.p_13_xj });
		imgIds.add(new int[] { R.drawable.p_20_fj, R.drawable.p_21_fj, R.drawable.p_22_fj, R.drawable.p_23_fj });
		imgIds.add(new int[] { R.drawable.p_30_bj, R.drawable.p_31_bj, R.drawable.p_32_bj, R.drawable.p_33_bj });
		imgIds.add(new int[] { R.drawable.p_40_etj, R.drawable.p_41_etj, R.drawable.p_42_etj, R.drawable.p_43_etj });
		imgIds.add(new int[] { R.drawable.p_50_stj, R.drawable.p_51_stj, R.drawable.p_52_stj, R.drawable.p_53_stj });
		imgIds.add(new int[] { R.drawable.p_60_tj, R.drawable.p_61_tj, R.drawable.p_62_tj, R.drawable.p_63_tj,
				R.drawable.p_64_tj });
		return imgIds;
	}

	private static ArrayList<String[]> getDescriptions(Context context) {
		ArrayList<String[]> descriptions = new ArrayList<String[]>();
		descriptions.add(context.getResources().getStringArray(R.array.shoulder_description));
		descriptions.add(context.getResources().getStringArray(R.array.pectoralis_description));
		descriptions.add(context.getResources().getStringArray(R.array.abdominal_description));
		descriptions.add(context.getResources().getStringArray(R.array.back_description));
		descriptions.add(context.getResources().getStringArray(R.array.biceps_description));
		descriptions.add(context.getResources().getStringArray(R.array.triceps_description));
		descriptions.add(context.getResources().getStringArray(R.array.crureus_description));
		return descriptions;
	}

	private static ArrayList<String[]> getSportNames(Context context) {
		ArrayList<String[]> sportNames = new ArrayList<String[]>();
		sportNames.add(context.getResources().getStringArray(R.array.shoulder_name));
		sportNames.add(context.getResources().getStringArray(R.array.pectoralis_name));
		sportNames.add(context.getResources().getStringArray(R.array.abdominal_name));
		sportNames.add(context.getResources().getStringArray(R.array.back_name));
		sportNames.add(context.getResources().getStringArray(R.array.biceps_name));
		sportNames.add(context.getResources().getStringArray(R.array.triceps_name));
		sportNames.add(context.getResources().getStringArray(R.array.crureus_name));
		return sportNames;
	}

	private static void addItem(MuscleInfo item) {
		ITEMS.add(item);
		ITEM_MAP.put(item.id, item);
	}

	private static void clearItem() {
		ITEMS.clear();
		ITEM_MAP.clear();
	}
}
