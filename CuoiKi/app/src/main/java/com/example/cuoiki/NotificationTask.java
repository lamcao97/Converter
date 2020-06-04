package com.example.cuoiki;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.widget.ArrayAdapter;

import androidx.core.app.NotificationCompat;

import java.util.List;

public class NotificationTask  {
    public static String CHANNEL_ID = "MyChannelId";
    public static String CHANNEL_NAME = "My Channel";
    public static int REQUEST_CODE = 0;

    private Context context;

    public NotificationTask(Context context) {
        this.context = context;

    }

    public static void createNotificationChannel(Context context) {
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, CHANNEL_NAME, importance);
            channel.setDescription("Reminders");
            channel.setShowBadge(true);
            NotificationManager mNotificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
            mNotificationManager.createNotificationChannel(channel);
        }
    }

    public static void createSampleNotification(Context context, int notificationId, int icon, String title, String message) {
        NotificationCompat.Builder builder;
        Intent intent = new Intent(context, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        PendingIntent pendingIntent = PendingIntent.getActivity(context, REQUEST_CODE, intent, 0);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            builder = new NotificationCompat.Builder(context, CHANNEL_ID)
                    .setSmallIcon(icon)
                    .setContentTitle(title)
                    .setContentText(message)
                    .setContentIntent(pendingIntent);
        } else {
            builder = new NotificationCompat.Builder(context)
                    .setSmallIcon(icon)
                    .setContentTitle(title)
                    .setContentText(message)
                    .setContentIntent(pendingIntent);
        }
        NotificationManager mNotificationManager =
                (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        mNotificationManager.notify(notificationId, builder.build());
    }

}
