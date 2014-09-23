package com.bulls;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server implements Runnable{

    private int port;
    private String status;
    private String responseCode;
    private ServerSocket serverSocket;
    private String body;
    private boolean threadRun = true;


    public Server() {
    }

    public Server(int port) throws IOException {
        this.port = port;
        createSocket(port);
    }

    public static void main(String[] args) {

        try {
            Server server = new Server(Integer.parseInt(args[1]));
            server.start();
        }
        catch (Exception e) {


        }
    }

    private void createSocket(int port) throws IOException {
        serverSocket = new ServerSocket(port);
    }

    public void start() {
        new Thread(this).start();
        this.status = "Started";

    }



    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getResponseCode() {
        return Integer.parseInt(responseCode);
    }

    public void setResponseCode(String responseCode) {
        this.responseCode = responseCode;
    }

    public int getPort() {
        return port;
    }

    public ServerSocket getSocket() {
        return serverSocket;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public void stop() throws IOException{
        threadRun = false;
        serverSocket.close();
        this.status = "Stopped";
    }

    public void run() {

        while (threadRun) {
            try {

                Socket socket = serverSocket.accept();
                generateOutput(socket);

            } catch(IOException e) {
            	System.out.println("Failed to start server: " + e.getMessage());
                System.exit(0);
                return;
            }
        };

    }


    public void generateOutput (Socket socket) {
        try {

            // Decorate the streams so we can send characters
            // and not just bytes.  Ensure output is flushed
            // after every newline.
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            out.println("HTTP/1.0 404 Not Found");
            out.flush();

//            while (true) {
//                String input = in.readLine();
//                if (input == null || input.equals(".")) {
//                    break;
//                }
//                out.println(input.toUpperCase());
//            }
        } catch (IOException e) {

        } finally {
            try {
                socket.close();
            } catch (IOException e) {

            }

        }
    }



}
