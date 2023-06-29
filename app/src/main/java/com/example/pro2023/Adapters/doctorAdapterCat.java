package com.example.pro2023.Adapters;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pro2023.R;
import com.example.pro2023.model.doctors;

public class doctorAdapterCat extends RecyclerView.Adapter<doctorAdapterCat.ViewHolder> {
    @NonNull
    @Override
    public doctorAdapterCat.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }


    @Override
    public void onBindViewHolder(@NonNull doctorAdapterCat.ViewHolder holder, int position) {


    }
    public interface  onItemClick{
        void onItem(doctors doc);
    }

    @Override
    public int getItemCount() {
        return 0;
    }
    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView name;
        private ImageView img;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.categoryNameId);
        }
    }
}
