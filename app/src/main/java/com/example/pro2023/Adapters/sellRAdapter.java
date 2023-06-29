package com.example.pro2023.Adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
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
import com.example.pro2023.Activties.SelectedItem;
import com.example.pro2023.R;
import com.example.pro2023.model.product;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class sellRAdapter extends RecyclerView.Adapter<sellRAdapter.ViewHolder> {
    private    List<product>products;
    private     Context context;
    private  onClickListener onClickListener;

    public sellRAdapter(List<product> products, Context context ) {
        this.products = products;
        this.context = context;
        this.onClickListener=onClickListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.mos_recumented_item,parent,false));
    }
    public  interface onClickListener{
       void onItemClick(product pro);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {
             if(holder==null){
                 return;
             }

        holder.name.setText(products.get(position).getName());
        holder.price.setText(products.get(position).getPrice());
        Glide.with(holder.itemView.getContext()).load("http://10.0.2.2/pharmacy/SellRE/"+products.get(position).getImgId())
                .apply(new RequestOptions().override(100,100))
                .error(R.drawable.notfound)
                .into(holder.img);
          holder. add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(), "add",Toast.LENGTH_LONG).show();
                Intent intent =new Intent(view.getContext(), SelectedItem.class);
                intent.putExtra("name",products.get(position).getName());
                intent.putExtra("price",products.get(position).getPrice());
                intent.putExtra("img",products.get(position).getImgId());
                intent.putExtra("description",products.get(position).getDescription());
                 view.getContext().startActivity(intent);
            }
        });


    }

    @Override
    public int getItemCount() {
        return products.size();
    }

    public  class  ViewHolder extends RecyclerView.ViewHolder {
       private ImageView img ;
       private TextView name;
       private   TextView price ;
       private   CircleImageView add;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
           img= itemView.findViewById(R.id.imgRecumntedId);
          name=  itemView.findViewById(R.id.mostRecumntedName);
          price = (TextView) itemView.findViewById(R.id.priceR);
          add=(CircleImageView)itemView.findViewById(R.id.shoppingRe);

        }
    }

}
