package com.example.save;

import java.util.HashMap;
import java.util.Map;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public class save {
	public static boolean saveUserInfo(Context context, String yhm, String mm,String xb){
		SharedPreferences sp =context.getSharedPreferences("data", Context.MODE_PRIVATE);
		Editor edit =sp.edit();
		edit.putString("yhm", yhm);
		edit.putString("mm", mm);
		edit.putString("xb", xb);
		edit.commit();
		return true;
	}

	public static Map<String,String> getUserInfo(Context context){
		SharedPreferences sp=context.getSharedPreferences("data", Context.MODE_PRIVATE);
		String yhm =sp.getString("yhm", null);
		String mm =sp.getString("mm", null);
		Map<String, String> userMap=new HashMap<String, String>();
		userMap.put("yhm", yhm);
		userMap.put("mm", mm);
		return userMap;
	}
}
