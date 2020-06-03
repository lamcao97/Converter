package com.example.cuoiki;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    App app;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_giaodien1);
        /*setContentView(R.layout.temperature);*/
        app = (App) getApplication();

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

    public void notify(View v) {
//        Calendar calendar = Calendar.getInstance();
//        if(calendar.get(Calendar.DAY_OF_MONTH)==2)
            NotificationTask.createSampleNotification(app, 1, R.drawable.ic_notification, "Notifica", " BMI test at the beginning of each month !!!");
    }
}
