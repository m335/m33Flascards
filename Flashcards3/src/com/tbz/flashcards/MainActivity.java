package com.tbz.flashcards;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

public class MainActivity extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

/*		if (savedInstanceState == null) {
			getSupportFragmentManager().beginTransaction()
					.add(R.id.container, new PlaceholderFragment()).commit();
		}
*/	}

	
    public void lernen(View view) {
    	startActivity(new Intent(this, ListActivity.class));
        
    }
    
    
    public void main(View view) {
    	startActivity(new Intent(this, MainActivity.class));
    }
    public void myflashcards(View view) {
        startActivity(new Intent(this, EditListSetActivity.class));
    }
    

}
