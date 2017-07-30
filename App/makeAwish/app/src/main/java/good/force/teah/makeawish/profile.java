package good.force.teah.makeawish;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

public class profile extends AppCompatActivity {

    mySyncTask syncTask;
    TextView nameOfInsti, aadhar, lat, lon, age, name;

    // Bundle bundle=new Bundle();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        Log.i("FLAG", "hey1");
        Intent out = getIntent();
        Log.i("FLAG", "hey2");

        nameOfInsti = (TextView) findViewById(R.id.instText);
        aadhar = (TextView) findViewById(R.id.aadharText);
        lat = (TextView) findViewById(R.id.latText);
        lon = (TextView) findViewById(R.id.lonText);
        age = (TextView) findViewById(R.id.ageText);
        name = (TextView) findViewById(R.id.name);


        syncTask = new mySyncTask();
        Log.i("FLAG", "hey3");
        //if(out.getFlags()==0)
        syncTask.execute(out.getStringExtra("name"));
        //else
        //  syncTask.execute(out.getStringExtra("state"),out.getStringExtra("cat"),out.getStringExtra("data"));

        ArrayList<String> xlist = new ArrayList<>();

        try {
            xlist = syncTask.get();
        } catch (InterruptedException e) {
            e.printStackTrace();

        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        nameOfInsti.setText(xlist.get(0));
        lat.setText(xlist.get(0));
        lon.setText(xlist.get(0));
        aadhar.setText("-------");
        age.setText("21");
        name.setText("Gul");
    }

}

class mySyncTask extends AsyncTask<String, Void, ArrayList> {


    @Override
    protected ArrayList doInBackground(String... params) {
        String state = params[0];
        String index = null, data = null;
        if (params.length > 1) {
            index = params[1];
            data = params[2];
        }

        String API_KEY = "854b4425ebca54132fbe0c337b5afbbf";
        try {
            //ALL DATA FROM API KEY

            Log.i("BLAH", "inside try catch");
            URL url = new URL("https://api.betterdoctor.com/2016-03-01/doctors?location=37.773,-122.413,100&skip=2&limit=10&user_key=" + API_KEY);//+"&filters[STATEUT]="+state);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            try {
                ArrayList<String> list = new ArrayList<>();
                BufferedReader reader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
                JSONObject jsonObject = new JSONObject(reader.readLine());
                JSONArray jsonArray = jsonObject.getJSONArray("data");
                JSONArray jsonArray1 = jsonArray.getJSONObject(0).getJSONArray("practices");
                JSONObject jsonObject2 = jsonArray1.getJSONObject(0);

                if (index != null) {
                    jsonArray.getJSONObject(0).putOpt(index, data);
                }

                Log.i("blah", jsonArray.toString());

                list.add(jsonObject2.get("name").toString());
                list.add(jsonObject2.get("lat").toString());
                list.add(jsonObject2.get("lon").toString());

                Log.i("Array list in MySyncTa", jsonArray.toString());

                reader.close();
                return list;
            } finally {
                urlConnection.disconnect();
            }
        } catch (Exception e) {
            Log.e("ERROR", e.getMessage(), e);
            return null;
        }
    }
}
