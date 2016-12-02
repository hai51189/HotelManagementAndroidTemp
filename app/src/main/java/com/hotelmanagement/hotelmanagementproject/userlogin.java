package com.hotelmanagement.hotelmanagementproject;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;


public class userlogin extends AppCompatActivity {

    private String token;

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


    public Button userloginbut;
    public void userlogin(){
        userloginbut = (Button)findViewById(R.id.LoginButton);
        userloginbut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                EditText emailInput = (EditText)findViewById(R.id.LoginEmailField);
                String email = emailInput.getText().toString();

                EditText passwordInput = (EditText)findViewById(R.id.LoginPassWordField);
                String password = passwordInput.getText().toString();

                // 1. create HttpClient
                HttpClient httpclient = new DefaultHttpClient();

                // 2. make POST request to the given URL
                HttpPost httpPost = new HttpPost(url);

                String json = "";

                // 3. build jsonObject
                JSONObject jsonObject = new JSONObject();
                jsonObject.accumulate("email", email);
                jsonObject.accumulate("password", password);

                // 4. convert JSONObject to JSON to String
                json = jsonObject.toString();

                // ** Alternative way to convert Person object to JSON string usin Jackson Lib
                // ObjectMapper mapper = new ObjectMapper();
                // json = mapper.writeValueAsString(person);

                // 5. set json to StringEntity
                StringEntity se = new StringEntity(json);

                // 6. set httpPost Entity
                httpPost.setEntity(se);

                // 7. Set some headers to inform server about the type of the content
                httpPost.setHeader("Accept", "application/json");
                httpPost.setHeader("Content-type", "application/json");

                // 8. Execute POST request to the given URL
                HttpResponse httpResponse = httpclient.execute(httpPost);

                // 9. receive response as inputStream
                inputStream = httpResponse.getEntity().getContent();

                // 10. convert inputstream to string
                if(inputStream != null)
                    result = convertInputStreamToString(inputStream);
                else
                    result = "Did not work!";

                try {
                    JSONObject response = new JSONObject(result);
                    JSONObject status = response.getJSONObject("status");
                    if (status.getBoolean("success")) {
                        token = status.getString("token");
                        Intent login = new Intent(userlogin.this, guesthomepage.class);
                        startActivity(login);
                    } else {
                        Context context = getApplicationContext();
                        CharSequence text = status.getString("errorMessage");
                        int duration = Toast.LENGTH_SHORT;
                        Toast toast = Toast.makeText(context, text, duration);
                        toast.show();
                    }
                } catch(JSONException e) {
                    Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
                }

                // Parse JSON data from result
                /*

                {
                    "status": {
                        "success": true
                    },
                    "token": "somestring"
                }

                {
                    "status": {
                        "success": false,
                        "errorMessage": "Login failed"
                    }
                }

                 */

            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userlogin);
        userbregister();
        userlogin();

    }


}
