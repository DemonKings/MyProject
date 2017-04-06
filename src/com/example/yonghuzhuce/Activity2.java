package com.example.yonghuzhuce;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import com.example.shujuku.MyHelper;
public class Activity2 extends Activity {
	private EditText ed_yhm;
	private EditText ed_mm;	
	private MyHelper helper;
	protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity2);  
        ed_yhm =(EditText) findViewById(R.id.editText1);
        ed_mm =(EditText) findViewById(R.id.editText2);
        helper = new MyHelper(this);
    }

	public void login(View view){
		ed_yhm =(EditText) findViewById(R.id.editText1);
        ed_mm =(EditText) findViewById(R.id.editText2);
        
		String yhm=ed_yhm.getText().toString().trim();
		String mm=ed_mm.getText().toString().trim();
		boolean result=find(yhm,mm);

		// 判断所输入内容是否一致。 注意：对象不同，不能用"=="
		if(result==true){
	    	Intent intent=new Intent(this,Activity3.class);
	    	intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
	    	startActivity(intent);
	    	(Toast.makeText(Activity2.this,"登陆成功",Toast.LENGTH_LONG)).show();
		}else{
			(Toast.makeText(Activity2.this,"登陆失败",Toast.LENGTH_LONG)).show();//创建弹出窗体
		}

    }
	
	public boolean find(String yhm, String mm){
		SQLiteDatabase db=helper.getReadableDatabase();
		Cursor cursor = db.rawQuery("SELECT * FROM "+ "info", null);
		while (cursor.moveToNext()) {
			String yhmInDB = cursor.getString(cursor.getColumnIndex("yhm"));
        	String mmInDB = cursor.getString(cursor.getColumnIndex("mm"));
        	if(yhmInDB.equals(yhm) && mmInDB.equals(mm)){
        		cursor.close();
        		return true;
        	}
	    }
		cursor.close();
		return false;
	}
}
