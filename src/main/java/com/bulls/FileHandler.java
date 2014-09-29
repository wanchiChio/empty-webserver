package com.bulls;

import java.io.File;

/**
 * Created by anton.perez on 9/29/14.
 */
public class FileHandler extends RequestHandler {

    @Override
    public boolean processRequest(String data) {
        if (this.getHttpMethod() != null &&
           (this.getHttpMethod().equals("PUT") || this.getHttpMethod().equals("POST")))
            response = new Response("405", "");
        else
            response = new Response("200", "");

        return true;
    }

    public boolean processFile(String filePathString) {
        File file = new File(filePathString);
        if (file.exists() && !file.isDirectory())
            return true;
        else
            return false;
    }
}
