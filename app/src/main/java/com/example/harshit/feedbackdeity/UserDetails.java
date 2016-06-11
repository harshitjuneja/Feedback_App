package com.example.harshit.feedbackdeity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class UserDetails extends AppCompatActivity {

    public UserDetails(){
    }

    public void write_email(View view) {
        int id=0;
        Email em = new Email(id);
        DatabaseReference db = FirebaseDatabase.getInstance().getReference();
        db.setValue(em);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_details);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }

    public boolean onOptionsItemSelected(MenuItem item){
        if(item.getItemId()==R.id.home){
            NavUtils.navigateUpFromSameTask(this);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void verify_details(View v){
        EditText e = (EditText) findViewById(R.id.editText);
        EditText f = (EditText) findViewById(R.id.editText2);
        EditText g = (EditText) findViewById(R.id.editText3);
        EditText h = (EditText) findViewById(R.id.editText4);

        String designation = e.toString();
        String name = f.toString();
        String office = g.toString();
        String phone = h.toString();
        write_email(v);


        Intent i = new Intent(this,Feedback.class);
        startActivity(i);
    }


}
