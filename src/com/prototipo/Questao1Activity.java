package com.prototipo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

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

		
		 btVoltar.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View arg) {
					startActivity(lista);
				}
		 });
		 btAvancar.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View arg) {
					
					RadioGroup rgroup = (RadioGroup) findViewById(R.id.radiogroup1);
					
					if(rgroup.getCheckedRadioButtonId() != -1){
						RadioButton rb = (RadioButton) findViewById(rgroup.getCheckedRadioButtonId());
													
						DbHelper dbHelper = new DbHelper(Questao1Activity.this);
				        dbHelper.insertAlternative(dbHelper.getWritableDatabase(), rb.getText().toString(), 1);				
				        dbHelper.close();
						
						startActivity(questao2);
					}else{
						Toast msg = Toast.makeText(getApplicationContext(), "Questão Obrigatória.", Toast.LENGTH_SHORT);
						msg.show();
					}
				}
		 });
	}
}
