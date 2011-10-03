package com.prototipo;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PrototipoFormularioActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        
        final Button btAcessar = (Button) findViewById(R.id.button1);
        final Intent lista = new Intent(this, ListaFormularioActivity.class);
        
        btAcessar.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View arg) {
				startActivity(lista);
				finish();
			}
		});
    }
    
    
}