package com.bulls;

/**
 * Created by Lucien.Minot on 9/23/2014.
 */
public abstract class RequestHandler {

    protected String httpMethod;
    protected String endPoint;
    protected String responseCode;
    protected String requestPath;
    private String responseBody;
    protected Response response;

    public RequestHandler() {
        response = new Response();
    }

    public String generateDefaultResponse() {
        return "HTTP/1.0 404 Not Found";
    }

    public void parseInput(String data) {
        String[] parsed = data.split(" ");

        if (parsed != null && parsed.length > 1)
        {
            setEndPoint(parsed[1]);
            setHttpMethod(parsed[0]);
        }
    }

    public String getEndPoint() {
        return endPoint;
    }

    public void setEndPoint(String endPoint) {
        this.endPoint = endPoint;
    }

    public String getHttpMethod() {
        return httpMethod;
    }

    public void setHttpMethod(String httpMethod) {
        this.httpMethod = httpMethod;
    }

    public String getResponseCode() {
        return response.getResponseCode();
    }

    public String getRequestPath() {
        return response.getRedirectPath();
    }

    public abstract boolean processRequest();

    public String generateResponse() {
        return response.generateFullResponse();
    }

    public String getResponseBody() {
        return response.getBody();
    }
}
