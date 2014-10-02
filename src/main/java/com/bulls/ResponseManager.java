package com.bulls;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by wanchi.chio on 10/1/14.
 */
public class ResponseManager {


    public void generateOutput(Socket socket) {
        try {
            BufferedInputStream reader = new BufferedInputStream(socket.getInputStream());
            String inputData = getInput(reader);

            Request request = new Request(inputData);
            RequestHandler handler = RequestHandlerFactory.generateRequestHandler(request);

            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            if (handler.processRequest(inputData))
                out.println(handler.generateResponse());
            else
                out.println(handler.generateDefaultResponse());;

            out.flush();
        } catch (Exception e) {
            System.out.println("Could not generate output");
        } finally {
            try {
                socket.close();
            } catch (Exception e) {
                System.out.println("Could not close socket");
            }
        }

    }

    private String getInput(BufferedInputStream reader) throws Exception {
        List<Byte> byteL = new ArrayList();

        byte[] byteArray;
        boolean newLine = false;

        int b;
        while ((b = reader.read()) != -1) {
            if (b != 13) {
                if (b == 10) {
                    if (newLine) {
                        break;
                    }
                    newLine = true;
                } else {
                    newLine = false;
                }
                byteL.add((byte) b);
            }
        }

        byteArray = new byte[byteL.size()];

        for (int i = 0; i < byteL.size(); i++) {
            byteArray[i] = byteL.get(i);
        }

        return (new String(byteArray, "UTF-8"));
    }
}
