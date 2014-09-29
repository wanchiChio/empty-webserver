package com.bulls;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server implements Runnable{

    private ServerSocket serverSocket;
    private boolean threadRun = true;

    public Server(int port) throws IOException {
        createServerSocket(port);
    }

    public static void main(String[] args) {
        try {
            Server server = new Server(Integer.parseInt(args[1]));
            server.start();
            System.out.println("Server started...");
        } catch (Exception e) {
            System.out.println("Failed to start server: " + e.getMessage() + "...");
        }
    }

    private void createServerSocket(int port) throws IOException {
        serverSocket = new ServerSocket(port);
    }

    public void start() {
        new Thread(this).start();
    }

    public int getPort() {
        return serverSocket.getLocalPort();
    }

    public ServerSocket getServerSocket() {
        return serverSocket;
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
