package com.bulls;


import java.io.UnsupportedEncodingException;
import java.util.Base64;
import java.util.regex.Pattern;

public class AuthenticateHandler extends RequestHandler {

    private String requestHeaders;

    @Override
    public boolean processRequest(String data) {
        String auth = "";
        String[] lines = data.split("\n");
        for(int i=0; i < lines.length; i++){
            boolean authExists = Pattern.matches("Authorization: Basic .*", lines[i]);
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
            String fields[] = auth.split(" ");
            if (fields.length > 2 && decodeCredentials(fields[2]).equals("admin:hunter2") ) {
                response = new Response("200", "", "Authentication required");
                return true;
            }
            else {

                response = new Response("401", "", "Authentication required");
                return true;
            }
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
            decoded = new String(Base64.getDecoder().decode(encoded), "utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        return decoded;

    }

}
