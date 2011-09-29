package com.prototipo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;

public class Questao4Activity extends Activity {
	/**
	 * @see android.app.Activity#onCreate(Bundle)
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.questao4);

		final Button btAvancar = (Button) findViewById(R.id.btavancar);
		final Button btVoltar = (Button) findViewById(R.id.btvoltar);
		//final Intent questao5 = new Intent(this, Questao5Activity.class);
		final Intent questao3 = new Intent(this, Questao3Activity.class);
		
		final CheckBox ck1 = (CheckBox) findViewById(R.id.ck1);
		final CheckBox ck2 = (CheckBox) findViewById(R.id.ck2);
		final CheckBox ck3 = (CheckBox) findViewById(R.id.ck3);
		final CheckBox ck4 = (CheckBox) findViewById(R.id.ck4);
		final CheckBox ck5 = (CheckBox) findViewById(R.id.ck5);
		final CheckBox ck6 = (CheckBox) findViewById(R.id.ck6);
		final CheckBox ck7 = (CheckBox) findViewById(R.id.ck7);
		final CheckBox ck8 = (CheckBox) findViewById(R.id.ck8);
		final CheckBox ck9 = (CheckBox) findViewById(R.id.ck9);
		
		ck9.setOnClickListener(new OnClickListener() {		
			@Override
			public void onClick(View v) {
				if (((CheckBox) v).isChecked()) {
		            ck1.setChecked(false);
		            ck2.setChecked(false);
		            ck3.setChecked(false);
		            ck4.setChecked(false);
		            ck5.setChecked(false);
		            ck6.setChecked(false);
		            ck7.setChecked(false);
		            ck8.setChecked(false);
		            ck1.setEnabled(false);
		            ck2.setEnabled(false);
		            ck3.setEnabled(false);
		            ck4.setEnabled(false);
		            ck5.setEnabled(false);
		            ck6.setEnabled(false);
		            ck7.setEnabled(false);
		            ck8.setEnabled(false);
		        } else {
		        	ck1.setEnabled(true);
		        	ck2.setEnabled(true);
		        	ck3.setEnabled(true);
		        	ck4.setEnabled(true);
		        	ck5.setEnabled(true);
		        	ck6.setEnabled(true);
		        	ck7.setEnabled(true);
		        	ck8.setEnabled(true);
		        }
			}
		});
		
		 btVoltar.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View arg) {
					startActivity(questao3);
				}
		 });
		 btAvancar.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View arg) {
					//startActivity(questao5);
				}
		 });
	}
}
