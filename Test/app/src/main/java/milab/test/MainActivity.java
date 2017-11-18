package milab.test;

import android.app.AlarmManager;
import android.app.NotificationManager;
import android.content.Context;
import android.os.SystemClock;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button lunchButton = (Button) findViewById(R.id.button);
        lunchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startNotificationService();
            }
        });
    }


    private void startNotificationService() {
        Log.d("tag", "minutes");
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this)
                .setSmallIcon(R.drawable.jaime)
                .setContentTitle("Spam")
                .setContentText("It been minutes from your last spam");
        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        int id = 1;
        notificationManager.notify("", id, builder.build());
    }
}
