package com.bulls;

/**
 * Created by wanchi.chio on 9/23/14.
 */
public class RequestHandlerFactory {

    public static RequestHandler generateRequestHandler(String data) {
        String[] parsed = data.split(" ");

        if (parsed != null && parsed.length > 1) {
            RequestHandler handler;
            if (parsed[1].equals("/foobar")) {
                handler = new NotFoundHandler();
            } else if (parsed[1].equals("/redirect")) {
                handler = new RedirectHandler();
            } else {
                handler = null;
            }

            handler.setEndPoint(parsed[1]);
            handler.setHttpMethod(parsed[0]);

            return handler;
        } else
            return null;
    }
}
