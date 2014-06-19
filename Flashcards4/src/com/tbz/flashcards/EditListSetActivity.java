package com.tbz.flashcards;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import android.app.DialogFragment;



public class EditListSetActivity extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.editieren_list_set);
		
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
	        else{
	        	openQ(view);
	            }
	        
	        }	        
	        catch (NullPointerException e)
	        {}
	      }

	    });
	    
		}

	
	public void main(View view) {
		startActivity(new Intent(this, MainActivity.class));
    }

	public void addSet(View view) {        
        startActivity(new Intent(this, AddKatergoryActivity2.class));
    }
	
	public void openQ(View view) {
		startActivity(new Intent(this, QuestionActivity.class));
    }
	

}
