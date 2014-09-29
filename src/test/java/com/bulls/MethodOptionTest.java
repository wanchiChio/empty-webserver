package com.bulls;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by wanchi.chio on 9/29/14.
 */
public class MethodOptionTest {
    @Test
    public void testResponseCode() throws Exception
    {
        MethodOptionHandler moh = new MethodOptionHandler();

        moh.processRequest("");
        assertEquals("200", moh.getResponseCode());

    }

    @Test
    public void testOthersMethodHeader() throws Exception
    {
        MethodOptionHandler moh = new MethodOptionHandler();
        moh.processRequest("GET /method_options HTTP/1.1");
        assertNotEquals("Allow: GET,HEAD,POST,OPTIONS,PUT", moh.getResponseHeader());
    }

    @Test
    public void testOptionsMethodHeader() throws Exception
    {
        MethodOptionHandler moh = new MethodOptionHandler();
        moh.setHttpMethod("OPTIONS");
        moh.processRequest("OPTIONS /method_options HTTP/1.1");
        assertEquals("Allow: GET,HEAD,POST,OPTIONS,PUT", moh.getResponseHeader());
    }
}
