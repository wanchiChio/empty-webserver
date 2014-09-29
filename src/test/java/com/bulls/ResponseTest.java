package com.bulls;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by wanchi.chio on 9/24/14.
 */
public class ResponseTest {
    public Response response;

    @Before
    public void setUp() {
        response = new Response("124", "Message");
    }

    @Test
    public void verifyResponseCode() throws Exception {
        assertEquals("124", response.getResponseCode());
    }

    @Test
    public void verifyBody() throws Exception {
       assertEquals("Message", response.getBody());
    }

    @Test
    public void verifyResponseOutput() throws Exception {
       assertEquals("HTTP/1.1 " + response.getResponseCode() +
               "\r\n\r\n" + response.getBody(), response.generateFullResponse());
    }


    @Test
    public void verifyHeader() throws Exception
    {
       response.addHeader("Allow: GET,OPTION");
       assertEquals("Allow: GET,OPTION", response.getHeaders());
    }

    @Test
    public void verifyHeaderInfoInResponse() throws Exception
    {
        response.addHeader("Allow: GET,OPTION");

        assertEquals("HTTP/1.1 " + response.getResponseCode() +
                "\r\n" + response.getHeaders() +
                "\r\n\r\n" + response.getBody(), response.generateFullResponse());

    }

}
