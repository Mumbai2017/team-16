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

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

public class profile extends AppCompatActivity {

    mySyncTask syncTask;
    EditText blah;
   // Bundle bundle=new Bundle();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        Intent out = getIntent();


        blah = (EditText)findViewById(R.id.editText5);

        syncTask=new mySyncTask();
        Log.i("FLAG",Integer.toString(out.getFlags()));
        //if(out.getFlags()==0)
            syncTask.execute(out.getStringExtra("name"));
        //else
          //  syncTask.execute(out.getStringExtra("state"),out.getStringExtra("cat"),out.getStringExtra("data"));

        ArrayList<String> xlist=new ArrayList<>();
        try
        {
            xlist = syncTask.get();
            //if(xlist!=null)
           // Log.i("xlist",xlist.toString());
            //else
            //  Toast.makeText(this,"Error,xlist is empty",Toast.LENGTH_LONG);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();

        } catch (ExecutionException e)
        {
            e.printStackTrace();
        }
        //blah.setText(xlist.toString());
       // bundle.putStringArrayList("list",xlist);


    }

}

class mySyncTask extends AsyncTask<String, Void, ArrayList>
{
    @Override
    protected ArrayList doInBackground(String... params)
    {

        String state=params[0];
        String index=null,data=null;
        if(params.length>1)
        {
            index=params[1];
            data=params[2];
        }

//        Log.i("state: ",state);
        Log.i("BLAH","inside class");
        String API_KEY = "854b4425ebca54132fbe0c337b5afbbf";
        try
        {
            //ALL DATA FROM API KEY

            Log.i("BLAH","inside try catch");
            URL url = new URL("https://api.betterdoctor.com/2016-03-01/doctors?location=37.773,-122.413,100&skip=2&limit=10&user_key="+API_KEY);//+"&filters[STATEUT]="+state);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            try
            {
                Log.i("BLAH","inside second try catch");

                ArrayList<String> list=new ArrayList<>();
                BufferedReader reader=new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
                JSONObject jsonObject=new JSONObject(reader.readLine());
                JSONArray jsonArray=jsonObject.getJSONArray("name");
                Log.i("BLAH",jsonArray.getJSONObject(0).get("name").toString());
                Log.i("BLAH",jsonArray.toString());

                if (index!=null)
                {
                    jsonArray.getJSONObject(0).putOpt(index, data);
                }

                Log.i("blah",jsonArray.toString());

                //list.add(jsonArray.getJSONObject(0).get("FullTimeTeachersMale").toString());
                //list.add(jsonArray.getJSONObject(0).get("FullTimeTeachersFemale").toString());
                //list.add(jsonArray.getJSONObject(0).get("ParaContractTeachersMale").toString());
                //list.add(jsonArray.getJSONObject(0).get("ParaContractTeachersFemale").toString());

                Log.i("Array list in MySyncTa",list.toString());

                reader.close();
                return list;
            }
            finally
            {
                urlConnection.disconnect();
            }
        }
        catch(Exception e)
        {
            Log.e("ERROR", e.getMessage(), e);
            return null;
        }
    }
}
