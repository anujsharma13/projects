package com.example.blooddonor3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;

public class bloodgroup extends AppCompatActivity {
ListView lv1;
TextView tv1;
DatabaseReference dataa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bloodgroup);
lv1=(ListView)findViewById(R.id.blood_lv1);
final String values[]={"A+","A-","B+","B-","AB+","AB-","O+","O-"};
        ArrayAdapter arrayAdapter=new ArrayAdapter(this,android.R.layout.simple_list_item_1,values);
lv1.setAdapter(arrayAdapter);
lv1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Toast.makeText(bloodgroup.this,values[i],Toast.LENGTH_LONG).show();
       Intent ii=new Intent(bloodgroup.this,first.class);
      ii.putExtra("bloodgroup",values[i]);
       startActivity(ii);
    }
});
    }
}
