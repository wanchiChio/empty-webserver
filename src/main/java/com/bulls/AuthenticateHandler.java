package com.bulls;

import com.sun.org.apache.xml.internal.security.exceptions.Base64DecodingException;
import com.sun.org.apache.xml.internal.security.utils.Base64;

import java.io.UnsupportedEncodingException;
import java.util.regex.Pattern;

public class AuthenticateHandler extends RequestHandler {

    private String requestHeaders;

    @Override
    public boolean processRequest(String data) {
        String auth = "";
        String[] lines = data.split("\n");
        for(int i=0; i < lines.length; i++){
            boolean authExists = Pattern.matches("Authorization: Basic ", lines[i]);
            if (authExists)  {
                auth = lines[i];
                break;
            }
        }

        if (auth.length() <= 0) {
            response = new Response("401", "", "Authentication required");
            return true;
        }
        else {

            response = new Response("401", "", "Authentication required");
            return true;
        }
    }


    public void setRequestHeaders(String requestHeaders) {
        this.requestHeaders = requestHeaders;
    }

    public String getRequestHeaders() {
        return requestHeaders;
    }

    public String decodeCredentials(String encoded) {

        String decoded = "";
        try {
            decoded = new String(Base64.decode(encoded), "utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (Base64DecodingException e) {
            e.printStackTrace();
        }

        return decoded;

    }
}
