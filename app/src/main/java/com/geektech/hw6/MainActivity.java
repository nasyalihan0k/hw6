package com.geektech.hw6;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    @SuppressLint({"WrongViewCast", "MissingInflatedId"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         EditText emailText = findViewById(R.id.email);
         EditText passwordText = findViewById(R.id.password);
         EditText btnText = findViewById(R.id.btn);
        TextView textView = findViewById(R.id.inputText);
        TextView textView1 = findViewById(R.id.text);

       emailText.addTextChangedListener(new TextWatcher() {
           @Override
           public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

           }

           @Override
           public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        if (!TextUtils.isEmpty(charSequence)){
            btnText.setBackgroundColor(getColor(R.color.orange));
        }else {
            btnText.setBackgroundColor(getColor(R.color.gray));
        }
           }

           @Override
           public void afterTextChanged(Editable editable) {

           }
       });

       btnText.setOnClickListener(view -> {
           if (emailText.getText().toString().equals("Admin") && passwordText.getText().toString().equals("Admin")){
               textView.setVisibility(View.GONE);
               textView1.setVisibility(View.GONE);
               Toast.makeText(MainActivity.this, "Вы успешно зарегестрировались", Toast.LENGTH_SHORT).show();
           }else {
               Toast.makeText(MainActivity.this, "Не верный пароль", Toast.LENGTH_SHORT).show();
           }
       });


    }
}