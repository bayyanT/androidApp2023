package com.example.pro2023.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.pro2023.R;
import com.example.pro2023.model.category;
import com.example.pro2023.model.doctors;
import com.example.pro2023.model.product;

import java.util.List;

public class VitaminsAdapter extends RecyclerView.Adapter<VitaminsAdapter.ViewHolder> {
   private  List<product> products;
    private Context mCon;

    public VitaminsAdapter(List<product> products, Context mCon) {
        this.products = products;
        this.mCon = mCon;
    }
    public interface  onItemClick{
        void onItem(product productT);
    }

    @NonNull
    @Override
    public VitaminsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.card_products,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull VitaminsAdapter.ViewHolder holder, int position) {
        if(holder==null ){
            return ;
        }
        holder.vitaminName.setText(products.get(position).getName());
        holder.price.setText(products.get(position).getPrice());
        Glide.with(holder.itemView.getContext()).load("http://10.0.2.2/pharmacy/vitamins/" + products.get(position).getImgId())
                .apply(new RequestOptions().override(90, 90))
                .error(R.drawable.notfound)
                .into(holder.img);

        holder.add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(),"add",Toast.LENGTH_LONG).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return products.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView vitaminName;
        private ImageView img;
        private  TextView price;
        private  ImageView add;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            vitaminName=itemView.findViewById(R.id.productsVName);
            img=itemView.findViewById(R.id.vitaminsImgId);
            price=itemView.findViewById(R.id.priceVId);
            add=itemView.findViewById(R.id.addViId);


        }
    }
}
