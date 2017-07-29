package good.force.teah.makeawish;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Button;
import android.widget.Toast;

public class ConsentForm extends AppCompatActivity {
EditText parentName,  formExplainedBy;
CheckBox checkBox;
boolean flag=false;
    Button approve;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consent_form);

        parentName=(EditText)findViewById(R.id.editText);
        formExplainedBy=(EditText)findViewById(R.id.editText2);
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
                if(parentName.getText().toString().length()==0 || formExplainedBy.getText().toString().length()==0)
                {
                    Toast.makeText(getApplicationContext(),"Please enter all the values",Toast.LENGTH_LONG).show();
                }
                else
                {

                }
            }
        });
    }
}
