package com.example.yonghuzhuce;

import java.io.IOException;

import com.google.gson.Gson;
import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {
	public class Res{
		public String message;
		public String img;
	}
	//定义各种控件对象
	private static final int ERROR = 1;
	private static final int SUCCESS = 2 ;
    private EditText et_yhm;
    private EditText et_mm;
    private Button button2;
    private Res resss;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //找到对象
        et_yhm =(EditText) findViewById(R.id.etyhm);
        et_mm =(EditText) findViewById(R.id.etmm);
        button2 = (Button) findViewById(R.id.bt);
    }
    //传递数据
    public void Click(View view) throws IOException{
    	button2.setVisibility(View.INVISIBLE);
    	// Intent intent=new Intent(this,Activity1.class); //创建Intent对象
    	String syhm = et_yhm.getText().toString().trim();
    	String smm = et_mm.getText().toString().trim();
    	
    	final Gson gson = new Gson();
    	final OkHttpClient client = new OkHttpClient();

    	MediaType mediaType = MediaType.parse("application/json");
    	RequestBody body = RequestBody.create(mediaType, 
    			"{\n\t\"username\": \""+syhm+"\",\n\t\"password\": \""+smm+"\"\n}");
    	final Request request = new Request.Builder()
    	  .url("http://lidengming.com:10199/api")
    	  .post(body)
    	  .addHeader("content-type", "application/json")
    	  .addHeader("cache-control", "no-cache")
    	  .build();

    	// Response response = client.newCall(request).enqueue(new Callback(){});
    	
    	new Thread(new Runnable() {
            @Override
            public void run() {
                Response response = null;
                try {
                    response = client.newCall(request).execute();
                    if (response.isSuccessful()) {
                    	Res res = gson.fromJson(response.body().charStream(), Res.class);
                        Message msg = Message.obtain();
                        
                        if(res.message.equals("ok")){
                        	msg.what = SUCCESS;
                            msg.obj = res;
                            handler.sendMessage(msg);
                        }else{
                        	msg.what = ERROR;
                            handler.sendMessage(msg);
                        }
                    } else {
                        throw new IOException("Unexpected code " + response);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                    //失败
                    Message msg = Message.obtain();
                    msg.what = ERROR;
                    handler.sendMessage(msg);
                }
            }
        }).start();
    	
    	
    	
    	
    }
    
    private Handler handler = new Handler(){
    	@Override
    	public void handleMessage(Message msg) {
    		button2.setVisibility(View.VISIBLE);
    		switch (msg.what){
    			case SUCCESS:
    				resss = (Res)msg.obj;
    				Toast.makeText(MainActivity.this, "登陆成功", Toast.LENGTH_SHORT).show();
    				jump();
    				break;
    			case ERROR:
    				Toast.makeText(MainActivity.this, "账号或密码错误", Toast.LENGTH_SHORT).show();
    				break;
    			}
    	}
    };

    public void jump(){
    	Intent intent=new Intent(this, Activity1.class); //创建Intent对象
    	intent.putExtra("url",resss.img);
		startActivity(intent);
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
