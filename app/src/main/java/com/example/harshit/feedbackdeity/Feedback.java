package com.example.harshit.feedbackdeity;

import android.content.Intent;

import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

public class Feedback extends AppCompatActivity {
    public Feedback(){}
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public boolean onOptionsItemSelected(MenuItem item){
        if(item.getItemId()==R.id.home){
            NavUtils.navigateUpFromSameTask(this);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void submit_feedback(View v){
        EditText e = (EditText) findViewById(R.id.edtInput);
        String feedback = e.toString();



        Intent i = new Intent(this,Camera.class);
        startActivity(i);
    }

}

