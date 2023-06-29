package com.example.pro2023.Activties;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.pro2023.R;

public class baseActivity extends AppCompatActivity implements View.OnClickListener{
    Button Employee;
    Button Customer;
    Button Location;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
        Employee=findViewById(R.id.toEmployee);
        Customer=findViewById(R.id.toCustomer);
        Location=findViewById(R.id.Location);
        Employee.setOnClickListener(this);
        Customer.setOnClickListener(this)
        ;
        Location.setOnClickListener(this);


    }



    @Override
    public void onClick(View view) {
        if(view ==Employee){
            Intent intent=new Intent(baseActivity.this,SignInEmployee.class);
            startActivity(intent);

        }else if(view ==Customer){
            Intent intent=new Intent(baseActivity.this, SiginInUser.class);
            startActivity(intent);
        }else if(view ==Location){
            Toast.makeText(getApplicationContext(),"Location",Toast.LENGTH_LONG).show();
        }

    }
}