package com.hotelmanagement.hotelmanagementproject;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.List;

public class resandentertainment extends AppCompatActivity {

    // after view the entertainment homebutton transfer them back to guest homepage.
    public Button homebut;
    public void homepagebut(){
        homebut = (Button)findViewById(R.id.GHbutton);
        homebut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent register = new Intent(resandentertainment.this, guesthomepage.class);
                startActivity(register);
            }
        });
    }

    // list of restaurant and theme park information


    String[] name = {
            "Kobe Japanese Steak House",
            "Ale House",
            "Chipotle",
            "Disney",
            "SeaWorld",
            "Universal"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resandentertainment);
        homepagebut();

        // the display for listview.
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_expandable_list_item_1,name);
        ListView relistview =  (ListView) findViewById(R.id.RElistView);
        relistview.setAdapter(adapter);

        relistview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    String url = "https://kobesteakhouse.com/current-promotions/";
                    Intent i = new Intent(Intent.ACTION_VIEW);
                    i.setData(Uri.parse(url));
                    startActivity(i);
                }
                if (position == 1) {
                    String url1 = "https://millersalehouse.com/specials/";
                    Intent i1 = new Intent(Intent.ACTION_VIEW);
                    i1.setData(Uri.parse(url1));
                    startActivity(i1);
                }
                if (position == 2) {
                    String url2 = "https://chipotle.com/whats-happening";
                    Intent i2 = new Intent(Intent.ACTION_VIEW);
                    i2.setData(Uri.parse(url2));
                    startActivity(i2);
                }
                if(position == 3) {
                    String url3 = "https://disneyworld.disney.go.com/special-offers/";
                    Intent i3 = new Intent(Intent.ACTION_VIEW);
                    i3.setData(Uri.parse(url3));
                    startActivity(i3);
                }
                if(position == 4) {
                    String url4 = "https://seaworldparks.com/en/seaworld-orlando/book-online/3-months-free/annual-pass";
                    Intent i4 = new Intent(Intent.ACTION_VIEW);
                    i4.setData(Uri.parse(url4));
                    startActivity(i4);
                }
                if (position == 5) {
                    String url5 = "https://www.universalorlando.com/Theme-Park-Tickets/Hot-Deals.aspx";
                    Intent i5 = new Intent(Intent.ACTION_VIEW);
                    i5.setData(Uri.parse(url5));
                    startActivity(i5);
                }
            }
        });
        // end display and linking list view.
    }

}
