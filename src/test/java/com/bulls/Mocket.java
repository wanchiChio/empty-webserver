package com.bulls;

import java.net.Socket;

/**
 * Created by anton.perez on 9/24/14.
 */
public class Mocket {

    private Socket socket;
    private boolean closed;

    public Mocket() {
        socket = new Socket();
    }

    public Socket getSocket() {
        return socket;
    }

    public boolean isClosed() {
        return socket.isClosed();
    }
}
