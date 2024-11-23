package com.example.helloandroid;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class MainScreenActivity extends Activity {
//    private TextView display;
//    private String currentInput = "";
//    private String operator = "";
//    private double a = 0;
//    @Override
//    protected void onCreate(@Nullable Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.layout_calculator);
//
//        display = findViewById(R.id.txt_ketqua);
//
//        int[] numberButtonIds = {
//                R.id.btn_0, R.id.btn_1, R.id.btn_2, R.id.btn_3,
//                R.id.btn_4, R.id.btn_5, R.id.btn_6, R.id.btn_7,
//                R.id.btn_8, R.id.btn_9
//        };
//
//        for (int id : numberButtonIds) {
//            findViewById(id).setOnClickListener(this::onNumberClick);
//        }
//
//        findViewById(R.id.btn_cong).setOnClickListener(this::onOperatorClick);
//        findViewById(R.id.btn_tru).setOnClickListener(this::onOperatorClick);
//        findViewById(R.id.btn_nhan).setOnClickListener(this::onOperatorClick);
//        findViewById(R.id.btn_chia).setOnClickListener(this::onOperatorClick);
//
//        findViewById(R.id.btn_bang).setOnClickListener(this::onEqualsClick);
//        findViewById(R.id.btn_ac).setOnClickListener(this::onAcClick);
//    }
//
//    private void onNumberClick(View view) {
//        Button button = (Button) view;
//        currentInput += button.getText().toString();
//        display.setText(currentInput);
//    }
//
//    private void onOperatorClick(View view) {
//        if (!currentInput.isEmpty()) {
//            a = Double.parseDouble(currentInput);
//            Button button = (Button) view;
//            operator = button.getText().toString();
//            currentInput = "";
//            display.setText(operator);
//        }
//    }
//
//    private void onEqualsClick(View view) {
//        if (!currentInput.isEmpty() && !operator.isEmpty()) {
//            double b = Double.parseDouble(currentInput);
//            double result = 0;
//
//            switch (operator) {
//                case "+":
//                    result = a + b;
//                    break;
//                case "-":
//                    result = a - b;
//                    break;
//                case "*":
//                    result = a * b;
//                    break;
//                case "/":
//                    if (b != 0) {
//                        result = a / b;
//                    } else {
//                        display.setText("Loi");
//                        return;
//                    }
//                    break;
//            }
//
//            display.setText(String.valueOf(result));
//            currentInput = String.valueOf(result);
//            operator = "";
//        }
//    }
//    private void onAcClick(View view) {
//        currentInput = "";
//        operator = "";
//        a = 0;
//        display.setText("0");
//    }

    private EditText txtEmail;
    SharedPreferences pref;
    SharedPreferences.Editor editor;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_signinfb);

        txtEmail = findViewById(R.id.txtEmail);

        pref = getApplicationContext().getSharedPreferences("MyPref", Context.MODE_PRIVATE);

        if(checkLogin()){
            Intent i = new Intent(MainScreenActivity.this, ProfileActivity.class);
            i.putExtra("txtEmail", txtEmail.getText().toString());
            startActivity(i);
            finish();
        }
        //--------------------------
        EditText txtPassword = (EditText) findViewById(R.id.txtPassword);

        Button btnLogin = (Button) findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String txt_Email = txtEmail.getText().toString();
                String txt_Password = txtPassword.getText().toString();
//                if ((txt_Email.equals("admin")) && (txt_Password.equals("1234"))) {
//                    Toast.makeText(MainScreenActivity.this, "Ban da login thanh cong", Toast.LENGTH_SHORT).show();
//                } else {
//                    Toast.makeText(MainScreenActivity.this, "Sai username hoac password", Toast.LENGTH_SHORT).show();
//                }

                editor = pref.edit();
                editor.putString("txtEmail", txtEmail.getText().toString());
                editor.commit();

                Intent intent = new Intent(MainScreenActivity.this, ProfileActivity.class);
                intent.putExtra("txtEmail", txt_Email);
                startActivities(new Intent[]{intent});
                finish();
            }
        });
    }
    public boolean checkLogin() {
        String user = pref.getString("username", "");
        if (user.equals("")) return false;
        else return true;
    }

    @Override
    protected void onPause() {
        super.onPause();
        txtEmail.setText("");
    }

    @Override
    protected void onStart() {
        super.onStart();
        txtEmail.setText("");
    }

}

