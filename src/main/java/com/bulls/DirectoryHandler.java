package com.bulls;

import java.io.File;

/**
 * Created by anton.perez on 9/30/14.
 */
public class DirectoryHandler extends RequestHandler {
    @Override
    public boolean processRequest(String data) {

        String responseBody = "";
        if (Server.getDirectory().length() > 0) {
            responseBody = getDirectoryListing(Server.getDirectory());
        }
        response = new Response("200", responseBody);

        return true;
    }

    public String getDirectoryListing(String path) {


        File[] listings = getDirectoryContents(path);
        StringBuilder newListing = new StringBuilder("");

        if (listings != null && listings.length > 0) {
            for (File f : listings) {
                if (f == null) continue;
                newListing.append(f.getPath());
            }

        }
        return newListing.toString();

    }

    public File[] getDirectoryContents(String path) {

        File file = new File(path);
        return file.listFiles();
    }
}
