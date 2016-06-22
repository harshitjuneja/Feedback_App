package com.example.harshit.feedbackdeity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NavUtils;

import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;

import android.view.View;
import android.widget.EditText;

import com.firebase.client.Firebase;


public class UserDetails extends AppCompatActivity {

    private static final String TAG = "UserDetails";
    private static final String REQUIRED = "Required";

    private String key;
    private EditText designation;
    private EditText name;
    private EditText phone;
    private EditText office;

    public UserDetails(){}

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_details);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Bundle b = getIntent().getExtras();
        key = b.getString("key");
        Log.d("User_Details",key);
        name = (EditText) findViewById(R.id.Name);
        designation = (EditText) findViewById(R.id.Designation);
        phone = (EditText) findViewById(R.id.Phone);
        office = (EditText) findViewById(R.id.Office);

    }

    public boolean onOptionsItemSelected(MenuItem item){
        if(item.getItemId()==R.id.home){
            NavUtils.navigateUpFromSameTask(this);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void verify(View view) {
        Intent i = new Intent(this,Feedback.class);
        String fullname = name.getText().toString();
        String post = designation.getText().toString();
        String mobile = phone.getText().toString();
        String daftar = office.getText().toString();
        Firebase ref = new Firebase("https://feedbackdeity.firebaseio.com/");
        ref.child("Name").child(key).setValue(fullname);
        ref.child("Designation").child(key).setValue(post);
        ref.child("Phone").child(key).setValue(mobile);
        ref.child("Office").child(key).setValue(daftar);
        i.putExtra("key",key);
        startActivity(i);

    }


    
    }



