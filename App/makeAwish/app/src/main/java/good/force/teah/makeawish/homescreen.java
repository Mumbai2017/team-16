package good.force.teah.makeawish;

import android.app.Activity;
import android.app.FragmentManager;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListView;

import static good.force.teah.makeawish.R.styleable.View;

public class homescreen extends AppCompatActivity {
    private Bundle bundle;
    private LinearLayout viewProfile, viewReferrals, addReferrals, search, donation;
    private EditText hey;
    private good.force.teah.makeawish.ConnectionManager.Session session;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homescreen);
        // Session manager

        session = new good.force.teah.makeawish.ConnectionManager.Session(getApplicationContext());
        viewProfile = (LinearLayout) findViewById(R.id.button_profile);
        viewReferrals = (LinearLayout) findViewById(R.id.button_view_refferal);
        addReferrals = (LinearLayout) findViewById(R.id.button_add_refferal);
        search = (LinearLayout) findViewById(R.id.button_faq);
        donation = (LinearLayout) findViewById(R.id.button_calender);

        // String uid= bundle.getString("uid");
        String uid = "2343";
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
                Intent intent = new Intent(homescreen.this, viewReferral.class);
                startActivity(intent);

            }
        });

        addReferrals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(homescreen.this, ReferralForm.class);
                startActivity(intent);

            }
        });
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(homescreen.this, AdminPanel.class);
                startActivity(intent);
            }
        });
        donation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(homescreen.this, AdminPanel.class);
                startActivity(intent);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.menu_volunteer: {
                Intent intent = new Intent(homescreen.this, ConsentForm.class);
                intent.putExtra("uid", "uid");
                startActivity(intent);
                return true;
            }
            case R.id.menu_admin: {
                Intent intent = new Intent(homescreen.this, AdminPanel.class);
                intent.putExtra("uid", "uid");
                startActivity(intent);
                return true;
            }
            case R.id.menu_exit: {
                //Kill the app
                System.exit(0);
                return true;
            }
            case R.id.menu_logout: {
                session.setLogin(true);
                System.exit(0);
                return true;
            }
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
