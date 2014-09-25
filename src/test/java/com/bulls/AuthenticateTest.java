package com.bulls;

import com.sun.org.apache.xml.internal.security.utils.Base64;
import org.junit.Before;
import org.junit.Test;

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
        String encoded = Base64.encode("admin:hunter2".getBytes("utf-8"));
        handler.setRequestHeaders("Authorization: Basic #".concat(encoded));

        assertEquals("Authorization: Basic #YWRtaW46aHVudGVyMg==", handler.getRequestHeaders());
    }

    @Test
    public void ableToDecodeEncodedCredentials() throws Exception {
        String encoded = Base64.encode("admin:hunter2".getBytes("utf-8"));
        handler.setRequestHeaders("Authorization: Basic ".concat(encoded));
        String decoded = new String(Base64.decode(encoded), "utf-8");

        assertEquals("admin:hunter2", decoded);
    }

}
