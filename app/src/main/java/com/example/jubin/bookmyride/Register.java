package com.example.jubin.bookmyride;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.jubin.bookmyride.databinding.ActivityRegisterBinding;

public class Register extends AppCompatActivity {

    SharedPreferences sharedPreferences;
    String username,password,confirm;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //using databinding
        final ActivityRegisterBinding databinding=DataBindingUtil.setContentView(this,R.layout.activity_register);

        sharedPreferences=getSharedPreferences("Login", Context.MODE_PRIVATE);

        databinding.regButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                username = databinding.regUsername.getText().toString();

                if (databinding.regPassword.getText().toString().length() < 6)//validation

                {
                    databinding.regPassword.setError("Password should not be less than 6 character");
                } else {
                    password = databinding.regPassword.getText().toString();
                    confirm = databinding.regConfirm.getText().toString();

                    if (username.equals("") || password.equals("")) {
                        Toast.makeText(Register.this, "Enter all fields", Toast.LENGTH_SHORT).show();
                    } else if (password.equals(confirm)) {
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.putString("username", username);
                        editor.putString("password", password);
                        editor.putBoolean("loggedin", false);
                        editor.commit();
                        Intent intent = new Intent(Register.this, Login.class);
                        startActivity(intent);

                    } else {

                        Toast.makeText(Register.this, "Passwords did not match", Toast.LENGTH_SHORT).show();

                    }

                }
            }
        });

        databinding.txtGotoLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Register.this, Login.class);
                startActivity(intent);
            }
        });

    }
}
