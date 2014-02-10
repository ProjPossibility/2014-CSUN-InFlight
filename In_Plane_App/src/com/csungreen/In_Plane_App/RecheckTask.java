package com.csungreen.In_Plane_App;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.AsyncTask;
import org.apache.http.impl.client.*;
import org.apache.http.client.methods.*;
import java.util.*;
import org.apache.http.*;
import org.apache.http.message.*;
import android.provider.Settings.Secure;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import android.util.Log;
import android.app.Activity;

/**
 * Created by warren on 2/9/14.
 */
public class RecheckTask extends AsyncTask<Void, Void, String>{

    private Activity uiRef;

    public void init( Activity a ){
        uiRef = a;
    }

    public String doInBackground(Void...v){
        // TODO: Wait 15 seconds
        DefaultHttpClient httpcli;
        HttpPost httppost;
        Secure secure = new Secure();
        String deviceID = secure.ANDROID_ID;
        String result = "true";
        try {
            Thread.sleep( 5000 );
            httpcli = new DefaultHttpClient();
            httppost = new HttpPost("http://172.31.176.125/no_name_yet.php");
            ArrayList<NameValuePair> postParameters = new ArrayList<NameValuePair>();
            postParameters.add(new BasicNameValuePair("DeviceID", deviceID ));

            httppost.setEntity(new UrlEncodedFormEntity(postParameters));
            HttpResponse response = httpcli.execute(httppost);
            Log.i("postData", response.getStatusLine().toString());
            // TODO: Do something with response, like: result = response.toString();
        }
        catch(Exception e)
        {
            Log.e("kablooey", "Error:  "+e.toString());
        }
        return result;
    }

    public void onPostExecute( String s ){
        if( s  == "true" ){
            // Generate a "your turn" alert
            AlertDialog.Builder builder = new AlertDialog.Builder( uiRef );
            builder.setMessage("It's your turn for the bathroom!  Press OK when you've returned.");
            builder.setTitle("Restroom Queue");
            builder.setPositiveButton("I'm back.", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                    new DequeueTask().execute();
                }
            });
            AlertDialog dialog = builder.create();
            dialog.show();
        } else {
            // Do recheck task again.
            RecheckTask rTask = new RecheckTask();
            rTask.init( uiRef );
            rTask.execute();
        }
    }
}
