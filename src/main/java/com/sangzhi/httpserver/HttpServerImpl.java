package com.sangzhi.httpserver;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import com.sangzhi.httpserver.handle.HandlerThread;

public class HttpServerImpl implements HttpServer {

    private int                portNo       = 80;
    private ThreadPoolExecutor executor     = new ThreadPoolExecutor(1, 4, 30, TimeUnit.SECONDS,
                                                                     new ArrayBlockingQueue<Runnable>(100),
                                                                     new ThreadPoolExecutor.CallerRunsPolicy());

    private ServerSocket       serverSocket = null;

    @Override
    public void bind(int port) {
        this.portNo = port;

    }

    @Override
    public void start() throws IOException {
        serverSocket = new ServerSocket(portNo);
        try {
            while (true) {
                Socket socket = serverSocket.accept();
                HandlerThread handlerThread = new HandlerThread(socket);
                executor.submit(handlerThread);
            }
        } finally {
            serverSocket.close();
        }

    }

    @Override
    public void stop() throws IOException {
        serverSocket.close();
        executor.shutdownNow();
    }

}
