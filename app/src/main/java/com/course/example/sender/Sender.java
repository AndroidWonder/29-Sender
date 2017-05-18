package com.course.example.sender;

import android.os.Bundle;
import android.app.Activity;
import android.widget.Button;
import android.view.View.OnClickListener;
import android.view.View;
import android.util.Log;
import android.content.Intent;

public class Sender extends Activity {
	
	private Button button1 = null;
	private Button button2 = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		button1 = (Button)findViewById(R.id.button1);
		button2 = (Button)findViewById(R.id.button2);
		
		button1.setOnClickListener(
				new OnClickListener(){
					
				public void onClick(View v){
					Log.e("Permission", "Sender sent Broadcast");
					Intent intent = new Intent("com.course.event.buttonevent");
					sendBroadcast(intent);
				}
				});
		
		button2.setOnClickListener(
				new OnClickListener(){
					
					public void onClick(View v){
						Log.e("Permission", "Fire Photon Torpedos");
						Intent intent = new Intent("com.course.event.serviceevent");
						startService(intent);				
					}
					});			
		
	}

}
