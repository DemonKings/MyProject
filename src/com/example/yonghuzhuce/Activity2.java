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
		
		if((yhm.contentEquals("lidengming")&&mm.contentEquals("139")) ||
				(yhm.contentEquals("weitong")&&mm.contentEquals("142")) ||
				(yhm.contentEquals("zhaoxuechen")&&mm.contentEquals("140"))
		){
	    	Intent intent=new Intent(this,Activity3.class);
	    	intent.putExtra("mm",ed_mm.getText().toString().trim());
	    	startActivity(intent);
		}else{
			(Toast.makeText(Activity2.this,"’À∫≈ªÚ√‹¬Î¥ÌŒÛ",Toast.LENGTH_LONG)).show();
		}

    }
}
