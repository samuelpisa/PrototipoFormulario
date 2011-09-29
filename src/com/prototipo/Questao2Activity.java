package com.prototipo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

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
					startActivity(questao3);
				}
		 });
	}
}
