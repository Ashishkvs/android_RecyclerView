package com.imagegrafia.recyclerviewdemo;

import android.content.Context;

import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;


import java.util.List;

/**
 * Created by Ashish on 3/1/2018.
 */

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ProductViewHolder> {

    //to get List of product while creating object only create Constructor

    private Context context;
    private List<Product> productList;


    public CustomAdapter(Context context, List<Product> productList) {
        this.context = context;
        this.productList = productList;

    }

    @Override
    public ProductViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.product_layout, null);

        //create viewHolder obj and pass it to it
        ProductViewHolder productViewHolder = new ProductViewHolder(view);
        return productViewHolder;
    }

    @Override
    public void onBindViewHolder(ProductViewHolder holder, int position) {
        final Product product = productList.get(position);
        holder.productName.setText(product.getName());
        holder.productPrice.setText(String.valueOf(product.getPrice()));
        holder.productImage.setImageResource(Integer.parseInt(String.valueOf(product.getImage())));
        holder.constraintLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context,"You clicked "+product.getName(),Toast.LENGTH_SHORT).show();
            }
        });


    }

    @Override
    public int getItemCount() {
        return productList.size();
    }

    //INTERNAL CLASS implemented first
    public class ProductViewHolder extends RecyclerView.ViewHolder {
        private TextView productName;
        private TextView productPrice;
        private ImageView productImage;
        private ConstraintLayout constraintLayout;

        public ProductViewHolder(View itemView) {
            super(itemView);
            productName = itemView.findViewById(R.id.productName);
            productPrice = itemView.findViewById(R.id.productPrice);
            productImage = itemView.findViewById(R.id.productImage);
            constraintLayout=itemView.findViewById(R.id.constraint_layout);

        }
    }
}
