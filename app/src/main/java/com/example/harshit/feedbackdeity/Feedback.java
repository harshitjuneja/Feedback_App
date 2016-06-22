package com.example.harshit.feedbackdeity;

import android.content.Intent;

import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import com.firebase.client.Firebase;

public class Feedback extends AppCompatActivity {

    String key;
    EditText feedback;

    public Feedback(){}
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Bundle b = getIntent().getExtras();
        key = b.getString("key");
        feedback = (EditText) findViewById(R.id.Feedbck);
    }

    public boolean onOptionsItemSelected(MenuItem item){
        if(item.getItemId()==R.id.home){
            NavUtils.navigateUpFromSameTask(this);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void submit_feedback(View v){

        String fbck = feedback.getText().toString();
        Firebase ref = new Firebase("https://feedbackdeity.firebaseio.com/");
        ref.child("Feedback").child(key).setValue(fbck);
        Intent i = new Intent(this,Camera.class);
        i.putExtra("key",key);
        startActivity(i);
    }

}

