package com.bulls;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server implements Runnable{

    private ServerSocket serverSocket;
    private boolean threadRun = true;
    private static String directory;

    public Server(int port) throws IOException {
        createServerSocket(port);
    }

    public Server(int port, String directory) throws IOException {
        createServerSocket(port);
        Server.setDirectory(directory);
    }

    public static void main(String[] args) {
        try {
            int port;
            String directory;

            if (args.length > 0) {
                port = Integer.parseInt(args[1]);
                directory = args[3];
            } else {
                port = 5000;
                directory = "src/main/resources/public";
            }

            Server server = new Server(port, directory);
            server.start();

            System.out.print("Starting server on port: " + server.getPort());
            for (int i = 0; i < 4; i++){
                System.out.print(".");
                Thread.sleep(500);
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

    public static void setDirectory(String inputDirectory) {
        directory = inputDirectory;
    }

    public static String getDirectory() {
        return directory;
    }
}
