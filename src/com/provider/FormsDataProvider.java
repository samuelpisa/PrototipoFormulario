package com.provider;

import java.util.HashMap;

import android.content.ContentProvider;
import android.net.Uri;
import android.content.ContentValues;
import android.database.Cursor;
import android.content.ContentUris;  
import android.content.Context;  
import android.content.UriMatcher;  
import android.provider.BaseColumns;   
import android.database.sqlite.SQLiteDatabase;  
import android.database.sqlite.SQLiteOpenHelper;  
import android.database.sqlite.SQLiteQueryBuilder;  

public class FormsDataProvider extends ContentProvider {
	public static final Uri CONTENT_URI = Uri
			.parse("content://com.providers.formsdataprovider");

	
	 // Authority do nosso provider, a ser usado nas Uris.  
    public static final String AUTHORITY = "com.provider.formsdataprovider";  
	
	
    // Nome do arquivo que irá conter o banco de dados.  
    private static  final String DATABASE_NAME = "forms.db";  
  
	
    // Versao do banco de dados.  
    // Este valor é importante pois é usado em futuros updates do DB.  
    private static  final int  DATABASE_VERSION = 1;  
	

    // Nome da tabela que irá conter as anotações.  
    private static final  String QUESTIONS_TABLE = "question";  
  
    // 'Id' da Uri referente às notas do usuário.  
    private  static final int QUESTIONS = 1;  

    // Tag usada para imprimir os logs.  
    public static final String TAG = "FormsProvider"; 
    
    
    // Instância da classe utilitária  
    private DBHelper mHelper;  

    // Uri matcher - usado para extrair informações das Uris  
    private static final UriMatcher mMatcher;  
    
    
    //TODO: REVER FORMATO DE STRING (antes estava string)
    private static HashMap<String, String> mProjection;  
 
    static {  
        mProjection = new HashMap<String, String>();  
        mProjection.put(Questions.QUESTION_ID, Questions.QUESTION_ID);  
        mProjection.put(Questions.DESC,Questions.DESC);  
    }  
  
    static {  
        mMatcher = new UriMatcher(UriMatcher.NO_MATCH);  
        mMatcher.addURI(AUTHORITY, QUESTIONS_TABLE, QUESTIONS);  
    }  
  
    
    
    
    
    /////////////////////////////////////////////////////////////////  
    //           Métodos overrided de ContentProvider              //  
    /////////////////////////////////////////////////////////////////
	/**
	 * @see android.content.ContentProvider#delete(Uri,String,String[])
	 */
	@Override
	public int delete(Uri uri, String selection, String[] selectionArgs) {
		 SQLiteDatabase db = mHelper.getWritableDatabase();  
	        int count;  
	        switch (mMatcher.match(uri)) {  
	            case QUESTIONS:  
	                count = db.delete(QUESTIONS_TABLE, selection, selectionArgs);  
	                break;  
	            default:  
	                throw new IllegalArgumentException(  
	                  "URI desconhecida " + uri);  
	        }  
	  
	        getContext().getContentResolver().notifyChange(uri, null);  
	        return count;  
	}

	/**
	 * @see android.content.ContentProvider#getType(Uri)
	 */
	@Override
	public String getType(Uri uri) {
		  switch (mMatcher.match(uri)) {  
          case QUESTIONS:  
              return Questions.CONTENT_TYPE;  
          default:  
              throw new IllegalArgumentException(  
                  "URI desconhecida " + uri);  
      }  
	}

	/**
	 * @see android.content.ContentProvider#insert(Uri,ContentValues)
	 */
	@Override
	public Uri insert(Uri uri, ContentValues values) {
		switch (mMatcher.match(uri)) {  
        case QUESTIONS:  
            SQLiteDatabase db = mHelper.getWritableDatabase();  
            long rowId = db.insert(QUESTIONS_TABLE, Questions.DESC, values);  
            if (rowId > 0) {  
                Uri noteUri = ContentUris.withAppendedId(  
                             Questions.CONTENT_URI, rowId);  
                getContext().getContentResolver().notifyChange(  
                             noteUri, null);  
                return noteUri;  
            }  
        default:  
            throw new IllegalArgumentException(  
                    "URI desconhecida " + uri);  
    }  
	}

