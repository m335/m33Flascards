package com.tbz.flashcards;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;

import android.app.ListActivity;
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

public class RemoveKatActivity extends ListActivity {

	@Override
	public void onCreate(Bundle icicle) {
	    super.onCreate(icicle);
	    setContentView(R.layout.editieren_list_set);
	    // create an array of Strings, that will be put to our ListActivity
	    ArrayAdapter<Model> adapter = new InteractiveArrayAdapter(this,
	        getModel());
	    setListAdapter(adapter);
	  }
	/**
	 * 	
	 * @return
	 */
	private List<Model> getModel() {
	    final ListView listview = (ListView) findViewById(R.id.listview);
	    final List<Model> paths = new ArrayList<Model>();
	    try{
		    File directory = new File("/data/data/com.tbz.flashcards/app_FlashCards/");
		    File[] files = directory.listFiles();
		    for (int i = 0; i < files.length; ++i) {
//		        paths.add(files[i].getName());
		    }		    
	    }
		catch (NullPointerException e)
		{}	 
	    return paths;
	    }
	/**
	 * 	
	 * @param s
	 * @return
	 */
	private Model get(String s) {
		    return new Model(s);
		  }
	
	/**
	* 
	* @param view
	*/	
	public void main(View view) {
		   startActivity(new Intent(this, MainActivity.class));
        }

	} 
