package milab.mynotifier;

import android.app.NotificationManager;
import android.content.Context;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.NumberPicker;

public class MainActivity extends AppCompatActivity {

    static int minutes = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        NumberPicker np = (NumberPicker) findViewById(R.id.number_picker);
        Button lunchButton = (Button) findViewById(R.id.lunch_button);

        np.setMinValue(0);
        np.setMaxValue(10);
        np.setWrapSelectorWheel(true);
        np.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal){
                minutes = newVal;
                Log.d("" , ""+newVal);
            }
        });
        lunchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startNotificationService(minutes, v);
            }
        });
    }

    private void startNotificationService(int minutes, View v){
//        Log.d("tag" , "minutes" + minutes);
//        NotificationCompat.Builder builder = new NotificationCompat.Builder(v.getContext())
//                .setSmallIcon(R.drawable.jaime)
//                .setContentTitle("Spam")
//                .setContentText("It been " + minutes + " minutes from your last spam");
//        NotificationManager notificationManager = (NotificationManager) this
//                .getSystemService(Context.NOTIFICATION_SERVICE);
//        int id = 1;
//        notificationManager.notify(id, builder.build());
        NotificationService.startNotifications(this, minutes);
    }
}
