package com.course.example.sender;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button button1 = null;
    private Button button2 = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button1 = (Button)findViewById(R.id.button1);
        button2 = (Button)findViewById(R.id.button2);

        button1.setOnClickListener(
                new View.OnClickListener(){

                    public void onClick(View v){
                        Log.e("Permission", "Sender sent Broadcast");
                        Intent intent = new Intent("com.course.event.buttonevent");
                        intent.putExtra("message", "Happy Days");
                        intent.setComponent(
                               new ComponentName("com.course.example.receiver",
                                        "com.course.example.receiver.LogWriteReceiver"));
                        sendBroadcast(intent);
                    }
                });

        button2.setOnClickListener(
                new OnClickListener(){

                    public void onClick(View v){
                        Log.e("Permission", "Fire Photon Torpedos");
                        Intent intent = new Intent();
                        //identify component in another app
                        intent.setComponent(new ComponentName("com.course.example.protectedservice",
                                "com.course.example.protectedservice.TorpedoService"));
                        startService(intent);
                        Log.e("Permission", "Service intent sent");
                    }
                });
    }
}