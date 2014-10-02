package com.bulls;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by anton.perez on 9/29/14.
 */
public class FileHandlerTest {

    private FileHandler handler = null;

    @Before
    public void setUp() {
        handler = new FileHandler();
    }

    @Test
    public void verifyPutMethodIsNotAllowed() throws Exception {
        handler.setHttpMethod("PUT");
        handler.processRequest("PUT /file1 HTTP/1.1");

        assertEquals("405", handler.getResponseCode());
    }

    @Test
    public void verifyPostMethodIsNotAllowed() throws Exception {
        handler.setHttpMethod("POST");
        handler.processRequest("POST //text-file.txt HTTP/1.1");

        assertEquals("405", handler.getResponseCode());
    }

    @Test
    public void testIfFile1Exists() throws Exception {
        String result = handler.readFile("src/main/resources/public/file1");

        assertNotNull(result);
    }

    @Test
    public void testIfTextFileTxtExists() throws Exception {
        String result = handler.readFile("src/main/resources/public/text-file.txt");

        assertNotNull(result);
    }

    @Test
    public void testNonExistentPathReturns404() throws Exception {
        handler.setHttpMethod("GET");
        handler.processRequest("GET /nonexistent HTTP/1.1");

        assertEquals("404", handler.getResponseCode());
    }

    @Test
    public void testNonExistentPathReturns404Body() throws Exception {
        handler.setHttpMethod("GET");
        handler.processRequest("GET /nonexistent HTTP/1.1");

        assertEquals("404! What you're looking for ain't here, yo!", handler.getResponseBody());
    }

}
