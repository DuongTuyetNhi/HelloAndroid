package com.example.helloandroid;

import static android.content.Intent.getIntent;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ProfileActivity extends Activity {
    SharedPreferences pref;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_main);

        TextView textViewProfile = findViewById(R.id.hello);
        String userName = "Hello, "+ getIntent().getStringExtra("txtEmail");
        textViewProfile.setText(userName);

        pref = getApplicationContext().getSharedPreferences("MyPref", Context.MODE_PRIVATE);

        String user = pref.getString("username", "");
        if (!user.equals("")) textViewProfile.setText(user);
        else textViewProfile.setText(userName);
    }

    public void onClose(View view){
        editor=pref.edit();
        editor.remove("username");
        editor.commit();

         finish();
    }

}
