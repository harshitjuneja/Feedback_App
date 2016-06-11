package com.example.harshit.feedbackdeity;

import android.content.Intent;

import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import java.io.ByteArrayOutputStream;


public class Camera extends AppCompatActivity {

    Bitmap bitmap;
    ImageView image;
    String encoded_image;

    public Camera(){}
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        image = (ImageView) findViewById(R.id.imageView);
        Intent cam = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);  // intent object to take picture
        startActivityForResult(cam, 100);
    }

    public boolean onOptionsItemSelected(MenuItem item){
        if(item.getItemId()==R.id.home){
            NavUtils.navigateUpFromSameTask(this);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void onActivityResult(int req_code,int res_code, Intent data){
        Bundle b = data.getExtras();
        bitmap = (Bitmap)b.get("data");
        image.setImageBitmap(bitmap);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.WEBP,100,outputStream);
        byte[] image = outputStream.toByteArray();
        encoded_image = Base64.encodeToString(image,Base64.DEFAULT );
        Log.d("TAG",encoded_image);

    }

    public void save(View v){
        Intent i = new Intent(this,Signature.class);
        startActivity(i);
    }

    public void skip(View v){
        Intent j = new Intent(this,Signature.class);
        startActivity(j);
    }

}
