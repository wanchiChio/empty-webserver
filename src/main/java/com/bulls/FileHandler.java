package com.bulls;

import org.apache.commons.io.FileUtils;

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
                (this.getHttpMethod().equals("PUT") || this.getHttpMethod().equals("POST"))) {
            response = new Response("405", "Method not allowed");
        } else if (this.getHttpMethod().equals("GET") && endPoint != null) {
            String content = readFile(Server.getDirectory().concat(endPoint));
            if (content != null)
                response = new Response("200", content);
            else
                generate404Response();
        } else
            generate404Response();

        return true;
    }

    private void generate404Response() {
        response = new Response("404", "404. These are not the droids you are looking for. Go along now.");;
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

    public byte[] readImage(String filePathString) throws IOException {
        File file = new File(filePathString);
        return FileUtils.readFileToByteArray(file);
    }
}
