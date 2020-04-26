package com.example.blooddonor3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class otp extends AppCompatActivity {
public String verification;EditText et1,et2,et3,et4,et5;
Spinner s1;
//DatabaseReference dataa;
FirebaseAuth mauth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp);
      et1=(EditText)findViewById(R.id.et1);
      et2=(EditText)findViewById(R.id.et2);
      et3=(EditText)findViewById(R.id.et3);
      s1=(Spinner)findViewById(R.id.s1);
      et4=(EditText)findViewById(R.id.et4);
      et5=(EditText)findViewById(R.id.et5);
    //  dataa= FirebaseDatabase.getInstance().getReference();
      mauth=FirebaseAuth.getInstance();
    }

    public void fun1(View view) {
        Intent i=new Intent(otp.this,login.class);
        startActivity(i);

    }

    public void register(View view) {
        mauth.createUserWithEmailAndPassword(et2.getText().toString(),et3.getText().toString()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful())
                {
Intent i=new Intent(otp.this,bloodgroup.class);
startActivity(i);
                }
                else
                {
                    String s=task.getException().getMessage();
                    Toast.makeText(otp.this,"exception:"+s,Toast.LENGTH_LONG).show();
                }
            }
        });

    }

}
