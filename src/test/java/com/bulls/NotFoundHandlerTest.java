package com.bulls;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by wanchi.chio on 9/24/14.
 */
public class NotFoundHandlerTest {

    private NotFoundHandler handler;

    @Before
    public void setUp() {
        handler = new NotFoundHandler();
        handler.setEndPoint("/redirect");
    }

    @Test
    public void verifyResponseCode() throws Exception {
        handler.processRequest();

        assertEquals("404", handler.getResponseCode());
    }
}
