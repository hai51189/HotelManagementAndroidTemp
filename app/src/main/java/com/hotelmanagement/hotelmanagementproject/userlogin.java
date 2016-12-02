package com.hotelmanagement.hotelmanagementproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class userlogin extends AppCompatActivity {


    // register button linking guest login page to user register page.
   public Button userregisterbut;
    public void userbregister(){
        userregisterbut = (Button)findViewById(R.id.GuestRegisterButton);
        userregisterbut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent register = new Intent(userlogin.this, userregister.class);
                startActivity(register);
            }
        });
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userlogin);
        userbregister();

    }
}
