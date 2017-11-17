package layout;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.NumberPicker;

import milab.mynotifier.R;
import milab.mynotifier.notificationService;


public class MainFragment extends Fragment {

    private static int time;

    public MainFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        NumberPicker np = (NumberPicker) getView().findViewById(R.id.numberPicker);
//        Button lunchButton = (Button) getView().findViewById(R.id.lunch_button);

        np.setMinValue(0);
        np.setMaxValue(10);
        np.setWrapSelectorWheel(true);

        np.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                time = newVal;
                Log.d("time", Integer.toString(time));
            }
        });

//        lunchButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                setNotification(time);
//            }
//        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    public void setNotification(int numOfMinutes) {
        notificationService.startNotifications(this.getContext(), numOfMinutes);
    }

}
