package com.lykdsb.rpcv1.service;

import com.lykdsb.rpcv1.common.User;
import com.lykdsb.rpcv1.service.UserService;

import java.util.Random;
import java.util.UUID;

public class UserServiceImpl implements UserService {
    @Override
    public User getUserById(Integer id){
        System.out.println("客户端查询了id为"+id+"的客户");
        Random random = new Random();
        User user = User.builder().userName(UUID.randomUUID().toString()).id(id).sex(random.nextBoolean()).build();
        return user;
    }
}
