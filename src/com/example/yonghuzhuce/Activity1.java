package com.example.yonghuzhuce;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Activity1 extends Activity {
	//定义
	private EditText editText1;
	private TextView textView4,textView5,textView7;
	private EditText extra_yhm;
	private TextView extra_mm,extra_xb;
	
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity1);
        
        //获取Intent对象
        Intent intent=getIntent();
        //取出key对应的值
        String yhm=intent.getStringExtra("yhm");
        String mm=intent.getStringExtra("mm");
        String xb=intent.getStringExtra("xb");
        String cg=intent.getStringExtra("cg");
        String tw=intent.getStringExtra("tw");
        String ds=intent.getStringExtra("ds");
        String yy=intent.getStringExtra("yy");
        //找到控件
        editText1=(EditText) findViewById(R.id.editText1);
        textView4=(TextView) findViewById(R.id.textView4);
        textView5=(TextView) findViewById(R.id.textView5);
        textView7=(TextView) findViewById(R.id.textView7);
        //写入内容
        editText1.setText(yhm);
        textView4.setText(mm);
        textView5.setText(xb);
        textView7.setText(cg+" "+tw+" "+ds+" "+yy);     
    }
    // 单击时间名字“click”应与该控件onClick值一致
    public void click(View view){    //创建单击事件  回传数据
    	extra_yhm =(EditText) findViewById(R.id.editText1);
    	extra_mm=(TextView) findViewById(R.id.textView4);
    	extra_xb=(TextView) findViewById(R.id.textView5);
    	Intent intent =new Intent(); //创建Intent对象
    	intent.putExtra("extra_data",extra_yhm.getText().toString().trim());
    	setResult(1,intent);
    	SharedPreferences sp = getSharedPreferences("data", MODE_PRIVATE);
    	Editor editor=sp.edit();
    	editor.putString("yhm", extra_yhm.getText().toString().trim());
    	editor.putString("mm", extra_mm.getText().toString().trim());
    	editor.putString("xb", extra_xb.getText().toString().trim());
    	editor.putString("ischeck", null);
    	editor.commit();
    	finish();  //销毁activity
    	
    }

}
