package com.example.blooddonor3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
ImageView iv1,iv2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Handler handler=new Handler();
        iv2=(ImageView)findViewById(R.id.iv2);
        iv2.animate().translationY(250f).alpha(1).setDuration(2500);
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i=new Intent(MainActivity.this,login.class);
                startActivity(i);
            }
        },4500);
    }
}
