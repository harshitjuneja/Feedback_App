package com.example.harshit.feedbackdeity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;


public class Email extends AppCompatActivity{

    String email1;
    static String mail_address="mail_address";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email);
    }

     public Email(){
     }

     public Email(int id){
        EditText e = (EditText) findViewById(R.id.editText5);
        this.email1 = e.toString();


    }

    public void check_email(View v){
        Intent i = new Intent(this,UserDetails.class);
        EditText e = (EditText) findViewById(R.id.editText5);
        email1 = e.toString();
        startActivity(i);
    }
}

