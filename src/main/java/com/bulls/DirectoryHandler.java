package com.bulls;

import java.io.File;

/**
 * Created by anton.perez on 9/30/14.
 */
public class DirectoryHandler extends RequestHandler {
    @Override
    public boolean processRequest(String data) {
        response = new Response("200", "");
        return true;
    }

    public File[] getDirectoryContents(String path) {

        File file = new File(path);
        File[] files = file.listFiles();

        for (int i = 0; i < files.length; i++) {
            System.out.println(files[i]);
        }

        return files;
    }
}
