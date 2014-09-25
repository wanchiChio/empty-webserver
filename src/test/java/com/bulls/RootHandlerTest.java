package com.bulls;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by anton.perez on 9/24/14.
 */
public class RootHandlerTest {

    @Test
    public void testRootHandler() throws Exception {
        RootHandler handler = new RootHandler();
        handler.processRequest("");

        assertEquals("200", handler.getResponseCode());
    }

}
