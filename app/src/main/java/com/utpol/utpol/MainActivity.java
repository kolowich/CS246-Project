package com.utpol.utpol;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private Login login;
    private HomeScreen home;
    private boolean prototype = true;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // comment
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

    public boolean isPrototype() {
        return prototype;
    }

    public void setPrototype(boolean prototype) {
        this.prototype = prototype;
    }
}
