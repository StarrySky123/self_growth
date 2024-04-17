package com.xuyuan.spring;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class PortServer {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket();
        serverSocket.bind(new InetSocketAddress(8080));
        System.out.println("start server");
        while (true){
            Socket socket = null;
            try {
                socket = serverSocket.accept();
                System.out.println("new connection accepted"+socket.getInetAddress()+":"+socket.getPort());
            }finally {
                if(socket != null){
                    socket.close();
                }
            }
        }
    }
}
