package milab.mynotifier;

import android.app.AlarmManager;
import android.app.IntentService;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import android.support.v4.app.NotificationCompat;


public class NotificationService extends IntentService {

    private AlarmManager alarmMgr;
    private PendingIntent alarmIntent;
    private static final String EXTRA_MINUTES = "milab.mynotifier.extra.MINUTES";

    public NotificationService() {
        super("notificationService");
    }

    /**
     * Starts this service to perform action Foo with the given parameters. If
     * the service is already performing a task this action will be queued.
     *
     * @see IntentService
     */
    public static void startNotifications(Context context, int time) {
        Intent intent = new Intent(context, NotificationService.class);
        intent.putExtra(EXTRA_MINUTES, time);
        context.startService(intent);
    }


    @Override
    protected void onHandleIntent(Intent intent) {
        if (intent == null) {
            return;
        }
        final int delay = intent.getIntExtra(EXTRA_MINUTES, 1);
        handleNotification(delay);
    }

    private void handleNotification(int delay) {
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this)
                .setSmallIcon(R.drawable.ic_stat_name)
                .setContentTitle("Spam")
                .setContentText("It been " + delay + " minutes from your last spam");

        Notification notification = builder.build();
        Intent notificationIntent = new Intent(this, NotificationPublisher.class);
        notificationIntent.putExtra(NotificationPublisher.NOTIFICATION_ID, 1);
        notificationIntent.putExtra(NotificationPublisher.NOTIFICATION, notification);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(this, 0, notificationIntent, PendingIntent.FLAG_UPDATE_CURRENT);

        long delayInMillis = delay * 60 * 100;
        long futureInMillis = SystemClock.elapsedRealtime() + delayInMillis;
        AlarmManager alarmManager = (AlarmManager)getSystemService(Context.ALARM_SERVICE);
        alarmManager.setInexactRepeating(AlarmManager.ELAPSED_REALTIME_WAKEUP, futureInMillis, delay,pendingIntent);

    }

}