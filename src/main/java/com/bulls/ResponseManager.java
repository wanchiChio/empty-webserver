package com.bulls;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Created by wanchi.chio on 10/1/14.
 */
public class ResponseManager {


    public void generateOutput(Socket socket) {
        try {
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            String inputData = in.readLine();
            RequestHandler handler = RequestHandlerFactory.generateRequestHandler(inputData);

            String line;
            while ((line = in.readLine()) != null && line.length()!= 0) {
                inputData += '\n' + line;
            }

            if (handler.processRequest(inputData))
                out.println(handler.generateResponse());
            else
                out.println(handler.generateDefaultResponse());;

            out.flush();
        } catch (Exception e) {
            System.out.println("Server Error");
        } finally {
            try {
                socket.close();
            } catch (Exception e) {
                System.out.println("Could not close socket");
            }
        }

    }
}
