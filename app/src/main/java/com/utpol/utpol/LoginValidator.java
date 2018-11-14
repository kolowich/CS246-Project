package com.utpol.utpol;

import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseUser;

public class LoginValidator {

    private String username;
    private String password;

    private static boolean validated = false;
    private static ParseUser mainUser;

    public LoginValidator(){
        username = null;
        password = null;
    }

    public LoginValidator(String user, String pass) {
        username = user;
        password = pass;
    }

    public boolean validateUserAndLogIn() {

        ParseUser.logInInBackground(username, password, new LogInCallback() {
            public void done(ParseUser user, ParseException e) {
                if (e == null) {
                    validated = true;
                    mainUser = user;
                }
                else {
                    e.printStackTrace();
                }
            }
        });

        username = null;
        password = null;

        return validated;
    }

    public void logOut() {
        ParseUser.logOutInBackground();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
