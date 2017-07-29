package good.force.teah.makeawish;

import android.app.DatePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Calendar;
import java.util.Date;

public class Registration extends AppCompatActivity {

    private EditText aadhar,password;
    private Button register;
    private CheckBox dr, vol, donor;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        aadhar = (EditText)findViewById(R.id.aadhar);
       password=(EditText) findViewById(R.id.password);
        register=(Button) findViewById(R.id.register);
        dr=(CheckBox) findViewById(R.id.checkBox2);
        vol=(CheckBox) findViewById(R.id.checkBox3);
        donor=(CheckBox) findViewById(R.id.checkBox4);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(aadhar.getText().toString().length()==0 || password.getText().toString().length()==0 )
                {
                    Toast.makeText(getApplicationContext(),"Please enter all details",Toast.LENGTH_LONG).show();
                }
                else
                {
                    JSONObject obj=new JSONObject();
                    try
                    {
                        obj.put("aadharNo",aadhar.getText().toString());
                        obj.put("password",password.getText().toString());
                        if(dr.isChecked())
                            obj.put("doctor","y");
                        else
                            obj.put("doctor","n");
                        if(vol.isChecked())
                            obj.put("volunteer","y");
                        else
                            obj.put("volunteer","n");
                        if(donor.isChecked())
                            obj.put("donor","y");
                        else
                            obj.put("donor","n");
                        Log.d("json",obj.toString());
                    }
                    catch (JSONException e)
                    {
                        e.printStackTrace();
                    }
                }
            }
        });




    }
}
