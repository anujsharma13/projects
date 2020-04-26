package com.example.blooddonor3.adapters;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.blooddonor3.R;
import com.example.blooddonor3.datamodels.RequestDataModel;

import java.util.ArrayList;

public class recycleradapter extends RecyclerView.Adapter<recycleradapter.ViewHolder> {
    ArrayList<RequestDataModel> arrayList;

    public recycleradapter(ArrayList<RequestDataModel> arrayList) {
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v=LayoutInflater.from(parent.getContext()).inflate(R.layout.requestitem,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
RequestDataModel dataModel=arrayList.get(position);
holder.tv1.setText(dataModel.getName());
holder.tv2.setText(dataModel.getGender());
holder.tv3.setText(dataModel.getPh_no());
holder.tv4.setText(dataModel.getCity());
holder.tv5.setText(dataModel.getAge());
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }
    class ViewHolder extends RecyclerView.ViewHolder
    {
TextView tv1,tv2,tv3,tv4,tv5;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tv1=(TextView)itemView.findViewById(R.id.reciever_name);
            tv2=(TextView)itemView.findViewById(R.id.reciever_gender);
            tv3=(TextView)itemView.findViewById(R.id.reciever_phno);
            tv4=(TextView)itemView.findViewById(R.id.reciever_city);
            tv5=(TextView)itemView.findViewById(R.id.reciever_age);

        }
    }
}