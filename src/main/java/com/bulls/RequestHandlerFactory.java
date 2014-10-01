package com.bulls;

/**
 * Created by wanchi.chio on 9/23/14.
 */
public class RequestHandlerFactory {

    public static RequestHandler generateRequestHandler(String data) {
        String[] parsed = data.split(" ");

        if (parsed != null && parsed.length > 1) {

            RequestHandler handler;
            String endPoint = parsed[1];
            if (endPoint.equals("/")) {
                handler = new DirectoryHandler();
            } else if (endPoint.equals("/redirect")) {
                handler = new RedirectHandler();
            } else if (endPoint.equals("/logs")) {
                handler = new AuthenticateHandler();
            } else if (endPoint.equals("/method_options")) {
                handler = new MethodOptionHandler();
            } else if (endPoint.equals("/form")) {
                handler = new FormHandler();
            } else if (endPoint.equals("/file1") || endPoint.equals("/text-file.txt")){
                handler = new FileHandler();
            } else {
               handler = new NotFoundHandler();
            }

            handler.setEndPoint(endPoint);
            handler.setHttpMethod(parsed[0]);

            return handler;
        } else
            return null;
    }
}
