package com.imagegrafia.recyclerviewdemo;

import android.content.Context;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.ImageView;
import android.widget.TextView;


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
        Product product = productList.get(position);
        holder.productName.setText(product.getName());
        holder.productPrice.setText(String.valueOf(product.getPrice()));
        holder.productImage.setImageResource(Integer.parseInt(String.valueOf(product.getImage())));


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

        public ProductViewHolder(View itemView) {
            super(itemView);
            productName = itemView.findViewById(R.id.productName);
            productPrice = itemView.findViewById(R.id.productPrice);
            productImage = itemView.findViewById(R.id.productImage);

        }
    }
}
