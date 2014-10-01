package com.bulls;

import java.io.File;

/**
 * Created by anton.perez on 9/30/14.
 */
public class DirectoryHandler extends RequestHandler {
    @Override
    public boolean processRequest(String data) {

        if (Server.getDirectory().equals("/")) {
            getDirectoryListing(data);
        }

        response = new Response("200", getDirectoryListing(data));


        return true;
    }

    public String getDirectoryListing(String listing) {

        StringBuilder newListing = new StringBuilder(listing);

        File[] listings = getDirectoryContents(listing);

        for (int i = 0; i < listings.length ; i++){

            newListing.append(listings[i]);
    };
        //System.out.println(newListing);
        return newListing.toString();

    }

    public File[] getDirectoryContents(String path) {

        File file = new File(path);
        File[] files = file.listFiles();

//        for (int i = 0; i < files.length; i++) {
//            //System.out.println(files[i]);
//        }

        return files;
    }
}
