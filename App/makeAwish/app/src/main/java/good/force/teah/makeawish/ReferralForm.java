package good.force.teah.makeawish;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import static java.security.AccessController.getContext;

public class ReferralForm extends AppCompatActivity {
    private EditText caseNo, hospitalName, adhaar, mothertongue, fname, mname, gname, education, siblings, illness, notes;
    private good.force.teah.makeawish.Data.DataHandler db;
    Button refer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_referral_form);
        caseNo = (EditText) findViewById(R.id.caseNo);
        hospitalName = (EditText) findViewById(R.id.hospName);
        adhaar = (EditText) findViewById(R.id.adhaarNo);
        mothertongue = (EditText) findViewById(R.id.mptherTongue);
        fname = (EditText) findViewById(R.id.fName);
        mname = (EditText) findViewById(R.id.mName);
        gname = (EditText) findViewById(R.id.gName);
        education = (EditText) findViewById(R.id.education);
        siblings = (EditText) findViewById(R.id.siblings);
        illness = (EditText) findViewById(R.id.illness);
        notes = (EditText) findViewById(R.id.notes);
        refer = (Button) findViewById(R.id.refer);
        refer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registerUser(
                        caseNo.getText().toString(), hospitalName.getText().toString(), adhaar.getText().toString(), mothertongue.getText().toString(),
                        fname.getText().toString(), mname.getText().toString(), gname.getText().toString(), education.getText().toString(),
                        siblings.getText().toString(), illness.getText().toString(), notes.getText().toString()
                );
            }
        });
    }

    private void registerUser(final String caseNo, final String hospital, final String adhaar, final String mtongue, final String fname, final String mname, final String gname, final String edu, final String siblings, final String illness, final String notes) {
        // Tag used to cancel the request
        String tag_string_req = "req_register";

        StringRequest strReq = new StringRequest(Request.Method.POST,
                good.force.teah.makeawish.Config.config.URL_REGISTER, new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {
                //Log.d(TAG, "Register Response: " + response.toString());
            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                //Log.e(TAG, "Registration Error: " + error.getMessage());
                Toast.makeText(ReferralForm.this,
                        error.getMessage(), Toast.LENGTH_LONG).show();
            }
        }) {

            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<String, String>();
                params.put("caseNo", caseNo);
                params.put("hospital", hospital);
                params.put("adhaar", adhaar);
                params.put("mother tongue", mtongue);
                params.put("fname", fname);
                params.put("mname", mname);
                params.put("gname", gname);
                params.put("edu", edu);
                params.put("siblings", siblings);
                params.put("illness", illness);
                params.put("notes", notes);
                return params;
            }
        };
        // Adding request to request queue
        App.getInstance().addToRequestQueue(strReq, tag_string_req);
    }
}
