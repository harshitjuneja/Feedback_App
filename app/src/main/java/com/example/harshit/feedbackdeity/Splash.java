package com.example.harshit.feedbackdeity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;


public class Splash extends AppCompatActivity {

    public Splash(){}
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        Thread t = Thread.currentThread();
        try {
            t.sleep(1000);
        }
        catch (InterruptedException e){
            Log.d("Exception occurred","Exception");
        }
        Intent i = new Intent(this,Email.class);
        startActivity(i);
    }



}
