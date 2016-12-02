package com.hotelmanagement.hotelmanagementproject;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class receptionisthomepage extends AppCompatActivity {


    // room example
    String[] roomlist = {
            "Room 100 / Type 2bed / Price $40",
            "Room 106 / Type 3bed / Price $70",
            "Room 201 / Type 1bed / Price $30",};
    // end


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receptionisthomepage);

        //start make listview.
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,R.layout.list_view_custom_layout,R.id.list_item,roomlist);
        ListView relistview =  (ListView) findViewById(R.id.RoonListView);
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


    //--------------------------------------------------------------------------------------------
    //Message for reservation button.
    public void CheckInMessage(View view){
        Context context = getApplicationContext();
        CharSequence text = "Successfully Check In";
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }
    public void CheckOutMessage(View view){
        Context context = getApplicationContext();
        CharSequence text = "Successfully Check Out";
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }
    //end message for reservation button
    // -----------------------------------------------------------------------

}
