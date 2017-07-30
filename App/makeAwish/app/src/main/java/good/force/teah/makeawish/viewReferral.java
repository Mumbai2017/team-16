package good.force.teah.makeawish;

import android.content.Intent;
import android.graphics.Movie;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import good.force.teah.makeawish.Data.WishData;
import good.force.teah.makeawish.Data.wish;
import good.force.teah.makeawish.Data.wishAdapter;

import static java.security.AccessController.getContext;

public class viewReferral extends AppCompatActivity {

    private static final String TAG ="Referal" ;
    private List<wish> wishList = new ArrayList<>();
    private RecyclerView recView;
    private wishAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_referral);
      //  Intent intent = getIntent();
//Toast.makeText(getApplicationContext(),"recycler view",Toast.LENGTH_LONG).show();
        recView = (RecyclerView) findViewById(R.id.recycler_view);
        mAdapter = new wishAdapter(wishList,viewReferral.this);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());

        recView.setLayoutManager(new LinearLayoutManager(this));

        mAdapter=new wishAdapter(WishData.getListData(),this);
        recView.setAdapter(mAdapter);
    }

    private List<wish> getListData(){
        final List<wish> data = new ArrayList<>();
        final String tag_string_req = "request_referrals";
        StringRequest strReq = new StringRequest(Request.Method.POST,
                good.force.teah.makeawish.Config.config.URL_REGISTER,
                new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jObj = new JSONObject(response);
                    JSONArray jArray = jObj.getJSONArray("data");
                    for(int i=0;i<jArray.length();i++){
                        JSONObject tmp = jArray.getJSONObject(i);
                        data.add(new wish(tmp.getString("name"),tmp.getString("status")));
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                //Log.e(TAG, "Registration Error: " + error.getMessage());
                Toast.makeText(viewReferral.this,
                        error.getMessage(), Toast.LENGTH_LONG).show();
            }
        }) {

            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<String, String>();
                return params;
            }

        };

        // Adding request to request queue
        App.getInstance().addToRequestQueue(strReq, tag_string_req);
        return data;
    }

    private void checkLogin() {
        // Tag used to cancel the request
        String tag_string_req = "req_login";

        StringRequest strReq = new StringRequest(Request.Method.POST,
                good.force.teah.makeawish.Config.config.URL_LOGIN, new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {
                Log.d(TAG, "Login Response: " + response.toString());

                try {
                    JSONObject jObj = new JSONObject(response);
                    //JSONArray jsonArray= new JSONArray(response);
                    //boolean error = jObj.getBoolean("error");

                    // Check for error node in json
                    //if (!error) {
                    // user successfully logged in
                    // Create login session
                    //session.setLogin(true);

                    // Now store the user in SQLite

                    String uid = jObj.getString("aadhar_id");
                    String username = jObj.getString("username");
                    Log.d("response",uid);
                    Intent intent = new Intent(viewReferral.this,homescreen.class);
                    intent.putExtra("uid", uid );
                    viewReferral.this.startActivity(intent);
                } catch (JSONException e) {
                    // JSON error
                    e.printStackTrace();
                    Toast.makeText(viewReferral.this, "Json error: " + e.getMessage(), Toast.LENGTH_LONG).show();
                }

            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e(TAG, "Login Error: " + error.getMessage());
                Toast.makeText(viewReferral.this,
                        error.getMessage(), Toast.LENGTH_LONG).show();
            }
        }) {

            @Override
            protected Map<String, String> getParams() {
                // Posting parameters to post to the server
                Map<String, String> params = new HashMap<String, String>();
                return params;
            }

        };

        App.getInstance().addToRequestQueue(strReq, tag_string_req);
    }


}
