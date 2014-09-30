package com.bulls;

import org.junit.Before;
import org.junit.Test;

import java.io.File;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by anton.perez on 9/30/14.
 */
public class DirectoryListingTest {

    DirectoryHandler handler;

    @Before
    public void setUp() {
        handler = new DirectoryHandler();
    }

    @Test
    public void itReturns200() throws Exception {
        handler.processRequest("GET / HTTP/1.1");

        assertEquals("200", handler.getResponseCode());
    }

    @Test
    public void itChecksIfDirectoryNotNull() throws Exception {
        File[] result = handler.getDirectoryContents("src/main/resources/public/");

        assertNotNull(result);
    }

}
