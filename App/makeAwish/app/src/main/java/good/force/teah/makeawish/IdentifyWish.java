package good.force.teah.makeawish;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import android.widget.Toast;

public class IdentifyWish extends AppCompatActivity {
EditText wish1,wish2, wish3;
    Button submit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_identify_wish);

        wish1=(EditText) findViewById(R.id.wish1);
        wish2=(EditText) findViewById(R.id.wish2);
        wish3=(EditText) findViewById(R.id.wish3);
        submit=(Button) findViewById(R.id.submit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(wish1.getText().toString().length()==0 || wish2.getText().toString().length()==0 || wish3.getText().toString().length()==0 )
                {
                    Toast.makeText(getApplicationContext(),"Please enter all details",Toast.LENGTH_LONG).show();
                }
                else
                {

                }
            }
        });
    }
}
