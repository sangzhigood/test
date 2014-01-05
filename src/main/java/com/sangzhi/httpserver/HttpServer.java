package com.sangzhi.httpserver;

import java.io.IOException;

public interface HttpServer {

    public void start() throws IOException;

    public void stop() throws IOException;

    public void bind(int port);

}
