package com.example.yonghuzhuce;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;
public class Activity2 extends Activity {
	private EditText ed_yhm;
	private EditText ed_mm;	
	private CheckBox check;
	protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity2);  
        ed_yhm =(EditText) findViewById(R.id.editText1);
        SharedPreferences sp = getSharedPreferences("data", MODE_PRIVATE);
        String ch=sp.getString("ischeck", null);
        ed_yhm.setText(ch);
    }
	public void login(View view){
        SharedPreferences sp = getSharedPreferences("data", MODE_PRIVATE);
        String getyhm=sp.getString("yhm", null);
        String getmm=sp.getString("mm", null);
		ed_yhm =(EditText) findViewById(R.id.editText1);
		ed_mm =(EditText) findViewById(R.id.editText2);
		
		String yhm=ed_yhm.getText().toString().trim();
		String mm=ed_mm.getText().toString().trim();
		// 判断所输入内容是否一致。 注意：对象不同，不能用"=="
		if(yhm.contentEquals(getyhm)&&mm.contentEquals(getmm)){
	    	Intent intent=new Intent(this,Activity3.class);
	    	intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
	    	startActivity(intent);
	    	(Toast.makeText(Activity2.this,"登陆成功",Toast.LENGTH_LONG)).show();
		}else{
			(Toast.makeText(Activity2.this,"登陆失败",Toast.LENGTH_LONG)).show();//创建弹出窗体
		}
		check =(CheckBox) findViewById(R.id.checkBox1);
		if(check.isChecked()){
	        Editor editor=sp.edit();
	        editor.putString("ischeck", yhm);
	        editor.commit();
		}else{
			Editor editor=sp.edit();
			editor.putString("ischeck", null);
	        editor.commit();
		}
    }
}
