package com.techup.idealschool;

import java.util.List;
import java.util.Vector;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class MainActivity extends FragmentActivity {

	Button buttonl;
	Intent intent1,intent2;
	final int REQUEST_CODE=1234;
	
	
	private PagerAdapter mPagerAdapter;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.viewpager_layout);
		initialisePaging();
	}
	
	

	private void initialisePaging() {
		// TODO Auto-generated method stub
		List<Fragment> fragments = new Vector<Fragment>();
		fragments.add(Fragment.instantiate(this,Fragment1.class.getName()));
		fragments.add(Fragment.instantiate(this,Fragment2.class.getName()));
		fragments.add(Fragment.instantiate(this,Fragment3.class.getName()));
		mPagerAdapter =new PagerAdapter(this.getSupportFragmentManager(), fragments);
		
		ViewPager pager = (ViewPager) findViewById(R.id.viewpager);
		pager.setAdapter(mPagerAdapter);
		intent1 = new Intent(getApplicationContext(),LatestNews.class);
		intent2 = new Intent(getApplicationContext(),LikeUs.class);
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
		.setTitle("Latest News")
		.setMessage("Be Connected To Internet")
		.setNeutralButton("GET NEWS",new DialogInterface.OnClickListener() {
			
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
		.setMessage("Ideal English Higher Secondary School\n\nAddress : Maijubahal, Chabahil,\nP.O.Box : 5308, Kathmandu\nTel.: 4470363, 4498858, 4486754\nFax : 977-1-4473298\nE-mail : info@ideal.edu.np\nWebsite : ideal.edu.np")
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


