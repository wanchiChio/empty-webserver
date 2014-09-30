package com.bulls;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.charset.Charset;

/**
 * Created by anton.perez on 9/24/14.
 */
public class Mocket extends Socket {

    private boolean closed;

    private InputStream is;
    private String myInputString;
    private OutputStream bos;

    public Mocket(String inputString) {
        super();
        myInputString = inputString;
        is = new ByteArrayInputStream( myInputString.getBytes());
        bos = new ByteArrayOutputStream();
    }

    public Socket getSocket() {
        return this;
    }

    @Override
    public InputStream getInputStream() {
        return is;
    }

    @Override
    public OutputStream getOutputStream() {
        return bos;
    }




}
