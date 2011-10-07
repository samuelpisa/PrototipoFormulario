package com.prototipo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class Questao3Activity extends Activity {
	/**
	 * @see android.app.Activity#onCreate(Bundle)
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.questao3);
		
		final CheckBox ck1 = (CheckBox) findViewById(R.id.ck1);
		final CheckBox ck2 = (CheckBox) findViewById(R.id.ck2);
		final CheckBox ck3 = (CheckBox) findViewById(R.id.ck3);
		final CheckBox ckOutro = (CheckBox) findViewById(R.id.ck4);
		final EditText editOutro = (EditText) findViewById(R.id.editOutro);
		final Button btAvancar = (Button) findViewById(R.id.btavancar);
		final Button btVoltar = (Button) findViewById(R.id.btvoltar);
		final Intent questao4 = new Intent(this, Questao4Activity.class);
		final Intent questao2 = new Intent(this, Questao2Activity.class);
		
		ckOutro.setOnClickListener(new OnClickListener() {
		    public void onClick(View v) {
		        // Perform action on clicks, depending on whether it's now checked
		        if (((CheckBox) v).isChecked()) {
		            editOutro.setVisibility(View.VISIBLE);
		        } else {
		        	 editOutro.setVisibility(View.INVISIBLE);
		        }
		    }
		});
		
		 btVoltar.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View arg) {
					startActivity(questao2);
				}
		 });
		 btAvancar.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View arg) {
					if(ck1.isChecked() || ck2.isChecked() || ck3.isChecked() 
							|| (ckOutro.isChecked() && !editOutro.getText().toString().isEmpty())){
						
						DbHelper dbHelper = new DbHelper(Questao3Activity.this);
						
						if(ck1.isChecked()) 
							dbHelper.insertAlternative(dbHelper.getWritableDatabase(), ck1.getText().toString(), 3);
						if(ck2.isChecked()) 
							dbHelper.insertAlternative(dbHelper.getWritableDatabase(), ck2.getText().toString(), 3);
						if(ck3.isChecked()) 
							dbHelper.insertAlternative(dbHelper.getWritableDatabase(), ck3.getText().toString(), 3);	        
						if(ckOutro.isChecked() && !editOutro.getText().toString().isEmpty())
							dbHelper.insertAlternative(dbHelper.getWritableDatabase(), editOutro.getText().toString(), 3);
				        dbHelper.close();
						startActivity(questao4);
					}else{
						Toast msg = Toast.makeText(getApplicationContext(), "Questão Obrigatória.", Toast.LENGTH_SHORT);
						msg.show();
					}
				}
		 });
		
	}
}
