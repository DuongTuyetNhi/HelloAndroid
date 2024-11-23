package com.example.helloandroid;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class ListProductActivity extends Activity implements OnProductClickListener {
    ListView lvProduct;
    ProductAdapter mAdapter;
    ArrayList<Product> listProducts=new ArrayList<>();
    EditText edtName, edtPrice;
    Button btnAdd, btnView;
    MyDatabaseHelper myDatabaseHelper;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_listview);

        //-----------------
        edtName = (EditText)findViewById(R.id.edt_name);
        edtPrice = (EditText)findViewById(R.id.edt_price);
        btnAdd = (Button)findViewById(R.id.btn_add) ;
        btnView = (Button)findViewById(R.id.btn_view) ;

        myDatabaseHelper = new MyDatabaseHelper(this);
        //------------------

        //setProducts();



        lvProduct = (ListView) findViewById(R.id.lv_products);
        mAdapter = new ProductAdapter(this, listProducts, this);
        lvProduct.setAdapter(mAdapter);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Product p = new Product(edtName.getText().toString(), Float.parseFloat(edtPrice.getText().toString()),0);
                myDatabaseHelper.insertProduct(p);
            }
        });

        btnView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ArrayList<Product> listProduct= myDatabaseHelper.getlistProducts();
                listProducts.clear();
                listProducts.addAll(listProduct);
                mAdapter.notifyDataSetChanged();
                if(listProduct.size()>0)
                    for(int i=0;i<listProduct.size();i++)
                        Log.d("PRoduct",listProduct.get(i).getProductName());

            }
        });
    }





    public void setProducts(){
        listProducts.add(new Product("Dell",200000000,R.drawable.ic_launcher_foreground));
        listProducts.add(new Product("HP",200000000,R.drawable.edittext_border));
        listProducts.add(new Product("Macbook",200000000,R.drawable.ic_launcher_background));
        listProducts.add(new Product("Sony",200000000,R.drawable.ic_launcher_foreground));
        listProducts.add(new Product("LG gram",200000000,R.drawable.ic_launcher_foreground));
        listProducts.add(new Product("Asus",200000000,R.drawable.ic_launcher_background));
        listProducts.add(new Product("accer",200000000,R.drawable.ic_launcher_foreground));
        listProducts.add(new Product("Lenovo",200000000,R.drawable.edittext_border));
        listProducts.add(new Product("Surface",200000000,R.drawable.ic_launcher_background));
        listProducts.add(new Product("Dell",200000000,R.drawable.ic_launcher_foreground));
    }

    @Override
    public void onProductClick(String productName) {
        Toast.makeText(this,"Product "+productName, Toast.LENGTH_SHORT).show();;
    }
}
