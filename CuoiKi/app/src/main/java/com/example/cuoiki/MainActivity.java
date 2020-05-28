package com.example.cuoiki;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_giaodien1);
        /*setContentView(R.layout.temperature);*/


        LinearLayout data = findViewById(R.id.data);
        data.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Datastorage.class);
//                data.setBackgroundColor(Color.parseColor(String.valueOf(R.string.mau_xanh)));
                startActivity(intent);
            }
        });

        LinearLayout tem = findViewById(R.id.tem);
        tem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Temperature.class);
                startActivity(intent);
            }
        });

        LinearLayout weight = findViewById(R.id.weight);
        weight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Weight.class);
                startActivity(intent);
            }
        });

        LinearLayout length = findViewById(R.id.length);
        length.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Length.class);
                startActivity(intent);
            }
        });

        LinearLayout time = findViewById(R.id.bmi);
        time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, BMI.class);
                startActivity(intent);
            }
        });

    }

}
