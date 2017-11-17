package milab.mynotifier;

import android.app.IntentService;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;


public class notificationService extends IntentService {

    private static final String EXTRA_MINUTES = "milab.mynotifier.extra.MINUTES";

    public notificationService() {
        super("notificationService");
    }

    /**
     * Starts this service to perform action Foo with the given parameters. If
     * the service is already performing a task this action will be queued.
     *
     * @see IntentService
     */
    // TODO: Customize helper method
    public static void startNotifications(Context context, int time) {
        Intent intent = new Intent(context, notificationService.class);
        intent.putExtra(EXTRA_MINUTES, time);
        context.startService(intent);
    }


    @Override
    protected void onHandleIntent(Intent intent) {
        if (intent == null) {
            return;
        }
        final int time = intent.getIntExtra(EXTRA_MINUTES, 1);
        handleNotification(time);
    }

    private void handleNotification(int time) {
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this)
                .setContentTitle("Spam")
                .setContentText("It been" + time + " minutes from your last spam");
        NotificationManager notificationManager = (NotificationManager) this
                .getSystemService(Context.NOTIFICATION_SERVICE);
        int id = 1;
        notificationManager.notify(id, builder.build());
    }
}
