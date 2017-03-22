package com.example.yonghuzhuce;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;

public class MainActivity extends Activity {
	//定义各种控件对象
    private EditText et_yhm;
    private EditText et_mm;
    private RadioButton manRadio;
    private RadioButton womanRadio;
    private CheckBox cb_cg;
    private CheckBox cb_tw;
    private CheckBox cb_ds;
    private CheckBox cb_yy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //找到对象
        et_yhm =(EditText) findViewById(R.id.editText1);
        et_mm =(EditText) findViewById(R.id.EditText01);
        manRadio =(RadioButton) findViewById(R.id.radioButton1);
        womanRadio =(RadioButton) findViewById(R.id.radioButton01);
        cb_cg =(CheckBox) findViewById(R.id.checkBox1);
        cb_tw =(CheckBox) findViewById(R.id.CheckBox03);
        cb_ds =(CheckBox) findViewById(R.id.CheckBox02);
        cb_yy =(CheckBox) findViewById(R.id.CheckBox01);
    }
    //传递数据
    public void Click(View view){
    	Intent intent=new Intent(this,Activity1.class); //创建Intent对象
    	//将内容取出并转换为字符串通过intent传递
    	intent.putExtra("yhm",et_yhm.getText().toString().trim());
    	intent.putExtra("mm",et_mm.getText().toString().trim());
    	String sex="";
    	if(manRadio.isChecked()){  //判断是否选中此控件
    		sex="男";
    	}else if(womanRadio.isChecked()){
    		sex="女";
    	}
    	intent.putExtra("xb",sex);
    	String xq1="";
    	String xq2="";
    	String xq3="";
    	String xq4="";
    	if(cb_cg.isChecked()){
    		xq1="唱歌";
    	}
    	if(cb_tw.isChecked()){
    		xq2="跳舞";
    	}
    	if(cb_ds.isChecked()){
    		xq3="读书";
    	}
    	if(cb_yy.isChecked()){
    		xq4="游泳";
    	}
    	intent.putExtra("cg",xq1);
    	intent.putExtra("tw",xq2);
    	intent.putExtra("ds",xq3);
    	intent.putExtra("yy",xq4);
    	
    	startActivityForResult(intent,1);   // 启动activity并接收回传数据
    }
    protected void onActivityResult(int requestCode,int resultCode,Intent data){
    	super.onActivityResult(requestCode,resultCode,data);
    	if(resultCode==1){
    		et_yhm =(EditText) findViewById(R.id.editText1);
    		String msg=data.getStringExtra("extra_data"); // 将回传数据取出转换为字符串
    		et_yhm.setText(msg);    //将内容写入

    	}
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
