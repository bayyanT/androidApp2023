package com.example.pro2023.Activties;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.pro2023.R;
import com.example.pro2023.model.product;

import java.util.List;

public class SelectedItem extends AppCompatActivity {
    private TextView price;
    private  TextView selectedItemName;
    private ImageView img;
    private  TextView description;
   private  String name;
  private   String Price;
   private String ImgId;
   private String Info;
   private List<product> list;
   product[] pr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selected_item);
        setup();
        Intent intent =getIntent();
          name=intent.getStringExtra("name");
          Price=intent.getStringExtra("price");
          ImgId=intent.getStringExtra("img");
          Info=intent.getStringExtra("description");
        selectedItemName.setText(name);
        price.setText(Price);
        description.setText(Info);
        Glide.with(getApplicationContext()).load("http://10.0.2.2/pharmacy/SellRE/"+ImgId)
                .apply(new RequestOptions().override(200,200))
                .error(R.drawable.notfound)
                .into(img);





    }

    private void setup() {
//        price=findViewById(R.id.priceSe);
//        selectedItemName=findViewById(R.id.seletedName);
//        img=findViewById(R.id.selectedImgId);
//        description=findViewById(R.id.informationSeId);
    }

    public void btnAdd(View view) {
        Intent intent =new Intent(SelectedItem.this,orders.class);
        intent.putExtra("Name",name);
        intent.putExtra("Price",Price);
        intent.putExtra("img",ImgId);
        intent.putExtra("Info",Info);
        startActivity(intent);




    }
}