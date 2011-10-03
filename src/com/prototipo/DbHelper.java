package com.prototipo;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;
import android.util.Log;

public class DbHelper extends SQLiteOpenHelper {
	
	private static final String TAG = DbHelper.class.getSimpleName();
	public static final String DB_NAME = "forms.db";
	public static final int DB_VERSION = 1; 
	public static final String TABLE_QUESTIONS = "questions";
	public static final String QUESTION_ID = BaseColumns._ID;
	public static final String QUESTION_DESC= "description";
	
	private Context context;
	
	public DbHelper(Context context) {
		super(context, DB_NAME, null, DB_VERSION);
		this.context = context;
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		String sql = "create table questions(_id int primary key, desc text);";
		sql += "create table alternatives(_id int primary key, idQuestions int, desc text);";
		Log.d(TAG,"onCreate sql: "+sql);
		db.execSQL(sql);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		String sql = "drop table if exists"+ TABLE_QUESTIONS;
		db.execSQL(sql);
		Log.d(TAG,"onUpgrade sql: "+sql);
		this.onCreate(db);
		
	}

}
