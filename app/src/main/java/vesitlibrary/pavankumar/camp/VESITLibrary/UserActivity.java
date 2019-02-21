package vesitlibrary.pavankumar.camp.VESITLibrary;

/** THIS PROJECT IS COPYRIGHT TO VESIT COLLAGE AND LIBRARY.TEAM AND APP DEVELOPERS ALL RIGHTS ARE RESERVED
 *
 *
 /**
 * Created by Pavankumar Sakhare on for managing fragments
 */

import android.app.ProgressDialog;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;


public class UserActivity extends AppCompatActivity  {

    private ListView listView;
    String id = null;
    Toolbar toolbar = null;
    String test = "abc" ;
    TextView checknet;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        id = getIntent().getStringExtra(MainActivity.send_to_other_activity2);
        listView = (ListView) findViewById(R.id.list);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //noinspection ConstantConditions
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        checknet =  (TextView)findViewById(R.id.checknet);
        checkConnection();
    }

    private void checkConnection() {
        boolean isConnected = ConnectivityReceiver.isConnected();
        showSnack(isConnected);
    }

    private void showSnack(boolean isConnected) {
        String message = null;
        int color;
        if (isConnected) {
            message = "Good! You are connected to internet....";
            color = Color.WHITE;
            final ProgressDialog progressDialog = new ProgressDialog(UserActivity.this,
                    R.style.AppTheme_Dark_Dialog1);
            progressDialog.setIndeterminate(true);
            progressDialog.setCanceledOnTouchOutside(false);
            progressDialog.setMessage("Please Wait.... \nGetting Your Issued Book Status.....");
            progressDialog.show();

            StringRequest stringRequest = new StringRequest("http://192.168.43.214/vesit/public/user/details/"+test+"/"+id,
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            progressDialog.dismiss();
                            showJSON(response);
                        }
                    },
                    new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            Toast.makeText(UserActivity.this, "Server is busy \nPlease Try Again Later :/", Toast.LENGTH_LONG).show();
                            progressDialog.dismiss();
                            checknet.setText("Sorry :( \n Please Try Again Later");
                        }
                    });

            RequestQueue requestQueue = Volley.newRequestQueue(this);
            requestQueue.add(stringRequest);

        } else {
            message = "Sorry! You are Not connected to internet... \nPlease Check Your Internet Connection :(";
            checknet.setText("Sorry :( \n Please Try Again Later");
            color = Color.WHITE;
        }

        Snackbar snackbar = Snackbar
                .make(findViewById(R.id.fab), message, Snackbar.LENGTH_LONG);
        View sbView = snackbar.getView();
        sbView.setBackgroundColor(ContextCompat.getColor(UserActivity.this, R.color.snackbar1));
        TextView textView = (TextView) sbView.findViewById(android.support.design.R.id.snackbar_text);
        textView.setTextColor(color);
        snackbar.show();
    }

    private void showJSON(String json) {

        ParseJSONdetails pj = new ParseJSONdetails(json);
        pj.parseJSON();
        CustomListdetails cl = new CustomListdetails(this, ParseJSONdetails.names, ParseJSONdetails.date1, ParseJSONdetails.date2);
        listView.setAdapter(cl);
    }

}