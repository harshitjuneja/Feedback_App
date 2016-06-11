package com.example.harshit.feedbackdeity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

import java.io.ByteArrayOutputStream;

public class Signature extends AppCompatActivity implements View.OnTouchListener {


    ImageView iv;
    Bitmap b;
    Canvas c;
    Paint paint;
    float init_x = 0, init_y=0 ;
    String encoded_signature;

    public Signature(){}
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signature);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        iv = (ImageView) findViewById(R.id.imageView2);
        b = Bitmap.createBitmap(750, 1000, Bitmap.Config.ARGB_8888);
        c = new Canvas(b);
        paint = new Paint();
        paint.setColor(Color.RED);
        iv.setImageBitmap(b);
        iv.setOnTouchListener(this);
    }

    public boolean onOptionsItemSelected(MenuItem item){
        if(item.getItemId()==R.id.home){
            NavUtils.navigateUpFromSameTask(this);
            return true;
        }
        return super.onOptionsItemSelected(item);

    }

    public void save_sig(View v) {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        b.compress(Bitmap.CompressFormat.WEBP,100,outputStream);
        byte[] sig = outputStream.toByteArray();
        encoded_signature =Base64.encodeToString(sig, Base64.DEFAULT);
        Log.d("TAG",encoded_signature);

        Intent i = new Intent(this, Exit.class);
        startActivity(i);
    }

    public void retake_sig(View v) {
        Intent i = new Intent(this, Signature.class);
        startActivity(i);
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {

            int action = event.getAction();
            switch (action){
                case MotionEvent.ACTION_DOWN:
                    init_x = event.getX();
                    init_y = event.getY();
                    break;
                case MotionEvent.ACTION_MOVE:
                    float final_x = event.getX();
                    float final_y = event.getY();
                    c.drawLine(final_x,final_y, init_x,init_y ,paint);
                    init_x=final_x;
                    init_y=final_y;
                    iv.invalidate();
                    break;
                case MotionEvent.ACTION_UP:
                    final_x = event.getX();
                    final_y = event.getY();
                    c.drawLine(final_x,final_y,init_x,init_y,paint);
                    iv.invalidate();
                    break;
                default:
                    break;
            }

        return true;
    }

}
