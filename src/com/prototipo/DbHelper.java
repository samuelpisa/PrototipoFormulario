package com.prototipo;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;
import android.provider.Contacts.Intents.Insert;
import android.util.Log;

public class DbHelper extends SQLiteOpenHelper {
	
	private static final String TAG = DbHelper.class.getSimpleName();
	public static final String DB_NAME = "forms.db";
	public static final int DB_VERSION = 10; 
	
	
	public static final String TABLE_QUESTIONS = "questions";
	public static final String QUESTION_ID = BaseColumns._ID;
	public static final String QUESTION_DESC= "description";
	
	
	public static final String TABLE_ALTERNATIVES = "alternatives";
	public static final String ALTERNATIVE_ID = BaseColumns._ID;
	public static final String ALTERNATIVE_DESC= "description";
	public static final String ALTERNATIVE_QUESTION_ID= "idQuestion";
	
	
	private Context context;
	
	public DbHelper(Context context) {
		super(context, DB_NAME, null, DB_VERSION);
		this.context = context;
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		String sql = String.format("create table %s(%s integer primary key, %s text);", TABLE_QUESTIONS,QUESTION_ID,QUESTION_DESC);
		Log.d(TAG,"onCreate sql1: "+sql);
		db.execSQL(sql);
		
		sql = String.format(" create table %s(%s integer primary key, %s text, %s int);", TABLE_ALTERNATIVES,ALTERNATIVE_ID,ALTERNATIVE_DESC,ALTERNATIVE_QUESTION_ID);
		Log.d(TAG,"onCreate sql2: "+sql);
		db.execSQL(sql);
		
		ContentValues values = new ContentValues();
				
		String[] listOfValues = {
				"Você já estudou em outra escola anteriormente?",
				"Por qual motivo seus pais transferiram você para o colégio?",
				"Onde você costuma acessar a internet?",
				"Quais ambientes (redes sociais) você costuma ter acesso?",
				"Por qual motivo seus pais matricularam você no colégio?",
				"Sobre esta pesquisa:",
		};
		
		for (String v : listOfValues) {
			values.put(QUESTION_DESC, v);
			db.insert(TABLE_QUESTIONS, null, values);
			values.clear();
		}		
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		String sql = String.format("drop table if exists %s;", TABLE_QUESTIONS);
		db.execSQL(sql);
		Log.d(TAG,"onUpgrade sql: "+sql);
		
		sql = String.format("drop table if exists %s;", TABLE_ALTERNATIVES);
		db.execSQL(sql);
		Log.d(TAG,"onUpgrade sql: "+sql);
		
		this.onCreate(db);
		
	}
	
	public void truncateDB(SQLiteDatabase db) {
		String sql = String.format("DELETE FROM %s;", TABLE_QUESTIONS);
		db.execSQL(sql);
		Log.d(TAG,"!!!!!!!!!!!!!!!!!!!!onUpgrade sql: "+sql);
		
		sql = String.format("DELETE FROM %s; ", TABLE_ALTERNATIVES);
		db.execSQL(sql);
		Log.d(TAG,"onTRUNCATE sql: "+sql);
	}
	
	public void insertAlternative(SQLiteDatabase db, String description, int idQuestion){
		ContentValues values = new ContentValues();
		
		values.put(ALTERNATIVE_DESC, description);
		values.put(ALTERNATIVE_QUESTION_ID, idQuestion);
		
		db.insert(TABLE_ALTERNATIVES, null, values);
		
		db.close();
	}

}
