package vesitlibrary.pavankumar.camp.VESITLibrary;

/** THIS PROJECT IS COPYRIGHT TO VESIT COLLAGE AND LIBRARY.TEAM AND APP DEVELOPERS ALL RIGHTS ARE RESERVED
 *
 *
 * Created by Pavankumar on managing activity for validate-user
 */

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    EditText etpassword;
    Button btn_login;
    final String LOG = "LoginActivity";
    public final static String send_to_other_activity = "etpassword";
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etpassword = (EditText) findViewById(R.id.etpassword);
        btn_login = (Button) findViewById(R.id.btn_login);
        btn_login.setOnClickListener(LoginActivity.this);
        //HashMap<String, EditText> postData = new HashMap<String, EditText>();
        //postData.put("", etpassword);

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        checkConnection();
    }
    boolean doubleBackToExitPressedOnce = false;

    @Override
    public void onBackPressed() {

        if (doubleBackToExitPressedOnce) {
            Intent intent = new Intent(Intent.ACTION_MAIN);
            intent.addCategory(Intent.CATEGORY_HOME);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
            return;
        }

        this.doubleBackToExitPressedOnce = true;
        Toast.makeText(this, "Please click BACK again to exit", Toast.LENGTH_SHORT).show();

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                doubleBackToExitPressedOnce=false;
            }
        }, 3000);
    }
    private void checkConnection() {
        boolean isConnected = ConnectivityReceiver.isConnected();
        showSnack(isConnected);
    }

    // Showing the status in Snackbar
    private void showSnack(boolean isConnected) {
        String message;
        int color;
        if (isConnected) {
            message = "Good! Connected to Internet....";
            color = Color.BLACK;
        } else {
            message = "Sorry! Please Check Your Internet Connection...";
            color = Color.RED;
        }
        Snackbar snackbar = Snackbar
                .make(findViewById(R.id.fab), message, Snackbar.LENGTH_LONG);

        View sbView = snackbar.getView();
        sbView.setBackgroundColor(ContextCompat.getColor(LoginActivity.this, R.color.snackbar3));
        TextView textView = (TextView) sbView.findViewById(android.support.design.R.id.snackbar_text);
        textView.setTextColor(color);
        snackbar.show();
    }

    @Override
    public void onClick(View view) {
        final String password = etpassword.getText().toString();
        final String checkid = etpassword.getText().toString();
        if (checkid.isEmpty() || checkid.length() < 5 || checkid.length() > 9) {
            Toast.makeText(this, "Please enter valid 6-Digit Library-Id", Toast.LENGTH_LONG).show();
            return;
        }
        final ProgressDialog progressDialog = new ProgressDialog(LoginActivity.this,
                R.style.AppTheme_Dark_Dialog2);
        progressDialog.setIndeterminate(true);
        progressDialog.setCanceledOnTouchOutside(false);
        progressDialog.setMessage("Authenticating...\nAlmost done.....");
        progressDialog.show();
        //Creating a string request
        StringRequest stringRequest = new StringRequest("http://192.168.43.214/vesit/public/user/validate/abc/"+ password,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String s) {
                        String checklogin = s;
                        if (s.contains("true")) {
                            progressDialog.dismiss();
                            Toast.makeText(LoginActivity.this, "Welcome", Toast.LENGTH_LONG).show();
                            Intent i = new Intent(LoginActivity.this, MainActivity.class);
                            i.putExtra("etpassword", password);
                            startActivity(i);
                        } else {
                            checklogin = s;
                            if (checklogin.equals("false")) {
                                progressDialog.dismiss();
                                Toast.makeText(LoginActivity.this, "Please Give Valid 6-Digit Library-Id", Toast.LENGTH_LONG).show();
                                return;
                            }
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        progressDialog.dismiss();
                        Toast.makeText(LoginActivity.this, "Sorry For Inconvenience :((,Service Is Not Available Now, Service Is available From 8:00AM TO 6:00PM", Toast.LENGTH_LONG).show();

                    }
                });

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);


    }

}
