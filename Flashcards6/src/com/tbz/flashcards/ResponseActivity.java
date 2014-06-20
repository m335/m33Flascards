package com.tbz.flashcards;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

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

public class ResponseActivity extends ActionBarActivity {

	private static final String TAG = "Raffi";
	private static final String FILENAME = TAG + ".txt";
	private EditText textB;
	private Button imageB1;
	private Button imageB2;
	private Button submitB;
	private String imgPfad;
	private String katPfad;
	private String cardLine;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_response);
		Bundle b = getIntent().getExtras();
	    imgPfad = b.getString("imgPfad");
		katPfad = b.getString("katPfad");
		cardLine = b.getString("cardLine");
		textB = (EditText) findViewById(R.id.editCardResponse);
		imageB1 = (Button) findViewById(R.id.imgFGal);
		imageB2 = (Button) findViewById(R.id.imgFCam);
		submitB = (Button) findViewById(R.id.submitCard);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.response, menu);
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

	/**
	 * A placeholder fragment containing a simple view.
	 */
	public static class PlaceholderFragment extends Fragment {

		public PlaceholderFragment() {
		}


	}
	private void save(String s) throws IOException {
		cardLine = cardLine + s;
		File f = new File (katPfad + "/" + FILENAME);
		try
		{
		    FileWriter fw = new FileWriter(f,true); //the true will append the new data
		    fw.write(cardLine+"\n");//appends the string to the file
		    fw.close();
		}
		catch(IOException ioe)
		{
		    System.err.println("IOException: " + ioe.getMessage());
		}
		
	}
	
	public void okButton(View view) throws IOException {
		save(textB.getText().toString() + "¦");
		startActivity(new Intent(this, EditListSetActivity.class));   
    }

}
