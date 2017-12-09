package milab.googlesearch;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    final String host = "https://www.googleapis.com/customsearch/v1?";

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
                initiateRequest(searchParam + "", v);
            }
        });
    }
    private void initiateRequest(final String param, View v){

        RequestQueue queue = Volley.newRequestQueue(v.getContext());
        String key = "AIzaSyA1c9ZyIIM7EnHQ-Qloo1kdQB6w7N9On9g";
        String cxVal = "001358638682705194926:exppffh1hca";
        String url =
                host +
                        "key=" + key +
                        "&cx=" + cxVal +
                        "&q=" + param;
        Log.d("url", "url - "+ url);
        StringRequest req = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {
                    Object data = null;
                TextView timeTextView = (TextView)findViewById(R.id.time_textView);

                Log.d("MainActivityFragment", "Response - " + response);
                try {

                    data = new JSONObject(response).getJSONObject("searchInformation").get("formattedSearchTime");
                    Log.d("","");

                } catch (Throwable t) {
                    Log.e("err", "Could not parse malformed JSON: \"" + response + "\"");
                }
                timeTextView.setText("Searching \"" + param + "\" in Google, took " + data.toString() + "ms");

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
