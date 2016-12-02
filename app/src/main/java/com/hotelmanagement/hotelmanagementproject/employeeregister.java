package com.hotelmanagement.hotelmanagementproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class employeeregister extends AppCompatActivity {

    // linking button to receptionist page after the employee doing the registration
    public Button employeebut;
    public void buttonlinking(){
        employeebut = (Button)findViewById(R.id.employeeRegisterbut);
        employeebut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent register = new Intent(employeeregister.this, receptionisthomepage.class);
                startActivity(register);
            }
        });
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employeeregister);
        buttonlinking();
    }
}
