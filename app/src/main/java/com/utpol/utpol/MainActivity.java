package com.utpol.utpol;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.Parse;
import com.parse.ParseUser;

public class MainActivity extends AppCompatActivity {

    private LoginValidator login;
    private HomeScreen home;
    private static final boolean PROTOTYPE = true;
    private SharedPreferences sharedPreferences = this.getSharedPreferences("utpol", MODE_PRIVATE);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String location = sharedPreferences.getString(HomeScreen.LOCATION, "Unknown Location");
        //create the HomeScreen View
        home = new HomeScreen(this, location);

        //initialize the database's information so that we can contact it easily later
        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId("Qi6kBpZU4OCF3cj11qKtD3CB6FpFY45tHNTtLlj6")
                .clientKey(null)
                .server("https://utpol.herokuapp.com/parse/")
                .build());
    }

    public void login(View view) {

        LoginValidator login = new LoginValidator();

        EditText user = (EditText) findViewById(R.id.editText3);
        EditText pass = (EditText) findViewById(R.id.editText);

        String userName = user.getText().toString();
        String password = pass.getText().toString();

        if(PROTOTYPE) {
            setContentView(R.layout.home_screen);
        }
        else {
            login.setUsername(userName); //put the editText's string here
            login.setPassword(password); //put the editText's string here

            boolean valid = login.validateUserAndLogIn();

            if(valid) {
               setContentView(R.layout.home_screen);
            }
            else {
                Toast toast = new Toast(this);
                toast.setText("Username or Password are incorrect");
                toast.show();
            }
        }
    }

    public LoginValidator getLogin() {
        return login;
    }

    public void setLogin(LoginValidator login) {
        this.login = login;
    }

    public HomeScreen getHome() {
        return home;
    }

    public void setHome(HomeScreen home) {
        this.home = home;
    }

    public SharedPreferences getSharedPreferencesObject() {
        return sharedPreferences;
    }
}
