package com.example.jubin.bookmyride;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.jubin.bookmyride.databinding.ActivityPremiumCarsBinding;

public class PremiumCars extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final ActivityPremiumCarsBinding binding= DataBindingUtil.setContentView(this,R.layout.activity_premium_cars);

        binding.btnAltis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String model=binding.txtAltis1.getText().toString();
                String baseFare=binding.txtAltis2.getText().toString();
                String extra=binding.txtAltis3.getText().toString();

                Intent intent=new Intent(PremiumCars.this,Booking.class);
                intent.putExtra("model",model);
                intent.putExtra("base",baseFare);
                intent.putExtra("extra",extra);
                startActivity(intent);
            }
        });

        binding.btnFortuner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String model=binding.txtFortuner1.getText().toString();
                String baseFare=binding.txtFortuner2.getText().toString();
                String extra=binding.txtFortuner3.getText().toString();

                Intent intent=new Intent(PremiumCars.this,Booking.class);
                intent.putExtra("model",model);
                intent.putExtra("base",baseFare);
                intent.putExtra("extra",extra);
                startActivity(intent);

            }
        });
    }
}
