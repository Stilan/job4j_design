package ru.job4j.io;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.ServerSocket;
import java.io.*;
import java.net.Socket;

public class EchoServer {

    private static final Logger LOG = LoggerFactory.getLogger(UsageLog4j.class.getName());

    public static void main(String[] args)  {
        try (ServerSocket server = new ServerSocket(9000)) {
            while (!server.isClosed()) {
                Socket socket = server.accept();
                try (OutputStream out = socket.getOutputStream();
                     BufferedReader Buffered = new BufferedReader(
                             new InputStreamReader(socket.getInputStream()))) {
                    String str;
                    String str2 = Buffered.readLine();
                    str2 = str2.split("=")[1];
                    str2 = str2.split(" ")[0];
                    while (!(str = Buffered.readLine()).isEmpty()) {
                        System.out.println(str);
                    }
                    if (str2.equals("Hello")) {
                        out.write("HTTP/1.1 200 OK\r\n\r\n".getBytes());
                        out.write("Hello".getBytes());
                    } else if (str2.equals("Exit")) {
                        out.write("HTTP/1.1 200 OK\r\n\r\n".getBytes());
                        server.close();
                    } else {
                        out.write("HTTP/1.1 200 OK\r\n\r\n".getBytes());
                        out.write("What".getBytes());
                    }
                }
            }
        } catch (Exception e) {
           LOG.error("Exception in log example", e);
        }
    }
}
