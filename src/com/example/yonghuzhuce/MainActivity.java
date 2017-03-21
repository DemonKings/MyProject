package com.example.yonghuzhuce;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;

public class MainActivity extends Activity {
	//����
    private EditText et_yhm;
    private EditText et_mm;
    private RadioButton manRadio;
    private RadioButton womanRadio;
    private Button btn_sent;
    private CheckBox cb_cg;
    private CheckBox cb_tw;
    private CheckBox cb_ds;
    private CheckBox cb_yy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        et_yhm =(EditText) findViewById(R.id.editText1);
        et_mm =(EditText) findViewById(R.id.EditText01);
        manRadio =(RadioButton) findViewById(R.id.radioButton1);
        womanRadio =(RadioButton) findViewById(R.id.radioButton01);
        btn_sent =(Button) findViewById(R.id.button1);
        cb_cg =(CheckBox) findViewById(R.id.checkBox1);
        cb_tw =(CheckBox) findViewById(R.id.CheckBox03);
        cb_ds =(CheckBox) findViewById(R.id.CheckBox02);
        cb_yy =(CheckBox) findViewById(R.id.CheckBox01);
        //���ע��
    }
    //��������
    public void Click(View view){
    	Intent intent=new Intent(this,Activity1.class);
    	intent.putExtra("yhm",et_yhm.getText().toString().trim());
    	intent.putExtra("mm",et_mm.getText().toString().trim());
    	String sex="";
    	if(manRadio.isChecked()){
    		sex="��";
    	}else if(womanRadio.isChecked()){
    		sex="Ů";
    	}
    	intent.putExtra("xb",sex);
    	String xq1="";
    	String xq2="";
    	String xq3="";
    	String xq4="";
    	if(cb_cg.isChecked()){
    		xq1="����";
    	}
    	if(cb_tw.isChecked()){
    		xq2="����";
    	}
    	if(cb_ds.isChecked()){
    		xq3="����";
    	}
    	if(cb_yy.isChecked()){
    		xq4="��Ӿ";
    	}
    	intent.putExtra("cg",xq1);
    	intent.putExtra("tw",xq2);
    	intent.putExtra("ds",xq3);
    	intent.putExtra("yy",xq4);
    	
    	startActivityForResult(intent,1);
    }
    protected void onActivityResult(int requestCode,int resultCode,Intent data){
    	super.onActivityResult(requestCode,resultCode,data);
    	if(resultCode==1){
    		et_yhm =(EditText) findViewById(R.id.editText1);
    		String msg=data.getStringExtra("extra_data");
    		et_yhm.setText(msg);

    	}
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
