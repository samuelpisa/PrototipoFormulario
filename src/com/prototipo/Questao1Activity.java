package com.prototipo;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Questao1Activity extends Activity {
	/**
	 * @see android.app.Activity#onCreate(Bundle)
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.questao1);
		
		Button btVoltar = (Button) findViewById(R.id.btvoltar);
		Button btAvancar = (Button) findViewById(R.id.btavancar);
		final Intent lista = new Intent(this, ListaFormularioActivity.class);
		final Intent questao2 = new Intent(this, Questao2Activity.class);
		
		//POR ENQUANTO INSIRA ASSIM DESSE JEITO TOSCO MESMO!!! 
        DbHelper dbHelper = new DbHelper(Questao1Activity.this);
        SQLiteDatabase db =  dbHelper.getWritableDatabase();
        
        ContentValues values = new ContentValues();
        
        // dbHelper.truncateDB(db);
         
       // TextView textView =  (TextView) findViewById(R.id.textView1);
          
        

        values.put(DbHelper.QUESTION_DESC, "DESCRICAO DA QUESTAO" );
    
        db.insert(DbHelper.TABLE_QUESTIONS, null, values);
        
        values.clear();
    
        //ID DA ALTERNATIVA TA COMO AUTOINCREMENT
     
        values.put(DbHelper.ALTERNATIVE_DESC, "DESCRICAO DA ALTERNATIVA" );
        values.put(DbHelper.ALTERNATIVE_QUESTION_ID, 1 );
        
        //db.insert(DbHelper.TABLE_ALTERNATIVES, null, values);
        db.execSQL("insert into alternatives values(null,\"asdasdas\", 1)");
        
        dbHelper.close();
        db.close();
        // NAO ESQÇAM DE FEIXAR A CONEXAO COM O BD
		
		
		 btVoltar.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View arg) {
					startActivity(lista);
				}
		 });
		 btAvancar.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View arg) {
					startActivity(questao2);
				}
		 });
	}
}
