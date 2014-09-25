package com.bulls;

import org.junit.Before;
import org.junit.Test;

import java.util.Base64;

import static org.junit.Assert.assertEquals;

public class AuthenticateTest {

    private AuthenticateHandler handler;

    @Before
    public void setup() {
        handler = new AuthenticateHandler();
        handler.setEndPoint("/logs");
    }

    @Test
    public void authenticationFail() throws Exception {
        handler.processRequest();

        assertEquals("401", handler.getResponseCode());
    }

    @Test
    public void authenticationFailedBodyResponse() throws Exception {
        handler.processRequest();
        assertEquals("Authentication required", handler.getResponseBody());
    }

    @Test
    public void encodeCredentialsInHeader() throws Exception {
        String encodedCredentials = Base64.getEncoder().encodeToString("admin:hunter2".getBytes("utf-8"));
        handler.setRequestHeaders("Authorization: Basic #".concat(encodedCredentials));


        assertEquals("Authorization: Basic #YWRtaW46aHVudGVyMg==", handler.getRequestHeaders());
    }

    @Test
    public void ableToDecodeEncodedCredentials() throws Exception {
        String encoded = Base64.getEncoder().encodeToString("admin:hunter2".getBytes("utf-8"));
        handler.setRequestHeaders("Authorization: Basic ".concat(encoded));

        String decoded = new String(Base64.getDecoder().decode(encoded), "utf-8");

        assertEquals("admin:hunter2", decoded);
    }

}
