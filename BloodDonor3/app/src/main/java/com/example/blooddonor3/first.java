package com.example.blooddonor3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.blooddonor3.adapters.recycleradapter;
import com.example.blooddonor3.database.Donor_data;
import com.example.blooddonor3.datamodels.RequestDataModel;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class first extends AppCompatActivity {
    RecyclerView rv1;
    Spinner sp1,sp2,sp3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        Toolbar t=findViewById(R.id.toolbar);
sp1=(Spinner)findViewById(R.id.select_country);
sp2=(Spinner)findViewById(R.id.select_state);
sp3=(Spinner)findViewById(R.id.select_city);
        t.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                if(item.getItemId()==R.id.search_button);
                {
                    Intent i=new Intent(first.this,search.class);
                    startActivity(i);
                }
                return false;
            }
        });
        String[] coutries = {
                "India", "America", "Canada", "Australia", "London"
        };
        String[] states = {"Jammu and Kashmir",
                "Punjab",
                "Himachal Pradesh",
                "Haryana",
                "Delhi",
                "Rajasthan",
                "Uttar Pradesh",
                "Uttarakhand",
                "Madhya Pradesh",
                "Chattisgarh",
                "Gujarat",
                "Maharashtra",
                "Karnataka",
                "Goa",
                "Kerala",
                "Tamil nadu",
                "Andhra pradesh",
                "Telangana",
                "Orissa",
                "Bihar",
                "Jharkhand",
                "West Bengal",
                "Assam",
                "Arunach Pradesh",
                "Sikkim",
                "Meghalaya",
                "Mizoram",
                "Nagaland",
                "Tripura"};

       String punjab[]={
               "Amritsar",
               "Barnala",
               "Bathinda",
               "Faridkot",
               "Fatehgarh Sahib",
               "Firozpur",
               "Gurdaspur",
               "Hoshiarpur",
               "Jalandhar",
               "Kapurthala",
               "Ludhiana",
               "Mansa",
               "Moga",
               "Muktsar",
               "Patiala	District",
               "Rupnagar",
               "Sahibzada Ajit Singh Nagar",
               "Sangrur	District",
               "Shahid Bhagat Singh Nagar",
               "Tarn Taran"};
       String jammu[]={};
       final ArrayAdapter<String> arrayAdapterpunjab=new ArrayAdapter<>(first.this,android.R.layout.simple_list_item_1,punjab);
       final ArrayAdapter<String> arrayAdapterstates=new ArrayAdapter<>(first.this,android.R.layout.simple_list_item_1,states);
       final ArrayAdapter<String> arrayAdaptercountries=new ArrayAdapter<>(first.this,android.R.layout.simple_list_item_1,coutries);
       final ArrayAdapter<String> arrayAdapterjammu=new ArrayAdapter<>(first.this,android.R.layout.simple_list_item_1,jammu);
       sp1.setAdapter(arrayAdaptercountries);
       sp1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
           @Override
           public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
             if(sp1.getSelectedItem().equals("India"))
               sp2.setAdapter(arrayAdapterstates);
           }

           @Override
           public void onNothingSelected(AdapterView<?> adapterView) {

           }
       });
sp2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        if(sp2.getSelectedItem().equals("Punjab"))
            sp3.setAdapter(arrayAdapterpunjab);
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
});
}

    public void makerequest(View view) {
        Intent intent=new Intent(first.this,needblood.class);
        startActivity(intent);
    }

    public void finddonor(View view) {
    rv1=findViewById(R.id.first_recycler);
        ArrayList<RequestDataModel> arrayList=new ArrayList<>();
        Donor_data donorData=new Donor_data(this);
        Cursor c=donorData.fetchdata();
        if(c.getCount()==0)
        {
            Toast.makeText(first.this,"no donor found",Toast.LENGTH_LONG).show();
        }
        else
        {
            while (c.moveToNext())
            {
                arrayList.add(new RequestDataModel(c.getString(0),c.getString(1),c.getString(2),c.getString(3),c.getString(4),c.getString(5),c.getString(6),c.getString(7),c.getString(8),c.getString(9)));
            }
            rv1.setLayoutManager(new LinearLayoutManager(this));
            rv1.setAdapter(new recycleradapter(arrayList));
        }
    }
}
