package com.example.helloandroid;

import static android.content.Intent.getIntent;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ProfileActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_main);

        TextView textViewProfile = findViewById(R.id.hello);
        String userName = "Hello, "+ getIntent().getStringExtra("txtEmail");
        textViewProfile.setText(userName);
    }

    public void onClose(View view){
         finish();
    }

}
