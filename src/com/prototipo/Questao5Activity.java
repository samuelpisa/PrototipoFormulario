package com.prototipo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

public class Questao5Activity extends Activity {
	/**
	 * @see android.app.Activity#onCreate(Bundle)
	 */
	
	
	CheckBox ck1;
	CheckBox ck2;
	CheckBox ck3;
	CheckBox ck4;
	CheckBox ck5;
	CheckBox ck6;
	CheckBox ck7;
	CheckBox ck8;
	CheckBox ck9;
	
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.questao5);
		
		Button btVoltar = (Button) findViewById(R.id.btvoltar);
		Button btAvancar = (Button) findViewById(R.id.btavancar);
		final Intent lista = new Intent(this, ListaFormularioActivity.class);
		final Intent questao6 = new Intent(this, Questao6Activity.class);
		
		
		ck1 = (CheckBox) findViewById(R.id.ck1);
		ck2 = (CheckBox) findViewById(R.id.ck2);
		ck3 = (CheckBox) findViewById(R.id.ck3);
		ck4 = (CheckBox) findViewById(R.id.ck4);
		ck5 = (CheckBox) findViewById(R.id.ck5);
		ck6 = (CheckBox) findViewById(R.id.ck6);
		ck7 = (CheckBox) findViewById(R.id.ck7);
		ck8 = (CheckBox) findViewById(R.id.ck8);
		ck9 = (CheckBox) findViewById(R.id.ck9);
		
		
		
		
		
		
		
		
		 btVoltar.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View arg) {
					startActivity(lista);
				}
		 });
		 btAvancar.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View arg) {
					startActivity(questao6);
				}
		 });
	}
}

