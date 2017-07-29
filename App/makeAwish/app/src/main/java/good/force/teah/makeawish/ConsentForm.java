package good.force.teah.makeawish;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;
public class ConsentForm extends AppCompatActivity {
EditText parentName, formFilledInPresenceOf, formExplainedBy;


    Button approve;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consent_form);

        parentName=(EditText)findViewById(R.id.editText);
        formFilledInPresenceOf=(EditText)findViewById(R.id.editText2);
        formExplainedBy=(EditText)findViewById(R.id.editText3);
        approve=(Button)findViewById(R.id.approveButton);
        approve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
