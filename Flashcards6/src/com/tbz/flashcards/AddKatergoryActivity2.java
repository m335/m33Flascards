/**@author Fabienne Pfister, Davina Golomingi
 * @version V4
 */
package com.tbz.flashcards;

import java.io.File;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class AddKatergoryActivity2 extends Activity implements OnClickListener {
	private EditText editName;
	private Button buttonOK;
	private String katName;
	private File dirMain;
	private File dirIMG;
	private File dirKat;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_add_kategory);

		dirMain = getDir("FlashCards", MODE_WORLD_READABLE);
						
		//Schaltflächen als Objekte
		editName = (EditText) findViewById(R.id.editName);
		buttonOK = (Button) findViewById(R.id.buttonOK);
		  
		buttonOK.setOnClickListener(this);
			
   }

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.add_katergory_activity2, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	
	@Override
	public void onClick(View view) {
	katName = editName.getText().toString();
	//Erzeugen eines leeren Kategori-Ordners wenn der Name stimmt
	if(NameOk(katName)){
		//Files im richtigen Ordner werden hier erstellt
		dirKat = new File(dirMain, katName);
		dirIMG = new File(dirKat , "image");
			dirKat.mkdir();
			dirIMG.mkdir();
		
	}
	startActivity(new Intent(this, EditListSetActivity.class));
		 }
	
	
	
	/**
	 * @author Davina
	 * @param kategory Der Name der Kategorie
	 * @return true, wenn der Name den Kriterien entspricht
	 */
	public boolean NameOk(String kategory){
		//Name wird ueberprüft, es sollte nicht leer sein und keien Puntuation enthalten
		String expression = "\\p{Punct}";
		String name = kategory;
		if ( name == "" || name.matches(expression)){
		   return false;
		} else {
		   return true;
		}   
	}

}