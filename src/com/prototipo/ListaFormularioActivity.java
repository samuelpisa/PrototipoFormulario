/*
 ******************************************************************************
 * Parts of this code sample are licensed under Apache License, Version 2.0   *
 * Copyright (c) 2009, Android Open Handset Alliance. All rights reserved.    *
 *                                                                            *                                                                         *
 * Except as noted, this code sample is offered under a modified BSD license. *
 * Copyright (C) 2010, Motorola Mobility, Inc. All rights reserved.           *
 *                                                                            *
 * For more details, see MOTODEV_Studio_for_Android_LicenseNotices.pdf        * 
 * in your installation folder.                                               *
 ******************************************************************************
 */

package com.prototipo;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class ListaFormularioActivity extends ListActivity {

	private String[] listItems = {"formulario 1", "formulario 2"};

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		// load list
		//Resources res = getResources();
		//listItems = res.getStringArray(R.array.sample_simple_list_items);

		// maps an array to TextViews
		setListAdapter(new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, listItems));
	}

	@Override
	protected void onListItemClick(ListView lv, View v, int position, long id) {
		// your action here
		Toast.makeText(
				lv.getContext(),
				getString(R.string.sample_simple_list_selected)
						+ lv.getItemAtPosition(position).toString(),
				Toast.LENGTH_SHORT).show();
	}
}