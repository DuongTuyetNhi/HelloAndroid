package com.example.helloandroid;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class MyDatabaseHelper extends SQLiteOpenHelper {
    String database="products.db";
    String createTableProduct="create table Product(productname TEXT, productprice REAL, productimage integer)";
    String deleteTable="Drop table if exists Product";

    public MyDatabaseHelper(@Nullable Context context ) {
        super(context, "products.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(createTableProduct);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL(deleteTable);
        onCreate(sqLiteDatabase);
    }

    public void insertProduct(Product p){
        ContentValues values = new ContentValues();
        values.put("productname",p.getProductName());
        values.put("productprice",p.getProductPrice());
        values.put("productimage",p.getImage());
        SQLiteDatabase db= getWritableDatabase();
        db.insert("Product",null, values);
    }

    public ArrayList<Product> getlistProducts(){
        ArrayList<Product> arrayList = new ArrayList<>();
        SQLiteDatabase db= getReadableDatabase();
        String sql="select * from Product";
        Cursor cursor = db.rawQuery(sql,null);
        while (cursor.moveToNext()){
            Product p = new Product();
            p.setProductName(cursor.getString(cursor.getColumnIndexOrThrow("productname")));
            p.setProductPrice(cursor.getFloat(cursor.getColumnIndexOrThrow("productprice")));
            p.setImage(cursor.getInt(cursor.getColumnIndexOrThrow("productimage")));
            arrayList.add(p);
        }
        return arrayList;
    }
}
