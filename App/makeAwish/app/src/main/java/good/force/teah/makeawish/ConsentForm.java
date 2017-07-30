package good.force.teah.makeawish;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.CheckBox;
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

public class ConsentForm extends AppCompatActivity {
EditText parentName,  formExplainedBy, witness;
CheckBox checkBox;
boolean flag=false;
    Button approve;
    private good.force.teah.makeawish.Data.DataHandler db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consent_form);

        parentName=(EditText)findViewById(R.id.editText);
        formExplainedBy=(EditText)findViewById(R.id.editText2);
        witness=(EditText)findViewById(R.id.editText3);
        approve=(Button)findViewById(R.id.approveButton);
        checkBox=(CheckBox)findViewById(R.id.checkBox);
        checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(flag==false)
                {
                    approve.setEnabled(true);
                    flag=true;
                }
                else
                {
                    approve.setEnabled(false);
                    flag=false;
                }
            }
        });
        approve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(parentName.getText().toString().length()==0 || formExplainedBy.getText().toString().length()==0 || witness.getText().toString().length()==0)
                {
                    Toast.makeText(getApplicationContext(),"Please enter all the values",Toast.LENGTH_LONG).show();
                }
                else
                {
registerUser(parentName.getText().toString(),formExplainedBy.getText().toString(),witness.getText().toString());
                }
            }
        });
    }
    private void registerUser(final String pName, final String expBy, final String witness){ // Tag used to cancel the request
        String tag_string_req = "req_register";

        StringRequest strReq = new StringRequest(Request.Method.POST,
                good.force.teah.makeawish.Config.config.URL_REGISTER, new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {
                //Log.d(TAG, "Register Response: " + response.toString());

                try {
                    JSONObject jObj = new JSONObject(response);
                    boolean error = jObj.getBoolean("error");
                    if (!error) {
                        // User successfully stored in MySQL
                        // Now store the user in sqlite
                        String uid = jObj.getString("uid");

                        JSONObject user = jObj.getJSONObject("user");
                        String name = user.getString("name");
                        String email = user.getString("email");
                        String created_at = user
                                .getString("created_at");

                        // Inserting row in users table
                        db.addUser(name, email, uid, created_at);

                        Toast.makeText(ConsentForm.this, "User successfully registered. Try login now!", Toast.LENGTH_LONG).show();
                    } else {
                        String errorMsg = jObj.getString("error_msg");
                        Toast.makeText(ConsentForm.this,
                                errorMsg, Toast.LENGTH_LONG).show();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                //Log.e(TAG, "Registration Error: " + error.getMessage());
                Toast.makeText(ConsentForm.this,
                        error.getMessage(), Toast.LENGTH_LONG).show();
            }
        }) {

            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<String, String>();
                params.put("parentName", pName);
                params.put("explainedBy", expBy);
                params.put("witness", witness);


                return params;
            }

        };

        // Adding request to request queue
        App.getInstance().addToRequestQueue(strReq, tag_string_req);
    }
}
