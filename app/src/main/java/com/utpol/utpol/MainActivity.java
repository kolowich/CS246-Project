package com.utpol.utpol;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.parse.Parse;
import com.parse.ParseUser;

public class MainActivity extends AppCompatActivity {

    private LoginValidator login;
    private HomeScreen home;
    private static final boolean PROTOTYPE = true;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //create the HomeScreen View
        home = new HomeScreen(this);

        //initialize the database's information so that we can contact it easily later
        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId("Qi6kBpZU4OCF3cj11qKtD3CB6FpFY45tHNTtLlj6")
                .clientKey(null)
                .server("https://utpol.herokuapp.com/parse/")
                .build());
        login();
    }

    public void login() {

        Login login = new Login();

        if(PROTOTYPE) {
            setContentView(R.layout.home_screen);
        }
        else {
            login.setUsername(""); //put the editText's string here
            login.setPassword(""); //put the editText's string here

            login.validateUserAndLogIn();
        }
    }

    public Login getLogin() {
        return login;
    }

    public void setLogin(Login login) {
        this.login = login;
    }

    public HomeScreen getHome() {
        return home;
    }

    public void setHome(HomeScreen home) {
        this.home = home;
    }
}
