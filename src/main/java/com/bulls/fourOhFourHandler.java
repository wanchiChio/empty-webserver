package com.bulls;

/**
 * Created by Lucien.Minot on 9/23/2014.
 */
public class fourOhFourHandler implements RequestHandler {
    String httpMethod;
    String endPoint;

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



    @Override
    public String genDefaultResponse() {
        return "HTTP/1.0 404 Not Found";
    }

    @Override
    public void parseInput(String data) {
        String[] parsed = data.split(" ");

        if (parsed != null && parsed.length > 1)
        {

            setEndPoint(parsed[1]);
            setHttpMethod(parsed[0]);

        }

    }

}
