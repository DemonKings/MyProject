package com.example.yonghuzhuce;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.shujuku.MyHelper;

public class Activity1 extends Activity {
	//����
	private MyHelper helper;
	private EditText editText1;
	private TextView textView4,textView5,textView7;
	private EditText extra_yhm;
	private TextView extra_mm,extra_xb;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity1);
        
        helper = new MyHelper(this);
        
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
    	extra_mm =(TextView) findViewById(R.id.textView4);
    	extra_xb =(TextView) findViewById(R.id.textView5);
    	Intent intent =new Intent(); //����Intent����
    	intent.putExtra("extra_data",extra_yhm.getText().toString().trim());
    	setResult(1,intent);
    	String yhm=extra_yhm.getText().toString().trim();
    	String mm=extra_mm.getText().toString().trim();
    	String xb=extra_xb.getText().toString().trim();
    	add(yhm, mm, xb);
    	finish();  //����activity
    	
    }
    public long add(String yhm,String mm,String xb){
		SQLiteDatabase db=helper.getWritableDatabase();
		ContentValues values=new ContentValues();
		values.put("yhm", yhm);
		values.put("mm", mm);
		values.put("xb", xb);
		long id=db.insert("info", null, values);
		db.close();
		return id;
	}

}
