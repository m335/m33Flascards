package com.tbz.flashcards;


import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.os.Build;

public class QuestionActivity extends ActionBarActivity {
    
	private static final String TAG = "Raffi";
	private static final String FILENAME = TAG + ".txt";
	private EditText textF;
	private Button imageF1;
	private Button imageF2;
	private Button submitF;
	private String imgPfad;
	private String katPfad;
	private String cardLine;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_question);
		Bundle b = getIntent().getExtras();
	    imgPfad = b.getString("imgPfad");
		katPfad = b.getString("katPfad");
		textF = (EditText) findViewById(R.id.editCardResponse);
		imageF1 = (Button) findViewById(R.id.imgFCam);
		imageF2 = (Button) findViewById(R.id.imgFGal);
		submitF = (Button) findViewById(R.id.submitFront);
		
		cardLine = "";
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.question, menu);
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

    public void galleryButton(View view) {  
	startActivity(new Intent(this, FotoGalleryActivity.class));
    }

    public void shootButton(View view) {  
	startActivity(new Intent(this, FotoShootActivity.class));
    }
    
    public void okButton(View view) {  
    	Intent i = new Intent(this, ResponseActivity.class);
    	i.putExtra("imgPfad",imgPfad);
    	i.putExtra("katPfad",katPfad);
    	
    	save(textF.getText().toString() + "¦");
    	i.putExtra("cardLine", cardLine);
    	startActivity(i);
    }
    
    private void save(String s) {
	cardLine = cardLine + s;
    }

}
