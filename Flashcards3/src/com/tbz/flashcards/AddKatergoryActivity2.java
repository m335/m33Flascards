package com.tbz.flashcards;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import android.app.Activity;
import android.util.Log;
import android.support.v7.app.ActionBarActivity;
import android.support.v4.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class AddKatergoryActivity2 extends Activity implements OnClickListener {
	private EditText editName;
	private Button buttonOK;
	private String katName;
	private File dirMain;
	private File dirIMG;
	private File dirKat;
	private static final String TAG = AddKatergoryActivity2.class.getSimpleName();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_add_kategory);

		dirMain = getDir("FlashCards", MODE_WORLD_READABLE);
						
		editName = (EditText) findViewById(R.id.editName);
		buttonOK = (Button) findViewById(R.id.buttonOK);
		  
		buttonOK.setOnClickListener(this);

/*		if (savedInstanceState == null) {
			getSupportFragmentManager().beginTransaction()
					.add(R.id.container, new PlaceholderFragment()).commit();
		}
		
*/			
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
	//Erzeugen eines leeren Kategori-Ordners
	if(NameOk(katName)){
		//File dirKat = getDir(katName, MODE_WORLD_READABLE);
		//createFile(dirMain, "image");
		dirKat = new File(dirMain, katName);
		dirIMG = new File(dirKat , "image");
			dirKat.mkdir();
			dirIMG.mkdir();
		
	}
	startActivity(new Intent(this, EditListSetActivity.class));
		 }
	
	
	
	public boolean NameOk(String kategory){
		String expression = "\\p{Punct}";
		//| name.matches(expression)
		//lieber mit fkt isEmpty()
		String name = kategory;
		if ( name == "" || name.matches(expression)){
		   return false;
		} else {
		   return true;
		}   
	}


}