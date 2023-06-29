package com.example.pro2023.Adapters;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.pro2023.R;
import com.example.pro2023.model.product;
import java.util.List;

public class seromsAdapter extends ArrayAdapter<product> {

    private List<product> productList;
    private boolean flag = false ;

    //the context object
    private Context mCtx;

    public seromsAdapter(Context context, List<product> products){

        super(context, R.layout.list_item,products);
        this.productList = products;
        this.mCtx = context;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        //get products data at certain position using Product class
        product product = getItem(position);

        if(convertView == null){

            convertView = LayoutInflater.from(getContext()).inflate(R.layout.card_products,parent,false);
        }



        ImageView img = (ImageView) convertView.findViewById(R.id.vitaminsImgId);
        TextView name = (TextView) convertView.findViewById(R.id.productsVName);
        TextView price = (TextView) convertView.findViewById(R.id.priceVId);

        name.setText(productList.get(position).getName());
        price.setText(productList.get(position).getPrice());
        Glide.with(getContext()).load("http://10.0.2.2/pharmacy/seroms/"+productList.get(position).getImgId())
                .apply(new RequestOptions().override(90,90))
                .error(R.drawable.notfound)
                .into(img);



        return convertView;
    }
}
