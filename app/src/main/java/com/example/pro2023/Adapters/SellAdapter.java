package com.example.pro2023.Adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.pro2023.Activties.SelectedItem;
import com.example.pro2023.R;
import com.example.pro2023.model.product;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class SellAdapter extends ArrayAdapter<product> {
    private List<product> products;
    private Context context;



    public SellAdapter(List<product> products, Context context) {
        super(context,R.layout.card_orders,products);
        this.products = products;
        this.context = context;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        //get products data at certain position using Product class
        product product = getItem(position);

        if(convertView == null){

            convertView = LayoutInflater.from(getContext()).inflate(R.layout.card_products,parent,false);
        }



        ImageView img = (ImageView) convertView.findViewById(R.id.orderImgAdd);
        TextView name = (TextView) convertView.findViewById(R.id.productIdOrders);
        TextView price = (TextView) convertView.findViewById(R.id.productsIdPriceOrders);


        name.setText(products.get(position).getName());
        price.setText(products.get(position).getPrice());
        Glide.with(getContext()).load("http://10.0.2.2/pharmacy/SellRE/"+products.get(position).getImgId())
                .apply(new RequestOptions().override(90,90))
                .error(R.drawable.notfound)
                .into(img);




        return convertView;


    }
}