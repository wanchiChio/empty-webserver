package com.bulls;

/**
 * Created by wanchi.chio on 9/23/14.
 */
public class RequestHandlerFactory {

    public static RequestHandler generateRequestHandler(Request request) {

        String endPoint = request.getUri();
        String method = request.getMethod();

        RequestHandler handler;
        if (endPoint.equals("/"))
            handler = new DirectoryHandler();
        else if (endPoint.equals("/redirect"))
          handler = new RedirectHandler();
        else if (endPoint.equals("/logs"))
          handler = new AuthenticateHandler();
        else if (endPoint.equals("/method_options"))
          handler = new MethodOptionHandler();
        else if (endPoint.equals("/form"))
          handler = new FormHandler();
        else
          handler = new FileHandler();


        handler.setEndPoint(endPoint);
        handler.setHttpMethod(method);

        return handler;
    }
}
