package com.lykdsb.rpcv2.client;

import com.lykdsb.rpcv2.common.User;
import com.lykdsb.rpcv2.service.UserService;

public class RPCClient {
    public static void main(String[] args) {
        ClientProxy clientProxy = new ClientProxy("127.0.0.1",8899);
        UserService userService = clientProxy.getProxy(UserService.class);
        User user = userService.getUserById(1);
        System.out.println("getUserById:"+user);

        User user1 = User.builder().userName("liuyikang").sex(true).build();
        Integer id = userService.insertUserId(user1);
        System.out.println("insertUserId:"+id);
    }
}
