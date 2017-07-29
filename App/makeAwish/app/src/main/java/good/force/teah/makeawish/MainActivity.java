package good.force.teah.makeawish;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button btnLogin,btnDonate;
    private WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // setting up view
        btnLogin =(Button) findViewById(R.id.button_login);
        btnDonate = (Button) findViewById(R.id.button_donate);
        webView = (WebView) findViewById(R.id.webview_main);
        //enabling javascript
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);

        //TODO Connect webView to the backend

        btnDonate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //TODO add Payment GateWay
                String keyIdentifer  = "SignUp";
                Intent i = new Intent(MainActivity.this, Login.class);
                i.putExtra("strName", keyIdentifer );
                startActivity(i);
                Log.d("Login","Signing up....");
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // go to the Login page
                String keyIdentifer  = "Login";
                Intent i = new Intent(MainActivity.this, Login.class);
                i.putExtra("strName", keyIdentifer );
                startActivity(i);
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
            case R.id.menu_exit:
                //Kill the app
                System.exit(0);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
