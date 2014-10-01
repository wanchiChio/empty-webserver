package com.bulls;

import java.util.HashMap;

public class Request {
    private String rawRequest;
    private String method;
    private String uri;
    private String version;
    private HashMap<String, String> headerMap;
    private HashMap<String, String> bodyMap;

    public Request(String rawRequest) {
        this.rawRequest = rawRequest;
        parseRequest();
    }

    private void parseHeaderType(String header) {
        String[] typeArray = header.split(" ");
        method = typeArray[0];
        uri = typeArray[1];
        version = typeArray[2];
    }

    private void parseRequest() {
        String[] splitArray = rawRequest.split("\r\n");

        headerMap = new HashMap<String, String>();
        String[] headerArray = splitArray[0].split("\n");
        parseHeaderType(headerArray[0]);
        parseHeader(headerArray);

        if (splitArray.length > 1) {
            bodyMap = new HashMap<String, String>();
            String[] bodyArray = splitArray[1].split("&");
            parseBody(bodyArray);
        }
    }

    private void parseBody(String[] bodyArray) {
        for (int i = 0; i < bodyArray.length; i++) {
            String[] lineArray = bodyArray[i].split(":");
            bodyMap.put(lineArray[0], lineArray[1]);
        }
    }

    private void parseHeader(String[] headerArray) {
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

    public String getBodyByType(String content) {
        if (bodyMap != null) {
            return bodyMap.get(content);

        } else {
            return null;
        }
    }
}
