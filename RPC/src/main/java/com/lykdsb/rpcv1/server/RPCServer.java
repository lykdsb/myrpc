package com.lykdsb.rpcv1.server;

import com.lykdsb.rpcv1.common.User;
import com.lykdsb.rpcv1.service.UserService;
import com.lykdsb.rpcv1.service.UserServiceImpl;
import org.apache.log4j.net.SocketServer;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class RPCServer {
    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();
        try{
            ServerSocket server = new ServerSocket(8899);
            System.out.println("服务端启动了");
            while(true){
                Socket socket = server.accept();
                new Thread(()->{
                    try {
                        ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
                        ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());
                        Integer id = inputStream.readInt();
                        User user = userService.getUserById(id);
                        outputStream.writeObject(user);
                        outputStream.flush();
                    } catch (IOException e) {
                        System.out.println("写入数据失败");
                        e.printStackTrace();
                    }
                }).start();
            }
        } catch (IOException e) {
            System.out.println("服务器启动失败");
            e.printStackTrace();
        }
    }
}
