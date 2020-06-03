package com.example.cuoiki;

import android.database.Cursor;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.Calendar;

public class BieuDo extends AppCompatActivity {

    BarChart barChart;
    ArrayList<Object> arrayDataKH = new ArrayList<>();
    Cursor cursor;
    SQLite data;
    ListView list;
    Button timkiem, load, back;
    EditText ngaykt;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bieu_do);

        barChart = findViewById(R.id.barChart);
        Calendar c = Calendar.getInstance();


        data = new SQLite(this, "BMI_Manage.sqlite", null, 1);
        cursor = data.TruyVanTraVe("Select * From BMI");
        while (cursor.moveToNext()) {
            arrayDataKH.add(new Object(cursor.getInt(0), cursor.getString(1), cursor.getString(2), cursor.getString(3)));
        }


        ArrayList<BarEntry> barEntries = new ArrayList<>();
        for(int i=0;i<arrayDataKH.size();i++){
            Log.i("CSC", "C"+arrayDataKH.get(i).ngay+arrayDataKH.get(i).bmi+arrayDataKH.get(i).ketqua);
            float x= Float.parseFloat(arrayDataKH.get(i).bmi);
//            barEntries.add(new BarEntry(10*i,x ));
            barEntries.add(new BarEntry(i,x));
        }

//        barEntries.add(new BarEntry(2014,0));
//        barEntries.add(new BarEntry(2015,100));
//        barEntries.add(new BarEntry(2016,508));
//        barEntries.add(new BarEntry(2017,660));
//        barEntries.add(new BarEntry(2018,550));
//        barEntries.add(new BarEntry(2019,630));
//        barEntries.add(new BarEntry(2020,470));
        BarDataSet barDataSet = new BarDataSet(barEntries,"BMI");

        barDataSet.setColors(ColorTemplate.MATERIAL_COLORS);
        barDataSet.setValueTextColor(Color.BLACK);
        barDataSet.setValueTextSize(16f);

        BarData theData = new BarData(barDataSet);
        barChart.setFitBars(true);
        barChart.setData(theData);
        barChart.getDescription().setText("Bar Chart Example");
        barChart.animateY(10);
        barChart.setDragEnabled(true);

    }

    private void LoadData() {
//        arrayDataKH = new ArrayList<>();
        cursor = data.TruyVanTraVe("Select * From BMI");
        while (cursor.moveToNext()) {
            arrayDataKH.add(new Object(cursor.getInt(0), cursor.getString(1), cursor.getString(2), cursor.getString(3)));
        }
//        BMIAdapter adapter = new BMIAdapter(ShowResultBMI.this, R.layout.itembmi, arrayDataKH);
//        adapter.setNotifyOnChange(true);
//        list.setAdapter(adapter);
    }
}
