package com.bulls;

/**
 * Created by Lucien.Minot on 9/23/2014.
 */
public class fourOhFourHandler implements RequestHandler {

    @Override
    public String genDefaultResponse() {
        return "HTTP/1.0 404 Not Found";
    }
}
