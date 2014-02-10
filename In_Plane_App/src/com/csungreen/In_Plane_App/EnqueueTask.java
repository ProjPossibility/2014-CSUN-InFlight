package com.csungreen.In_Plane_App;


import android.os.AsyncTask;
import org.apache.http.impl.client.*;
import org.apache.http.client.methods.*;
import org.apache.http.*;
import android.provider.Settings.Secure;
import android.util.Log;
import android.app.Activity;

public class EnqueueTask extends AsyncTask<Void, Void, String>{

    private Activity uiRef;

    public void init( Activity a ){
        uiRef = a;
    }


    public String doInBackground(Void...v){
        // TODO: Wait 15 seconds
        DefaultHttpClient httpcli;
        HttpGet httpget;
        String deviceID;
        deviceID = Secure.getString(uiRef.getContentResolver(), Secure.ANDROID_ID);
        String result = "true";
        try {
            httpcli = new DefaultHttpClient();
            httpget = new HttpGet("http://172.31.176.125/bathroomEnqueue.php?DeviceID='" + deviceID + "'" );
            HttpResponse response = httpcli.execute(httpget);
            Log.i("postData", response.getStatusLine().toString());
        }
        catch(Exception e)
        {
            Log.e("kablooey", "Error:  "+e.toString());
        }
        return result;
    }

    public void onPostExecute( String s ){
        // TODO: Confirmation popup
        RecheckTask rTask = new RecheckTask();
        rTask.init( uiRef );
        rTask.execute();
    }
}