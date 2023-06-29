package com.example.pro2023.Activties;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import java.util.List;

import android.widget.Toast;

import com.example.pro2023.Adapters.AdapterDoctorsCategory;
import com.example.pro2023.Adapters.CategoryAdapter;
import com.example.pro2023.Adapters.recummnetdItemAdapter;
import com.example.pro2023.Adapters.sellRAdapter;
import com.example.pro2023.Apis.RetrofitCategory;
import com.example.pro2023.Apis.RetrofitDoctors;
import com.example.pro2023.Apis.RetrofitSellR;
import com.example.pro2023.R;
import com.example.pro2023.model.category;
import com.example.pro2023.model.doctors;
import com.example.pro2023.model.product;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

   private RecyclerView catRecyclerView;
   private  RecyclerView doctorsCategoryRe;
    private RecyclerView listView;
   FragmentTransaction fragmentTransaction;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        catRecyclerView=findViewById(R.id.recCat);
        doctorsCategoryRe=findViewById(R.id.doctorsList);
        listView=findViewById(R.id.RList);

        Call<List<category>>call= RetrofitCategory.getInstance().getMyApi().getCategory();
        call.enqueue(new Callback<List<category>>() {
            @Override
            public void onResponse(Call<List<category>> call, Response<List<category>> response) {
             //   Toast.makeText(MainActivity.this,"corrected process", Toast.LENGTH_LONG).show();
                List<category>categoryList=response.body();

                CategoryAdapter adapter =new CategoryAdapter(categoryList, getApplicationContext(), new CategoryAdapter.itemClickListener() {
                    @Override
                    public void onItemClick(category cat) {
                        if(cat.getNameCategory().equals(null)){
                            Toast.makeText(MainActivity.this, "error", Toast.LENGTH_SHORT).show();
                        }else if(cat.getNameCategory().equals("Vitamins")){

                            Toast.makeText(MainActivity.this, "e"+cat.getNameCategory(), Toast.LENGTH_SHORT).show();
                             startActivity(new Intent(MainActivity.this,MainActivity2.class));

                        }else if(cat.getNameCategory().equals("antibiotics")){
                            startActivity(new Intent(MainActivity.this,MainActivity3.class));

                        }else if(cat.getNameCategory().equals("serums")){
                            startActivity(new Intent(MainActivity.this,serums.class));

                        }else if(cat.getNameCategory().equals("Analgesic")){
                            startActivity(new Intent(MainActivity.this,Analgesic.class));


                        }else if(cat.getNameCategory().equals("creams")){
                            startActivity(new Intent(MainActivity.this,creams.class));
                        }
                     }
                });
                catRecyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(),RecyclerView.HORIZONTAL,false));
                catRecyclerView.setAdapter(adapter);

            }

            @Override
            public void onFailure(Call<List<category>> call, Throwable t) {
                Toast.makeText(MainActivity.this,t.getMessage(), Toast.LENGTH_LONG).show();
                Log.d("Retrofit ERROR --->",t.getMessage());

            }
        });
        // doctors API
        Call<List<doctors>>call1= RetrofitDoctors.getInstance().getMyApi().getDoctorsCategory();
        call1.enqueue(new Callback<List<doctors>>() {
            @Override
            public void onResponse(Call<List<doctors>> call, Response<List<doctors>> response) {
                List<doctors>list=response.body();
                Toast.makeText(MainActivity.this,"corrected process", Toast.LENGTH_LONG).show();
                AdapterDoctorsCategory adapter2=new AdapterDoctorsCategory(list, getApplicationContext(), new AdapterDoctorsCategory.onItemClick() {
                    @Override
                    public void onItem(doctors doc) {
                        Toast.makeText(getApplicationContext(),"done",Toast.LENGTH_SHORT).show();
                        Intent intent =new Intent(MainActivity.this,doctorsDetiels.class);
                        intent.putExtra("Email",doc.getEmail());
                        intent.putExtra("Phone",doc.getPhone());
                        intent.putExtra("Name",doc.getName());
                        intent.putExtra("imgId",doc.getImgId());
                        Toast.makeText(getApplicationContext(),doc.getImgId(),Toast.LENGTH_SHORT).show();
                        startActivity(intent);

                    }
                });
                doctorsCategoryRe.setLayoutManager(new LinearLayoutManager(getApplicationContext(),RecyclerView.HORIZONTAL,false));
                doctorsCategoryRe.setAdapter(adapter2);

            }

            @Override
            public void onFailure(Call<List<doctors>> call, Throwable t) {

            }
        });

        Call<List<product>>call2= RetrofitSellR.getInstance().getMyApi().getSells();
        call2.enqueue(new Callback<List<product>>() {
            @Override
            public void onResponse(Call<List<product>> call, Response<List<product>> response) {
                List<product>list=response.body();
                sellRAdapter adapter =new sellRAdapter(list,getApplicationContext());
                listView.setLayoutManager(new LinearLayoutManager(getApplicationContext(),RecyclerView.HORIZONTAL,false));
                listView.setAdapter(adapter);

            }

            @Override
            public void onFailure(Call<List<product>> call, Throwable t) {

            }
        });














    }
}