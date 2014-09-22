package com.bulls;

import java.io.IOException;
import java.net.ServerSocket;

public class Server {

    private int port;
    private String status;
    private String responseCode;
    private ServerSocket serverSocket;
    private String body;

    public Server() {
    }

    public Server(int port) throws IOException {
        this.port = port;
        createSocket(port);
    }

    public static void main(String[] args)
    {

    }

    private void createSocket(int port) throws IOException {
        serverSocket = new ServerSocket(port);
    }

    public void start() {
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
}
