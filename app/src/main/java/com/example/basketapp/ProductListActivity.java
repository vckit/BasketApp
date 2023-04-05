package com.example.basketapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ProductListActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ArrayList<Product> products;
    private CartManager cartManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_list);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        products = generateTestData();
        cartManager = CartManager.getInstance();


        recyclerView.setAdapter(new ProductAdapter(products, this, cartManager));

        Button viewCartButton = findViewById(R.id.view_cart_button);
        viewCartButton.setOnClickListener(v -> {
            Intent intent = new Intent(this, CartActivity.class);
            startActivity(intent);
        });
    }

    private ArrayList<Product> generateTestData() {
        ArrayList<Product> products = new ArrayList<>();

        products.add(new Product(1, "Телефон 1", "Описание телефона 1", 10000, R.drawable.phone1));
        products.add(new Product(2, "Телефон 2", "Описание телефона 2", 12000, R.drawable.phone2));
        products.add(new Product(3, "Телефон 4", "Описание телефона 4", 16000, R.drawable.phone3));
        products.add(new Product(4, "Телефон 5", "Описание телефона 5", 18000, R.drawable.phone4));

        return products;
    }
}

