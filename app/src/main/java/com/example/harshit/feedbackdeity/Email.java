package com.example.harshit.feedbackdeity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.firebase.client.Firebase;

public class Email extends AppCompatActivity{

    String email1;
    String TAG = "Email";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email);
        Firebase.setAndroidContext(this);
    }

     public Email(){}

    public void check_email(View view){
        Intent i = new Intent(this,UserDetails.class);
        EditText e = (EditText) findViewById(R.id.editText5);
        email1 = e.getText().toString();
        Firebase myref = new Firebase("https://feedbackdeity.firebaseio.com/");
        myref.child("Email").push().setValue(email1);
        String key = myref.child("Email").push().getKey();
        i.putExtra("key",key);
        //Log.d(TAG,key);
        startActivity(i);
    }
}

