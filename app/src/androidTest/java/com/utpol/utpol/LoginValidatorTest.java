package com.utpol.utpol;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertTrue;

import com.parse.Parse;

@RunWith(AndroidJUnit4.class)
public class LoginValidatorTest {
    @Test
    public void loginValidator_userExistsTest() {
        Context context = InstrumentationRegistry.getTargetContext();
        Parse.initialize(new Parse.Configuration.Builder(context)
                .applicationId("Qi6kBpZU4OCF3cj11qKtD3CB6FpFY45tHNTtLlj6")
                .clientKey(null)
                .server("https://utpol.herokuapp.com/parse/")
                .build());

        LoginValidator validator = new LoginValidator("Adamkolowich" , "82^Zt@0X7%@8");
        validator.validateUserAndLogIn();

        assertTrue(validator.isValidated());
    }
}
