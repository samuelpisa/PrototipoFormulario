package com.prototipo;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnKeyListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;

public class Questao6Activity extends Activity {
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
		
		RadioButton rbr1c1 = (RadioButton) findViewById(R.id.rbr1c1);
		RadioButton rbr1c2 = (RadioButton) findViewById(R.id.rbr1c1);
		RadioButton rbr1c3 = (RadioButton) findViewById(R.id.rbr1c1);
		
		RadioButton rbarr1[] = {rbr1c1,rbr1c2,rbr1c3};
		
		RadioButton rbr2c1 = (RadioButton) findViewById(R.id.rbr1c1);
		RadioButton rbr2c2 = (RadioButton) findViewById(R.id.rbr1c1);
		RadioButton rbr2c3 = (RadioButton) findViewById(R.id.rbr1c1);
		
		RadioButton rbarr2[] = {rbr2c1,rbr2c2,rbr2c3};
		
		RadioButton rbr3c1 = (RadioButton) findViewById(R.id.rbr1c1);
		RadioButton rbr3c2 = (RadioButton) findViewById(R.id.rbr1c1);
		RadioButton rbr3c3 = (RadioButton) findViewById(R.id.rbr1c1);
		
		RadioButton rbarr3[] = {rbr3c1,rbr3c2,rbr3c3};
		
		
		
		rbr1c1.setOnClickListener(new OnClickRadioButton(rbarr1));
		rbr1c2.setOnClickListener(new OnClickRadioButton(rbarr1));
		rbr1c3.setOnClickListener(new OnClickRadioButton(rbarr1));
		rbr2c1.setOnClickListener(new OnClickRadioButton(rbarr2));
		rbr2c2.setOnClickListener(new OnClickRadioButton(rbarr2));
		rbr2c3.setOnClickListener(new OnClickRadioButton(rbarr2));
		rbr3c1.setOnClickListener(new OnClickRadioButton(rbarr3));
		rbr3c2.setOnClickListener(new OnClickRadioButton(rbarr3));
		rbr3c3.setOnClickListener(new OnClickRadioButton(rbarr3));
		
		
		
		
		
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


class OnClickRadioButton implements OnClickListener, OnKeyListener{

	private RadioButton []rb;
	
	public OnClickRadioButton(RadioButton []rb) {
		this.rb = rb;
	}

	@Override
	public boolean onKey(View arg0, int arg1, KeyEvent arg2) {
		return true;
		
	}


	@Override
	public void onClick(View arg0) {
		RadioButton rbc = (RadioButton) arg0;
		
		for (int i = 0; i < rb.length; i++) {
			
			if(rbc != rb[i]){
				rb[i].setChecked(false);
			}
			
		}
		
	}
	
}
