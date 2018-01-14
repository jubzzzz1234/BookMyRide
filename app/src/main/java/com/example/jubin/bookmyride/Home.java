package com.example.jubin.bookmyride;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class Home extends Fragment {

    Button btn_economy;
    Button btn_premium;
    Button btn_luxury;


    public Home() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view=inflater.inflate(R.layout.fragment_home, container, false);
        btn_economy=(Button)view.findViewById(R.id.btn_economy);
        btn_premium=(Button)view.findViewById(R.id.btn_premium);
        btn_luxury=(Button)view.findViewById(R.id.btn_luxury);

        btn_economy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(),EconomyCars.class);
                startActivity(intent);
            }
        });

        btn_premium.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(),PremiumCars.class);
                startActivity(intent);
            }
        });

        btn_luxury.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(),LuxuryCars.class);
                startActivity(intent);

            }
        });

        return view;
    }

}
