package com.example.pro2023.Activties;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import com.example.pro2023.Adapters.SellAdapter;
import com.example.pro2023.R;
import com.example.pro2023.model.product;

import java.util.ArrayList;
import java.util.List;

public class orders extends AppCompatActivity {
    private  ListView orders;
    TextView editText;
    List<product>list;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
         super.onCreate(savedInstanceState);
         setContentView(R.layout.activity_orders);
         setup();





    }



    private void setup() {
        orders=findViewById(R.id.ordersID);
        editText=findViewById(R.id.edtTest);
        orders=findViewById(R.id.ordersID);
    }

}