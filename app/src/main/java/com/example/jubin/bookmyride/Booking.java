package com.example.jubin.bookmyride;

import android.content.Intent;
import android.database.DatabaseUtils;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.jubin.bookmyride.databinding.ActivityBookingBinding;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;

public class Booking extends AppCompatActivity {

    String model,base,extra;
    List<ModelClass> modelClass;
    Realm realm;
    String car,fare1,fare2,name,mob,purpose,date,time,status;

    String[] category={"Family Tour","Wedding","Business Trip","Personal Use","Others"};

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final ActivityBookingBinding binding= DataBindingUtil.setContentView(this,R.layout.activity_booking);

        Realm.init(this);
        realm=Realm.getDefaultInstance();
        modelClass=new ArrayList<>();

        Intent intent=getIntent();
        model=intent.getStringExtra("model");
        base=intent.getStringExtra("base");
        extra=intent.getStringExtra("extra");

        binding.txtC1.setText(model);
        binding.txtC2.setText(base);
        binding.txtC3.setText(extra);

        binding.edtStatus.setVisibility(View.INVISIBLE);

        binding.spinnerCategory.setPrompt("Select Category");

        ArrayAdapter aa = new ArrayAdapter(this,android.R.layout.simple_spinner_item,category);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        binding.spinnerCategory.setAdapter(aa);

       binding.spinnerCategory.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
           @Override
           public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

           }

           @Override
           public void onNothingSelected(AdapterView<?> parent) {

           }
       });

        binding.btnDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                car=binding.txtC1.getText().toString();
                fare1=binding.txtC2.getText().toString();
                fare2=binding.txtC3.getText().toString();
                name=binding.edtCust.getText().toString();
                mob=binding.edtCustMob.getText().toString();
                purpose=binding.spinnerCategory.getSelectedItem().toString();
                date=binding.edtDate.getText().toString();
                time=binding.edtTime.getText().toString();
                status=binding.edtStatus.getText().toString();
                if(name.equals("")||mob.equals("")||date.equals("")||time.equals(""))
                {
                    Toast.makeText(Booking.this, "Fill all feilds", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    realm.beginTransaction();
                    RealmClass realmClass=realm.createObject(RealmClass.class);
                    realmClass.setCar(car);
                    realmClass.setBaseFare(fare1);
                    realmClass.setExtra(fare2);
                    realmClass.setName(name);
                    realmClass.setNo(mob);
                    realmClass.setPurpose(purpose);
                    realmClass.setDate(date);
                    realmClass.setTime(time);
                    realmClass.setStatus(status);
                    realm.commitTransaction();

                    Toast.makeText(Booking.this, "Booking Successful", Toast.LENGTH_SHORT).show();
                    Intent intent=new Intent(Booking.this,MainActivity.class);
                    startActivity(intent);
                }


            }
        });

    }
}