	/**
	 * @see android.content.ContentProvider#onCreate()
	 */
	@Override
	public boolean onCreate() {
		   mHelper = new DBHelper(getContext());;  
	        return true;  
	}

	/**
	 * @see android.content.ContentProvider#query(Uri,String[],String,String[],String)
	 */
	@Override
	public Cursor query(Uri uri, String[] projection, String selection,
			String[] selectionArgs, String sortOrder) {
		
	            // Aqui usaremos o SQLiteQueryBuilder para construir  
	            // a query que será feito ao DB, retornando um cursor  
	            // que enviaremos à aplicação.  
	            SQLiteQueryBuilder builder = new  SQLiteQueryBuilder();  
	            SQLiteDatabase database = mHelper.getReadableDatabase();  
	            Cursor cursor;  
	            switch (mMatcher.match(uri)) {  
	                case QUESTIONS:  
	                    // O Builer receberá dois parametros: a tabela  
	                    // onde será feita a busca, e uma projection -  
	                    // que nada mais é que uma HashMap com os campos  
	                    // que queremos recuperar do banco de dados.  
	                    builder.setTables(QUESTIONS_TABLE);  
	                    builder.setProjectionMap(mProjection);  
	                    break;  
	  
	                default:  
	                    throw new IllegalArgumentException(  
	                          "URI desconhecida " + uri);  
	            }  
	  
	            cursor = builder.query(database, projection, selection,  
	             selectionArgs, null, null, sortOrder);  
	  
	            cursor.setNotificationUri(getContext().getContentResolver(), uri);  
	            return cursor;  
	}

	/**
	 * @see android.content.ContentProvider#update(Uri,ContentValues,String,String[])
	 */
	@Override
	public int update(Uri uri, ContentValues values, String selection,
			String[] selectionArgs) {
		   SQLiteDatabase db = mHelper.getWritableDatabase();  
           int count;  
           switch (mMatcher.match(uri)) {  
               case QUESTIONS:  
                   count = db.update(QUESTIONS_TABLE, values,  
                                                    selection, selectionArgs);  
                   break;  
               default:  
                   throw new IllegalArgumentException(  
                           "URI desconhecida " + uri);  
           }  
 
           getContext().getContentResolver().notifyChange(uri, null);  
           return count;  
	}
	
	
	   
    /////////////////////////////////////////////////////////////////  
    //                Inner Classes utilitárias                    //  
    /////////////////////////////////////////////////////////////////  
    public static final class  Questions implements  BaseColumns {  
        public static final Uri CONTENT_URI = Uri.parse("content://"  
                    + FormsDataProvider.AUTHORITY + "/questions");  
  
        public static final String CONTENT_TYPE =  
                "vnd.android.cursor.dir/" + FormsDataProvider.AUTHORITY;  
  
        public static final String QUESTION_ID = "_id";  
  
        public static final String DESC = "description";  
    }  
    
    
    private static class DBHelper extends SQLiteOpenHelper {  
    	  
        DBHelper(Context context) {  
            super(context, DATABASE_NAME, null, DATABASE_VERSION);  
        }  
  
        /* O método onCreate é chamado quando o provider é executado pela 
         * primeira vez, e usado para criar as tabelas no database 
         */  
        @Override  
        public void onCreate(SQLiteDatabase db) {  
            db.execSQL("CREATE TABLE " + QUESTIONS_TABLE + " (" +  
                    Questions.QUESTION_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +  
                    Questions.DESC + " LONGTEXT" + ");");  
        }  
  
        /* O método onUpdate é invocado quando a versão do banco de dados 
         * muda. Assim, é usado para fazer adequações para a aplicação 
         * funcionar corretamente. 
         */  
        @Override  
        public void onUpgrade(SQLiteDatabase db,  
                                      int oldVersion, int newVersion) {  
            // Como ainda estamos na primeira versão do DB,  
            // não precisamos nos preocupar com o update agora.  
        }  
    }     
}
