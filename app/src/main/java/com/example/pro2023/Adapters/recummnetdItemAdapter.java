package com.example.pro2023.Adapters;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pro2023.R;
import com.example.pro2023.model.itemR;

public class recummnetdItemAdapter extends RecyclerView.Adapter<recummnetdItemAdapter.RecummentedViewHolder> {
     itemR [] recummented;

    public recummnetdItemAdapter(itemR[] recummented) {
        this.recummented = recummented;
    }

    @NonNull
    @Override
    public recummnetdItemAdapter.RecummentedViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new RecummentedViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.mos_recumented_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull recummnetdItemAdapter.RecummentedViewHolder holder, int position) {

        holder.name.setText(recummented[position].getName());
        holder.img.setImageResource(recummented[position].getImgId());
        holder.price.setText(recummented[position].getPrice());
        holder.add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(),"add",Toast.LENGTH_LONG).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return recummented.length;
    }
    public class RecummentedViewHolder extends RecyclerView.ViewHolder {
        private TextView name;
        private ImageView img;
        private TextView price;
        private  ImageView add ;

        public RecummentedViewHolder(@NonNull View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.mostRecumntedName);
            img=itemView.findViewById(R.id.imgRecumntedId);
            price=itemView.findViewById(R.id.priceR);
            add=itemView.findViewById(R.id.shoppingRe);
        }
    }

}
