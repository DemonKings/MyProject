package com.example.shujuku;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MyHelper extends SQLiteOpenHelper {
	public MyHelper(Context context){
		super(context, "info.db", null, 5);
	}
	public void onCreate(SQLiteDatabase db){
		db.execSQL("create table IF NOT EXISTS info (id integer primary key autoincrement,"+
				"yhm varchar(20),"+
				"mm varchar(20)," +
				"xb varchar(20))");
	}
	public void onUpgrade(SQLiteDatabase db,int oldVersion,int newVersion){
		db.execSQL("alter table info add accout varchar(20)");
	}
}
