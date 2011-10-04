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
		
		//EXEMPLO DO INSERT 
        DbHelper dbHelper = new DbHelper(Questao1Activity.this);
        
        int idQuestion = 1;
        dbHelper.insertAlternative(dbHelper.getWritableDatabase(), "DESCRICAO DA ALTERNATIVA", idQuestion);
		
        dbHelper.close();
        //FIM DO EXEMPLO DO INSERT
		
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
