package com.xuyuan.spring;

import java.net.Socket;

public class PortCheck {

    public static void main(String[] args){
        String host = "127.0.0.1";
        int port = 8080;
        if(isPortOpen(host,port)){
            System.out.println("port "+port+" on host "+host+" is open");
        }else {
            System.out.println("port "+port+" on host "+host+" is closed");
        }
    }

    public static boolean isPortOpen(String host,int port){
        try {
            Socket socket = new Socket(host, port);
            socket.close();
            return true;
        }catch(Exception e){
            return  false;
        }
    }
}
