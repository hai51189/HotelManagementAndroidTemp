package com.hotelmanagement.hotelmanagementproject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import android.app.DatePickerDialog;
import android.app.DatePickerDialog.OnDateSetListener;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

public class guesthomepage extends AppCompatActivity {

    // linking button to resandentertainment page after the guest click on button.
    public Button buttonRE;
    public void resandentertainment(){
        buttonRE = (Button)findViewById(R.id.REbutton);
        buttonRE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent register = new Intent(guesthomepage.this, resandentertainment.class);
                startActivity(register);
            }
        });
    }
    // endlinking button.


    //date picker declaration
    Calendar c = Calendar.getInstance();
    TextView DateCheckIndisplay;
    TextView DateCheckOutdisplay;
    int cday, cmonth, cyear;
    // end

    // room example
    private String[] rock = {
            "Room 100 / Type 2bed / Price $40",
            "Room 106 / Type 3bed / Price $70",
            "Room 201 / Type 1bed / Price $30",};
    // end


    // decalre array
    private ArrayList<String> arrayList;
    private ArrayAdapter<String> adapter1;
    private EditText txtInput;
    //
    private String datein;
    private String dateout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guesthomepage);
        resandentertainment(); // linking to resandentertainment page



        // start function listview room hotel.
        //start make listview.
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,R.layout.list_view_custom_layout,R.id.list_item,rock);
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

        //listvew for room result
        ListView listView = (ListView)findViewById(R.id.RoomResult);
        String[] items =new String[0];
        arrayList = new ArrayList<>(Arrays.asList(items));
        adapter1 = new ArrayAdapter<String>(this,R.layout.list_item,R.id.txtitem,arrayList);
        listView.setAdapter(adapter1);
        txtInput=(EditText)findViewById(R.id.txtinput);
        Button btAdd = (Button)findViewById(R.id.GuestReservationButton);
        btAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int newItem= Integer.parseInt(txtInput.getText().toString());

                if( newItem == 100 || newItem == 106 ) {
                    arrayList.add("Booked Room # " + String.valueOf(newItem) + " From " + datein  +" To " + dateout );
                    adapter1.notifyDataSetChanged();
                }
                else if (newItem == 201)
                {
                    arrayList.add("Booked Room # " + String.valueOf(newItem) + " From " + datein  +" To " + dateout );
                    adapter1.notifyDataSetChanged();
                }
                else
                {
                    Context context = getApplicationContext();
                    CharSequence text1 = "Please Choose the right room #";
                    int dur = Toast.LENGTH_SHORT;

                    Toast toast = Toast.makeText(context, text1, dur);
                    toast.show();
                }
            }
        });


        final Button deletebut = (Button) findViewById(R.id.GuestCancelReservationButton);
        deletebut.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {
                arrayList.clear();
                adapter1.notifyDataSetChanged();
            }
        });

        //Date pick
        //date picker checkin implement
        Button datecheckin = (Button) findViewById(R.id.DateCheckInButton);
        DateCheckIndisplay = (TextView) findViewById(R.id.DateCheckInDisplay);
        datecheckin.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                new DatePickerDialog(guesthomepage.this, d,c.get(Calendar.YEAR), c.get(Calendar.MONTH),
                        c.get(Calendar.DAY_OF_MONTH)).show();

            }
        });// end date checkin implement

        //date picker checkout implement
        Button datecheckout = (Button) findViewById(R.id.DateCheckOutButton);
        DateCheckOutdisplay = (TextView) findViewById(R.id.DateCheckOutDisplay);
        datecheckout.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                new DatePickerDialog(guesthomepage.this, e,c.get(Calendar.YEAR), c.get(Calendar.MONTH),
                        c.get(Calendar.DAY_OF_MONTH)).show();
            }
        });// end date checkin implement
    }
//-----------------------------------------------------------------------------------
    // function call of date picker dialog
    DatePickerDialog.OnDateSetListener d = new OnDateSetListener() {

        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear,
                              int dayOfMonth) {

            cday = dayOfMonth;
            cmonth = monthOfYear + 1;
            cyear = year;

            DateCheckIndisplay.setText("Selected Day: " + cday + "/" + cmonth + "/"
                    + cyear);
            datein = ( cday + "/" + cmonth + "/"+ cyear);

        }
    };// end function call of datepicker
    // function call of date picker dialog
    DatePickerDialog.OnDateSetListener e = new OnDateSetListener() {

        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear,
                                int dayOfMonth ) {

            cday = dayOfMonth;
            cmonth = monthOfYear + 1;
            cyear = year;

            DateCheckOutdisplay.setText("Selected Day: " + cday + "/" + cmonth + "/"
                    + cyear);
            dateout = ( cday + "/" + cmonth + "/"+ cyear);

        }
    };// end function call of datepicker
//--------------------------------------------------------------------------------------------


    //Message for reservation button.
    public void MakeReservation(View view){
        Context context = getApplicationContext();
        CharSequence text = "Sucess Make Reservation";
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }
    public void CancelReservation(View view){
        Context context = getApplicationContext();
        CharSequence text = "Reservation Cancelled";
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }
    //end message for reservation button
    // -----------------------------------------------------------------------






}

