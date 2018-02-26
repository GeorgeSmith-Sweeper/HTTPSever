package com.GeorgesServer.app;

import java.util.HashMap;


public class RequestHandler {

    public String handle(HashMap<String, String> clientRequest) {

        if (clientRequest.get("Url").equals("/") || clientRequest.get("Url").equals("/form")) {
            return clientRequest.get("HttpVersion") + " " + StatusCodes.OK + "\n";
        }

        if (clientRequest.get("Method").equals("HEAD") && clientRequest.get("Url").equals("/foobar")) {
            return clientRequest.get("HttpVersion") + " " + StatusCodes.NOT_FOUND + "\n";
        }

        return "";
    }


}
