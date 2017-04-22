package com.example.yonghuzhuce;

import java.io.IOException;
import java.io.InputStream;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.shujuku.MyHelper;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.ResponseBody;

public class Activity1 extends Activity {
	//定义
	private ImageView vv;
	private static final int ERROR = 1;
	private static final int SUCCESS = 2 ;
	
	private Handler handler = new Handler(){
		@Override
		public void handleMessage(Message msg) {
			switch (msg.what){
				case SUCCESS:
					vv.setImageBitmap((Bitmap) msg.obj);
					break;
				case ERROR:
					Toast.makeText(Activity1.this, "请求超时", Toast.LENGTH_SHORT).show();
					break;
			}
    	}
	};
	
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity1);
        vv = (ImageView)findViewById(R.id.imageView1);
      
        Intent intent=getIntent();
        final String url = intent.getStringExtra("url");
        
        new Thread(){
        	@Override
      	  public void run() {
      	  //获取okHttp对象get请求,
	        	  try {
	        		  OkHttpClient client = new OkHttpClient();
	        		  Request request = new Request.Builder().url(url).build();
	        		  // ResponseBody body = client.newCall(request).execute().body();
	        		  InputStream in = client.newCall(request).execute().body().byteStream();
	        		  Bitmap bitmap = BitmapFactory.decodeStream(in);
	        		  Message msg = Message.obtain();
	        	 
	        		  msg.what = SUCCESS;
	        		  msg.obj = bitmap;
	        		  handler.sendMessage(msg);
	        	  } catch (IOException e) {
	        		  e.printStackTrace();
	        		  Message msg = Message.obtain();
	        		  msg.what = ERROR;
	        		  handler.sendMessage(msg);
	        	  }
      	  }
        }.start();
        
        Intent intent1 = new Intent(Activity1.this,yypService.class);  
        startService(intent1);  
    }
    
    @Override  
    protected void onStop() {  
        // TODO Auto-generated method stub  
        Intent intent = new Intent(Activity1.this,yypService.class);  
        stopService(intent);  
        super.onStop();  
    }  
    
    @Override
	public void onBackPressed() {  
        // TODO Auto-generated method stub  
        Intent intent = new Intent(Activity1.this,yypService.class);  
        stopService(intent);  
        super.onBackPressed();  
    }  
	
}