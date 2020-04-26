package com.example.blooddonor3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class login extends AppCompatActivity {
FirebaseAuth mauth;
EditText et1,et2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mauth=FirebaseAuth.getInstance();
        et1=(EditText)findViewById(R.id.login_et1);
        et2=(EditText)findViewById(R.id.login_et2);
    }

    public void fun(View view) {
Intent i=new Intent(login.this,otp.class);
startActivity(i);

    }

    public void mainfun(View view) {
if(et1.getText().toString().isEmpty() || et2.getText().toString().isEmpty())
{
    Toast.makeText(login.this,"please enter details",Toast.LENGTH_LONG).show();
}
else{        mauth.signInWithEmailAndPassword(et1.getText().toString(),et2.getText().toString()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful())
                {
                    Intent i=new Intent(login.this,first.class);
                    startActivity(i);
                }
                else
                {
                    Toast.makeText(login.this,"invalid email or password",Toast.LENGTH_LONG).show();
                }
            }
        });}
    }

    public void needhelp(View view) {
        AlertDialog.Builder builder=new AlertDialog.Builder(login.this);
       View v= LayoutInflater.from(this).inflate(R.layout.alertdialogsupport,null);
       builder.setView(v);
       AlertDialog dialog=builder.create();
       dialog.show();
    }
}
