package com.example.harshit.feedbackdeity;

import android.content.Intent;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

public class Confirmation extends AppCompatActivity {

    String decodedSignature;
    String key;
    private String getname;
    private String getphone;
    private String getemail;
    private String getoffice;
    private String getdesignation;
    private String getSignature;
    private String getphoto;
    private String getFeedback;

    public Confirmation(){}

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmation);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Bundle bundle = getIntent().getExtras();
        key=bundle.getString("key");
        Firebase ref = new Firebase("https://feedbackdeity.firebaseio.com/");
        ref.child("Name").child(key).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                getname=snapshot.getValue().toString();
                Log.d("Conf",getname);
                TextView t = (TextView) findViewById(R.id.edit1);
                t.setText(getname);
            }
            @Override public void onCancelled(FirebaseError error) { }
        });

        Firebase ref1 = new Firebase("https://feedbackdeity.firebaseio.com/");

        ref1.child("Email").child(key).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                getemail=snapshot.getValue().toString();
                TextView t = (TextView) findViewById(R.id.edit2);
                t.setText(getemail);
                Log.d("Conf",getemail);
            }
            @Override public void onCancelled(FirebaseError error) { }
        });

        ref.child("Designation").child(key).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                getdesignation=snapshot.getValue().toString();
                TextView t = (TextView) findViewById(R.id.edit4);
                t.setText(getdesignation);
                Log.d("Conf",getdesignation);
            }
            @Override public void onCancelled(FirebaseError error) { }
        });

        ref.child("Phone").child(key).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                getphone=snapshot.getValue().toString();
                TextView t = (TextView) findViewById(R.id.edit3);
                t.setText(getphone);
                Log.d("Conf",getphone);
            }
            @Override public void onCancelled(FirebaseError error) { }
        });

        ref.child("Office").child(key).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                getoffice=snapshot.getValue().toString();
                TextView t = (TextView) findViewById(R.id.edit5);
                t.setText(getoffice);
                Log.d("Conf",getoffice);
            }
            @Override public void onCancelled(FirebaseError error) { }
        });

        ref.child("Feedback").child(key).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                getFeedback=snapshot.getValue().toString();
                Log.d("Conf",getFeedback);
                TextView t = (TextView) findViewById(R.id.edit6);
                t.setText(getFeedback);
            }
            @Override public void onCancelled(FirebaseError error) { }
        });


        ref.child("Photo").child(key).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                getphoto=snapshot.getValue().toString();
                //Log.d("Conf",getname);
            }
            @Override public void onCancelled(FirebaseError error) { }
        });

        ref.child("Signature").child(key).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                getSignature=snapshot.getValue().toString();
                //Log.d("Conf",getname);
            }
            @Override public void onCancelled(FirebaseError error) { }
        });

    }

    public boolean onOptionsItemSelected(MenuItem item){
        if(item.getItemId()==R.id.home){
            NavUtils.navigateUpFromSameTask(this);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void save(View view){
        Intent i = new Intent(this,Exit.class);
        startActivity(i);
    }

}

