package com.example.pro2023.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pro2023.R;
import com.example.pro2023.model.category;

import java.util.List;

public class CatListAdapter extends RecyclerView.Adapter<CatListAdapter.CategoryListViewHolder> {
    private Context mCon;
    private category[]mListCategory;

    public CatListAdapter(Context mCon) {
        this.mCon = mCon;
    }
    public void setData(category [] cat){
        this.mListCategory=cat;

    }

    @NonNull
    @Override
    public CatListAdapter.CategoryListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CategoryListViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.category_item,parent,false));

    }

    @Override
    public void onBindViewHolder(@NonNull CatListAdapter.CategoryListViewHolder holder, int position) {
   category cat=mListCategory[position];
   if(cat==null){
       return;
   }







    }

    @Override
    public int getItemCount() {
        return mListCategory.length;
    }

    public class CategoryListViewHolder extends RecyclerView.ViewHolder {
        private  RecyclerView recyclerView;
        private TextView textView;
        public CategoryListViewHolder(@NonNull View itemView) {
            super(itemView);
            textView=itemView.findViewById(R.id.catNameId);
            recyclerView=itemView.findViewById(R.id.recCat);

        }
    }
}
