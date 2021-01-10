package com.gmail.sauravarv.alertdialog;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
{
    Button btnName, btnNumber, btnBalance;
    TextView name, accountNumber, accountBalance;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = (TextView) findViewById(R.id.name);
        accountNumber = (TextView) findViewById(R.id.accountNumber);
        accountBalance = (TextView) findViewById(R.id.accountBalance);
        btnName = (Button) findViewById(R.id.btnName);
        btnNumber = (Button) findViewById(R.id.btnNumber);
        btnBalance = (Button) findViewById(R.id.btnBalance);

        btnName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                View v = LayoutInflater.from(MainActivity.this).inflate(R.layout.activity_custom_alert_dialog, null);

                EditText userName = v.findViewById(R.id.userName);
                EditText password = v.findViewById(R.id.password);

                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setMessage("Login here!").
                        setView(v).
                        setPositiveButton("Login", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i)
                            {
                                String n = userName.getText().toString();
                                String pass = password.getText().toString();
                                if(n.equals("saurav") && pass.equals("1234"))
                                    name.setText("Saurav Kumar");
                                else
                                    name.setText("Invalid Credentials!");
                            }
                        }).
                        setNegativeButton("Cancel", null).setCancelable(false);
                AlertDialog alert = builder.create();
                alert.show();
            }
        });

        btnNumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { accountNumber.setText("4256310");
            }
        });

        btnBalance.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setMessage("Are you sure?").setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        accountBalance.setText("5000");
                    }
                }).setNegativeButton("Cancel",null);
                AlertDialog alert = builder.create();
                alert.show();
            }
        }));
    }
    @Override
    public void onBackPressed()
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setMessage("Really Exit?").setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i)
            {
                MainActivity.super.onBackPressed();
            }
        }).setNegativeButton("Cancel", null);
        AlertDialog alert = builder.create();
        alert.show();

    }
}