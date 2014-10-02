package com.bulls;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by anton.perez on 9/29/14.
 */
public class FileHandler extends RequestHandler {

    @Override
    public boolean processRequest(String data) {
        if (this.getHttpMethod() != null &&
                (this.getHttpMethod().equals("PUT") || this.getHttpMethod().equals("POST")))
            response = new Response("405", "");
        else if (endPoint != null)
            response = new Response("200", readFile(Server.getDirectory().concat(endPoint)));
        else
            response = new Response("200", "");

        return true;
    }

    public String readFile(String filePathString) {
        String content = null;
        File file = new File(filePathString);

        try {
            FileReader reader = new FileReader(file);
            char[] chars = new char[(int) file.length()];
            reader.read(chars);
            content = new String(chars);
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return content;
    }
}
