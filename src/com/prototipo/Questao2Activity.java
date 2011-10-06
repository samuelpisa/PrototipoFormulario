package com.prototipo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Questao2Activity extends Activity {
	/**
	 * @see android.app.Activity#onCreate(Bundle)
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.questao2);
		
		final Button btVoltar = (Button) findViewById(R.id.btvoltar);
		final Intent questao1 = new Intent(this, Questao1Activity.class);
		final Button btAvancar = (Button) findViewById(R.id.btavancar);
		final Intent questao3 = new Intent(this, Questao3Activity.class);

		 btVoltar.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View arg) {
					startActivity(questao1);
				}
		 });
		 btAvancar.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View arg) {
					EditText edit1 = (EditText) findViewById(R.id.editText1);
					
					if(!edit1.getText().toString().isEmpty()){
						DbHelper dbHelper = new DbHelper(Questao2Activity.this);
				        dbHelper.insertAlternative(dbHelper.getWritableDatabase(), edit1.getText().toString(), 2);				
				        dbHelper.close();
						
						startActivity(questao3);
					}else{
						Toast msg = Toast.makeText(getApplicationContext(), "Questão Obrigatória.", Toast.LENGTH_SHORT);
						msg.show();
					}
					
					
				}
		 });
	}
}
