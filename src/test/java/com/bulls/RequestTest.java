package com.bulls;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class RequestTest {
    Request request;

    @Test
    public void receivesRequest() throws Exception {
        request = new Request("GET /form HTTP/1.1\n");
        assertEquals("GET /form HTTP/1.1\n", request.getRawRequest());
    }

    @Test
    public void parsesRequestType() throws Exception {
        request = new Request("GET /form HTTP/1.1\n");
        assertEquals("GET", request.getMethod());
        assertEquals("/form", request.getUri());
        assertEquals("HTTP/1.1", request.getVersion());
    }

    @Test
    public void parsesHeadersByType() throws Exception {
        request = new Request("GET /form HTTP/1.1\nContent:stuff\nAccept:text/html\nContent-type:json");
        assertEquals("stuff", request.getHeaderByType("Content"));
        assertEquals("text/html", request.getHeaderByType("Accept"));
        assertEquals("json", request.getHeaderByType("Content-type"));
        assertEquals(null, request.getHeaderByType("fake"));
    }

    @Test
    public void parsesBodyByType() throws Exception {
        request = new Request("GET /form HTTP/1.1\nContent:stuff\nAccept:text/html\nContent-type:json");
        assertEquals(null, request.getBodyByType("Data"));

        Request request1 = new Request("GET /form HTTP/1.1\nContent:stuff\nAccept:text/html\nContent-type:json\r\nData:stuff&Data1:stuff1");
        assertEquals("stuff", request1.getBodyByType("Data") );
        assertEquals("stuff1", request1.getBodyByType("Data1") );
    }
}
