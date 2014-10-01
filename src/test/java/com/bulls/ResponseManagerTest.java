package com.bulls;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by wanchi.chio on 10/1/14.
 */
public class ResponseManagerTest {
    @Test
    public void testGenerateOutput() throws Exception
    {
        ResponseManager rm = new ResponseManager();
        Mocket mocket = new Mocket("GET /logs HTTP/1.1");
        rm.generateOutput(mocket);
        assertTrue(mocket.isClosed());
    }
}
