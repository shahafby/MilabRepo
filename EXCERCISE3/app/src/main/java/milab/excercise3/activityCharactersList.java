package milab.excercise3;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import layout.fragmentLanisterList;
import layout.fragmentStarkList;

public class activityCharactersList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle b = getIntent().getExtras();
        String house = null; // or other values
        if(b != null) {
            house = b.getString("house");
        }
        setContentView(R.layout.activity_chracters_list);
        switch (house){
            case "lanister":
                Fragment fragmentLanister = new fragmentLanisterList();
                if (findViewById(R.id.fragment_container_charactersList) != null) {
                    if (savedInstanceState != null) {
                        return;
                    }
                    FragmentTransaction transaction = getFragmentManager().beginTransaction();
                    transaction.add(R.id.fragment_container_charactersList, fragmentLanister);
                    transaction.addToBackStack(null);  // this will manage backstack
                    transaction.commit();
                }
                break;
            case "stark":
                Fragment fragmentStark = new fragmentStarkList();
                if (findViewById(R.id.fragment_container_charactersList) != null) {
                    if (savedInstanceState != null) {
                        return;
                    }
                    FragmentTransaction transaction = getFragmentManager().beginTransaction();
                    transaction.add(R.id.fragment_container_charactersList, fragmentStark);
                    transaction.addToBackStack(null);  // this will manage backstack
                    transaction.commit();
                }

        }

    }
}
