package milab.exercise_09;



import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;


/**
 * A simple {@link Fragment} subclass.
 *
 */
public class FragmentMain extends Fragment {


    public FragmentMain() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fragment_main, container, false);
        final TextView timeView = (TextView) view.findViewById(R.id.textView);
        Button timeButton = (Button) view.findViewById(R.id.show_time_button);
        timeButton.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(final View view) {
                final ProgressDialog progressDialog = new ProgressDialog(view.getContext());
                progressDialog.setMessage("Fetching time from server...");
                progressDialog.show();
                final RequestQueue _queue = Volley.newRequestQueue(getContext());
                String url = "https://secure-journey-30558.herokuapp.com/getTime";

                StringRequest req = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        progressDialog.hide();
                        timeView.setText(response);
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        progressDialog.hide();
                        Toast.makeText(view.getContext(), "Error while fetching time from server", Toast.LENGTH_LONG);
                        return;
                    }
                });

                _queue.add(req);
            }
        });

        return view;
    }
}
