package com.example.petshopproject.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.petshopproject.R;
import com.example.petshopproject.interfaces.OnOrderItemClick;
import com.example.petshopproject.models.Order;

import java.util.ArrayList;
import java.util.List;

public class OrderAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<Order> orders = new ArrayList<Order>();
    private OnOrderItemClick onOrderItemClick;

    public OrderAdapter(List<Order> orderList, OnOrderItemClick onOrderItemClick) {
        this.orders = orderList;
        this.onOrderItemClick = onOrderItemClick;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.order_cell, parent, false);
        OrderAdapter.OrderViewHolder orderViewHolder = new OrderAdapter.OrderViewHolder(view);
        return orderViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Order order = (Order)orders.get(position);
        ((OrderViewHolder) holder).bind(order);
    }

    @Override
    public int getItemCount() {
        return this.orders.size();
    }

    class OrderViewHolder extends RecyclerView.ViewHolder {
        private TextView name;
        private TextView price;
        private View view;

        OrderViewHolder(View view) {
            super(view);
            name = view.findViewById(R.id.order_name);
            price = view.findViewById(R.id.order_price);
            this.view = view;
        }

        void bind(Order order) {
            String orderName = String.valueOf(order.getCount()) + " x " + order.getProduct().getName();
            name.setText(orderName);
            String priceString = String.valueOf(order.getCount() * order.getProduct().getPrice()) + " RON";
            price.setText(priceString);
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onOrderItemClick.onClick(order);
                }
            });
        }
    }
}
