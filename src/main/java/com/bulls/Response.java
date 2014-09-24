package com.bulls;

public class Response {

    protected String responseCode;
    protected String redirectPath;
    protected String body;

    public Response() {}

    public Response(String responseCode, String redirectPath, String body) {
        this.responseCode = responseCode;
        this.redirectPath = redirectPath;
        this.body = body;
    }

    public String getResponseCode() {
        return responseCode;
    }

    public String getRedirectPath() {
        return redirectPath;
    }

    public String getBody() {
        return body;
    }

    public String generateFullResponse() {

        String output = "HTTP/1.1 " + responseCode;

        if (redirectPath.length() > 0)
            output += "\r\nLocation: " + redirectPath;

        if (body.length() > 0)
            output += "\r\n" + body;

        return output;
    }
}
