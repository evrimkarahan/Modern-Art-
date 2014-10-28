package com.coursera.modernartui;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.ActionBarActivity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;


public class ModernArt extends ActionBarActivity {

	
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modern_art);
        
        
        FragmentManager fm =getSupportFragmentManager();
        Fragment fragment = fm.findFragmentById(R.id.modern_art_container);
        
        if(fragment ==null){
        	fragment = new ModernArtFragment();
        	fm.beginTransaction().add(R.id.modern_art_container, fragment).commit();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.modern_art, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
    	
        switch (item.getItemId()) {
        case R.id.icon:
             Intent intent = new Intent(this, ModernArt.class);
             startActivity(intent);
        case R.id.information:
            //popup window code here
        	AlertDialog.Builder alertbox = new AlertDialog.Builder(this);
        	
     
        	
	         // set the message to display
        	alertbox.setMessage("Inspired by the works of artists such as Piet Mondrian and Ben Nicholson. \n Click below to learn more ");
        	
        	
        	alertbox.setPositiveButton("Not Now", new DialogInterface.OnClickListener() {
				
				@Override
				public void onClick(DialogInterface dialog, int which) {
					dialog.cancel();
				}
			});

        
	         alertbox.setNegativeButton("Visit MOMA", new DialogInterface.OnClickListener() {

	             // click listener on the alert box
	             @Override
				public void onClick(DialogInterface arg0, int arg1) {
	                
	            	 Uri uri = Uri.parse("http://www.moma.org");
	            	 Intent intent = new Intent(Intent.ACTION_VIEW, uri);
	            	 startActivity(intent);
	
	             }
	         });
	          

         // show it
         alertbox.show();

    }
    return true;
    }
}
