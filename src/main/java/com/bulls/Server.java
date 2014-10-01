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
    private String directory;

    public Server(int port) throws IOException {
        createServerSocket(port);
    }

    public static void main(String[] args) {
        try {
            Server server = new Server(Integer.parseInt(args[1]));
            server.start();

            System.out.print("Starting server on port: " + server.getPort());
            for (int i = 0; i < 4; i++){
                System.out.print(".");
                Thread.sleep(1000);
            }
            System.out.println("\nServer started!");

        } catch (Exception e) {
            System.out.println("Failed to start server: " + e.getMessage());
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
                ResponseManager responseManager = new ResponseManager();
                responseManager.generateOutput(socket);

            } catch(IOException e) {
            	System.out.println("Failed to start server: " + e.getMessage());
                System.exit(0);
                return;
            }
        }
    }


    public void setDirectory(String directory) {
        this.directory = directory;
    }

    public String getDirectory() {
        return directory;
    }
}
