package com.csungreen.In_Plane_App;


import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.AsyncTask;
import org.apache.http.impl.client.*;
import org.apache.http.client.methods.*;
import org.apache.http.*;
import android.provider.Settings.Secure;
import android.util.Log;
import android.app.Activity;
import org.apache.http.util.EntityUtils;

public class RecheckTask extends AsyncTask<Void, Void, String>{

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
        String result = "";
        try {
            Thread.sleep( 5000 );
            httpcli = new DefaultHttpClient();

            httpget = new HttpGet("http://172.31.176.125/update.php?DeviceID='" + deviceID + "'" );
            HttpResponse response = httpcli.execute(httpget);
            result = EntityUtils.toString( response.getEntity() );

            Log.i("postData", response.getStatusLine().toString() + " ...The response was " + result );
            // TODO: Do something with response, like: result = response.toString();
        }
        catch(Exception e)
        {
            Log.e("kablooey", "Error:  "+e.toString());
        }
        return result;
    }

    public void onPostExecute( String s ){
        if( s.equals( "1" ) ){

            AlertDialog.Builder builder = new AlertDialog.Builder( uiRef );
            builder.setMessage("It's your turn for the bathroom!  Press OK when you've returned.");
            builder.setTitle("Restroom Queue");
            builder.setPositiveButton("I'm back.", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                    doDequeue();
                }
            });
            builder.setCancelable(false);
            AlertDialog dialog = builder.create();
            dialog.show();
        } else {
            // Do recheck task again.
            RecheckTask rTask = new RecheckTask();
            rTask.init( uiRef );
            rTask.execute();
        }
    }

    private void doDequeue(){
        DequeueTask dTask = new DequeueTask();
        dTask.init(uiRef);
        dTask.execute();

    }

}
