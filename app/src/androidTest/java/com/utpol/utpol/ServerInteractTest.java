package com.utpol.utpol;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.util.Log;

import com.parse.LogInCallback;
import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseUser;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

@RunWith(AndroidJUnit4.class)
public class ServerInteractTest {
    @Test
    public void TestServerInteraction() {
        Context context = InstrumentationRegistry.getTargetContext();
        Log.d("utpol","initializing parse");
        Parse.initialize(new Parse.Configuration.Builder(context)
                .applicationId("Qi6kBpZU4OCF3cj11qKtD3CB6FpFY45tHNTtLlj6")
                .clientKey(null)
                .server("https://utpol.herokuapp.com/parse/")
                .build());

        System.out.println("initialized");


        Interact interact = new Interact();

        interact.setRequest("Person");
        interact.serverRequest();

        assertNotNull(interact.getResponse());
    }
}
