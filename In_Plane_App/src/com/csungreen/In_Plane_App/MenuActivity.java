package com.csungreen.In_Plane_App;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.DataSetObserver;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;

import java.util.ArrayList;

public class MenuActivity extends Activity {
    ListView listView;
    ArrayList<String> cart;
    int total = 0;
    Context context = this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Get the layout from video_main.xml
        setContentView(R.layout.menu);
        listView =(ListView) findViewById(R.id.listView);
        float size = getIntent().getFloatExtra("FontSize",20);
        cart = new ArrayList<String>();
        ArrayList<String> your_array_list = new ArrayList<String>();
        your_array_list.add("Burger");
        your_array_list.add("Jack and Coke");
        your_array_list.add("Twinkie");
        your_array_list.add("Purchase");

        // This is the array adapter, it takes the context of the activity as a
        // first parameter, the type of list view as a second parameter and your
        // array as a third parameter.
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                your_array_list );

        listView.setAdapter(arrayAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        cart.add("Burger");
                        total+=5;
                        break;
                    case 1:
                        cart.add("Jack and Coke");
                        total+=3;
                        break;
                    case 2:
                        cart.add("Twinkie");
                        total+=2;
                        break;
                    case 3:
                        AlertDialog.Builder builder = new AlertDialog.Builder(context);
                        String purchase = "Purchase:";
                        for(int i = 0; i < cart.size(); i++){
                            purchase += cart.get(i)+"\n";
                        }
                        purchase+= "for $"+total;
                        builder.setMessage(purchase);
                        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                cart.clear();
                                total=0;
                            }
                        });
                        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                cart.clear();
                                total=0;
                            }
                        });
                        AlertDialog a = builder.create();
                        a.show();
                        break;
                }
            }
        });

    }
}
