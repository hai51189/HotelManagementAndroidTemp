package com.hotelmanagement.hotelmanagementproject;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class manager extends AppCompatActivity {

    // room example
    String[] roomlist = {
            "Room 100 / Type 2bed / Price $40",
            "Room 106 / Type 3bed / Price $70",
            "Room 201 / Type 1bed / Price $30",};
    // end

    // another test comment
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manager);


        //start make listview.
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,R.layout.list_view_custom_layout,R.id.list_item,roomlist);
        ListView relistview =  (ListView) findViewById(R.id.RoomListView);
        relistview.setAdapter(adapter);
        relistview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getBaseContext(),adapterView.getItemIdAtPosition(i)+" is selected", Toast.LENGTH_SHORT).show();
                view.setSelected(true);
            }
        });
        //end listview
    }




    //-------------------------------------------------------------------
    //Message for reservation button.
    public void MMakeReservation(View view){
        Context context = getApplicationContext();
        CharSequence text = "Sucess Make Reservation";
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }
    public void MCancelReservation(View view){
        Context context = getApplicationContext();
        CharSequence text = "Reservation Cancelled";
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }
    public void AddRoomMessage(View view){
        Context context = getApplicationContext();
        CharSequence text = "Sucess Add A Room.";
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }
    //end message for reservation button
    // -----------------------------------------------------------------------




}
