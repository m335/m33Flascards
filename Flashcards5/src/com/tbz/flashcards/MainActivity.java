package com.tbz.flashcards;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;

public class MainActivity extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

	}


    /**
     * Startet die View der Liste zum Lernen
     * @param view
     */
	public void lernen(View view) {
    	startActivity(new Intent(this, ListActivity.class));
        
    }
    

    /**
     * Startet die View der Liste zum Bearbeiten
     * @param view
     */
	public void myflashcards(View view) {
        startActivity(new Intent(this, EditListSetActivity.class));
    }
    

}
