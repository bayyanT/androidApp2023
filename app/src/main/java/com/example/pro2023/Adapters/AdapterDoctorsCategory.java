package com.example.pro2023.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.pro2023.R;
import com.example.pro2023.model.category;
import com.example.pro2023.model.doctors;

import java.util.List;

public class AdapterDoctorsCategory extends RecyclerView.Adapter<AdapterDoctorsCategory.ViewHolderDoctors> {
    private List<doctors>doctors;
    onItemClick itemClick;
    private Context context;

    public AdapterDoctorsCategory(List<doctors> categories, Context context ,onItemClick itemClick) {
        this.doctors = categories;
        this.context = context;
        this.itemClick=itemClick;

    }
    public interface  onItemClick{
        void onItem(doctors doc);
    }

    @NonNull
    @Override
    public AdapterDoctorsCategory.ViewHolderDoctors onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolderDoctors(LayoutInflater.from(parent.getContext()).inflate(R.layout.category_item,parent,false));

    }


    @Override
    public void onBindViewHolder(@NonNull AdapterDoctorsCategory.ViewHolderDoctors holder, int position) {
        if(holder==null){
            return;
        }
        holder.name.setText(doctors.get(position).getName());
        Glide.with(holder.itemView.getContext()).load("http://10.0.2.2/pharmacy/doctors/" + doctors.get(position).getImgId())
                .apply(new RequestOptions().override(90, 90))
                .error(R.drawable.notfound)
                .into(holder.img);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //  itemClickListener.onItemClick(categories.get(position));
                itemClick.onItem(doctors.get(position));

            }
        });

    }

    @Override
    public int getItemCount() {

        return doctors.size();
    }

    public class ViewHolderDoctors extends RecyclerView.ViewHolder {
         private TextView name;
         private ImageView img;
        public ViewHolderDoctors(@NonNull View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.categoryNameId);
            img=itemView.findViewById(R.id.categoryListId);
        }
    }
}
