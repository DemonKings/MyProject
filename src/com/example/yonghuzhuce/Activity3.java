package com.example.yonghuzhuce;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;


public class Activity3 extends Activity {
	
	private ImageView im;
	protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity3);     
        
        Intent intent=getIntent();
        String mm=intent.getStringExtra("mm");
        im =(ImageView) findViewById(R.id.imageView1);
        if(mm.contentEquals("142")){
        	im.setImageResource(R.drawable.wei);
        }else if(mm.contentEquals("140")){
        	im.setImageResource(R.drawable.lei);
        }
    }

}
