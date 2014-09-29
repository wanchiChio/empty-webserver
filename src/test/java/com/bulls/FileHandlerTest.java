package com.bulls;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

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
    public void testResponseCode() throws Exception {
        handler.processRequest("");

        assertEquals("200", handler.getResponseCode());
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
        boolean result = handler.processFile("../cob_spec/public/file1");

        assertEquals(true, result);
    }

    @Test
    public void testIfTextFileTxtExists() throws Exception {
        boolean result = handler.processFile("../cob_spec/public/text-file.txt");

        assertEquals(true, result);
    }
}
