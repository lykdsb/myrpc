package com.lykdsb.rpcv1.client;

import com.lykdsb.rpcv1.common.User;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Random;

public class RPCClient {
    public static void main(String[] args) {
        try{
            Socket socket = new Socket("127.0.0.1",8899);
            ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());
            outputStream.writeInt(new Random().nextInt());
            outputStream.flush();
            User user = (User) inputStream.readObject();
            System.out.println(user);

        }catch(IOException e){
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
