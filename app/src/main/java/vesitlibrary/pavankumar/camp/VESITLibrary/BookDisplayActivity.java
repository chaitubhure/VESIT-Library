package vesitlibrary.pavankumar.camp.VESITLibrary;

/** THIS PROJECT IS COPYRIGHT TO VESIT COLLAGE AND LIBRARY.TEAM AND APP DEVELOPERS ALL RIGHTS ARE RESERVED
 *
 *
 * Created by Pavankumar on managing activity for book-data
 */
import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
public class BookDisplayActivity extends AppCompatActivity {

    String passinstru = null ;
    String passit = null ;
    String passcomputer = null ;
    String passextc = null ;
    String passetrx = null ;
    String bookname = null ;


    private TextView  passbooknamecount ;

    private ProgressDialog loading;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_display);

        passbooknamecount = (TextView) findViewById(R.id.passbooknamecount);

        if (passinstru != null) {
            bookname = passinstru;
        } else if (passetrx != null) {
            bookname = passetrx;
        }else if (passcomputer != null) {
            bookname = passcomputer;
        }else if (passextc != null) {
            bookname = passextc;
        }else if (passit != null) {
            bookname = passit;
        }

        String id = bookname;
        final ProgressDialog progressDialog = new ProgressDialog(BookDisplayActivity.this,
                R.style.AppTheme_Dark_Dialog);
        progressDialog.setIndeterminate(true);
        progressDialog.setCanceledOnTouchOutside(false);
        progressDialog.setMessage("Please Wait.... \nGetting Your Required Results ...");
        progressDialog.show();

        try {
            id = URLEncoder.encode(id , "utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        String url = Configbookconnection.DATA_URL+ id;

        StringRequest stringRequest = new StringRequest(url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                progressDialog.dismiss();
                showJSON(response);
            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(BookDisplayActivity.this, error.getMessage(),Toast.LENGTH_LONG).show();
                    }
                });

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }

    private void showJSON(String response){
        String name="";
        String count="";

        try {
            JSONObject jsonObject = new JSONObject(response);
            JSONArray result = jsonObject.getJSONArray(Configbookconnection.JSON_ARRAY);
            JSONObject collegeData = result.getJSONObject(0);
            name = collegeData.getString(Configbookconnection.KEY_NAME);
            count = collegeData.getString(Configbookconnection.KEY_ADDRESS);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        passbooknamecount.setText("Your Selected BookName Is:-\t\t" +name+"\n\nAvailability:-\t" +count+"\n\n");
    }


}