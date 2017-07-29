package good.force.teah.makeawish;

import android.app.DatePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;

import java.util.Calendar;
import java.util.Date;

public class Registration extends AppCompatActivity {

    private EditText aadhar, password;
    private Button register;
    private CheckBox doctor, vol, donor;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
aadhar=(EditText) findViewById(R.id.aadhar);
        password=(EditText) findViewById(R.id.password);
        register=(Button) findViewById(R.id.register);

        doctor=(CheckBox) findViewById(R.id.checkBox2) ;
        vol=(CheckBox) findViewById(R.id.checkBox3);
        donor=(CheckBox) findViewById(R.id.checkBox4);


        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

       





    }
}
