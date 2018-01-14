package com.example.jubin.bookmyride;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.DatabaseUtils;
import android.databinding.DataBindingUtil;
import android.support.v4.database.DatabaseUtilsCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.jubin.bookmyride.databinding.ActivityLoginBinding;

public class Login extends AppCompatActivity {

    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //databinding
        final ActivityLoginBinding databinding= DataBindingUtil.setContentView(this,R.layout.activity_login);

        sharedPreferences=getSharedPreferences("Login", Context.MODE_PRIVATE);

        if(sharedPreferences.getBoolean("loggedin",false)==true)
        {
            Intent intent=new Intent(Login.this,MainActivity.class);
            startActivity(intent);
        }

        databinding.loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name=sharedPreferences.getString("username","");
                String password=sharedPreferences.getString("password","");

                if(name.equals(databinding.loginUsername.getText().toString())&&password.equals(databinding.loginPassword.getText().toString()))

                {
                    SharedPreferences.Editor editor=sharedPreferences.edit();
                    editor.putBoolean("loggedin",true);
                    editor.commit();
                    Intent intent=new Intent(Login.this,MainActivity.class);
                    startActivity(intent);
                }
                else
                    Toast.makeText(Login.this, "Wrong credentials", Toast.LENGTH_SHORT).show();
            }
        });

        databinding.txtGotoReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Login.this,Register.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(this).setIcon(android.R.drawable.ic_dialog_alert).setTitle("Exit")
                .setMessage("Do you want to exit ?")
                .setPositiveButton("yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        Intent intent = new Intent(Intent.ACTION_MAIN);
                        intent.addCategory(Intent.CATEGORY_HOME);
                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        startActivity(intent);
                        finish();
                    }
                }).setNegativeButton("no", null).show();
    }
}
