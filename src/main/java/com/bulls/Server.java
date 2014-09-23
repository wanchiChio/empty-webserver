package com.bulls;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server implements Runnable{

    private String responseCode;
    private ServerSocket serverSocket;
    private String body;
    private boolean threadRun = true;

    public Server(int port) throws IOException {
        createSocket(port);
    }

    public static void main(String[] args) {
        try {
            Server server = new Server(Integer.parseInt(args[1]));
            server.start();
        } catch (Exception e) {
            // Do nothing
        }
    }

    private void createSocket(int port) throws IOException {
        serverSocket = new ServerSocket(port);
    }

    public void start() {
        new Thread(this).start();
    }

    public int getResponseCode() {
        return Integer.parseInt(responseCode);
    }

    public void setResponseCode(String responseCode) {
        this.responseCode = responseCode;
    }

    public int getPort() {
        return serverSocket.getLocalPort();
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
        }
    }

    public void generateOutput (Socket socket) {
        try {
            // Decorate the streams so we can send characters
            // and not just bytes.  Ensure output is flushed
            // after every newline.
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            RequestHandler handler = RequestHandlerFactory.generateRequestHandler(in.readLine());
            //handler.parseInput(in.readLine());

            if (handler.processRequest())
                out.println(handler.generateResponse());
            else
                out.println(handler.generateDefaultResponse());;

            out.flush();
        } catch (IOException e) {
            // Do nothing
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                // Do nothing
            }
        }
    }

}
