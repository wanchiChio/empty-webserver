package com.bulls;

/**
 * Created by Lucien.Minot on 9/23/2014.
 */
public class RootHandler extends RequestHandler {

    @Override
    public boolean processRequest() {
        responseCode = "200";
        return true;
    }

}
