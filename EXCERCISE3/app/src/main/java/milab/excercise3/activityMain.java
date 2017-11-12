package milab.excercise3;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import layout.fragmentLanisterList;

public class activityMain extends FragmentActivity {

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button lanisterButton = (Button)this.findViewById(R.id.lanisterHouse_button);
        lanisterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startListScreen(v, "lanister");
            }
        });
        Button starkButton = (Button)this.findViewById(R.id.starkHouse_button);
        starkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startListScreen(v, "stark");
            }
        });
    }

    private void startListScreen(View v, String house){
        Intent intent = new Intent(v.getContext(), activityCharactersList.class);
        Bundle b = new Bundle();
        b.putString("house", house);
        intent.putExtras(b); //Put your
        startActivity(intent);
    }
}
