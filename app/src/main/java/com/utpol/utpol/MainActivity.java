package com.utpol.utpol;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Point;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.Parse;
import com.parse.ParseUser;

public class MainActivity extends AppCompatActivity {

    private static LoginValidator login;
    private static HomeScreen home;
    private static final boolean PROTOTYPE = true;
    //private SharedPreferences sharedPreferences = this.getSharedPreferences("utpol", MODE_PRIVATE);
    private static long animationDuration = 1;
    private static ConstraintLayout homeView = null;
    private static ConstraintLayout loginView = null;
    private static ConstraintLayout navigationView = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //String location = sharedPreferences.getString(HomeScreen.LOCATION, "Unknown Location");
        //create the HomeScreen View
        home = new HomeScreen(this, null);
        homeView = findViewById(R.id.home_overlay);
        loginView = findViewById(R.id.login_overlay);
        navigationView = findViewById(R.id.navigation_overlay);


        //get the size of the screen/window
        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);

        //translate the forest_overlay off screen without animation before anyone can see it
        homeView.setX(size.x);
        navigationView.setX(size.x);
        loginView.setX(new Point(0,0).x);

        //initialize the database's information so that we can contact it easily later
        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId("Qi6kBpZU4OCF3cj11qKtD3CB6FpFY45tHNTtLlj6")
                .clientKey(null)
                .server("https://utpol.herokuapp.com/parse/")
                .build());
    }

    public void login(View view) {
        login = new LoginValidator();

        EditText user = (EditText) findViewById(R.id.editText3);
        EditText pass = (EditText) findViewById(R.id.editText);

        String userName = user.getText().toString();
        String password = pass.getText().toString();

        if(PROTOTYPE) {
            loginView.animate().x(loginView.getWidth()).setDuration(animationDuration);
            homeView.animate().x(0).setDuration(animationDuration);
            navigationView.animate().x(0).setDuration(animationDuration);
        }
        else {
            login.setUsername(userName); //put the editText's string here
            login.setPassword(password); //put the editText's string here

            login.validateUserAndLogIn();

            Toast toast = Toast.makeText(this,"Logging in", (int) 1000);
            toast.show();
        }
    }

    public static void checkValidation() {
        if(login != null && home != null) {
            if (login.isValidated()) {
                loginView.animate().x(loginView.getWidth()).setDuration(animationDuration);
                homeView.animate().x(0).setDuration(animationDuration);
                navigationView.animate().x(0).setDuration(animationDuration);
            } else {
                Toast toast = Toast.makeText(home.getContext(),"Username or Password are incorrect", (int) 1000);
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

    /*
    public SharedPreferences getSharedPreferencesObject() {
        return sharedPreferences;
    }
    */
}
