package com.example.petshopproject.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.petshopproject.R;
import com.example.petshopproject.interfaces.OnProductItemClick;
import com.example.petshopproject.models.Product;

import java.util.ArrayList;

public class ProductAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private ArrayList<Product> products;
    private OnProductItemClick onProductItemClick;

    public ProductAdapter(ArrayList<Product> productList, OnProductItemClick onProductItemClick) {
        this.products = productList;
        this.onProductItemClick = onProductItemClick;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.product_cell, parent, false);
        ProductViewHolder productViewHolder = new ProductViewHolder(view);
        return productViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Product product = (Product)products.get(position);
        ((ProductViewHolder) holder).bind(product);
    }

    @Override
    public int getItemCount() {
        return this.products.size();
    }

    class ProductViewHolder extends RecyclerView.ViewHolder {
        private TextView name;
        private TextView price;
        private View view;

        ProductViewHolder(View view) {
            super(view);
            name = view.findViewById(R.id.product_name);
            price = view.findViewById(R.id.product_price);
            this.view = view;
        }

        void bind(Product product) {
            name.setText(product.getName());
            String priceString = product.getPrice() + " Pesos MX";
            price.setText(priceString);
            view.setOnClickListener(v -> onProductItemClick.onClick(product));
        }
    }
}
