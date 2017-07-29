package good.force.teah.makeawish;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import android.widget.Toast;

public class ReferralForm extends AppCompatActivity {
EditText caseNo, hospitalName, adhaar, mothertongue, fname, mname, gname, education, siblings, illness, notes;

    Button refer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_referral_form);
        caseNo=(EditText)findViewById(R.id.caseNo);
        hospitalName=(EditText)findViewById(R.id.hospName);
        adhaar=(EditText)findViewById(R.id.adhaarNo);
        mothertongue=(EditText)findViewById(R.id.mptherTongue);
        fname=(EditText) findViewById(R.id.fName);
        mname=(EditText) findViewById(R.id.mName);
        gname=(EditText) findViewById(R.id.gName);
        education=(EditText) findViewById(R.id.education);
        siblings=(EditText) findViewById(R.id.siblings);
        illness=(EditText) findViewById(R.id.illness);
        notes=(EditText) findViewById(R.id.notes);
        refer=(Button) findViewById(R.id.refer);
        refer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Connector connector=new Connector(ReferralForm.this);
               // connector.execute()
            }
        });
    }
}
