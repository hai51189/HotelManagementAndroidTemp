package com.hotelmanagement.hotelmanagementproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class userregister extends AppCompatActivity {

    // linking button to guest home page after the guest doing the registration
    public Button button;
    public void guestregister(){
        button = (Button)findViewById(R.id.GuestRegisterButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent register = new Intent(userregister.this, guesthomepage.class);
                startActivity(register);
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userregister);
        guestregister();
    }
}
