package good.force.teah.makeawish;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class AdminPanel extends AppCompatActivity {
    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_panel);
        webView = (WebView) findViewById(R.id.web_adminPanel);
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        // TODO Connect to the admin panel @ server
        //webView.loadUrl("http://");
        //setContentView(webView);
    }
}
