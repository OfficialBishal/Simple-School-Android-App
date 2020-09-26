package com.techup.idealschool;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

public class LikeUs extends Activity {

	Intent intent1,intent2;
	final int REQUEST_CODE=1234;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.likeus_layout);
		configureImageButton();
		intent1 = new Intent(getApplicationContext(),LatestNews.class);
		intent2 = new Intent(getApplicationContext(),LikeUs.class);
	}

	private void configureImageButton() {
		ImageButton btn = (ImageButton) findViewById(R.id.imageButton1);
		ImageButton btn2 = (ImageButton) findViewById(R.id.imageButton2);
		ImageButton btn3 = (ImageButton) findViewById(R.id.imageButton3);
	
		btn.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				String myWeb= "https://www.facebook.com/ouridealschool/";
				Intent myIntent = new Intent(Intent.ACTION_VIEW,
				Uri.parse(myWeb));
				startActivity(myIntent);
			}
		});
		
		btn2.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				String myWeb= "https://twitter.com/OurIdealSchool";
				Intent myIntent = new Intent(Intent.ACTION_VIEW,
				Uri.parse(myWeb));
				startActivity(myIntent);
			}
		});
		
		btn3.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				String myWeb= "https://plus.google.com/u/0/106204619761405541356/";
				Intent myIntent = new Intent(Intent.ACTION_VIEW,
				Uri.parse(myWeb));
				startActivity(myIntent);
			}
		});
	}

	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	/* (non-Javadoc)
	 * @see android.app.Activity#onOptionsItemSelected(android.view.MenuItem)
	 */
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		super.onOptionsItemSelected(item);
		switch(item.getItemId()){
		case R.id.menuupdate:
			updateMenuItem();
			break;
		case R.id.menuweb:
			webMenuItem();
			break;
		case R.id.menucontact:
			contactMenuItem();
			break;
		case R.id.menuinfo:
			infoMenuItem();
			break;
		case R.id.menuabout:
			LayoutInflater inflater = (LayoutInflater)this.getSystemService(LAYOUT_INFLATER_SERVICE);
		    View layout = inflater.inflate(R.layout.about, (ViewGroup)findViewById(R.id.root));
		    AlertDialog.Builder adb = new AlertDialog.Builder(this);
		    adb.setView(layout);
		    adb.show();
		    break;
		case R.id.menufindus:
			findMenuItem();
			break;
		}return true;
	}
	
	private void updateMenuItem(){
		new AlertDialog.Builder(this)
		.setTitle("Update")
		.setMessage("Please Connect To Internet")
		.setNeutralButton("OK",new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				startActivityForResult(intent1, REQUEST_CODE);
			}
		}).show();
	} 
	
	private void webMenuItem(){
		new AlertDialog.Builder(this)
		.setTitle("Visit Site")
		.setMessage("Be Connected To Internet")
		.setNeutralButton("Visit",new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				String myWeb= "http://www.ideal.edu.np";
				Intent myIntent = new Intent(Intent.ACTION_VIEW,
				Uri.parse(myWeb));
				startActivity(myIntent);
			}
		}).show();
	}
	
	private void contactMenuItem(){
		new AlertDialog.Builder(this)
		.setTitle("Contact")
		.setMessage("Ideal English Higher Secondary School\n\nAddress : Maijubahal, Chabahil, P.O.Box : 5308, Kathmandu\nTel.: 4470363, 4498858, 4486754\nFax : 977-1-4473298\nE-mail : info@ideal.edu.np\nWebsite : ideal.edu.np")
		.setNeutralButton("OK",new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
			}
		}).show();
	}
	
	private void infoMenuItem(){
		new AlertDialog.Builder(this)
		.setTitle("Help")
		.setMessage("Swipe Left and Right to proceed to next screen.\nClick on the Update Button to get the Latest Feed.\nIf there is any problem than please contact us.")
		.setNeutralButton("OK",new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
			}
		}).show();
	}
	
	private void findMenuItem(){
		new AlertDialog.Builder(this)
		.setTitle("Find us On")
		.setMessage("Facebook\nTwitter\nGmail+\nAnd many more....")
		.setNeutralButton("Proceed",new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				startActivityForResult(intent2, REQUEST_CODE);
			}
		}).show();
	}
}
