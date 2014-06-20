/**@author Fabienne Pfister
 * @version V3
 */
package com.tbz.flashcards;

import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class QuestionActivity extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_question);
		
	}
	//Startet den Dialog der Auswahl zur Gallerie-App
public void galleryButton(View view) {  
	startActivity(new Intent(this, FotoGalleryActivity.class));
    }

//Startet die View der Kamera.Api
public void shootButton(View view) {  
	startActivity(new Intent(this, FotoShootActivity.class));
    }

}
