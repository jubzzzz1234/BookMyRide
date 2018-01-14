package com.example.jubin.bookmyride;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by jubin on 29/11/17.
 */

public class AdapterClass extends ArrayAdapter<ModelClass> {

    private Activity context;
    private List<ModelClass> bookingdetails;

    public AdapterClass(Activity context, List<ModelClass> bookingdetails) {
        super(context, R.layout.listlayout,bookingdetails);
        this.context=context;
        this.bookingdetails=bookingdetails;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater=context.getLayoutInflater();
        View view=layoutInflater.inflate(R.layout.listlayout,null,false);
        TextView txt_car = (TextView) view.findViewById(R.id.disp_car);
        TextView txt_baseFare = (TextView) view.findViewById(R.id.disp_basefare);
        TextView txt_extra = (TextView) view.findViewById(R.id.disp_extra);
        TextView txt_name = (TextView) view.findViewById(R.id.disp_cust);
        TextView txt_mob = (TextView) view.findViewById(R.id.disp_mob);
        TextView txt_purpose = (TextView) view.findViewById(R.id.disp_purpose);
        TextView txt_date = (TextView) view.findViewById(R.id.disp_date);
        TextView txt_time = (TextView) view.findViewById(R.id.disp_time);
        TextView txt_status = (TextView) view.findViewById(R.id.disp_status);

        ModelClass modelClass=bookingdetails.get(position);

        txt_car.setText(modelClass.getCar());
        txt_baseFare.setText(modelClass.getBaseFare());
        txt_extra.setText(modelClass.getExtra());
        txt_name.setText(modelClass.getName());
        txt_mob.setText(modelClass.getNo());
        txt_purpose.setText(modelClass.getPurpose());
        txt_date.setText(modelClass.getDate());
        txt_time.setText(modelClass.getTime());
        txt_status.setText(modelClass.getStatus());

        return view;



    }
}
