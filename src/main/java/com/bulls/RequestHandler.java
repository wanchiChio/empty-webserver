package com.bulls;

/**
 * Created by Lucien.Minot on 9/23/2014.
 */
public interface RequestHandler {


    String genDefaultResponse();

    void parseInput(String data);

    public String getEndPoint();

    public void setEndPoint(String endPoint);

    public String getHttpMethod();
}
