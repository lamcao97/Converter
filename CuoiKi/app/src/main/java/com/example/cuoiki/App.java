package com.example.cuoiki;

import android.app.Application;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import java.util.Calendar;

public class App extends Application{

    @Override
    public void onCreate() {
        super.onCreate();
            NotificationTask.createNotificationChannel(this);
    }

}
