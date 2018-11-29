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

    public static boolean isValidated() {
        return validated;
    }

    public static ParseUser getMainUser() {
        return mainUser;
    }

    public void validateUserAndLogIn() {

        ParseUser.logInInBackground(username, password, new LogInCallback() {
            public void done(ParseUser user, ParseException e) {
                if (e == null) {
                    validated = true;
                    mainUser = user;
                    MainActivity.checkValidation();
                }
                else {
                    e.printStackTrace();
                    validated = false;
                    MainActivity.checkValidation();
                }
            }
        });

        username = null;
        password = null;

        return;
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
