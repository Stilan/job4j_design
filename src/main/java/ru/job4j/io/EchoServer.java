package ru.job4j.io;

import java.net.ServerSocket;
import java.io.*;
import java.net.Socket;

public class EchoServer {
    public static void main(String[] args) throws IOException {
        try (ServerSocket server = new ServerSocket(9000)) {
            while (!server.isClosed()) {
                Socket socket = server.accept();
                try (OutputStream out = socket.getOutputStream();
                     BufferedReader in = new BufferedReader(
                             new InputStreamReader(socket.getInputStream()))) {
                    String str;
                    String str2 = in.readLine();
                    str2 = str2.split("=")[1];
                    str2 = str2.split(" ")[0];
                    while (!(str = in.readLine()).isEmpty()) {
                        System.out.println(str);
                    }
                    if (str2.equals("Hello")) {
                        out.write("HTTP/1.1 200 OK\r\n\r\n".getBytes());
                        out.write("Hello".getBytes());
                    } else if (str2.equals("Exit")) {
                        server.close();
                    } else {
                        out.write("HTTP/1.1 200 OK\r\n\r\n".getBytes());
                        out.write("What".getBytes());
                    }
                }
            }
        }
    }
}
