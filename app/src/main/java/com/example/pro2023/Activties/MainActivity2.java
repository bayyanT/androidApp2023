package com.example.pro2023.Activties;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.pro2023.Adapters.VitaminsAdapter;
import com.example.pro2023.Apis.RetrofitVitamins;
import com.example.pro2023.R;
import com.example.pro2023.model.category;
import com.example.pro2023.model.product;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity2 extends AppCompatActivity {
   private RecyclerView recyclerView ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        recyclerView=findViewById(R.id.vitiId);
        btnCall();



    }

    private void btnCall() {
        Call<List<product>> call= RetrofitVitamins.getInstance().getMyApi().getProducts();
        call.enqueue(new Callback<List<product>>() {
            @Override
            public void onResponse(Call<List<product>> call, Response<List<product>> response) {
                List<product>products=response.body();
                VitaminsAdapter adapter=new VitaminsAdapter(products,getApplicationContext());
                recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<List<product>> call, Throwable t) {

            }
        });
    }
}