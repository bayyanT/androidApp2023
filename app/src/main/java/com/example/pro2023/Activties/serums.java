package com.example.pro2023.Activties;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.ListView;

import com.example.pro2023.Adapters.seromsAdapter;
import com.example.pro2023.Apis.RetrofitCategory;
import com.example.pro2023.Apis.RetrofitSerums;
import com.example.pro2023.R;
import com.example.pro2023.model.product;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class serums extends AppCompatActivity {
   private ListView listView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_serums);
        listView=findViewById(R.id.seromListId);

       Call< List<product>>call= RetrofitSerums.getInstance().getMyApi().getSerum();
       call.enqueue(new Callback<List<product>>() {
           @Override
           public void onResponse(Call<List<product>> call, Response<List<product>> response) {
           List<product>list=response.body();
           seromsAdapter adapter =new seromsAdapter(getApplicationContext(),list);
           listView.setAdapter(adapter);
           }

           @Override
           public void onFailure(Call<List<product>> call, Throwable t) {


           }
       });



    }
}