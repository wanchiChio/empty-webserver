package com.bulls;





import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Response {

    protected String responseCode;
    protected String body;
    private HashMap<String, String> responseHeaders;


    public Response() {}

    public Response(String responseCode, String responseBody) {
        this.responseCode = responseCode;
        this.body = responseBody;
        this.responseHeaders = new HashMap<String, String>();
    }

    public String getResponseCode() {
        return responseCode;
    }

    public String getBody() {
        return body;
    }

    public String generateFullResponse() {

        String output = "HTTP/1.1 " + responseCode;

        if (!responseHeaders.isEmpty()) {
            output += "\r\n" + getHeaders();
        }

        if (body.length() > 0)
            output += "\r\n\r\n" + body;

        return output;
    }

    public String getHeaders() {
        ArrayList<String> headerStrings = new ArrayList<String>();
        for (Map.Entry<String, String> entry : responseHeaders.entrySet()){
            headerStrings.add(entry.getKey() + ": " + entry.getValue());
        }

        return String.join("\r\n", headerStrings);
    }

    public void addHeader(String headerLine) {

        String fields[] = headerLine.split(":");
        if (fields.length != 2) return;
        responseHeaders.put(fields[0].trim(), fields[1].trim());
    }

    public void addHeader(String tag, String value) {
        responseHeaders.put(tag, value);
    }
}
