/**@author Fabienne Pfister
 * @version V3
 */
package com.tbz.flashcards;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class ListActivity extends ActionBarActivity {

	//Neue Liste erstellen
	@Override
	  protected void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.lernen_list);

	    final ListView listview = (ListView) findViewById(R.id.listview);
	    final List<String> paths = new ArrayList<String>();
	    try{
		    File directory = new File("/data/data/com.tbz.flashcards/app_FlashCards/");
		    File[] files = directory.listFiles();
		    for (int i = 0; i < files.length; ++i) {
		        paths.add(files[i].getName());
		    }


	    }
		catch (NullPointerException e)
		{}
	    
	    final StableArrayAdapter adapter = new StableArrayAdapter(this, android.R.layout.simple_list_item_1, paths);
	    listview.setAdapter(adapter);

	    listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {

	    //Aktion beim Klick  
		@Override
	      public void onItemClick(AdapterView<?> parent, final View view,
	          int position, long id) {
	        final String item = (String) parent.getItemAtPosition(position);
	        try{
	        File directory = new File("/data/data/com.tbz.flashcards/app_FlashCards/"+ item);
	        File[] contents = directory.listFiles();
	        if (contents.length == 0)
	        {
	        	Context context = getApplicationContext();
	        	CharSequence text = "Keine Karten vorhanden";
	        	int duration = Toast.LENGTH_SHORT;

	        	Toast toast = Toast.makeText(context, text, duration);
	        	toast.show();
	        }
	        }	        
	        catch (NullPointerException e)
	        {}
	      }

	    });
	   
	  }
	//Button der zurück zum Main führt
	public void main(View view) {
		startActivity(new Intent(this, MainActivity.class));
    }

	} 

	
	