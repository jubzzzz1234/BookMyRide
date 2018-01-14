package com.example.jubin.bookmyride;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.jubin.bookmyride.databinding.ActivityLuxuryCarsBinding;

public class LuxuryCars extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final ActivityLuxuryCarsBinding binding= DataBindingUtil.setContentView(this,R.layout.activity_luxury_cars);

        binding.btnAudi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String model=binding.txtAudi1.getText().toString();
                String baseFare=binding.txtAudi2.getText().toString();
                String extra=binding.txtAudi3.getText().toString();

                Intent intent=new Intent(LuxuryCars.this,Booking.class);
                intent.putExtra("model",model);
                intent.putExtra("base",baseFare);
                intent.putExtra("extra",extra);
                startActivity(intent);
            }
        });

        binding.btnBmw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String model=binding.txtBmw1.getText().toString();
                String baseFare=binding.txtBmw2.getText().toString();
                String extra=binding.txtBmw3.getText().toString();

                Intent intent=new Intent(LuxuryCars.this,Booking.class);
                intent.putExtra("model",model);
                intent.putExtra("base",baseFare);
                intent.putExtra("extra",extra);
                startActivity(intent);

            }
        });
    }
}
