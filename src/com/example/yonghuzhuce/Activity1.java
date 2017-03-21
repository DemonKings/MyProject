package com.example.yonghuzhuce;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Activity1 extends Activity {
	private EditText editText1;
	private TextView textView4,textView5,textView7;
	private EditText extra_yhm;
	
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
        editText1=(EditText) findViewById(R.id.editText1);
        textView4=(TextView) findViewById(R.id.textView4);
        textView5=(TextView) findViewById(R.id.textView5);
        textView7=(TextView) findViewById(R.id.textView7);
        editText1.setText(yhm);
        textView4.setText(mm);
        textView5.setText(xb);
        textView7.setText(cg+tw+ds+yy);  
        
    }
    public void click(View view){
    	extra_yhm =(EditText) findViewById(R.id.editText1);
    	Intent intent =new Intent();
    	intent.putExtra("extra_data",extra_yhm.getText().toString().trim());
    	setResult(1,intent);
    	finish();
    	
    }
    public void cl(View view){
    	Intent intent=new Intent(this,Activity2.class);
    	startActivity(intent);
    }

}
