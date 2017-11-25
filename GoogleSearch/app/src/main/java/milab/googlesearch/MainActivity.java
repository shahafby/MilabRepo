package milab.googlesearch;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class MainActivity extends AppCompatActivity {

    final String host = "http://www.google.com";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText searchBox = (EditText)findViewById(R.id.search_param);
        final Editable searchParam = searchBox.getText();
        Button lanisterButton = (Button)this.findViewById(R.id.go_button);
        lanisterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initiateRequest(searchParam, v);
            }
        });
    }
    private void initiateRequest(Editable initiateRequest, View v){
        Log.d("log","" + initiateRequest);
        RequestQueue queue = Volley.newRequestQueue(v.getContext());
        StringRequest req = new StringRequest(Request.Method.GET, host, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.d("MainActivityFragment", "Response - " + response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("MainActivityFragment", "Encountered error - " + error);
            }
        });
        queue.add(req);
    }

}
