package com.sangzhi.httpserver;

import java.io.IOException;

public class Test {

    public static void main(String[] args) throws IOException {

        HttpServer httpServer = new HttpServerImpl();
        httpServer.bind(4040);
        httpServer.start();

    }
}
