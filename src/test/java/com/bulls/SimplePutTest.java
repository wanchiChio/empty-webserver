package com.bulls;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SimplePutTest {

    @Test
    public void testPutCode() throws Exception
    {
        FormHandler handler = new FormHandler();
        handler.processRequest("PUT /form HTTP/1.1");
        assertEquals("200", handler.getResponseCode());

    }

    @Test
    public void testPostCode() throws Exception
    {
        FormHandler handler = new FormHandler();
        handler.processRequest("POST /form HTTP/1.1");
        assertEquals("200", handler.getResponseCode());
    }



}
