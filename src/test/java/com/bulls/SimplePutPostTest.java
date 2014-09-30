package com.bulls;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SimplePutPostTest {
    FormHandler handler;

    @Before
    public void setUp() {
        handler = new FormHandler();
    }

    @Test
    public void testPutCode() throws Exception
    {
        handler.processRequest("PUT /form HTTP/1.1");
        assertEquals("200", handler.getResponseCode());
    }

    @Test
    public void testPostCode() throws Exception
    {
        handler.processRequest("POST /form HTTP/1.1");
        assertEquals("200", handler.getResponseCode());
    }

}
