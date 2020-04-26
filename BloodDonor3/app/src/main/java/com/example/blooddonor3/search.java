package com.example.blooddonor3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class search extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

    }

    public void home(View view) {
        Intent i=new Intent(search.this,first.class);
        startActivity(i);
    }

    public void user_profile(View view) {
    }

    public void settings(View view) {
    }

    public void help(View view) {
    }

    public void complaint(View view) {
    }

    public void logout(View view) {
        Intent i=new Intent(search.this,login.class);
        startActivity(i);
    }

    public void back(View view) {
        Intent i=new Intent(search.this,first.class);
        startActivity(i);
    }
}
