package milab.excercise2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText txtBox = (EditText)findViewById(R.id.someTxtBox);
        Button dispButton = (Button)findViewById(R.id.displayButton);
        final Editable inputTxt = txtBox.getText();

        dispButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(inputTxt.length() == 0) {
                    Toast toast = Toast.makeText(v.getContext(), "Did not find anything to write?", Toast.LENGTH_LONG);
                    toast.show();
                } else {
                    Toast toast = Toast.makeText(v.getContext(), inputTxt.toString(), Toast.LENGTH_LONG);
                    toast.show();
                }
            }
        });
    }

}


