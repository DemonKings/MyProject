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
	//����
	private EditText editText1;
	private TextView textView4,textView5,textView7;
	private EditText extra_yhm;
	private TextView extra_mm,extra_xb;
	
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity1);
        
        //��ȡIntent����
        Intent intent=getIntent();
        //ȡ��key��Ӧ��ֵ
        String yhm=intent.getStringExtra("yhm");
        String mm=intent.getStringExtra("mm");
        String xb=intent.getStringExtra("xb");
        String cg=intent.getStringExtra("cg");
        String tw=intent.getStringExtra("tw");
        String ds=intent.getStringExtra("ds");
        String yy=intent.getStringExtra("yy");
        //�ҵ��ؼ�
        editText1=(EditText) findViewById(R.id.editText1);
        textView4=(TextView) findViewById(R.id.textView4);
        textView5=(TextView) findViewById(R.id.textView5);
        textView7=(TextView) findViewById(R.id.textView7);
        //д������
        editText1.setText(yhm);
        textView4.setText(mm);
        textView5.setText(xb);
        textView7.setText(cg+" "+tw+" "+ds+" "+yy);     
    }
    // ����ʱ�����֡�click��Ӧ��ÿؼ�onClickֵһ��
    public void click(View view){    //���������¼�  �ش�����
    	extra_yhm =(EditText) findViewById(R.id.editText1);
    	extra_mm=(TextView) findViewById(R.id.textView4);
    	extra_xb=(TextView) findViewById(R.id.textView5);
    	Intent intent =new Intent(); //����Intent����
    	intent.putExtra("extra_data",extra_yhm.getText().toString().trim());
    	setResult(1,intent);
    	SharedPreferences sp = getSharedPreferences("data", MODE_PRIVATE);
    	Editor editor=sp.edit();
    	editor.putString("yhm", extra_yhm.getText().toString().trim());
    	editor.putString("mm", extra_mm.getText().toString().trim());
    	editor.putString("xb", extra_xb.getText().toString().trim());
    	editor.putString("ischeck", null);
    	editor.commit();
    	finish();  //����activity
    	
    }

}
