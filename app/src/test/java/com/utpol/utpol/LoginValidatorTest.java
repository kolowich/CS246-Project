package com.utpol.utpol;

import org.junit.Test;
import com.utpol.utpol.LoginValidator;

public class LoginValidatorTest {
    @Test
    public void loginValidator_userExists_ReturnsTrue() {
        LoginValidator validator = new LoginValidator("Username" , "Password");
        validator.validate();

        assert(loginValidator.isValidLogin()).isTrue();
    }
}
