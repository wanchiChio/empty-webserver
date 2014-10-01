package com.bulls;





import java.util.ArrayList;

public class Response {

    protected String responseCode;
    protected String body;
    private ArrayList<String> headers;


    public Response() {}

    public Response(String responseCode, String responseBody) {
        this.responseCode = responseCode;
        this.body= responseBody;
        this.headers = new ArrayList<String>();
    }

    public String getResponseCode() {
        return responseCode;
    }

    public String getBody() {
        return body;
    }

    public String generateFullResponse() {

        String output = "HTTP/1.1 " + responseCode;


        if (headers.size() > 0) {
            output += "\r\n" + getHeaders();

        }

        if (body.length() > 0)
            output += "\r\n\r\n" + body;

        return output;
    }

    public String getHeaders() {

        return String.join("\r\n", headers);
    }

    public void addHeader(String headerLine) {
        headers.add(headerLine);
    }


    public void addHeader(String tag, String value) {


    }
}
