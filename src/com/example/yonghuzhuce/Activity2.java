package com.example.yonghuzhuce;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
public class Activity2 extends Activity {
	private EditText ed_yhm;
	private EditText ed_mm;	
	
	protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity2);      
    }
	public void login(View view){
		ed_yhm =(EditText) findViewById(R.id.editText1);
		ed_mm =(EditText) findViewById(R.id.editText2);
		
		String yhm=ed_yhm.getText().toString().trim();
		String mm=ed_mm.getText().toString().trim();
		// 判断所输入内容是否一致。 注意：对象不同，不能用"=="
		if((yhm.contentEquals("lidengming")&&mm.contentEquals("139")) ||
				(yhm.contentEquals("weitong")&&mm.contentEquals("142")) ||
				(yhm.contentEquals("zhaoxuechen")&&mm.contentEquals("140"))
		){
	    	Intent intent=new Intent(this,Activity3.class);
	    	intent.putExtra("mm",ed_mm.getText().toString().trim());
	    	intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
	    	startActivity(intent);
		}else{
			(Toast.makeText(Activity2.this,"账号或密码错误",Toast.LENGTH_LONG)).show();//创建弹出窗体
		}
    }
}
