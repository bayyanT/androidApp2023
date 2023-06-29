package com.example.pro2023.Adapters;

import static java.security.AccessController.getContext;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.pro2023.Activties.Vitamins;
import com.example.pro2023.R;
import com.example.pro2023.model.category;

import java.util.List;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.ViewHolder> {
    private List<category> categories;
    category cat;
    private boolean flag = false ;
    itemClickListener itemClickListener;

    //the context object
   private Context context;



    public CategoryAdapter(List<category> categories, Context context ,itemClickListener itemClickListener) {
        this.categories = categories;
        this.itemClickListener=itemClickListener;
        this.context=context;

    }

    @NonNull
    @Override
    public CategoryAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.category_item,parent,false));
    }



    @Override
    public int getItemCount() {
        return categories.size();
    }
    public interface  itemClickListener{
        void onItemClick(category cat);
    }
    @Override
    public void onBindViewHolder(@NonNull CategoryAdapter.ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        if(holder==null){
            return ;
        }
        holder.name.setText(categories.get(position).getNameCategory());
        Glide.with(holder.itemView.getContext()).load("http://10.0.2.2/pharmacy/cat/" + categories.get(position).getImgId())
                .apply(new RequestOptions().override(90, 90))
                .error(R.drawable.notfound)
                .into(holder.img);
        holder.itemView.setOnClickListener(view->{
            itemClickListener.onItemClick(categories.get(position));

        });




    }

    public class ViewHolder extends RecyclerView.ViewHolder {
         TextView name;
         ImageView img;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
              img = (ImageView) itemView.findViewById(R.id.categoryListId);
             name = (TextView) itemView.findViewById(R.id.categoryNameId);
        }
    }

}
