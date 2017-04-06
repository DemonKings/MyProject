package com.example.yonghuzhuce;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.example.shujuku.MyHelper;

import android.app.ListActivity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.util.Log;
import android.widget.SimpleAdapter;


public class Activity3 extends ListActivity {
	private MyHelper helper;
	
	protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // setContentView(R.layout.activity3); 
        helper = new MyHelper(this);
        
        SimpleAdapter adapter = new SimpleAdapter(this,getData(),R.layout.item, 
                new String[]{"textView1", "textView2","textView3"}, 
                new int[]{R.id.textView1, R.id.textView2, R.id.textView3}); 
        setListAdapter(adapter); 

    }
	public List<Map<String, Object>> getData(){
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>(); 
		try {
			SQLiteDatabase db=helper.getReadableDatabase();
			Cursor c = db.rawQuery("SELECT * FROM " + "info", null);
			
			while (c.moveToNext()) {
				Map<String, Object> user = new HashMap<String, Object>();
	            String username = c.getString(c.getColumnIndex("yhm"));
	            String password = c.getString(c.getColumnIndex("mm"));
	            String sex = c.getString(c.getColumnIndex("xb"));
	            
	            Log.i("db", "username=>" + username + "password" + password + ", sex=>" + sex);
	            
	            user.put("textView1", username);
	            user.put("textView2", password);
	            user.put("textView3", sex);
	            list.add(user);
	        }
	        c.close();
	        return list;
		}catch (SQLiteException e) {
			Log.i("db", "Error when read db");
		}
		return null;
	}
}
