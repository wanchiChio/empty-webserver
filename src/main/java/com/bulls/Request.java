package com.bulls;

import java.util.HashMap;

public class Request {
    private String rawRequest;
    private String method;
    private String uri;
    private String version;
    private String[] headerArray;
    private HashMap<String, String> headerMap;

    public Request(String rawRequest) {
        this.rawRequest = rawRequest;
        parseRequest();
    }

    private void parseHeaderType(String header) {
        String[] headerArray = header.split(" ");
        method = headerArray[0];
        uri = headerArray[1];
        version = headerArray[2];
    }

    private void parseRequest() {
        headerArray = rawRequest.split("\n");
        parseHeaderType(headerArray[0]);
        parseHeader();

    }

    private void parseHeader() {
        headerMap = new HashMap<String, String>();

        for (int i = 1; i < headerArray.length; i++) {
            String[] lineArray = headerArray[i].split(":");

            headerMap.put(lineArray[0], lineArray[1]);
        }
    }

    public String getRawRequest() {
        return rawRequest;
    }

    public String getMethod() {
        return method;
    }

    public String getUri() {
        return uri;
    }

    public String getVersion() {
        return version;
    }

    public String getHeaderByType(String content) {
        if (headerMap.containsKey(content)) {
            return headerMap.get(content);
        } else {
            return null;
        }
    }
}
