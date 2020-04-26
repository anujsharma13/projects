package com.example.blooddonor3;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.blooddonor3.database.Donor_data;

public class needblood extends AppCompatActivity {
EditText et1,et2,et4,et5,et6,et7,et8,et9;
Spinner sp1,sp2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_needblood);
    et1=findViewById(R.id.donor_name);
        et2=findViewById(R.id.donor_age);
        et4=findViewById(R.id.donor_phno);
        et5=findViewById(R.id.donor_city);
        et6=findViewById(R.id.donor_state);
        et7=findViewById(R.id.donor_country);
        et8=findViewById(R.id.donor_message);
        et9=findViewById(R.id.donor_date);
        sp1=findViewById(R.id.donor_lv1);   //gender
        sp2=findViewById(R.id.donor_lv2);   //blood group

    }
    public void goback(View view) {
        Intent i=new Intent(needblood.this,first.class);
        startActivity(i);
}

    public void submit_donor(View view) {

        final Donor_data donor=new Donor_data(this);
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setTitle("Are you sure all details are correct").setPositiveButton("yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String name= et1.getText().toString().toUpperCase();
                        String  age= et2.getText().toString().toUpperCase();
                        String gender=sp1.getSelectedItem().toString().toUpperCase();
                        String blood= sp2.getSelectedItem().toString().toUpperCase();
                        String phno=  et4.getText().toString().toUpperCase();
                        String city= et5.getText().toString().toUpperCase();
                        String state= et6.getText().toString().toUpperCase();
                        String country= et7.getText().toString().toUpperCase();
                        String message= et8.getText().toString().toUpperCase();
                        String date= et9.getText().toString().toUpperCase();


    Boolean b=donor.adddata(name,age,gender,blood,phno,city,state,country,message,date);
    if (b==true) {
        Toast.makeText(needblood.this, "Thank you", Toast.LENGTH_LONG).show();
    } else {
        Toast.makeText(needblood.this, "technical issue", Toast.LENGTH_LONG).show();
    }
                    }
                }
        ).setNegativeButton("no",null);
        AlertDialog alertDialog=builder.create();
        alertDialog.show();

    }
}
