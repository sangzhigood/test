package com.sangzhi.httpserver.handle;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class HandlerThread implements Runnable {

    private Socket socket;

    public HandlerThread(Socket socket) {
        super();
        this.socket = socket;
    }

    @Override
    public void run() {
        if (socket == null) {
            return;
        }
        BufferedReader in = null;
        BufferedWriter out = null;
        try {
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            String line = in.readLine();
            // while (line != null) {
            // System.out.println(line);
            // line = in.readLine();
            // }
            StringBuffer sb = new StringBuffer();
            sb.append("HTTP/1.1 404 OK\r\n");
            sb.append("Content-Length:10");
            sb.append("\r\n");
            sb.append("\r\n");
            sb.append("xiaochouyu");
            out.write(sb.toString());
            out.flush();
            System.out.println("done.....");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close();
                if (in != null) {
                    in.close();
                }

                if (out != null) {
                    out.close();
                }
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

    }
}
