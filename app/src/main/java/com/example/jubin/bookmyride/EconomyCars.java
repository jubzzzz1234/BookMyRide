package com.example.jubin.bookmyride;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.jubin.bookmyride.databinding.ActivityEconomyCarsBinding;

public class EconomyCars extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final ActivityEconomyCarsBinding binding= DataBindingUtil.setContentView(this,R.layout.activity_economy_cars);

        binding.btnIndica.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String model=binding.txtIndica1.getText().toString();
                String baseFare=binding.txtIndica2.getText().toString();
                String extra=binding.txtIndica3.getText().toString();

                Intent intent=new Intent(EconomyCars.this,Booking.class);
                intent.putExtra("model",model);
                intent.putExtra("base",baseFare);
                intent.putExtra("extra",extra);
                startActivity(intent);



            }
        });


        binding.btnFord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String model=binding.txtFord1.getText().toString();
                String baseFare=binding.txtFord2.getText().toString();
                String extra=binding.txtFord3.getText().toString();

                Intent intent=new Intent(EconomyCars.this,Booking.class);
                intent.putExtra("model",model);
                intent.putExtra("base",baseFare);
                intent.putExtra("extra",extra);
                startActivity(intent);

            }
        });

    }
}
