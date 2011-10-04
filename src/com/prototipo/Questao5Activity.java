package com.prototipo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

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
	EditText edit;
	
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.questao5);
		
		Button btVoltar = (Button) findViewById(R.id.btvoltar);
		Button btAvancar = (Button) findViewById(R.id.btavancar);
		final Intent questao4 = new Intent(this, Questao4Activity.class);
		final Intent questao6 = new Intent(this, Questao6Activity.class);
		
		edit = (EditText) findViewById(R.id.editText1);
		edit.setVisibility(View.INVISIBLE);
		
		ck1 = (CheckBox) findViewById(R.id.ck1);
		ck2 = (CheckBox) findViewById(R.id.ck2);
		ck3 = (CheckBox) findViewById(R.id.ck3);
		ck4 = (CheckBox) findViewById(R.id.ck4);
		ck5 = (CheckBox) findViewById(R.id.ck5);
		ck6 = (CheckBox) findViewById(R.id.ck6);
		ck7 = (CheckBox) findViewById(R.id.ck7);
		ck8 = (CheckBox) findViewById(R.id.ck8);
		
		ck8.setOnClickListener(new OnClickListener() {
		    public void onClick(View v) {
		        // Perform action on clicks, depending on whether it's now checked
		        if (((CheckBox) v).isChecked()) {
		            edit.setVisibility(View.VISIBLE);
		        } else {
		        	 edit.setVisibility(View.INVISIBLE);
		        }
		    }
		});
		
		
		
		
		
		
		 btVoltar.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View arg) {
					startActivity(questao4);
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

