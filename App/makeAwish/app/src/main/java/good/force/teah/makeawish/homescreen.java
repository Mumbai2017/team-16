package good.force.teah.makeawish;

import android.app.Activity;
import android.app.FragmentManager;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;

import static good.force.teah.makeawish.R.styleable.View;

public class homescreen extends AppCompatActivity {

    ImageButton viewProfile, viewReferrals , addReferrals, faq, calender;
    EditText hey;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homescreen);

        viewProfile = (ImageButton)findViewById(R.id.button_profile);
        viewReferrals = (ImageButton)findViewById(R.id.button_view_refferal);
        addReferrals = (ImageButton)findViewById(R.id.button_add_refferal);
        faq = (ImageButton)findViewById(R.id.button_faq);
        calender = (ImageButton)findViewById(R.id.button_calender);

        viewProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(homescreen.this, profile.class);
                startActivity(intent);

            }
        });

        viewReferrals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(homescreen.this, addReferral.class);
                startActivity(intent);

            }
        });

        addReferrals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(homescreen.this, viewReferral.class);
                startActivity(intent);

            }
        });

        calender.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(homescreen.this, calender.class);
                startActivity(intent);
            }
        });






    }
}
