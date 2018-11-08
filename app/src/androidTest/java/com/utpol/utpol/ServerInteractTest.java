package com.utpol.utpol;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

@RunWith(AndroidJUnit4.class)
public class ServerInteractTest {
    @Test
    public void TestServerInteraction() {
        Context app = InstrumentationRegistry.getContext();
        Interact interact = new Interact();

        interact.setRequest("");

        assertNotNull(interact.getResponse());
    }
}
